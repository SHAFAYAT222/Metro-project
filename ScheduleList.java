package EntityList;
import Entity.Schedule;
import File.FileIOSchedule;

public class ScheduleList {

    private Schedule schedules[];

    public ScheduleList() {
        schedules = new Schedule[5];
		
		FileIOSchedule.loadFromFile(this);
    }

    public ScheduleList(int size) {
        schedules = new Schedule[size];
		
		FileIOSchedule.loadFromFile(this);
    }

    public void insert(Schedule schedule) {
        boolean flag = false;
        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] == null) {
                schedules[i] = schedule;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Schedule Insertion Successful");
        } else {
            System.out.println("Schedule Insertion Failed");
        }
    }

    public Schedule getByScheduleID(String scheduleID) {
        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] != null && schedules[i].getScheduleID().equals(scheduleID)) {
                return schedules[i];
            }
        }
        return null;
    }

    public void delete(Schedule schedule) {
        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] != null && schedules[i].equals(schedule)) {
                schedules[i] = null;
                System.out.println("Schedule Deletion Successful");
                return;
            }
        }
        System.out.println("Schedule Deletion Failed");
    }

    public void deleteByScheduleID(String scheduleID) {
        boolean flag = false;
        for (int i = 0; i < schedules.length; i++) {
            if (schedules[i] != null && schedules[i].getScheduleID().equals(scheduleID)) {
                schedules[i] = null;
                flag = true;
                System.out.println("Schedule Deletion Successful");
                break;
            }
        }
        if (!flag) {
            System.out.println("Schedule Deletion Failed");
        }
    }

    public void searchByScheduleID(String scheduleID) {
        Schedule schedule = getByScheduleID(scheduleID);
        if (schedule != null) {
            System.out.println("+++ Schedule Found +++");
            schedule.showScheduleInfo();
        } else {
            System.out.println("=== Schedule Not Found ===");
        }
    }

    public void showAll() {
        System.out.println("++++++ List of All Schedules ++++++");
        for (Schedule schedule : schedules) {
            if (schedule != null) {
                System.out.println("+++++++++++++++++++");
                schedule.showScheduleInfo();
            }
        }
        System.out.println("+++++++++++++++++");
    }

    public String getAllSchedulesAsString() {
        StringBuilder allSchedulesInfo = new StringBuilder("++++++ List of All Schedules ++++++\n");
        for (Schedule schedule : schedules) {
            if (schedule != null) {
                allSchedulesInfo.append("+++++++++++++++++++\n");
                allSchedulesInfo.append(schedule.getTrainInfoAsString()).append("\n");
            }
        }
        allSchedulesInfo.append("+++++++++++++++++\n");
        return allSchedulesInfo.toString();
    }

    public Schedule[] getAllSchedules() {
        return schedules;
    }

    
}
