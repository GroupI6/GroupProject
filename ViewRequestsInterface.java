import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Program to implement a user interface.
public class ViewRequestsInterface extends JFrame implements ActionListener
{
  static int[] idArray = new int[100];
  static int daysAlreadyTaken;
    static  int daysRequested;
   static int approved = -1;
  // JButtons for use on the interface.
  private JButton submitButton = new JButton("Approve");
  private JButton cancelButton = new JButton("Cancel Request");
  String[] requestList = {"Select Request(s)"};
  JComboBox viewList = new JComboBox(requestList) ;
  JLabel requestLabel  ;
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
    if (theLoginInterface.connected()==true)
      companyHeaderPanel.add(loginName);
    return(companyHeaderPanel);
  } // setHeading
  
  // Helper method for creating and formatting JButtons
 /* private static JButton makeButton(JButton button, JButton largestButton)
  {
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
 */ 
  // Firstly, we need a constructor to build the GUI.
  public ViewRequestsInterface()
  {
    // Set the window title
    setTitle("IBMS: View Requests");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new GridLayout(0, 1));
    mainPanel.setBackground(Color.white);
    
    // Format the buttons
    //submitButton = makeButton(submitButton, submitButton);
   // cancelButton = makeButton(cancelButton,submitButton);
    // Add a JLabel for the confirmation
   
    JLabel confirmationJLabel; 
    LoginInterface theLoginInterface = new LoginInterface();
    RequestHolidayInterface theRequestHolidayInterface = new RequestHolidayInterface();
     if (theLoginInterface.connected()==false)
       confirmationJLabel = new JLabel("Your login and password details are wrong ");
     else
       {
         if (theRequestHolidayInterface.requestedDays()==true)
         {
            confirmationJLabel = new JLabel("You have submitted your request for approval");
          
         }
         else
           confirmationJLabel = new JLabel("This is invalid request");
       }
  int k = 0;
  

   database.openBusDatabase();
        int[] driverIDs = DriverInfo.getDrivers();
        String[] driverNames = new String [driverIDs.length];
           System.out.println(driverIDs.length); 
        for (int i=0; i<driverIDs.length; i++)
            if(DriverInfo.getHolidaysRequest(driverIDs[i]) == 1)
             {
               k++;
               idArray[k]=driverIDs[i];
               viewList.addItem(DriverInfo.getName(driverIDs[i]));
             }



   
   JPanel requestJPanel = new JPanel();
    mainPanel.add(requestJPanel);
    requestJPanel.setBackground(Color.white);
    requestJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
   requestJPanel.add(viewList);



   requestLabel = new JLabel("");

   viewList.addActionListener(this);
     viewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               viewListActionPerformed(evt);
            }
      });


      
JPanel viewRequestJPanel = new JPanel();
    mainPanel.add(viewRequestJPanel);
    viewRequestJPanel.setBackground(Color.white);
    viewRequestJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
   viewRequestJPanel.add(requestLabel);



   JPanel submitJPanel = new JPanel();
    mainPanel.add(submitJPanel);
    submitJPanel.setBackground(Color.white);
    submitJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    submitJPanel.add(submitButton)   ; 
    submitJPanel.add(cancelButton);
    // Add JButtons to layout
    submitButton.addActionListener(this);
    cancelButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));

    
    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // ViewRequestsInterface
  
  // Action performed method
  private void viewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       if (viewList.getSelectedIndex() == 0)
       requestLabel.setText("Please select a request");
     else{
         daysAlreadyTaken = DriverInfo.getHolidaysLength(idArray[viewList.getSelectedIndex()]);
        daysRequested =  DriverInfo.getControllerHolidaysLength(idArray[viewList.getSelectedIndex()]);
       String textView = convertSimple(daysAlreadyTaken) + " days (s)he already taken and "  + convertSimple(daysRequested) + " days requested ";
       requestLabel.setText(textView);
       }
           
     // System.out.println(textView);
   }

  public void actionPerformed(ActionEvent thisEvent)
  {

 approved = -1;
   
  if(viewList.getSelectedIndex() != 0)
   {
    if(thisEvent.getSource() == submitButton)
     {
       DriverInfo.setHolidaysLength(idArray[viewList.getSelectedIndex()], daysRequested + daysAlreadyTaken);
        DriverInfo.setControllerHolidaysLength(idArray[viewList.getSelectedIndex()], 0);
        DriverInfo.setHolidaysRequest(idArray[viewList.getSelectedIndex()],0);
        DriverInfo.setHolidaysTaken(idArray[viewList.getSelectedIndex()],1 +  DriverInfo.getHolidaysTaken(idArray[viewList.getSelectedIndex()]));
        approved = 1;
         ConfirmationInterface theConfirmationInterface = new ConfirmationInterface();
   
      theConfirmationInterface.setVisible(true);
      this.dispose();


     }
     else if(thisEvent.getSource() == cancelButton)
     {
       approved = 0;
       DriverInfo.setControllerHolidaysLength(idArray[viewList.getSelectedIndex()], 0);
       DriverInfo.setHolidaysRequest(idArray[viewList.getSelectedIndex()],0);

       ConfirmationInterface theConfirmationInterface = new ConfirmationInterface();
       theConfirmationInterface.setVisible(true);
       this.dispose();
     }
    }
  } // actionPerformed

  public static String convertSimple(int i) {
    return "" + i;
}
       public int approved()
  {
    
     //   System.out.println("old pass : " + loginNumber);
     // System.out.println("new pass : " + outPassword);
      
            return approved;
   }
  
 
  public static void main(String[] args)
  {
    // Run the window.
    ViewRequestsInterface theViewRequestsInterface = new ViewRequestsInterface();
    
    // Make sure we can see it.
    theViewRequestsInterface.setVisible(true);
  } // main

} // class ViewRequestsInterface
