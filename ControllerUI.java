import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Program to implement a user interface.
public class ControllerUI extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton viewRequestsButton = new JButton("View Requests");
  private JButton findDriverButton = new JButton("Find Driver");
  private JButton logoutButton = new JButton("Log Out");
   
  // Firstly, we need a constructor to build the GUI.
  public ControllerUI()
  {
    // Set the window title
    setTitle("IBMS: Main");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Pixel gaps are 10 between each column and 20 between each row.
    contents.setLayout(new BorderLayout());
    contents.setBackground(Color.WHITE);    
    
    // Add the heading panel
    contents.add(BuildUI.setHeading(), BorderLayout.NORTH);
    
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    BuildUI.formatPanel(mainPanel);
    
     // Format the buttons
    viewRequestsButton = BuildUI.makeButton(viewRequestsButton, logoutButton);
    findDriverButton = BuildUI.makeButton(findDriverButton, logoutButton);
    logoutButton = BuildUI.makeButton(logoutButton, logoutButton);

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
     ViewRequestsUI theViewRequestsUI = new ViewRequestsUI();
      theViewRequestsUI.setVisible(true);
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
    ControllerUI theControllerUI = new ControllerUI();
    
    // Make sure we can see it.
    theControllerUI.setVisible(true);
  } // main
} // class ControllerUI
