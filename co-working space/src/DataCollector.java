package com.example.co_working_space1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DataCollector extends Reservation{
    LocalTime time;
    LocalDate date;

    public DataCollector() {
        super();

    }

    public DataCollector(LocalDate date, LocalTime time, Visitor visitor, LocalDate date1, LocalTime time1, int room_id, String Room_type,double fees) {
        super(date, time, visitor, Room_type, room_id ,fees);

        this.date = date1;
        this.time = time1;
    }


    public DataCollector(LocalDate date, LocalTime time, Visitor Visitor, int room_id) {
        setDate(date);
        setTime(time);
        this.visitor = visitor;
        setRoom_id(room_id);
    }

    public room setRoom(room room) {
        if (Room_type.equalsIgnoreCase("Teaching Room")) {
            room = new TeachingRoom();
            if (room instanceof TeachingRoom) {
                return (TeachingRoom) room;
            }
        }
        else if (Room_type.equalsIgnoreCase("Meeting Room"))
        {
            room = new MeetingRoom();
            if (room instanceof MeetingRoom) {
                return (MeetingRoom) room;
            }
        }
        else {
            room = new GeneralRoom();

           if (room instanceof GeneralRoom)
           {
              return (GeneralRoom) room;
           }

        }
        return null;
    }



    /**
    public int checkSlot(ArrayList<Slott> slots) {
        for (Slott s : slots) {
            if (date.equals(s.getDate()) && time.equals(s.getTime())) {
                Date = date;
                Time = time;
                //System.out.println(s.counterRoom);
                // s.counterRoom++;
                return 0;
            }
        }
        return 1;
    }
     */

    public int teachingRoomReservation(room r12) {
        TeachingRoom r2 = (TeachingRoom) r12;
            boolean checkAvailability = r2.checkAvailability(date, time, visitor);
            if (checkAvailability == true) {
                setDate(date);
                setTime(time);
                setRoom_id(r2.id);
                //Main.roooms.get(1).slots.get();
                System.out.println("Successful Reservation");
                return 0;
            }
        System.out.println("Failed");
        return -1;
    }


    public int meetingRoomReservation(room r1) {
        MeetingRoom m1 = (MeetingRoom) r1;
        if (m1.bookSlot(date, time, visitor))
        {
            setDate(date);
            setTime(time);
            setRoom_id(r1.id);
            //Main.roooms.get(1).slots.get();
            System.out.println("Successful Reservation");
            return 0;

        }

        return -1;
    }

    public int generalRoomReservation(room r1) {
        GeneralRoom m1 = (GeneralRoom) r1;
        if (m1.checkAvailability(date, time, visitor))
        {
            setDate(date);
            setTime(time);
            //Main.roooms.get(1).slots.get();
            setRoom_id(m1.id);
            System.out.println("Successful Reservation");
            return 0;
        }

        return -1;
    }
    public boolean checkReservationx(LocalDate date, LocalTime time)
    {
        for (Reservation s: Main.Reservations)
        {
            if(s.getTime().equals(time) && s.getDate().equals(date) && s.getVisitor().getUsername().equals(this.getVisitor().getUsername()))
            {
                return false;
            }
        }
        return true;

    }
}
