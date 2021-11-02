package cz.madsoft.deltatimewrist;

public class HourList {
    public int startHour, startMinute, endHour, endMinute;

    private HourList(int startHour, int startMinute, int endHour, int endMinute){
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public static HourList[] FullHourList = {
            new HourList(8,0,8,45),
            new HourList(8,50,9,35),
            new HourList(9,50,10,35),
            new HourList(10,40,11,25),
            new HourList(11,35,12,20),
            new HourList(12,25,13,10),
            new HourList(13,15,14,0),
            new HourList(14,0,14,45),
            new HourList(14,45,15,30),
            new HourList(15,35,16,20),
    };

    public static int getHourId(int dayMinutes) {
        HourList[] hourList = HourList.FullHourList;
        for (int i = 0; i < hourList.length; i++) {
            HourList x = hourList[i];
            int realIndex = i + 1;
            if (dayMinutes < HourList.ConvertToMinutes(x.startHour, x.startMinute))
                return -1 * realIndex;
            else if (dayMinutes < HourList.ConvertToMinutes(x.endHour, x.endMinute))
                return realIndex;
        }
        return 0;
    }

    public static int ConvertToMinutes(int hours, int minutes) {
        return hours * 60 + minutes;
    }

    public static int ConvertToSeconds(int hours, int minutes, int seconds){
        return hours * 60 * 60 + minutes * 60 + seconds;
    }


}
