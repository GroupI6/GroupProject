import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Program to implement a user interface.
public class ConfirmationInterface extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton backButton = new JButton("Back");
  
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
  private static JButton makeButton(JButton button, JButton largestButton)
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
  
  // Firstly, we need a constructor to build the GUI.
  public ConfirmationInterface()
  {
    // Set the window title
    setTitle("IBMS: Confirm Request");
    
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
    backButton = makeButton(backButton, backButton);

    // Add a JLabel for the confirmation
   
    JLabel confirmationJLabel; 
    LoginInterface theLoginInterface = new LoginInterface();
    RequestHolidayInterface theRequestHolidayInterface = new RequestHolidayInterface();
    ViewRequestsInterface theViewRequestsInterface = new ViewRequestsInterface();
    
     if (theViewRequestsInterface.approved() == 1)
         confirmationJLabel = new JLabel("You have approved request ");
      else if(theViewRequestsInterface.approved() == 0)
         confirmationJLabel = new JLabel("You have cancelled request ");
     else
      {
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
   ViewRequestsInterface theViewRequestsInterface = new ViewRequestsInterface();
   if(theViewRequestsInterface.approved() != -1)
    {
      ControllerInterface theControllerInterface = new ControllerInterface();
      theControllerInterface.setVisible(true); 
this.dispose(); 
   }
else
{
      LoginInterface theLoginInterface = new LoginInterface();
     if (theLoginInterface.connected()==false)
    {
   theLoginInterface.setVisible(true);
   this.dispose();
   }

     else 
{
      DriverInterface theDriverInterface = new DriverInterface();
      theDriverInterface.setVisible(true);
      this.dispose();
} 

}
   }
  } // actionPerformed

} // class ConfirmationInterface
