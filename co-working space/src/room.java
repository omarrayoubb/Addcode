package com.example.co_working_space1;

import java.io.Serializable;
import java.util.ArrayList;

public  class room implements Serializable {
    protected String name;
    protected int id;
    protected int numberofvistors;
    public ArrayList<Slott> slots;
    ArrayList<Visitor> ListOfVisitors;

    public room(String teachingRoom, int id, int i, ArrayList<Slott> slots, ArrayList<Visitor> v7) {
        this.name = teachingRoom;
        this.id = id;
        this.slots = slots;
        ListOfVisitors = new ArrayList<Visitor>();
    }

    public room(String name, int id, int numberofvisitors, ArrayList<Slott> slots) {
        this.name = name;
        this.id = id;
        this.numberofvistors = numberofvisitors;
        this.slots = slots;

    }

    public room() {
        ListOfVisitors = new ArrayList<Visitor>();
        this.numberofvistors = 0;
        this.id = 0;
        this.name = "Not Assigned Yet";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNumberofvistors(int numberofvistors) {
        this.numberofvistors = numberofvistors;
    }

    public int getNumberofvistors() {
        return numberofvistors;
    }
    public void checkListOfVisitors(Visitor visitor)
    {
        for (room s : Main.roooms)
        {
            for (Visitor v: s.ListOfVisitors)
            {
                if (visitor.getUsername().equalsIgnoreCase(v.getUsername()))
                {
                    continue;
                }
                else {
                    s.ListOfVisitors.add(v);
                }
            }
        }
    }


}

