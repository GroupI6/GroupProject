import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Program to implement a user interface.
public class DriverInterface extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton requestHoliday = new JButton("Request A Holiday");
  private JButton viewRoster = new JButton("View Roster");
  private JButton viewTimetable = new JButton("View Timetable");
  
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
  public DriverInterface()
  {
    // Set the window title
    setTitle("IBMS Bus Company");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.SOUTH);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBackground(Color.white);
    
    // Format the buttons
    requestHoliday = makeButton(requestHoliday, requestHoliday);
    viewRoster = makeButton(viewRoster, requestHoliday);
    viewTimetable = makeButton(viewTimetable, requestHoliday);

    // Add JButtons to layout
    mainPanel.add(requestHoliday);
    requestHoliday.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    mainPanel.add(viewRoster);
    viewRoster.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    mainPanel.add(viewTimetable);
    viewTimetable.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  } // DriverInterface
  
  // Action performed method
  public void actionPerformed(ActionEvent thisEvent)
  {
    if(thisEvent.getSource() == requestHoliday)
      System.out.println("I am requesting a holiday");
    
    else if (thisEvent.getSource() == viewRoster)
      System.out.println("I am viewing the roster");
      
    else if (thisEvent.getSource() == viewTimetable)
      System.out.println("I am viewing the timetable");
  } // actionPerformed

} // class DriverInterface
