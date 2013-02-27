import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


// Program to implement a user interface.
public class ConfirmationUI extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton backButton = new JButton("Back");
  
  // Firstly, we need a constructor to build the GUI.
  public ConfirmationUI()
  {
    // Set the window title
    setTitle("IBMS: Confirm Request");
    
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
    backButton = BuildUI.makeButton(backButton, backButton);

    // Add a JLabel for the confirmation
   
    JLabel confirmationJLabel; 
    LoginUI theLoginUI = new LoginUI();
    RequestHolidayUI theRequestHolidayInterface = new RequestHolidayUI();
    ViewRequestsUI theViewRequestsUI = new ViewRequestsUI();
    
     if (theViewRequestsUI.approved() == 1)
         confirmationJLabel = new JLabel("You have approved request ");
      else if(theViewRequestsUI.approved() == 0)
         confirmationJLabel = new JLabel("You have cancelled request ");
     else
      {
     if (theLoginUI.connected()==false)
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
      }
    mainPanel.add(confirmationJLabel);
    // Add JButtons to layout
    mainPanel.add(backButton);
    backButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));

    
    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // ConfirmationInterface
  
  // Action performed method
  public void actionPerformed(ActionEvent thisEvent)
  {
  //database.openBusDatabase();
    if(thisEvent.getSource() == backButton)
     {
   ViewRequestsUI theViewRequestsUI = new ViewRequestsUI();
   if(theViewRequestsUI.approved() != -1)
    {
      ControllerUI theControllerUI = new ControllerUI();
      theControllerUI.setVisible(true); 
this.dispose(); 
   }
else
{
      LoginUI theLoginUI = new LoginUI();
     if (theLoginUI.connected()==false)
    {
   theLoginUI.setVisible(true);
   this.dispose();
   }

     else 
{
      DriverUI theDriverUI = new DriverUI();
      theDriverUI.setVisible(true);
      this.dispose();
} 

}
   }
  } // actionPerformed

} // class ConfirmationUI
