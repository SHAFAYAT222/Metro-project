package Entity;

public class Schedule {

    private String trainID; 
    private String trainName; 
    private String scheduleID;
    private String sourceStation;
    private String destinationStation;
    private String departureTime;
    private String arrivalTime;

    public Schedule() {

    }

    public Schedule(String trainID, String trainName, String scheduleID, String sourceStation,
            String destinationStation, String departureTime, String arrivalTime) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.scheduleID = scheduleID;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTrainID() {
        return trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void showScheduleInfo() {
        System.out.println("Train ID: " + trainID);
        System.out.println("Train Name: " + trainName);
        System.out.println("Schedule ID: " + scheduleID);
        System.out.println("Source Station: " + sourceStation);
        System.out.println("Destination Station: " + destinationStation);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
    }

    public String getTrainInfoAsString() {
        return "Train ID : " + trainID + "\n" +
            "Train Name : " + trainName + "\n" +
            "Schedule ID : " + scheduleID + "\n" +
            "Source Station: " + sourceStation + "\n" +
            "Destination Station : " + destinationStation + "\n" +
            "Departure Time : " + departureTime + "\n" +
            "Arrival Time : " + arrivalTime + "\n";
    }
}
