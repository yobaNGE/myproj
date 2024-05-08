package org.example.level_1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Calendar_Working {
    private Set<Month> monthSet;
    private int year;
    private final int beginHour = 9, endHour = 18;

    public Calendar_Working(Set<Month> monthSet, int year) {
        this.monthSet = monthSet;
        this.year = year;
    }

    public boolean isHolidayDate(LocalDate localDate) {
        for (Month m : monthSet) {
            if (m.getMonthNumber() == localDate.getMonthValue()) {
                return m.isHoliday(localDate.getDayOfMonth());
            }
        }
        throw new IllegalArgumentException("Month not found: " + localDate.getMonthValue());
    }

    public boolean isHolidayTime(ZonedDateTime zonedDateTime) {
        zonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("+3")); // cast to moscow time zone
        if (zonedDateTime.getHour() < beginHour || zonedDateTime.getHour() >= endHour) {
            // is true if it isn't working hours
            return true;
        }
        for (Month m : monthSet) {
            if (m.getMonthNumber() == zonedDateTime.getMonthValue()) {
                return m.isHoliday(zonedDateTime.getDayOfMonth());
            }
        }
        throw new IllegalArgumentException("Month not found: " + zonedDateTime.getMonthValue());
    }

    public Set<Month> getMonthSet() {
        return monthSet;
    }

    public void setMonthSet(Set<Month> monthSet) {
        this.monthSet = monthSet;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
