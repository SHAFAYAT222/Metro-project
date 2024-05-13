package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Train;
import EntityList.TrainList;
import File.FileIOTrain;

public class TrainGUI extends JFrame implements ActionListener, MouseListener {
    Font titleFont = new Font("Cambria", Font.BOLD, 30);
    Font font15 = new Font("Cambria", Font.BOLD, 15);

    JTextField idTextField, nameTextField, sourceTextField, destinationTextField, departureTextField, arrivalTextField;
    JTextField searchTextField, deleteTextField;
    JButton addButton, updateButton, searchButton, deleteButton, clearButton, showAllButton,backButton;
    JTextArea textArea;
    TrainList trainList;
	
	Dashboard dashboard;

    public TrainGUI(TrainList trainList, Dashboard dashboard) {
        super("Metrorail Management GUI");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1000, 800);
        super.setLocation(150, 0);
          

        ImageIcon backgroundIcon = new ImageIcon("./Resources/Icon/pp.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1000, 800);

        super.setContentPane(backgroundLabel);

        super.setLayout(null);

        

        this.trainList = trainList;
		
		this.dashboard = dashboard;

        JLabel title = new JLabel("Metro Rail Management System");
        title.setBounds(230, 10, 500, 50);
        title.setFont(titleFont);

        JLabel subTitle = new JLabel("TRAIN INFORMATIONS");
        subTitle.setBounds(300, 60, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));

        int top = 100;
        int gap = 40;

        JLabel idLabel = new JLabel("Train ID");
        idLabel.setBounds(20, top, 200, 30);
        idLabel.setFont(font15);

        idTextField = new JTextField();
        idTextField.setBounds(20, top += gap, 200, 30);
        idTextField.setFont(font15);

        JLabel nameLabel = new JLabel("Train Name");
        nameLabel.setBounds(20, top += gap, 200, 30);
        nameLabel.setFont(font15);

        nameTextField = new JTextField();
        nameTextField.setBounds(20, top += gap, 200, 30);
        nameTextField.setFont(font15);

        JLabel sourceLabel = new JLabel("Source Station");
        sourceLabel.setBounds(20, top += gap, 200, 30);
        sourceLabel.setFont(font15);

        sourceTextField = new JTextField();
        sourceTextField.setBounds(20, top += gap, 200, 30);
        sourceTextField.setFont(font15);

        JLabel destinationLabel = new JLabel("Destination Station");
        destinationLabel.setBounds(20, top += gap, 200, 30);
        destinationLabel.setFont(font15);

        destinationTextField = new JTextField();
        destinationTextField.setBounds(20, top += gap, 200, 30);
        destinationTextField.setFont(font15);

        JLabel departureLabel = new JLabel("Departure Time");
        departureLabel.setBounds(20, top += gap, 200, 30);
        departureLabel.setFont(font15);

        departureTextField = new JTextField();
        departureTextField.setBounds(20, top += gap, 200, 30);
        departureTextField.setFont(font15);

        JLabel arrivalLabel = new JLabel("Arrival Time");
        arrivalLabel.setBounds(20, top += gap, 200, 30);
        arrivalLabel.setFont(font15);

        arrivalTextField = new JTextField();
        arrivalTextField.setBounds(20, top += gap, 200, 30);
        arrivalTextField.setFont(font15);

