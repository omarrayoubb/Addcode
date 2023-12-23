package com.example.co_working_space1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class admin extends person {
    Scanner scanner = new Scanner(System.in);

    public admin(String username, String password) {
        super(username, password);
    }

    public admin() {
        super();
    }

    public void AdminMenu() {
        int adminChoice = 0;
        do {
            // lesa : 1 add slots ,delete(rooms , slots , res),display(slots, rooms , res),
            // calc, update(rooms , slots , res)
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Slots");
            System.out.println("2. Delete Entity");
            System.out.println("3. Display All Slots");
            System.out.println("4. Display All Visitors' Data");
            System.out.println("5. Display All Rooms' Data");
            System.out.println("6. Display All Instructors' Data");
            System.out.println("7. Calculate Total Amounts");
            System.out.println("8. Update Any Data");
            System.out.println("9. Logout");

            System.out.println("Enter your choice:");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                     addSlots();
                    break;
                case 2:
                    deleteEntity(Main.usrData);
                    break;
                case 3:
                    displayAllSlotsAvailable();
                    break;
                case 4:

                    displayAllVisitors(Main.usrData);

                    /*
                     * System.out.println("Do you want to logout? (yes/no)");
                     * String logoutChoice = scanner.next();
                     * if (logoutChoice.equals("yes")) {
                     * loggedIn = false;
                     * }
                     */
                    break;

                case 5:

                   break;

                case 6:

                    displayAllInstructorsData(Main.usrData);
                    /*
                     * System.out.println("Do you want to logout? (yes/no)");
                     * String L6 = scanner.next().toLowerCase();
                     * if (L6.equals("yes")) {
                     * loggedIn = false;
                     * }
                     */

                    break;
                case 7:
                    RoomFees();
                    // adminUser.calculateTotalAmount();
                    // Calculate and display the total amount of money from general room reservation
                    // Calculate and display the total amount of money from meeting room reservation
                    // Calculate and display the total amount of money from teaching room
                    // reservation

                    break;
                case 8:
                    update();

                    break;
                case 9:
                    System.out.println("Logging out...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (adminChoice != 9);

    }
    public void displayAllVisitors(ArrayList<Visitor> usrData) {
        System.out.println("\nList of All Visitors:");

        for (Visitor s : usrData) {
            System.out.println(s.getUsername() + " " + s.getPassword() + " " + s.getType() + " " + s.getId());
        }
    }
    public void displayAllInstructorsData(ArrayList<Visitor> usrData) {
        for (Visitor i : usrData) {
            if (i.getType().equalsIgnoreCase("Instructor")) {
                System.out.println(i.getUsername() + "\t" + i.getPassword() + "\t" + i.getId() + "\t" + i.getType());
            }
        }
    }
    public void deleteEntity(ArrayList<Visitor> usr) {

        System.out.println("do you want to delete users or rooms or slots ?");
        System.out.println("Delete entities");
        System.out.println("1. users");
        System.out.println("2. rooms");
        System.out.println("3. Slots");
        int delete_choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (delete_choice) {
            case 1:
                System.out.println("what the user id you want to delete ?");
                int wanted_id = scanner.nextInt();
                deleteuser(usr, wanted_id);
                break;

            case 2:
                deleteReservation();
                break;

            case 3:

                break;

            default:
                break;
        }
    }
    public void deleteuser(ArrayList<Visitor> usrData, int id)
    {
        for (Visitor s: usrData)
         {
            if (s.getId() == id) {
                usrData.remove(s); // Remove the user from the list
                System.out.println("User with ID " + id + " deleted successfully.");
                break; // Break the loop once the user is found and removed
            }
        }
    }
    public void deleteReservation()
    {
        Visitor vs = new Visitor();
        vs.deleteReservation();
    }
    public void update() {
        System.out.println("do you want to update users or rooms or slots ?");
        System.out.println("Delete entities");
        System.out.println("1. users");
        System.out.println("2. rooms");
        System.out.println("3. Slots");
        int delete_choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (delete_choice) {
            case 1:
                System.out.println("what the user id you want to update ?");
                int wanted_id = scanner.nextInt();
                updateuser(wanted_id);
                break;

            case 2:
                break;

            case 3:

                break;

            default:
                break;
        }
    }
    public void updateuser(int id) {
        for (Visitor s : Main.usrData) {
            if (s.getId() == id) {
                System.out.println("what do you want to update ");
                System.out.println("update attrubutes");
                System.out.println("1. username");
                System.out.println("2. password");
                System.out.println("3. visitor type");
                int update_choice = scanner.nextInt();

                switch (update_choice) {
                    case 1:
                        System.out.println("enter the modified username");
                        String m_username;
                        m_username = scanner.nextLine();
                        s.setUsername(m_username);
                        break;

                    case 2:
                        System.out.println("enter the modified password");
                        String m_password;
                        m_password = scanner.nextLine();
                        s.setPassword(m_password);
                        break;

                    case 3:

                        System.out.println("enter the modified type");
                        String m_type;
                        m_type = scanner.nextLine();
                        s.setType(m_type);
                        break;

                    default:
                        break;
                }

            }

        }

    }
    public void RoomFees()
    {
        System.out.println("1: General Room");
        System.out.println("2: Meeting Room");
        System.out.println("3: Teaching Room");
        double fees = 0;
        int choice = scanner.nextInt();
      
        switch (choice)
        {
            case 1:
                fees = expectedFees("General Room");
                
                break;
            case 2:
                fees = expectedFees("Meeting Room");
                break;
            case 3:
                fees = expectedFees("Teaching Room");
                break;
        }
        System.out.println("Fees of This Room");
        System.out.println(fees);
    }
    public double expectedFees(String name) {
        double totalFees = 0.0;

        for (room s : Main.roooms) {
            if (s.getName().equalsIgnoreCase(name)) {
                LocalDate today = LocalDate.now();
                if (s.getName().equalsIgnoreCase("Meeting Room") || name.equalsIgnoreCase("Teaching Room")) {
                    for (Slott slot : s.slots) {
                        if (slot.getDate().equals(today)) {
                            if (!slot.getAvailability())
                                totalFees += slot.getFees();
                        }
                    }
                } else {
                    for (Slott slot : s.slots) {
                        if (slot.getDate().equals(today)) {
                            int totalPeopleInRoom = 20 - slot.getSlotsCounter();
                            if (totalPeopleInRoom > 0)
                                totalFees += totalPeopleInRoom * slot.getFees();
                        }
                    }
                }
            }

        }
        return totalFees;
    }
    public void displayAllSlotsAvailable() {
        System.out.println("Available Slots:");
        for (room r : Main.roooms) {

            for (Slott slot : r.slots) {
                if (slot.getAvailability() && slot.getDate().equals(LocalDate.now())) {
                    System.out.println(r.getName() +"  "+ r.getId() + "  " + slot.getDate() + "  " + slot.getTime());
                }
            }


        }


    }
    public void addSlots() {

        // --> han3ml final static fe el rooms b3dd el counter ha3mlha assign bl slot
        // counter elly fe el slot
        System.out.println("which room u want to add slots to it ?");
        System.out.println("rooms");
        System.out.println("1. general room");// two rooms <3
        System.out.println("2. Meeting room");// 3 rooms< 6
        System.out.println("3. Teaching room");// 3 rooms < 9
        int wanted_room = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int day, month, year;
        int hour;
        System.out.println("Please Enter The date");
        day = scanner.nextInt();
        month = scanner.nextInt();
        year = scanner.nextInt();
        System.out.println("Please enter time");
        hour = scanner.nextInt();
        LocalDate Date = LocalDate.of(year, month, day);
        LocalTime Time = LocalTime.of(hour, 0, 0);

        switch (wanted_room) {
            case 1:
                for (room r : Main.roooms) {
                    if (r.getId() < 3) {

                        Slott NewSlot = new Slott(20, 40);
                        NewSlot.setDate(Date);
                        NewSlot.setTime(Time);
                        NewSlot.setAvailability(true);
                        NewSlot.setFees(60);
                        r.slots.add(NewSlot);

                    }

                }
                break;
            case 2:
                for (room r : Main.roooms) {
                    if (r.getId() < 6 && r.getId() >= 3) {

                        Slott NewSlot = new Slott(20, 40);
                        NewSlot.setDate(Date);
                        NewSlot.setTime(Time);
                        NewSlot.setAvailability(true);
                        NewSlot.setFees(60);
                        r.slots.add(NewSlot);

                    }

                }

                break;

            case 3:
                for (room r : Main.roooms) {
                    if (r.getId() < 9 && r.getId() >= 6) {

                        // for (Slott slot : r.slots) {
                        // if (slot.getDate().equals(Date) && slot.getTime().equals(Time)) {
                        // System.out.println("already exists");

                        // } else {
                        Slott NewSlot = new Slott(20, 40);
                        NewSlot.setDate(Date);
                        NewSlot.setTime(Time);
                        NewSlot.setAvailability(true);
                        NewSlot.setFees(40);
                        r.slots.add(NewSlot);

                        // }

                        // }

                    }

                }

                break;

            default:
                break;
        }
    }
}


