package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Schedule;
import EntityList.ScheduleList;
import File.FileIOSchedule;

public class ScheduleGUI extends JFrame implements ActionListener, MouseListener {
    Font titleFont = new Font("Cambria", Font.BOLD, 32);
    Font font15 = new Font("Cambria", Font.BOLD, 16);

    JTextField trainIDTextField, trainNameTextField, scheduleIDTextField, sourceStationTextField,
            destinationStationTextField, departureTimeTextField, arrivalTimeTextField;
    JTextField searchTextField, deleteTextField;
    JButton addButton, updateButton, searchButton, deleteButton, clearButton, showAllButton,backButton;

    JTextArea textArea;
    ScheduleList scheduleList;
	
	Dashboard dashboard;

    public ScheduleGUI(ScheduleList scheduleList,Dashboard dashboard) {
        super("MetroRail Management System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocation(150, 0);

        ImageIcon backgroundIcon = new ImageIcon("./Resources/Icon/ff.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1000, 800);

        super.setContentPane(backgroundLabel);
        this.setLayout(null);

        this.scheduleList = scheduleList;
		
		this.dashboard = dashboard;

        // Title
        JLabel title = new JLabel("Metro Rail Management System");
        title.setBounds(230, 10, 500, 50);
        title.setFont(titleFont);
        this.add(title);

        // Subtitle
        JLabel subTitle = new JLabel("Schedules Information");
        subTitle.setBounds(300, 60, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));
        this.add(subTitle);

        // Schedule Entry Form
        int top = 100;
        int gap = 40;

        // Train ID Entry
        JLabel trainIDLabel = new JLabel("Train ID");
        trainIDLabel.setBounds(20, top, 200, 30);
        trainIDLabel.setFont(font15);
        this.add(trainIDLabel);

        trainIDTextField = new JTextField();
        trainIDTextField.setBounds(20, top += gap, 200, 30);
        trainIDTextField.setFont(font15);
        this.add(trainIDTextField);

        // Train Name Entry
        JLabel trainNameLabel = new JLabel("Train Name");
        trainNameLabel.setBounds(20, top += gap, 200, 20);
        trainNameLabel.setFont(font15);
        this.add(trainNameLabel);

        trainNameTextField = new JTextField();
        trainNameTextField.setBounds(20, top += gap, 200, 30);
        trainNameTextField.setFont(font15);
        this.add(trainNameTextField);

        // Schedule ID Entry
        JLabel scheduleIDLabel = new JLabel("Schedule ID");
        scheduleIDLabel.setBounds(20, top += gap, 200, 20);
        scheduleIDLabel.setFont(font15);
        this.add(scheduleIDLabel);

        scheduleIDTextField = new JTextField();
        scheduleIDTextField.setBounds(20, top += gap, 200, 30);
        scheduleIDTextField.setFont(font15);
        this.add(scheduleIDTextField);

        // Source Station Entry
        JLabel sourceStationLabel = new JLabel("Source Station");
        sourceStationLabel.setBounds(20, top += gap, 200, 20);
        sourceStationLabel.setFont(font15);
        this.add(sourceStationLabel);

        sourceStationTextField = new JTextField();
        sourceStationTextField.setBounds(20, top += gap, 200, 30);
        sourceStationTextField.setFont(font15);
        this.add(sourceStationTextField);

        // Destination Station Entry
        JLabel destinationStationLabel = new JLabel("Destination Station");
        destinationStationLabel.setBounds(20, top += gap, 200, 20);
        destinationStationLabel.setFont(font15);
        this.add(destinationStationLabel);

        destinationStationTextField = new JTextField();
        destinationStationTextField.setBounds(20, top += gap, 200, 30);
        destinationStationTextField.setFont(font15);
        this.add(destinationStationTextField);

        // Departure Time Entry
        JLabel departureTimeLabel = new JLabel("Departure Time");
        departureTimeLabel.setBounds(20, top += gap, 200, 20);
        departureTimeLabel.setFont(font15);
        this.add(departureTimeLabel);

        departureTimeTextField = new JTextField();
        departureTimeTextField.setBounds(20, top += gap, 200, 30);
        departureTimeTextField.setFont(font15);
        this.add(departureTimeTextField);

        // Arrival Time Entry
        JLabel arrivalTimeLabel = new JLabel("Arrival Time");
        arrivalTimeLabel.setBounds(20, top += gap, 200, 20);
        arrivalTimeLabel.setFont(font15);
        this.add(arrivalTimeLabel);

        arrivalTimeTextField = new JTextField();
        arrivalTimeTextField.setBounds(20, top += gap, 200, 30);
        arrivalTimeTextField.setFont(font15);
        this.add(arrivalTimeTextField);

        // Add Button
        addButton = new JButton("Add");
        addButton.setBounds(20, top += gap + 10, 200, 30);
        addButton.setFont(font15);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(this);
        this.add(addButton);

        // Update Button
        updateButton = new JButton("Update");
        updateButton.setBounds(20, top += gap + 20, 200, 30);
        updateButton.setFont(font15);
        updateButton.setBackground(Color.GREEN);
        updateButton.addActionListener(this);
        this.add(updateButton);
		
		 backButton = new JButton("Back");
        backButton.setBounds(700, 600, 200, 30);
        backButton.setFont(font15);
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        this.add(backButton);
		
		this.dashboard = dashboard;

        // Center Component
        textArea = new JTextArea();
        textArea.setBounds(0, 0, 460, 470);
        textArea.setFont(font15);
        textArea.setEditable(false);

        reloadAllSchedules();

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBounds(230, 120, 460, 470);
        this.add(jsp);

        // Right Side Components
        top = 100;
        gap = 40;

        // Schedule Search Entry
        JLabel searchLabel = new JLabel("Search By Schedule ID");
        searchLabel.setBounds(700, top, 200, 30);
        searchLabel.setFont(font15);
        this.add(searchLabel);

        searchTextField = new JTextField();
        searchTextField.setBounds(700, top += gap, 200, 30);
        searchTextField.setFont(font15);
        this.add(searchTextField);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(700, top += gap, 200, 30);
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);
        this.add(searchButton);

        // Schedule Delete Entry
        JLabel deleteLabel = new JLabel("DELETE By Schedule ID");
        deleteLabel.setBounds(700, top += gap, 200, 30);
        deleteLabel.setFont(font15);
        this.add(deleteLabel);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(700, top += gap, 200, 30);
        deleteTextField.setFont(font15);
        this.add(deleteTextField);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, top += gap, 200, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(font15);
        deleteButton.addActionListener(this);
        this.add(deleteButton);

        // Show All Button
        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(700, 500, 200, 30);
        showAllButton.setBackground(Color.PINK);
        showAllButton.setForeground(Color.WHITE);
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);
        this.add(showAllButton);

