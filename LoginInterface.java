import java.awt.*;
import java.awt.event.*;



// Program to implement a user interface.
public class LoginInterface extends JFrame implements ActionListener
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
    
    // Change fonts etc to match logo
    companyName.setFont(new Font("Serif", Font.BOLD, 32));
    companyName.setForeground(Color.black);
    
    productName.setFont(new Font("Serif", Font.BOLD, 16));
    productName.setForeground(Color.black);
    
    // First element for the companyHeaderPanel
    companyHeaderPanel.add(companyName);
    companyHeaderPanel.add(productName);
    
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
  public LoginInterface()
  {
    // Set the window title
    setTitle("IBMS: Driver - Request Holiday");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(0, 1));

    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    formatPanel(mainPanel);
    

   
    

    
    userList.setSelectedIndex(0);


 JPanel userJPanel = new JPanel();
    mainPanel.add(userJPanel);
    formatPanel(userJPanel);
    userJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    userJPanel.add(new JLabel("Select User"));
    userJPanel.add(userList);

    // Middle left of the main panel

    
    // Middle right of the main panel
    // Use a JPanel so the alignment matches everything else.
  
 

    userList.addActionListener(this);
     userList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               userListActionPerformed(evt);
            }
      });
  
    JPanel loginJPanel = new JPanel();
    mainPanel.add(loginJPanel);

    formatPanel(loginJPanel);
    loginJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    // JTextFields for the date components, with JLabels

   //+ loginJPanel.add(startDayJTextField);
        loginJPanel.add(new JLabel("   Login:   "));
    loginJPanel.add(driverIDJTextField);



// Top left of the main panel       

    
  	// Top right of the main panel
		JPanel passwordJPanel = new JPanel();
		mainPanel.add(passwordJPanel);
		formatPanel(passwordJPanel);
		passwordJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    passwordJPanel.add(new JLabel("Password:"));
		// Add the JTextField
		passwordJPanel.add(jPasswordField1);




    
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
  } // LoginInterface
  
  // Action performed method


  private void userListActionPerformed(java.awt.event.ActionEvent evt) {

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
                     //getConnect =1;
                    // valueOf = this.connected();
                  System.out.println(DriverInfo.getName(driverID) + " connected");
             DriverInterface theDriverInterface = new DriverInterface();
      theDriverInterface.setVisible(true);
     
      this.dispose();
                  }

           if( valueOf== false ){
       getConnect =0;
valueOf = this.connected();
              // CODE WOULD GO HERE TO CONNECT TO THE DATABASE
      ConfirmationInterface theConfirmationInterface = new ConfirmationInterface();
   
      theConfirmationInterface.setVisible(true);
      this.dispose();
        }
   

     }
    } // if
   catch(NumberFormatException e)
{
   getConnect =0;
valueOf = this.connected();
   ConfirmationInterface theConfirmationInterface = new ConfirmationInterface();
   
      theConfirmationInterface.setVisible(true);
      this.dispose();
}
  }//if
else
{
 String outPassword = jPasswordField1.getText() ;
 String loginName = driverIDJTextField.getText();
 if("Admin".equals(loginName) && "Admin".equals(outPassword) )
  {
    ControllerInterface theControllerInterface = new ControllerInterface();
   
      theControllerInterface.setVisible(true);
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
            
    LoginInterface theLoginInterface = new LoginInterface();
    
    // Make sure we can see it.
    theLoginInterface.setVisible(true);
  } // main

} // class LoginInterface
