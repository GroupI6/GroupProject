import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Program to implement a user interface.
public class ViewRequestsUI extends JFrame implements ActionListener
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

  // Firstly, we need a constructor to build the GUI.
  public ViewRequestsUI()
  {
    // Set the window title
    setTitle("IBMS: View Requests");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(BuildUI.setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new GridLayout(0, 1));
    BuildUI.formatPanel(mainPanel);
    
    // Format the buttons
    //submitButton = BuildUI.makeButton(submitButton, submitButton);
   // cancelButton = BuildUI.makeButton(cancelButton,submitButton);
    // Add a JLabel for the confirmation
   
    JLabel confirmationJLabel; 
    LoginUI theLoginInterface = new LoginUI();
    RequestHolidayUI theRequestHolidayInterface = new RequestHolidayUI();
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
  } // ViewRequestsUI
  
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
         ConfirmationUI theConfirmationInterface = new ConfirmationUI();
   
      theConfirmationInterface.setVisible(true);
      this.dispose();


     }
     else if(thisEvent.getSource() == cancelButton)
     {
       approved = 0;
       DriverInfo.setControllerHolidaysLength(idArray[viewList.getSelectedIndex()], 0);
       DriverInfo.setHolidaysRequest(idArray[viewList.getSelectedIndex()],0);

       ConfirmationUI theConfirmationInterface = new ConfirmationUI();
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
    ViewRequestsUI theViewRequestsUI = new ViewRequestsUI();
    
    // Make sure we can see it.
    theViewRequestsUI.setVisible(true);
  } // main

} // class ViewRequestsUI
