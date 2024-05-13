package EntityList;

import Entity.Train;

import File.FileIOTrain; 

public class TrainList {
    private Train trains[];

    public TrainList() {
        trains = new Train[5];
		
		FileIOTrain.loadFromFile(this);
    }

    public TrainList(int size) {
        trains = new Train[size];
		
		FileIOTrain.loadFromFile(this);
    }

    public void insert(Train train) {
        boolean flag = false;
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] == null) {
                trains[i] = train;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Train Insertion Successful");
        } else {
            System.out.println("Train Insertion Failed");
        }
    }

    public Train getByTrainID(String trainID) {
        for (Train train : trains) {
            if (train != null && train.getTrainID().equals(trainID)) {
                return train;
            }
        }
        return null;
    }

   
 
	
	public void delete(Train train) {
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != null && trains[i].getTrainID().equals(train.getTrainID())) {
                trains[i] = null;
                System.out.println("Train Deletion Successful");
                return;
            }
        }
        System.out.println("Train Deletion Failed");
    }
	
	
	

    public void searchByTrainID(String trainID) {
        for (Train train : trains) {
            if (train != null && train.getTrainID().equals(trainID)) {
                System.out.println("+++ Train Found +++");
                train.showTrainInfo();
                return;
            }
        }
        System.out.println("=== Train Not Found ===");
    }

    public Train[] getAllTrains() {
        return trains;
    }

    public void showAll() {
        System.out.println("++++++ List of All Trains ++++++");
        for (Train train : trains) {
            if (train != null) {
                System.out.println("+++++++++++++++++++");
                train.showTrainInfo();
            }
        }
        System.out.println("+++++++++++++++++");
    }

    public String getAllTrainsAsString() {
        StringBuilder allTrainsInfo = new StringBuilder("++++++ List of All Trains ++++++\n");
        for (Train train : trains) {
            if (train != null) {
                allTrainsInfo.append("+++++++++++++++++++\n");
                allTrainsInfo.append(train.getTrainInfoAsString()).append("\n");
            }
        }
        allTrainsInfo.append("+++++++++++++++++\n");
        return allTrainsInfo.toString();
    }
	
	
	
	
	
	 
}








