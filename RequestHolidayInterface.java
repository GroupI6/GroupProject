import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Program to implement a user interface.
public class RequestHolidayInterface extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton submitRequestButton = new JButton("Submit Request");
  private JButton getSelect = new JButton("pop-up");
  static long diffDays = 0;
  static int holidayLength ;
 static int holidaysRequestedLength ;
 static int submit = 0;
  String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
  String[] days30 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
  String[] days28 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
  String[] days29 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
  String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
  String[] years = {"2013", "2014", "2015","2016", "2017", "2018","2019", "2020", "2021"};

  JComboBox monthListStart = new JComboBox(months) ;
  JComboBox monthListEnd = new JComboBox(months);
  JComboBox yearListStart = new JComboBox(years);
  JComboBox yearListEnd = new JComboBox(years);
  JComboBox dayListStart;
  JComboBox dayListEnd ;

  // JTextFields for use on the interface.
 // private final JTextField driverIDJTextField = new JTextField(5);
  private final JTextField startDayJTextField = new JTextField(2);
  private final JTextField startMonthJTextField = new JTextField(2);
  private final JTextField startYearJTextField = new JTextField(4);
  private final JTextField endDayJTextField = new JTextField(2);
  private final JTextField endMonthJTextField = new JTextField(2);
  private final JTextField endYearJTextField = new JTextField(4);
  
  // A public method to set the heading
  private static JPanel setHeading()
  {
    // The top panel is for the company name. It is a 1 x 1 grid.
    JPanel companyHeaderPanel = new JPanel();

    // Format
    companyHeaderPanel.setLayout(new GridLayout(0, 1));
    companyHeaderPanel.setBackground(Color.white);
    
    // JLabel for the company name
    JLabel companyName = new JLabel("GMPTE");
    JLabel productName = new JLabel("Integrated Bus Management System (IBMS)");
    JLabel loginName ;
    // Change fonts etc to match logo
    companyName.setFont(new Font("Serif", Font.BOLD, 32));
    companyName.setForeground(Color.black);
    
    productName.setFont(new Font("Serif", Font.BOLD, 16));
    productName.setForeground(Color.black);
    
    LoginInterface theLoginInterface = new LoginInterface();
    loginName= new JLabel(theLoginInterface.loggedName()) ;
    
    loginName.setFont(new Font("Serif", Font.BOLD, 18));
    loginName.setForeground(Color.black);
   
    // First element for the companyHeaderPanel
    companyHeaderPanel.add(companyName);
    companyHeaderPanel.add(productName);
    companyHeaderPanel.add(loginName); 

    return(companyHeaderPanel);
  } // setHeading
  
  private static JPanel formatPanel(JPanel panel)
  {
    panel.setBackground(Color.white);
    
    return panel;
  } // formatPanel
  
  // Helper method for creating and formatting JButtons
  private static JButton makeButton(JButton button, JButton largestButton)
  {
    // We introduce the variable phi to ensure we have the 'golden ratio'.
    double phi = 1.61803398875;
    double width = 150.0;
    double height = (width / phi) / 2;
    
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button.setFont(new Font("Serif", Font.BOLD, 12));
    
    // Minimum size
    button.setMinimumSize(new Dimension((int)width, (int)height));
    
    // Maximum size
    button.setMaximumSize(new Dimension((int)width, (int)height));
    
    // Preferred size
    button.setPreferredSize(new Dimension((int)width, (int)height));
    return button;
  } // makeButton
  
  // Firstly, we need a constructor to build the GUI.
  public RequestHolidayInterface()
  {
    // Set the window title
    setTitle("IBMS: Driver - Request Holiday");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(0, 2));

    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    formatPanel(mainPanel);
    
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DATE);

 
    

    if(month == 3 || month == 5 || month == 8 || month == 10 )
         dayListStart = new JComboBox(days30);
    else if (month == 1)
     {
      if ((year+2013) % 4 == 0)
        dayListStart = new JComboBox(days29);
      else 
         dayListStart = new JComboBox(days28);
      }   
     else 
        dayListStart = new JComboBox(days);

  if(month == 3 || month == 5 || month == 8 || month == 10 )
         dayListEnd = new JComboBox(days30);
    else if (month == 1)
     {
      if ((year + 2013 )% 4 == 0)
        dayListEnd = new JComboBox(days29);
      else 
         dayListEnd = new JComboBox(days28);
      }   
     else 
        dayListEnd = new JComboBox(days);


    dayListStart.setSelectedIndex(day-1);
    dayListStart.setMaximumRowCount(20);
    monthListStart.setSelectedIndex(month);
    monthListStart.setMaximumRowCount(12);
    yearListStart.setSelectedIndex(year-2013);
    yearListStart.setMaximumRowCount(9);

    dayListEnd.setSelectedIndex(day);
    dayListEnd.setMaximumRowCount(20);
    monthListEnd.setSelectedIndex(month);
    monthListEnd.setMaximumRowCount(12); 
    yearListEnd.setSelectedIndex(year-2013);
    yearListEnd.setMaximumRowCount(9);
   
   dayListStart.addActionListener(this);
     monthListStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthListStartActionPerformed(evt);
            }
      });

    yearListStart.addActionListener(this);
     yearListStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearListStartActionPerformed(evt);
            }
      });

   dayListEnd.addActionListener(this);
   monthListEnd.addActionListener(this);
    monthListEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthListEndActionPerformed(evt);
            }
    });
   yearListEnd.addActionListener(this);
     yearListEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearListEndActionPerformed(evt);
            }
      });
    // Top left of the main panel       
    mainPanel.add(new JLabel("Select Date for Holiday Request"));
		// Top right of the main panel
		JPanel driverIDPanel = new JPanel();
		mainPanel.add(driverIDPanel);
		formatPanel(driverIDPanel);
		driverIDPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Add the JTextField
		//driverIDPanel.add(driverIDJTextField);
    
    
    // Middle left of the main panel
    mainPanel.add(new JLabel("Start Date:"));
    
    // Middle right of the main panel
    // Use a JPanel so the alignment matches everything else.
    JPanel startDateJPanel = new JPanel();
    mainPanel.add(startDateJPanel);
    formatPanel(startDateJPanel);
    startDateJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    // JTextFields for the date components, with JLabels

   //+ startDateJPanel.add(startDayJTextField);
  startDateJPanel.add(dayListStart);
    startDateJPanel.add(new JLabel("/"));
  // + startDateJPanel.add(startMonthJTextField);
  startDateJPanel.add(monthListStart);
    startDateJPanel.add(new JLabel("/"));
