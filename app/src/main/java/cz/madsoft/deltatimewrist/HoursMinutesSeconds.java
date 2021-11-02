package cz.madsoft.deltatimewrist;

public class HoursMinutesSeconds {
    public int hours, minutes, seconds;

    public HoursMinutesSeconds(double hours, double minutes, double seconds) {
        this.hours = (int)hours;
        this.minutes = (int)minutes;
        this.seconds = (int)seconds;
    }

    public static HoursMinutesSeconds getRemainingTime(int hourId, int daySeconds) {
        HourList selected = HourList.FullHourList[Math.abs(hourId) - 1];
        int difference = (hourId < 0 ? HourList.ConvertToSeconds(selected.startHour, selected.startMinute, 0) : HourList.ConvertToSeconds(selected.endHour, selected.endMinute, 0)) - daySeconds - 1;
        return new HoursMinutesSeconds(
                Math.floor(difference / 60 / 60),
                Math.floor(difference / 60) - Math.floor(difference / 60 / 60) * 60,
                difference - Math.floor(difference / 60) * 60
        );
    }
}