        // Clear Screen
        clearButton = new JButton("CLEAR SCREEN");
        clearButton.setBounds(700, 550, 200, 30);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(font15);
        clearButton.addActionListener(this);
        this.add(clearButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (!trainIDTextField.getText().isEmpty() &&
                    !trainNameTextField.getText().isEmpty() &&
                    !scheduleIDTextField.getText().isEmpty() &&
                    !sourceStationTextField.getText().isEmpty() &&
                    !destinationStationTextField.getText().isEmpty() &&
                    !departureTimeTextField.getText().isEmpty() &&
                    !arrivalTimeTextField.getText().isEmpty()) {

                if (scheduleList.getByScheduleID(scheduleIDTextField.getText()) == null) {

                    Schedule schedule = new Schedule(
                            trainIDTextField.getText(),
                            trainNameTextField.getText(),
                            scheduleIDTextField.getText(),
                            sourceStationTextField.getText(),
                            destinationStationTextField.getText(),
                            departureTimeTextField.getText(),
                            arrivalTimeTextField.getText()
                    );

                    scheduleList.insert(schedule);
                    FileIOSchedule.writeScheduleInFile(schedule);
                    FileIOSchedule.updateSchedulesInFile(scheduleList);

                    reloadAllSchedules();
                } else {
                    JOptionPane.showMessageDialog(this, "This Schedule ID is Already in use, Provide Another ID", "Provide Unique Schedule ID", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide all Information for the Schedule", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == updateButton) {
            if (!scheduleIDTextField.getText().isEmpty()) {
                Schedule schedule = scheduleList.getByScheduleID(scheduleIDTextField.getText());
                if (schedule != null) {
                    if (!trainIDTextField.getText().isEmpty()) {
                        schedule.setTrainID(trainIDTextField.getText());
                    }

                    if (!trainNameTextField.getText().isEmpty()) {
                        schedule.setTrainName(trainNameTextField.getText());
                    }

                    if (!sourceStationTextField.getText().isEmpty()) {
                        schedule.setSourceStation(sourceStationTextField.getText());
                    }

                    if (!destinationStationTextField.getText().isEmpty()) {
                        schedule.setDestinationStation(destinationStationTextField.getText());
                    }

                    if (!departureTimeTextField.getText().isEmpty()) {
                        schedule.setDepartureTime(departureTimeTextField.getText());
                    }

                    if (!arrivalTimeTextField.getText().isEmpty()) {
                        schedule.setArrivalTime(arrivalTimeTextField.getText());
                    }

                    FileIOSchedule.updateSchedulesInFile(scheduleList);

                    reloadAllSchedules();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Schedule by This Schedule ID", " Schedule Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide Schedule ID for the Schedule ", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == searchButton) {
            System.out.println("SEARCH CLICKED");

            Schedule schedule = scheduleList.getByScheduleID(searchTextField.getText());
            if (schedule != null) {
                textArea.setText(schedule.getTrainInfoAsString());
            } else {

                JOptionPane.showMessageDialog(this, "NO Schedule FOUND.", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");

            String deleteScheduleID = deleteTextField.getText();

            if (!deleteScheduleID.isEmpty()) {
                Schedule scheduleToDelete = scheduleList.getByScheduleID(deleteScheduleID);

                if (scheduleToDelete != null) {
                    scheduleList.delete(scheduleToDelete);
                    FileIOSchedule.updateSchedulesInFile(scheduleList);
                    reloadAllSchedules();
                } else {
                    JOptionPane.showMessageDialog(this, "No Schedule found with the provided Schedule ID", "Schedule Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please provide Schedule ID to delete", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (showAllButton == e.getSource()) {
            System.out.println("SHOW ALL CLICKED");
           
		   
		   reloadAllSchedules();
        } else if (clearButton == e.getSource()) {
            System.out.println("CLEAR CLICKED");
            textArea.setText("");
        } else if (backButton == e.getSource()) {
            // Handle back button action here
            // You can decide what action to perform when the back button is clicked
            // For example, you can close the current window or navigate to another screen
            // For now, let's just print a message
            System.out.println("BACK CLICKED");

            // Show the Dashboard again
            dashboard.showDashboard();
            this.dispose(); // Close the current window
        }
    }

    public void reloadAllSchedules() {
        textArea.setText(scheduleList.getAllSchedulesAsString());
    }

    public void mouseExited(MouseEvent me) {
        if (addButton == me.getSource()) {
            addButton.setBackground(Color.GREEN);
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (addButton == me.getSource()) {
            addButton.setBackground(Color.GRAY);
        }
    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseClicked(MouseEvent me) {

    }
}

