package Entity;

public class Train {
    private String trainID;
    private String trainName;
    private String sourceStation;
    private String destinationStation;
    private String departureTime;
    private String arrivalTime;

    public Train(String trainID, String trainName, String sourceStation, String destinationStation,
                 String departureTime, String arrivalTime) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
	
	 public void setTrainName(String trainName) {
        this.trainName = trainName;
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

    

   
  

    public void showTrainInfo() {
        System.out.println("Train ID: " + trainID);
        System.out.println("Train Name: " + trainName);
        System.out.println("Source Station: " + sourceStation);
        System.out.println("Destination Station: " + destinationStation);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
    }


    public String getTrainInfoAsString() {
        
       
		 return "Train  ID : " + trainID + "\n" +
            "Train Name : " + trainName + "\n" +
            "Source Station: " + sourceStation + "\n" +
            "Destination Station : " + destinationStation + "\n" +
            "Departure Time : " + departureTime + "\n" +
            "Arrival Time : " + arrivalTime + "\n";
    }
}





