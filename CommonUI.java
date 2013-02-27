import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Program to implement a user interface.
public class CommonUI extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton passengerSelect = new JButton("Passenger");
  private JButton driverSelect = new JButton("Driver");
  private JButton controllerSelect = new JButton("Controller");
  private JButton homeSelect = new JButton("Home");

  // Firstly, we need a constructor to build the GUI.
  public CommonUI()
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
    BuildUI.formatPanel(mainPanel);
    
     // Format the buttons
    passengerSelect = BuildUI.makeButton(passengerSelect, controllerSelect);
    driverSelect = BuildUI.makeButton(driverSelect, controllerSelect);
    controllerSelect = BuildUI.makeButton(controllerSelect, controllerSelect);
    homeSelect = BuildUI.makeButton(homeSelect,controllerSelect);

    // Add JButtons to layout
    mainPanel.add(passengerSelect);
    passengerSelect.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    mainPanel.add(driverSelect);
    driverSelect.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    mainPanel.add(controllerSelect);
    controllerSelect.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    mainPanel.add(homeSelect);
    homeSelect.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));
    
    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // CommonInterface
  
  // Action performed method
  public void actionPerformed(ActionEvent event)
  {
    if(event.getSource() == passengerSelect)
      System.out.println("I pressed the passenger button");
    
    else if (event.getSource() == driverSelect)
    {
      LoginInterface theLoginInterface = new LoginInterface();
      theLoginInterface.setVisible(true);
      this.dispose();
    } // if
      
    else if (event.getSource() == controllerSelect)
      System.out.println("I pressed the controller button");
  } // actionPerformed
  
  public static void main(String[] args)
  {
    // Run the window.
    CommonUI theCommonUI = new CommonUI();
    
    // Make sure we can see it.
    theCommonUI.setVisible(true);
  } // main
} // class CommonUI
