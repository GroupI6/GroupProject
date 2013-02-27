import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Program to implement a user interface.
public class DriverUI extends JFrame implements ActionListener
{
  // JButtons for use on the interface.
  private JButton requestHoliday = new JButton("Request A Holiday");
  private JButton viewRoster = new JButton("View Roster");
  private JButton viewTimetable = new JButton("View Timetable");
  private JButton logoutButton = new JButton("Log Out");
   
  // Firstly, we need a constructor to build the GUI.
  public DriverUI()
  {
    // Set the window title
    setTitle("IBMS: Driver");
    
    // Make contents appear.
    Container contents = getContentPane();
    
    // Set the heading
    contents.add(BuildUI.setHeading(), BorderLayout.NORTH);
           
    // Make another JPanel for the buttons - separate section of the screen.
    JPanel mainPanel = new JPanel();
    
    // Add mainPanel to the layout and format
    contents.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    BuildUI.formatPanel(mainPanel);

    // Format the buttons
    requestHoliday = BuildUI.makeButton(requestHoliday, requestHoliday);
    viewRoster = BuildUI.makeButton(viewRoster, requestHoliday);
    viewTimetable = BuildUI.makeButton(viewTimetable, requestHoliday);
    logoutButton = BuildUI.makeButton(logoutButton, requestHoliday);

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
mainPanel.add(logoutButton);
    logoutButton.addActionListener(this);
    mainPanel.add(Box.createRigidArea(new Dimension(10, 10)));

    // Set the default close operation and make the correct size.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
  } // DriverUI
  
  // Action performed method
  public void actionPerformed(ActionEvent thisEvent)
  {
    if(thisEvent.getSource() == requestHoliday)
    {
      RequestHolidayUI theRequestHolidayInterface = new RequestHolidayUI();
      theRequestHolidayInterface.setVisible(true);
      this.dispose();
    }
    
    else if (thisEvent.getSource() == viewRoster)
      System.out.println("I am viewing the roster");
      
    else if (thisEvent.getSource() == viewTimetable)
      System.out.println("I am viewing the timetable");
    else if(thisEvent.getSource() == logoutButton)
     {
      LoginUI theLoginInterface = new LoginUI();
     theLoginInterface.setVisible(true);
      this.dispose();
    }
  } // actionPerformed

} // class DriverUI
