package org.example.level_1;

import java.util.Set;

public class Month {
    private String name;
    private int monthNumber;
    private Set<Integer> holidays;

    public Month(String name, int monthNumber, Set<Integer> holidays) {
        this.holidays = holidays;
        this.name = name;
        this.monthNumber = monthNumber;
    }

    public Boolean isHoliday(int day) {
        return holidays.contains(day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Set<Integer> getHolidays() {
        return holidays;
    }

    public void setHolidays(Set<Integer> holidays) {
        this.holidays = holidays;
    }
}