//   + startDateJPanel.add(startYearJTextField);
  startDateJPanel.add(yearListStart);
    
    
    // Bottom left of the main panel
    mainPanel.add(new JLabel("End Date:"));
    
    // Bottom right of the main panel
    // Use a JPanel so the alignment matches everything else.
    JPanel endDateJPanel = new JPanel();
    mainPanel.add(endDateJPanel);
    formatPanel(endDateJPanel);
    endDateJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    // JTextFields for the date components, with JLabels
    //endDateJPanel.add(endDayJTextField);
    endDateJPanel.add(dayListEnd);
    endDateJPanel.add(new JLabel("/"));
    
   // endDateJPanel.add(endMonthJTextField);
    endDateJPanel.add(monthListEnd);
    endDateJPanel.add(new JLabel("/"));
   // endDateJPanel.add(endYearJTextField);
     endDateJPanel.add(yearListEnd);
    
    // Final panel to hold the submit button
    JPanel buttonPanel = new JPanel();
    contents.add(buttonPanel, BorderLayout.SOUTH);
    formatPanel(buttonPanel);
    
    // Format the buttons
    submitRequestButton = makeButton(submitRequestButton, submitRequestButton);

    // Add JButtons to layout
    buttonPanel.add(submitRequestButton);
    submitRequestButton.addActionListener(this);

    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // RequestHolidayInterface
  
  // Action performed method
   
    private void monthListStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
if(monthListStart.getSelectedIndex() == 3 || monthListStart.getSelectedIndex() == 5 || monthListStart.getSelectedIndex() == 8 || monthListStart.getSelectedIndex() == 10 )
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days30));
    else if (monthListStart.getSelectedIndex() == 1)
     { 
     if ((yearListStart.getSelectedIndex()+2013) % 4 == 0)
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days29));
      else 
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days28));
     }
     else 
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days));
     
    }//GEN-LAST:event_jComboBox1ActionPerformed


