package com.example.co_working_space1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TeachingRoom extends room {
    protected String projector_type;
    protected String board_type;
    protected String instructor_name;
    int bookedSlotsCounter;


    public TeachingRoom() {
        super();
        bookedSlotsCounter = 0;
    }


    public double calculateFees(LocalDate date) {
        return 0;
    }


    public TeachingRoom(int id) {
        this.id = id;
    }

    public TeachingRoom(ArrayList<TeachingRoom> teachingRooms) {

    }

   /*
    public TeachingRoom(String name, int id, int numberofvisitors, String projector_type , String board_type, String instructor_name) {
        super(name, id, numberofvisitors);
        this.projector_type = projector_type;
        this.board_type=board_type;
        this.instructor_name=instructor_name;
    }
    */

    /**
     * @Override public double calculateFees(){
     * <p>
     * return 0;
     * };
     */
    public boolean checkAvailability(LocalDate date, LocalTime time, Visitor visitor) {

        for (room s : Main.roooms) {
            if (s.getName().equalsIgnoreCase("Teaching Room")) {
                for (Slott m : s.slots) {
                    if (date.equals(m.Date)) {
                        if (time.equals(m.getTime())) {
                            if (m.getSlotsCounter() > 0 && m.getAvailability()) {
                                m.setSlotsCounter(m.getSlotsCounter() - 1);
                                this.id = s.getId();
                                m.setAvailability(false);
                                checkListOfVisitors(visitor);
                                return true;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

        }
        return false;
    }
  //  public void setListOfArray()
}

