package cz.madsoft.deltatimewrist;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DeltaTime {
    public int getDeltaTime() {
        LocalDateTime time = LocalDateTime.now();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int days = time.getDayOfWeek().ordinal();
        int month = time.getMonth().ordinal();
        int dayMinutes = hours * 60 + minutes;

        if (month == 6 || month == 7) return 11;
        if (days == 5 || days == 6) return 12;

        return HourList.getHourId(dayMinutes);
    }

    public String getString(int hourId) {
        LocalDateTime time = LocalDateTime.now();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();
        int daySeconds = HourList.ConvertToSeconds(hours, minutes, seconds);
        switch (hourId) {
            case 0: return "Škola už dnes skončila";
            case 11: return "Jsou prázdniny";
            case 12: return "Je víkend!";
        }
        HoursMinutesSeconds remaining = HoursMinutesSeconds.getRemainingTime(hourId, daySeconds);
        if (hourId == -1)
            return "S: " + remaining.hours + ":" +fixTimeFormat(remaining.minutes) + ":" + fixTimeFormat(remaining.seconds);
        return (hourId < 0 ? "B: " : "R: ") + remaining.minutes + ":" + fixTimeFormat(remaining.seconds);
    }

    private String fixTimeFormat(int second) {
        return second < 10 ? "0"+second : second + "";
    }
}
