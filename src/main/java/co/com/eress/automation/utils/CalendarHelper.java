package co.com.eress.automation.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class CalendarHelper {
    public static LocalDate findDayInMonth(int year, Month month, DayOfWeek targetDay) {
        LocalDate date = LocalDate.of(year, month, 1);
        if (date.getDayOfWeek().getValue() > targetDay.getValue()) {
            date = date.plusWeeks(1);
        }
        date = date.with(TemporalAdjusters.nextOrSame(targetDay));
        return date;
    }

    public static DayOfWeek stringToDayOfWeek(String day) {
        return DayOfWeek.valueOf(day.toUpperCase());
    }

    public static Month stringToMonth(String month) {
        return Month.valueOf(month.toUpperCase());
    }
}