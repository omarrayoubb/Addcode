package com.example.co_working_space1;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class MeetingRoom extends room {

    private int Number_ofvisitors;
    int bookedSlotsCounter;

    public MeetingRoom(String name, int id, int numberOfVisitors, ArrayList<Slott> slots) {
        super(name, id, numberOfVisitors,slots);

    }

    public MeetingRoom() {
        super();

    }

    public ArrayList<Slott> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slott> slots) {
        this.slots = slots;
    }

    public boolean checkVisitors(@NotNull Visitor visitor) {
        int numberOfVisitors = numberofvistors;

        if (numberOfVisitors <= 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
    public double calculateFees(LocalDate date) {
        int numberOfVisitors = getNumberofvistors();
        double feePerSlot = 100.0;
        double totalFees = 0.0;

        for (Slott slot : slots) {
            if (!slot.getAvailability()) {
                totalFees += feePerSlot;
            }
        }
        return totalFees;
    }
     */

    public boolean bookSlot(LocalDate date, LocalTime time, Visitor vi) {
        for (room s : Main.roooms) {
            if (s.getName().equalsIgnoreCase("Meeting Room")) {
                for (Slott slot : s.slots) {
                    if (slot.getDate().equals(date) && slot.getTime().equals(time)) {
                        if (slot.getAvailability()) {
                            slot.setAvailability(false);
                            this.id = s.getId();
                            checkListOfVisitors(vi);
                            this.bookedSlotsCounter++;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setNumber_ofvisitors(int number_ofvisitors) {
        Number_ofvisitors = number_ofvisitors;
    }

    public int getNumber_ofvisitors() {
        return Number_ofvisitors;
    }
}

