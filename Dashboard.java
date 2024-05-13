package GUI;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton passengersButton, trainsButton, schedulesButton, employeesButton, foodButton;
	
	foodlist foodlist=new foodlist();
	
	EmployeeGUI employeeGUI;
	PassengerGUI passengerGUI;
	TrainGUI trainGUI;
	ScheduleGUI scheduleGUI;

    public Dashboard() {
        setTitle("MetroRail Management System - Dashboard");
         

        passengersButton = new JButton("Passengers");
        trainsButton = new JButton("Trains");
        schedulesButton = new JButton("Schedules");
        employeesButton = new JButton("Employees");
        foodButton = new JButton("Food");

        passengersButton.addActionListener(this);
        trainsButton.addActionListener(this);
        schedulesButton.addActionListener(this);
        employeesButton.addActionListener(this);
        foodButton.addActionListener(this);

        setLayout(new GridLayout(1, 5, 10, 10)); 

        
        passengersButton.setPreferredSize(new Dimension(150, 50));
        trainsButton.setPreferredSize(new Dimension(150, 50));
        schedulesButton.setPreferredSize(new Dimension(150, 50));
        employeesButton.setPreferredSize(new Dimension(150, 50));
        foodButton.setPreferredSize(new Dimension(150, 50));

        add(passengersButton);
        add(trainsButton);
        add(schedulesButton);
        add(employeesButton);
        add(foodButton);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public void setEmployeeGUI(EmployeeGUI employeeGUI) {
        this.employeeGUI = employeeGUI;
    }
	
	public void setPassengerGUI(PassengerGUI passengerGUI) {
        this.passengerGUI = passengerGUI;
	}
	
	public void setTrainGUI(TrainGUI trainGUI) {
        this.trainGUI = trainGUI;
	}
	
	public void setScheduleGUI(ScheduleGUI scheduleGUI) {
        this.scheduleGUI = scheduleGUI;
	}
	
	public void showDashboard() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeesButton) {
           
            EmployeeList employeeList = new EmployeeList();
            new EmployeeGUI(employeeList,this);
            
        } 
		
		 else if (e.getSource() == passengersButton) {
           
            PassengerList passengerList = new PassengerList();
            new PassengerGUI(passengerList,this);
            
        }
		
		else if (e.getSource() == trainsButton) {
           
            TrainList trainList = new TrainList();
            new TrainGUI(trainList,this);
            
        }
		
		else if (e.getSource() == schedulesButton) {
           
           ScheduleList scheduleList = new ScheduleList();
            new ScheduleGUI(scheduleList,this);
            
        }
		
		else if (e.getSource()==foodButton) {
            FoodGUI foodGUI=new FoodGUI(foodlist);
            foodGUI.setVisible(true);


        }
		
		
		
		
	
            
    }
}






