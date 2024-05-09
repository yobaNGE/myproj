package org.example;

import org.example.level_1.Calendar_Working;
import org.example.level_1.Month;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Month> monthSet = new HashSet<>();
        monthSet.add(new Month("January", 1, Set.of(1, 2, 3, 4, 5, 6, 7, 8, 13, 14, 20, 21, 27, 28)));
        monthSet.add(new Month("February", 2, Set.of(3, 4, 10, 11, 17, 18, 23, 24, 25)));
        monthSet.add(new Month("March", 3, Set.of(2, 3, 8, 9, 10, 16, 17, 23, 24, 30, 31)));
        monthSet.add(new Month("April", 4, Set.of(6, 7, 13, 14, 20, 21, 28, 29, 30)));
        monthSet.add(new Month("May", 5, Set.of(1, 4, 5, 9, 10, 11, 12, 18, 19, 25, 26)));

        Calendar_Working calendarWorking = new Calendar_Working(monthSet, 2024);
        System.out.println("Choose level 1 or 2: ");
        String str = sc.nextLine();
        switch (str) {
            case "1":
                level1(calendarWorking);
                break;
            case "2":
                level2(calendarWorking);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void level1(Calendar_Working calendarWorking) {
        System.out.print("Enter the date to check if it is a holiday(DD.MM.YYYY):");
        String input = sc.nextLine().strip();

        if (!input.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}"))
            throw new IllegalArgumentException("Invalid date format: " + input);
        int[] date = Arrays.stream(input.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalDate localDate = LocalDate.of(date[2], date[1], date[0]);
        System.out.println(calendarWorking.isHolidayDate(localDate));
    }

    public static void level2(Calendar_Working calendarWorking) {
        System.out.print("Enter the date to check if it is a holiday(DD.MM.YYYY.hh.mm.+-z):");
        String input = sc.nextLine().strip();

        if (!input.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\.\\d{1,2}\\.\\d{1,2}\\.[+-]?\\d{1,2}"))
            throw new IllegalArgumentException("Invalid date format: " + input);
        String[] dateStr = input.split("\\.");
        int day = Integer.parseInt(dateStr[0]);
        int month = Integer.parseInt(dateStr[1]);
        int year = Integer.parseInt(dateStr[2]);
        int hour = Integer.parseInt(dateStr[3]);
        int minute = Integer.parseInt(dateStr[4]);
        ZoneOffset zoneOffset = ZoneOffset.of(dateStr[5]);
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute); // could cause exception but it is kinda needed
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneOffset);// here too
        System.out.println(calendarWorking.isHolidayTime(zonedDateTime));
    }
}