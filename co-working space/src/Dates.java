package com.example.co_working_space1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dates {

   // protected int time, hour, minutes;

    protected String dateTime;
    protected String date;

    protected long fees;

    public Dates() {
       // this.time = 0;
        this.date = "Not assigned yet";
        this.fees = 0;
       // this.hour = 0;
       // this.minutes = 0;
        this.dateTime =  "Not assigned yet";

    }


    public void setDate(int day, int month, int year, int hour, int minutes) {
           /*
            String Day = Integer.toString(day);
            String Month = Integer.toString(month);
            String Year = Integer.toString(year);
            String Hour = Integer.toString(hour);
            String Minutes = Integer.toString(minutes);

            date = String.format("%s-%s-%s %s:%s", Year, Month, Day, Hour, Minutes);
            */
        LocalDateTime dateee = LocalDateTime.of(year, month, day, hour, minutes);
        DateTimeFormatter revdate = DateTimeFormatter.ofPattern("EE dd/MM/yyyy H:mm");
        dateTime = dateee.format(revdate);
    }


    public String getDate() {

            /*
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE dd-MM-yyyy H:mm");
            LocalDateTime RevDate = LocalDateTime.parse(date, dtf);
            // DayOfWeek DayInWeek = date.getDayOfWeek();
            return dtf.format(RevDate);
            */
        return date;
    }

    public void setDate(int day, int month, int year) {
        LocalDate dateee = LocalDate.of(year, month, day);
        DateTimeFormatter revdate = DateTimeFormatter.ofPattern("EE dd/MM/yyyy");
        date = dateee.format(revdate);

    }

}

