package com.example.co_working_space1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitor extends person {
    private String type;
    private int id = 0;

    public Visitor(String username, String password, String type, int id) {
        super(username, password);
        this.type = type;
        this.id = id;
    }

    public Visitor(String username, String password) {
        super(username, password);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visitor() {
    }

    public int Register() {

        String userName, Password, Type;

        // int check = 0;
        int id;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Username: ");
            userName = scan.nextLine();
            System.out.print("Password: ");
            Password = scan.nextLine();
            System.out.println("Type: ");
            Type = scan.nextLine();
            System.out.print("ID: ");
            id = scan.nextInt();
            //constraints
            if (userName.equalsIgnoreCase("admin")) {
                System.out.println("Please Enter a valid username");
                continue;
            }
            if (userName.isEmpty()) {
                System.out.println("Username field is required");
                continue;
            }
            if (Password.isEmpty()) {
                System.out.println("password field is required");
                continue;
            }
            if (checkPassword(Password) == false)
                continue;
            break;
        }
        // Create the user
        this.setUsername(userName);
        this.setPassword(Password);
        this.type = Type;
        this.id = id;
        return 0;

    }

    public boolean checkPassword(String password) {
        String Password = password;
        boolean x = false, y = false, z = false, checkPasswordd = false;

        if (Password.length() <= 6) {
            System.out.println("Please write a strong password");
            return checkPasswordd;
        }
        // check = 0;
        for (int i = 0; i < Password.length(); i += 1) {

            if (Password.charAt(i) >= (int) 'A' && Password.charAt(i) <= (int) 'Z') ;
            {
                x = true;
            }
            if (Password.charAt(i) >= (int) '0' && Password.charAt(i) <= (int) '9') {
                y = true;
            } else if (Password.charAt(i) >= (int) 'a' && Password.charAt(i) <= (int) 'z') {
                z = true;
            }
                /*
                if (x == true && y == true && z == true)
                {
                    break;
                }
                 */
        }
        if (x == false || y == false || z == false) {
            System.out.println("Please Enter A strong Password that contains upper and lower case letters and numbers and symbols");
            return checkPasswordd;
        }
        checkPasswordd = true;
        return checkPasswordd;

    }

    public static void displaytypeData(String type, ArrayList<Visitor> usrData)

    {
        ArrayList<Visitor> usr = usrData;
        for (Visitor i : usr)
        {
            if (i.getType().equalsIgnoreCase(type))
            {
                System.out.println(i.getUsername() + "\t" + i.getPassword() + "\t" + i.getId() + "\t" + i.getType());
            }
        }

    }
    public static void displayallData(String type, ArrayList<Visitor> usrData)

    {
        ArrayList<Visitor> usr = usrData;
        for (Visitor i : usr)
        {
                System.out.println(i.getUsername() + "\t" + i.getPassword() + "\t" + i.getId() + "\t" + i.getType());
        }

    }
    /*
    public boolean checkUsername(String name)
    {
        if (name.isEmpty())
            return false;
        else if (name.equalsIgnoreCase("admin"))
        {
            System.out.println("Please Enter a valid username");
            return false;
        }
    }

       */
    public boolean makeReservation(ArrayList<Reservation> Reservations) {
        Scanner scan = new Scanner(System.in);
        int check = 0, day , month, year, hour, count = 0;
        boolean checkDateTime = false, reserveMore = true;
        LocalDate date = LocalDate.MIN;
        LocalTime time = LocalTime.MIN;
        String roomType = null;
        room r1 = new room();
        DataCollector reserve = new DataCollector();
        System.out.println("Please Choose A Room");
        System.out.println("1: General Room");
        System.out.println("2: Teaching Room");
        System.out.println("3: Meeting Room");
        try {
            roomType = scan.nextLine();

            while (!checkDateTime) {
                System.out.println("Please Enter The date");
                day = scan.nextInt();
                month = scan.nextInt();
                year = scan.nextInt();
                System.out.println("Please enter time");
                date = LocalDate.of(year, month, day);
                if (!Visitor.CheckDate(date)) {
                    System.out.println("Please Enter A valid Date");

                } else {
                    checkDateTime = true;
                }
            }
            displayAvailableSlots(roomType);
            do {
                System.out.println("Please Enter Time");
                hour = scan.nextInt();
                time = LocalTime.of(hour, 0);
                

            } while (!CheckTime(date, time));
        }
        catch(Exception exception)
        {
            System.out.println("Please Enter Valid data");
        }
        scan.nextLine();
        while (reserveMore) {

            reserve.visitor = this;
            reserve.date = date;
            reserve.setRoom_type(roomType);
            reserve.time = time;
            r1 = reserve.setRoom(r1);
            if (!reserve.checkReservationx(date, time)) {
                return false;
            }
            if (r1 instanceof TeachingRoom) {
                check = reserve.teachingRoomReservation(r1);
            } else if (r1 instanceof MeetingRoom) {
                check = reserve.meetingRoomReservation(r1);
            } else if (r1 instanceof GeneralRoom) {
                check = reserve.generalRoomReservation(r1);
            }

            if (check == 0) {
                Reservations.add(reserve);
                count++;

                reserve.display();
                System.out.println("Do you want additional slot(y/n)");

                char c = scan.nextLine().charAt(0);
                if (c == 'y' || c == 'Y') {
                    time = time.plus(1, ChronoUnit.HOURS);
                    reserve = new DataCollector();

                    if (time.equals(DailyWorkspaceInfo.getClosingHour())) {
                        System.out.println("This Slot is not Available");
                        System.out.println("Do you want to complete your reservation(y/n)");
                        c = scan.nextLine().charAt(0);
                        if (c == 'y' || c == 'Y') {
                            reserveMore = false;
                        } else {
                            for (int i = 0; i < count; i++) {
                                time = time.minus(1, ChronoUnit.HOURS);
                                deleteReservation(date, time);
                            }
                            reserveMore = false;
                        }
                    }
                }
            }else {
                    System.out.println("Your Reservation Has been Confirmed");
                    reserveMore = false;
                }
        }

            return true;
    }

    public int editReservation() {
        int day, hour, month, year;
        LocalDate date;
        LocalTime time;
        boolean exist = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Name\tid\tDate\tTime\tRoom");
        for (Reservation r : Main.Reservations) {
            if (r.getVisitor().getUsername().equals(getUsername())) {
                if (Visitor.CheckTime(r.getDate(),r.getTime())) {
                    System.out.println(getUsername() + "\t" + r.getRoom_id() + "\t" + r.getDate() + "\t" + r.getTime() + "\t" + r.getRoom_type());
                }
            }
        }
        System.out.println("Enter your Reservation Date");
        day = scan.nextInt();
        month = scan.nextInt();
        year = scan.nextInt();
        System.out.println("Enter Slot");
        hour = scan.nextInt();
        scan.nextLine();
        date = LocalDate.of(year, month, day);
        time = LocalTime.of(hour, 0);

        System.out.println("Are you Sure about edit your reservation(y/n)");
        char c = scan.nextLine().charAt(0);
        if (c == 'n' || c == 'N') {
            System.out.println("Your Reservation is currently available");
            return -1;
        } else {
            for (Reservation r : Main.Reservations) {
                if (r.getVisitor().getUsername().equals(getUsername()) && r.getDate().equals(date) && r.getTime().equals(time)) {
                    deleteReservation(date, time);
                    this.makeReservation(Main.Reservations);
                }
            }
            return 0;
        }
    }

    public int deleteReservation() {
        LocalDate date;
        LocalTime time;
        int day, year, month, hour, id;
        char c;
        Scanner scan = new Scanner(System.in);
        System.out.println("Name\tid\tDate\tTime\tRoom");
        for (Reservation r : Main.Reservations)

        {

            if (r.getVisitor().getUsername().equals(getUsername()))
            {
                System.out.println(getUsername() +  "\t" + r.getRoom_id()+ "\t" + r.getDate() + "\t" + r.getTime() +"\t"+r.getRoom_type());
            }
        }
        System.out.println("Enter your Reservation Date");
        day = scan.nextInt();
        month = scan.nextInt();
        year = scan.nextInt();
        System.out.println("Enter Slot");
        hour = scan.nextInt();
        scan.nextLine();
        System.out.println("Are you sure about delete your Reservation?(y/n)");
        c = scan.nextLine().charAt(0);
        if (c == 'n')
        {
            System.out.println("No Resrevations are deleted");
            return -1;
        }
        else {
            date = LocalDate.of(year, month, day);
            time = LocalTime.of(hour, 0);
            for (Reservation s : Main.Reservations) {
                if (s.getDate().equals(date) && s.getTime().equals(time) && getUsername().equals(s.getVisitor().getUsername())) {
                    id = s.getRoom_id();
                    Main.Reservations.remove(s);
                    break;
                }
            }
            for (room s : Main.roooms) {
                for (Slott m : s.slots) {
                    if (m.getDate().equals(date) && m.getTime().equals(time)) {
                        if (!m.getAvailability()) {
                            m.setAvailability(true);
                            return 0;
                        }
                        m.setSlotsCounter(m.getSlotsCounter() + 1);
                    }
                }
            }
        }
        return 0;
    }

    public int deleteReservation(LocalDate date, LocalTime time) {
       String type = "Not assigned yet";
        for (Reservation s : Main.Reservations) {
            if (s.getDate().equals(date) && s.getTime().equals(time) && s.getVisitor().getUsername().equals(getUsername())) {
                id = s.getRoom_id();
                type = s.getRoom_type();
                Main.Reservations.remove(s);
                break;
            }
        }
        for (room s : Main.roooms) {
            if (s.getName().equalsIgnoreCase(type)) {
                for (Slott m : s.slots) {
                    if (m.getDate().equals(date) && m.getTime().equals(time)) {
                        if (!m.getAvailability()) {
                            m.setAvailability(true);
                        }
                    }
                    m.setSlotsCounter(m.getSlotsCounter() + 1);
                }
            }
        }
        return 0;
    }
    public static boolean CheckDate(LocalDate date)
    {
        if (date.compareTo(LocalDate.now()) < 0)
        {
            return false;
        }
        else {
            return true;
        }

    }
    public static boolean CheckTime(LocalDate date,LocalTime time) {
        if (time.compareTo(LocalTime.now()) < 0 && date.compareTo(LocalDate.now()) < 0) {
            return false;
        } else {
            return true;
        }

    }
    public  void displayAvailableSlots(String Name) {

    }

}