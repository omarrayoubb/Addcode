package com.example.co_working_space1;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
public abstract class Reservation implements Serializable{
    private LocalDate Date;
    private LocalTime Time;

    protected Visitor visitor;
    protected String Room_type;
    private double fees;
    private int room_id;

    public Reservation() {
        room_id = 0;
        Date = LocalDate.MIN;
        Time = LocalTime.MIN;

    }

    public Reservation(LocalDate date, LocalTime time, Visitor visitor, String room_type, int room_id ,double fees) {
        Date = date;
        Time = time;
        this.visitor = visitor;
        Room_type = room_type;
        this.fees = fees;
        this.room_id = room_id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getRoom_type() {
        return Room_type;
    }

    public void setRoom_type(String room_type) {
        Room_type = room_type;
    }

    public double getFees() {
        return fees;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
    public abstract room setRoom(room room);
    public void display() {
        System.out.println(visitor.getUsername());
        System.out.println(room_id);
        System.out.println(Date);
        System.out.println(Time);
    }
    public abstract int generalRoomReservation(room r1);
    public abstract int meetingRoomReservation(room r1);
    public abstract int teachingRoomReservation(room r12);
}