private void monthListEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
if(monthListEnd.getSelectedIndex() == 3 || monthListEnd.getSelectedIndex() == 5 || monthListEnd.getSelectedIndex() == 8 || monthListEnd.getSelectedIndex() == 10 )
        dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days30));
    else if (monthListEnd.getSelectedIndex() == 1)
     { if ((yearListEnd.getSelectedIndex()+2013) % 4 == 0)
        dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days29));
      else 
        dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days28));
     }
    else 
        dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days));
    

}//GEN-LAST:event_jComboBox1ActionPerformed


 private void yearListEndActionPerformed(java.awt.event.ActionEvent evt) 
{
  if ((yearListEnd.getSelectedIndex()+2013) % 4 == 0)
        dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days29));
  else 
         dayListEnd.setModel(new javax.swing.DefaultComboBoxModel(days28));


}




 private void yearListStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

if ((yearListStart.getSelectedIndex()+2013) % 4 == 0)
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days29));
      else 
        dayListStart.setModel(new javax.swing.DefaultComboBoxModel(days28));
}




  public void actionPerformed(ActionEvent thisEvent)
  {
    

    


    if(thisEvent.getSource() == submitRequestButton)
    {
      // Get all the information from the drivers input.Date in java difference
      try
      {
        database.openBusDatabase();
         int[] driverIDs = DriverInfo.getDrivers();   
       
         
         LoginInterface theLoginInterface = new LoginInterface();
        
 
        int driverID = theLoginInterface.loggedDriverID();
        for (int i=0; i<driverIDs.length; i++)
        {
          if (driverID == driverIDs[i])
          {
            System.out.println(DriverInfo.getName(driverIDs[i]) + " connected");
          
          }

       }
       

      Calendar start = Calendar.getInstance();
      Calendar end = Calendar.getInstance();
   
   start.set(yearListStart.getSelectedIndex() + 2013  ,monthListStart.getSelectedIndex() + 1,dayListStart.getSelectedIndex() + 1);
   end.set(yearListEnd.getSelectedIndex() + 2013  ,monthListEnd.getSelectedIndex() + 1, dayListEnd.getSelectedIndex() + 1);
  
       Calendar startCal = new GregorianCalendar(dayListStart.getSelectedIndex() + 1,
        					 monthListStart.getSelectedIndex() + 1,
        					 yearListStart.getSelectedIndex() + 2013);
        					 
       Date startDate = start.getTime();

        Calendar endCal = new GregorianCalendar(dayListEnd.getSelectedIndex() + 1,
        					 monthListEnd.getSelectedIndex() + 1,
      					 yearListEnd.getSelectedIndex() + 2013 );
        				 
     Date endDate = end.getTime();

     int  hoursAlreadyTaken=DriverInfo.getHolidaysTaken(driverID);

       
 
 




long startTime = startDate.getTime();
long endTime = endDate.getTime();
long diffTime = endTime - startTime;
diffDays = diffTime / (1000 * 60 * 60 * 24 );
start.add(Calendar.DAY_OF_MONTH, (int)diffDays);

int monthSelect = monthListStart.getSelectedIndex();
while(monthSelect !=monthListEnd.getSelectedIndex())
{
if(monthSelect == 3 || monthSelect == 5 || monthSelect == 8 || monthSelect == 10 )
        diffDays=diffDays;
    else if (monthSelect == 1)
     { 
     if ((yearListStart.getSelectedIndex()+2013) % 4 == 0)
        diffDays=diffDays-1;
      else 
        diffDays=diffDays-2;
     }
     else 
        diffDays=diffDays + 1;
monthSelect++;

}
//int daysHave = this.req

 holidayLength = DriverInfo.getHolidaysLength(driverID);
 holidaysRequestedLength = DriverInfo.getControllerHolidaysLength(driverID);
  
   if ( holidayLength+holidaysRequestedLength  + (int)diffDays<=25 && (int)diffDays>0)
      {
       submit = 1;
      DriverInfo.setHolidaysRequest(driverID,1);
      DriverInfo.setControllerHolidaysLength(driverID,holidaysRequestedLength  + (int)diffDays);

}




        int hourstaken,yeartaken,monthtaken; 
        hoursAlreadyTaken=DriverInfo.getHoursThisYear(driverID);
       System.out.println(diffDays);
  

        
      } // try
      
      catch (NumberFormatException exception)
      {
        System.out.println("Driver ID has been inputted incorrectly");
      } // catch

      // CODE WOULD GO HERE TO CONNECT TO THE DATABASE
      ConfirmationInterface theConfirmationInterface = new ConfirmationInterface();
      theConfirmationInterface.setVisible(true);
      this.dispose();
    } // if
  } // actionPerformed

public static boolean requestedDays(){
  if (submit==1)
    return true;
  else
 return false;
}

} // class RequestHolidayInterface
