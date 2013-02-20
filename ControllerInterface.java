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
public class ControllerInterface extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton viewRequestsButton = new JButton("View Requests");
  private JButton findDriverButton = new JButton("Find Driver");
  private JButton logoutButton = new JButton("Log Out");
  private JButton homeSelect = new JButton("Home");

  
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
  public ControllerInterface()
  {
    // Set the window title
    setTitle("IBMS: Main");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Pixel gaps are 10 between each column and 20 between each row.
    contents.setLayout(new BorderLayout());
    contents.setBackground(Color.WHITE);    
    
    // Add the heading panel
    contents.add(setHeading(), BorderLayout.NORTH);
    
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBackground(Color.white);
    
     // Format the buttons
    viewRequestsButton = makeButton(viewRequestsButton, logoutButton);
    findDriverButton = makeButton(findDriverButton, logoutButton);
    logoutButton = makeButton(logoutButton, logoutButton);
    homeSelect= makeButton(homeSelect,logoutButton);

    // Add JButtons to layout
    mainPanel.add(viewRequestsButton);
    viewRequestsButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    mainPanel.add(findDriverButton);
    findDriverButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    mainPanel.add(logoutButton);
    logoutButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
  //  mainPanel.add(homeSelect);
   // homeSelect.addActionListener(this);
    //mainPanel.add(Box.createRigidArea(new Dimension(2, 10)));
    
    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // ControllerInterface
  
  // Action performed method
  public void actionPerformed(ActionEvent event)
  {
    if(event.getSource() == viewRequestsButton)
    {
     ViewRequestsInterface theViewRequestsInterface = new ViewRequestsInterface();
      theViewRequestsInterface.setVisible(true);
     this.dispose();
      //System.out.println("I pressed the passenger button");
    }
    else if (event.getSource() == findDriverButton)
    {
       System.out.println("I pressed the find driver button");
    } // if
      
    else if (event.getSource() == logoutButton)
      System.out.println("I pressed the logout button");
  } // actionPerformed
  
  public static void main(String[] args)
  {
    // Run the window.
    ControllerInterface theControllerInterface = new ControllerInterface();
    
    // Make sure we can see it.
    theControllerInterface.setVisible(true);
  } // main
} // class ControllerInterface
