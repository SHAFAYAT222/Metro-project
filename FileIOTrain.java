package File;

import EntityList.TrainList;
import Entity.Train;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOTrain {
    public static void loadFromFile(TrainList trainList) {
        try {
            Scanner sc = new Scanner(new File("./File/TrainData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                Train train = new Train(data[0], data[1], data[2], data[3], data[4], data[5]);
                trainList.insert(train);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeTrainInFile(Train train) {
        try {
            FileWriter writer = new FileWriter(new File("./File/TrainData.txt"), true);
            String data = train.getTrainID() + ";" + train.getTrainName() + ";" +
                    train.getSourceStation() + ";" + train.getDestinationStation() + ";" +
                    train.getDepartureTime() + ";" + train.getArrivalTime() + "\n";
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateTrainsInFile(TrainList trainList) {
        try {
            FileWriter writer = new FileWriter(new File("./File/TrainData.txt"));
            Train trains[] = trainList.getAllTrains();

            String allData = "";

            for (Train train : trains) {
                if (train != null) {
                    String data = train.getTrainID() + ";" + train.getTrainName() + ";" +
                            train.getSourceStation() + ";" + train.getDestinationStation() + ";" +
                            train.getDepartureTime() + ";" + train.getArrivalTime() + "\n";

                    allData += data;
                }
            }
            writer.write(allData);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserFromFile(String userName, String userPass) {
        try {
            Scanner sc = new Scanner(new File("./File/UserData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                String storedUserName = data[0];
                String storedUserPass = data[1];

                if (userName.equals(storedUserName) && userPass.equals(storedUserPass)) {
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}






