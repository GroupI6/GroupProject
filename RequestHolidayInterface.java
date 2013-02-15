import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;


// Program to implement a user interface.
public class RequestHolidayInterface extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton submitRequestButton = new JButton("Submit Request");
  
  // JTextFields for use on the interface.
  private final JTextField driverIDJTextField = new JTextField(5);
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
    
    // Top left of the main panel       
    mainPanel.add(new JLabel("Driver ID"));
    
  	// Top right of the main panel
		JPanel driverIDPanel = new JPanel();
		mainPanel.add(driverIDPanel);
		driverIDPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// Add the JTextField
		driverIDPanel.add(driverIDJTextField);
    
    
    // Middle left of the main panel
    mainPanel.add(new JLabel("Start Date:"));
    
    // Middle right of the main panel
    // Use a JPanel so the alignment matches everything else.
    JPanel startDateJPanel = new JPanel();
    mainPanel.add(startDateJPanel);
    startDateJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    // JTextFields for the date components, with JLabels
    startDateJPanel.add(startDayJTextField);
    startDateJPanel.add(new JLabel("/"));
    startDateJPanel.add(startMonthJTextField);
    startDateJPanel.add(new JLabel("/"));
    startDateJPanel.add(startYearJTextField);
    
    
    // Bottom left of the main panel
    mainPanel.add(new JLabel("End Date:"));
    
    // Bottom right of the main panel
    // Use a JPanel so the alignment matches everything else.
    JPanel endDateJPanel = new JPanel();
    mainPanel.add(endDateJPanel);
    endDateJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    // JTextFields for the date components, with JLabels
    endDateJPanel.add(endDayJTextField);
    endDateJPanel.add(new JLabel("/"));
    endDateJPanel.add(endMonthJTextField);
    endDateJPanel.add(new JLabel("/"));
    endDateJPanel.add(endYearJTextField);
    
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
  public void actionPerformed(ActionEvent thisEvent)
  {
    if(thisEvent.getSource() == submitRequestButton)
    {
      // Get all the information from the drivers input.
      try
      {
        int driverID = Integer.parseInt(driverIDJTextField.getText());
        
        Date startDate 
        = new Date((Long.parseLong(startDayJTextField.getText()),
        					 Integer.parseInt(startMonthJTextField.getText()),
        					 Integer.parseInt(startYearJTextField.getText()));
        					 
        Date endDate 
        = new Date(Integer.parseInt(endDayJTextField.getText()),
        					 Integer.parseInt(endMonthJTextField.getText()),
        					 Integer.parseInt(endYearJTextField.getText()));  
        					             
        System.out.println(driverID);
        System.out.println(startDate);
        System.out.println(endDate);
      } // try
      
      catch (NumberFormatException exception)
      {
        System.out.println("NOOOOOOOOO");
      } // catch
      // First check that the DriverID has been inputted correctly.
      
      System.out.println("You have submitted your request for approval");
    } // if
  } // actionPerformed

} // class RequestHolidayInterface
