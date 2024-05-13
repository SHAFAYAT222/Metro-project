package File;

import Entity.Schedule;
import EntityList.ScheduleList;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOSchedule {

    public static void loadFromFile(ScheduleList scheduleList) {
        try {
            Scanner sc = new Scanner(new File("./File/ScheduleData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                Schedule schedule = new Schedule(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                scheduleList.insert(schedule);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeScheduleInFile(Schedule schedule) {
        try {
            FileWriter writer = new FileWriter(new File("./File/ScheduleData.txt"), true);
            String data = schedule.getTrainID() + ";" + schedule.getTrainName() + ";" +
                    schedule.getScheduleID() + ";" + schedule.getSourceStation() + ";" +
                    schedule.getDestinationStation() + ";" + schedule.getDepartureTime() + ";" +
                    schedule.getArrivalTime() + "\n";
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateSchedulesInFile(ScheduleList scheduleList) {
        try {
            FileWriter writer = new FileWriter(new File("./File/ScheduleData.txt"));
            Schedule schedules[] = scheduleList.getAllSchedules();

            StringBuilder allData = new StringBuilder();

            for (Schedule schedule : schedules) {
                if (schedule != null) {
                    String data = schedule.getTrainID() + ";" + schedule.getTrainName() + ";" +
                            schedule.getScheduleID() + ";" + schedule.getSourceStation() + ";" +
                            schedule.getDestinationStation() + ";" + schedule.getDepartureTime() + ";" +
                            schedule.getArrivalTime() + "\n";

                    allData.append(data);
                }
            }
            writer.write(allData.toString());
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
                if (data[0].equals(userName) && data[1].equals(userPass)) {
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

    public static boolean checkScheduleFromFile(String scheduleID) {
        try {
            Scanner sc = new Scanner(new File("./File/ScheduleData.txt"));
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(";");
                if (data[2].equals(scheduleID)) {
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


