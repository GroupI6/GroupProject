import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Program to implement a user interface.
public class LoginUI extends JFrame implements ActionListener
{
  static int getAction = 0;
   static int getConnect = 0;
   static int driverID;
    static boolean valueOf=false;
  // JButtons for use on the interface.
  private JButton submitRequestButton = new JButton("Submit Request");
  private JButton getSelect = new JButton("pop-up");
  
  String[] users = {"Driver","Controller"};

  JComboBox userList = new JComboBox(users);
 
  // JTextFields for use on the interface.
  JTextField driverIDJTextField = new JTextField(10);
  private javax.swing.JPasswordField jPasswordField1 = new javax.swing.JPasswordField(10);
  private final JTextField startDayJTextField = new JTextField(2);
  private final JTextField startMonthJTextField = new JTextField(2);
  private final JTextField startYearJTextField = new JTextField(4);
  private final JTextField endDayJTextField = new JTextField(2);
  private final JTextField endMonthJTextField = new JTextField(2);
  private final JTextField endYearJTextField = new JTextField(4);

 
  // Firstly, we need a constructor to build the GUI.
  public LoginUI()
  {
    // Set the window title
    setTitle("IBMS: Driver - Request Holiday");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(BuildUI.setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(0, 1));

    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    BuildUI.formatPanel(mainPanel);
 
    userList.setSelectedIndex(0);
    
    JPanel userJPanel = new JPanel();
    mainPanel.add(userJPanel);
    BuildUI.formatPanel(userJPanel);
    userJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    userJPanel.add(new JLabel("Select User"));
    userJPanel.add(userList);


    userList.addActionListener(this);
    userList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               userListActionPerformed(evt);
            }
      });
  
    JPanel loginJPanel = new JPanel();
    mainPanel.add(loginJPanel);

    BuildUI.formatPanel(loginJPanel);
    loginJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    // loginJPanel.add(startDayJTextField);
    loginJPanel.add(new JLabel("   Login:   "));
    loginJPanel.add(driverIDJTextField);

    // Top right of the main panel
  	JPanel passwordJPanel = new JPanel();
		mainPanel.add(passwordJPanel);
		BuildUI.formatPanel(passwordJPanel);
		passwordJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    passwordJPanel.add(new JLabel("Password:"));
		// Add the JTextField
		passwordJPanel.add(jPasswordField1);

    // Final panel to hold the submit button
    JPanel buttonPanel = new JPanel();
    contents.add(buttonPanel, BorderLayout.SOUTH);
    BuildUI.formatPanel(buttonPanel);
    
    // Format the buttons
    submitRequestButton = BuildUI.makeButton(submitRequestButton, submitRequestButton);

    // Add JButtons to layout
    buttonPanel.add(submitRequestButton);
    submitRequestButton.addActionListener(this);

    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // LoginUI
  
  // Action performed method


  private void userListActionPerformed(java.awt.event.ActionEvent evt) 
  {

   if(userList.getSelectedIndex() == 0)
   getAction = 0;
    else
    getAction = 1;
  }


  public void actionPerformed(ActionEvent thisEvent)
  {
if (getAction == 0)
 {
  try{

    if(thisEvent.getSource() == submitRequestButton)
    {
      // Get all the information from the drivers input.Date in java difference

    driverID = Integer.parseInt(driverIDJTextField.getText());
          database.openBusDatabase();

          getConnect =0;
          
         int[] driverIDs = DriverInfo.getDrivers();    
         
       String loginNumber =  DriverInfo.getNumber(driverID);  
       String outPassword = jPasswordField1.getText() ;
       for (int i=0; i<driverIDs.length; i++)
    { 
       if (driverID == driverIDs[i]) {    
      if ( outPassword.equals(loginNumber)) 
               getConnect=1;
           else getConnect = 0;
}
}
     valueOf = this.connected();

         String getDriverName = this.loggedName();
            
             if (valueOf== true)
                 { 
                  System.out.println(DriverInfo.getName(driverID) + " connected");
             DriverUI theDriverUI = new DriverUI();
      theDriverUI.setVisible(true);
     
      this.dispose();
                  }

           if( valueOf== false ){
       getConnect =0;
valueOf = this.connected();
              // CODE WOULD GO HERE TO CONNECT TO THE DATABASE
      ConfirmationUI theConfirmationUI = new ConfirmationUI();
   
      theConfirmationUI.setVisible(true);
      this.dispose();
        }
   

     }
    } // if
   catch(NumberFormatException e)
{
   getConnect =0;
valueOf = this.connected();
   ConfirmationUI theConfirmationUI = new ConfirmationUI();
   
      theConfirmationUI.setVisible(true);
      this.dispose();
}
  }//if
else
{
 String outPassword = jPasswordField1.getText() ;
 String loginName = driverIDJTextField.getText();
 if("Admin".equals(loginName) && "Admin".equals(outPassword) )
  {
    ControllerUI theControllerUI = new ControllerUI();
   
      theControllerUI.setVisible(true);
      this.dispose();
   }
}//else

  

  } // actionPerformed




  public String loggedName()
  {
    valueOf = this.connected();
   if (valueOf==true)
     return DriverInfo.getName(driverID);
   else
     return ""; 
  }


  public int loggedDriverID()
  {
   return driverID;
   }



   public boolean connected()
  {
    
     //   System.out.println("old pass : " + loginNumber);
     // System.out.println("new pass : " + outPassword);
      
            if ( getConnect == 1) 
               return true;
           else    
                 return false;
   }
  
     public static void main(String[] args)
  {
    // Run the window.
            
    LoginUI theLoginUI = new LoginUI();
    
    // Make sure we can see it.
    theLoginUI.setVisible(true);
  } // main

} // class LoginUI