        addButton = new JButton("ADD");
        addButton.setBounds(20, top += gap + 20, 200, 30);
        addButton.setBackground(Color.GREEN);
        addButton.setFont(font15);
        addButton.addActionListener(this);
        addButton.addMouseListener(this);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(20, top += gap, 200, 30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(font15);
        updateButton.addActionListener(this);
		
		 backButton = new JButton("Back");
        backButton.setBounds(700, 600, 200, 30);
        backButton.setFont(font15);
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        this.add(backButton);
		
		this.dashboard = dashboard;

        textArea = new JTextArea();
        textArea.setFont(font15);
        textArea.setEditable(false);

        reloadAllTrains();

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBounds(230, 120, 460, 500);

        super.add(jsp);

        top = 100;
        gap = 40;

        JLabel searchLabel = new JLabel("Search By Train ID");
        searchLabel.setBounds(700, top, 200, 30);
        searchLabel.setFont(font15);

        searchTextField = new JTextField();
        searchTextField.setBounds(700, top += gap, 200, 30);
        searchTextField.setFont(font15);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(700, top += gap, 200, 30);
        searchButton.setBackground(Color.YELLOW);
        searchButton.setFont(font15);
        searchButton.addActionListener(this);

        JLabel deleteLabel = new JLabel("Delete By Train ID");
        deleteLabel.setBounds(700, top += gap, 200, 30);
        deleteLabel.setFont(font15);

        deleteTextField = new JTextField();
        deleteTextField.setBounds(700, top += gap, 200, 30);
        deleteTextField.setFont(font15);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, top += gap, 200, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(font15);
        deleteButton.addActionListener(this);

        showAllButton = new JButton("SHOW ALL");
        showAllButton.setBounds(700, 500, 200, 30);
        showAllButton.setBackground(Color.PINK);
        showAllButton.setForeground(Color.WHITE);
        showAllButton.setFont(font15);
        showAllButton.addActionListener(this);

        clearButton = new JButton("CLEAR SCREEN");
        clearButton.setBounds(700, 550, 200, 30);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(font15);
        clearButton.addActionListener(this);

        super.add(title);
        super.add(subTitle);
        super.add(idLabel);
        super.add(idTextField);
        super.add(nameLabel);
        super.add(nameTextField);
        super.add(sourceLabel);
        super.add(sourceTextField);
        super.add(destinationLabel);
        super.add(destinationTextField);
        super.add(departureLabel);
        super.add(departureTextField);
        super.add(arrivalLabel);
        super.add(arrivalTextField);
        super.add(addButton);
        super.add(updateButton);
        super.add(searchLabel);
        super.add(searchTextField);
        super.add(searchButton);
        super.add(deleteLabel);
        super.add(deleteTextField);
        super.add(deleteButton);
        super.add(clearButton);
        super.add(showAllButton);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD")) {
            System.out.println("ADD CLICKED");

            if (
                    !idTextField.getText().isEmpty() &&
                            !nameTextField.getText().isEmpty() &&
                            !sourceTextField.getText().isEmpty() &&
                            !destinationTextField.getText().isEmpty() &&
                            !departureTextField.getText().isEmpty() &&
                            !arrivalTextField.getText().isEmpty()
            ) {

                if (trainList.getByTrainID(idTextField.getText()) == null) {

                    Train train = new Train(
                            idTextField.getText(),
                            nameTextField.getText(),
                            sourceTextField.getText(),
                            destinationTextField.getText(),
                            departureTextField.getText(),
                            arrivalTextField.getText()
                    );

                    trainList.insert(train);
                    FileIOTrain.writeTrainInFile(train);

                    reloadAllTrains();
                } else {
                    JOptionPane.showMessageDialog(this, "This ID is Already in use, Provide Another ID", "Provide Unique ID", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide all Information for the Train", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");

            if (!idTextField.getText().isEmpty()) {
                Train train = trainList.getByTrainID(idTextField.getText());
                if (train != null) {
                    if (!nameTextField.getText().isEmpty()) {
                        train.setTrainName(nameTextField.getText());
                    }

                    if (!sourceTextField.getText().isEmpty()) {
                        train.setSourceStation(sourceTextField.getText());
                    }

                    if (!destinationTextField.getText().isEmpty()) {
                        train.setDestinationStation(destinationTextField.getText());
                    }

                    if (!departureTextField.getText().isEmpty()) {
                        train.setDepartureTime(departureTextField.getText());
                    }

                    if (!arrivalTextField.getText().isEmpty()) {
                        train.setArrivalTime(arrivalTextField.getText());
                    }

                    FileIOTrain.updateTrainsInFile(trainList);

                    reloadAllTrains();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Train by This ID", "Train Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Train", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (searchButton == e.getSource()) {
            System.out.println("SEARCH CLICKED");

            Train train = trainList.getByTrainID(searchTextField.getText());
            if (train != null) {
                textArea.setText(train.getTrainInfoAsString());
            } else {
                JOptionPane.showMessageDialog(this, "NO TRAIN FOUND.", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        } else if (deleteButton == e.getSource()) {
            System.out.println("DELETE CLICKED");

            if (!deleteTextField.getText().isEmpty()) {
                String trainIDToDelete = deleteTextField.getText();
                Train trainToDelete = trainList.getByTrainID(trainIDToDelete);

                if (trainToDelete != null) {
                    trainList.delete(trainToDelete); 
                    FileIOTrain.updateTrainsInFile(trainList);
                    reloadAllTrains();
                } else {
                    JOptionPane.showMessageDialog(this, "No Available Train by This ID", "Train Not Found", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide ID for the Train to Delete", "Missing Information", JOptionPane.ERROR_MESSAGE);
            }

        } else if (showAllButton == e.getSource()) {
            System.out.println("SHOW ALL CLICKED");
            

            reloadAllTrains();
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

    public void reloadAllTrains() {
        textArea.setText(trainList.getAllTrainsAsString());
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




