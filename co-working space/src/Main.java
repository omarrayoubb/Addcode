package com.example.co_working_space1;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
    public static  ArrayList<Visitor> usrData = new ArrayList<Visitor>();
   // public static ArrayList<TeachingRoom> TeachingRooms = new ArrayList<TeachingRoom>();
   public static ArrayList<room> roooms = new ArrayList<>(3);
    public static void ReadUsers() {
        try {
            FileInputStream users = new FileInputStream("Users.txt");
            ObjectInputStream objusers = new ObjectInputStream(users);
            usrData = (ArrayList<Visitor>) objusers.readObject();
            users.close();

            FileInputStream reservations = new FileInputStream("Reservations.txt");
            ObjectInputStream objReservations = new ObjectInputStream(reservations);
            Reservations  = (ArrayList<Reservation>) objReservations.readObject();

            reservations.close();
            objReservations.close();

            FileInputStream roomFile = new FileInputStream("room.txt");
            ObjectInputStream roomObj = new ObjectInputStream(roomFile);
            roooms  = (ArrayList<room>) roomObj.readObject();

            roomFile.close();
            roomObj.close();


        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void WriteUsers(ArrayList<Visitor> usr, ArrayList<Reservation> reservations, ArrayList<room> Rooom) {
        {
            try {
                FileOutputStream fileUsr = new FileOutputStream("Users.txt");
                ObjectOutputStream objUsr = new ObjectOutputStream(fileUsr);
                ArrayList<Visitor> usrOutput = usr;
                objUsr.writeObject(usrOutput);
                objUsr.close();
                fileUsr.close();


                FileOutputStream fileRes = new FileOutputStream("Reservations.txt");
                ObjectOutputStream objRes = new ObjectOutputStream(fileRes);
                ArrayList<Reservation> Reserve = reservations;
                objRes.writeObject(Reserve);
                objRes.close();
                fileRes.close();

                FileOutputStream roomFile = new FileOutputStream("room.txt");
                ObjectOutputStream roomT = new ObjectOutputStream(roomFile);
                ArrayList<room> t1 = Rooom;
                roomT.writeObject(t1);
                roomT.close();
                roomFile.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

        public void checkRooms()
        {
            ArrayList<Slott> s1 = Slott.CreateListOfSlots(20, 100F);
            ArrayList<Slott> s2 = Slott.CreateListOfSlots(20, 100F);
            ArrayList<Slott> s3 = Slott.CreateListOfSlots(1, 100F);
            ArrayList<Slott> s4 = Slott.CreateListOfSlots(1, 100);

            ArrayList<Slott> s5 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s6 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s7 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s8 = Slott.CreateListOfSlots(1, 100);
            Visitor v = new Visitor("Omar", "20102003Omar", "Instructor", 1);
            ArrayList<Visitor> v1 = new ArrayList<>();

            ArrayList<Visitor> v2 = new ArrayList<>();
            ArrayList<Visitor> v3 = new ArrayList<>();
            ArrayList<Visitor> v4 = new ArrayList<>();
            ArrayList<Visitor> v5 = new ArrayList<>();
            ArrayList<Visitor> v6 = new ArrayList<>();
            ArrayList<Visitor> v7 = new ArrayList<>();
            ArrayList<Visitor> v8 = new ArrayList<>();
            // v1.add(v);
            // v2.add(v);
            // v3.add(v);
            // v4.add(v);
            // v5.add(v);
            //v6.add(v);
            //v7.add(v);

            room r1 = new room("General Room", 1, 20, new ArrayList<Slott>(s1), v1);
            room r2 = new room("General Room", 2, 20, new ArrayList<Slott>(s2), v2);
            room r3 = new room("Meeting Room", 3, 10, new ArrayList<Slott>(s3), v3);
            room r4 = new room("Meeting Room", 4, 10, new ArrayList<Slott>(s4), v4);
            room r5 = new room("Meeting Room", 5, 10, new ArrayList<Slott>(s5), v5);
            room r6 = new room("Teaching Room", 6, 10, new ArrayList<Slott>(s6), v6);
            room r7 = new room("Teaching Room", 7, 10, new ArrayList<Slott>(s7), v7);
            room r8 = new room("Teaching Room", 8, 10, new ArrayList<Slott>(s8), v8);

            roooms.add(r1);
            roooms.add(r2);
            roooms.add(r3);
            roooms.add(r4);
            roooms.add(r5);
            roooms.add(r6);
            roooms.add(r7);
            roooms.add(r8);
        }
        Main()
        {
            //checkRoooms1

        }

    public static void main(String[] args) {

            person user = new person();
            Visitor vis = new Visitor();
            admin Admin = new admin();


        int choose = 0;
        int i = 0;
            Scanner scan = new Scanner(System.in);

            //Reservation reserve = new Reservation(LocalDate.of(2023, 12, 15), LocalTime.of(7,0), "Omar", LocalDate.of(2023, 12, 15), LocalTime.of(7, 0), 1);
            //Reservations.add(reserve);
          //1

          //1
              //WriteUsers(usrData, Reservations, roooms);

            ReadUsers();
            boolean x = true;
            boolean Logout = true;
            /*
            if (ChronoUnit.DAYS.between(LocalDate.now(), roooms.get(1).slots.get(0).getDate()) > 30) {
            roooms = new ArrayList<room>();
            ArrayList<Slott> s1 = Slott.CreateListOfSlots(20, 100F);
            ArrayList<Slott> s2 = Slott.CreateListOfSlots(20, 100F);
            ArrayList<Slott> s3 = Slott.CreateListOfSlots(1, 100F);
            ArrayList<Slott> s4 = Slott.CreateListOfSlots(1, 100);

            ArrayList<Slott> s5 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s6 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s7 = Slott.CreateListOfSlots(1, 100);
            ArrayList<Slott> s8 = Slott.CreateListOfSlots(1, 100);

            room r1 = new room("General Room", 1, 20, s1);
            room r2 = new room("General Room", 2, 20, s2);
            room r3 = new room("Meeting Room", 3, 10, s3);
            room r4 = new room("Meeting Room", 4, 10, s4);
            room r5 = new room("Meeting Room", 5, 10, s5);
            room r6 = new room("Teaching Room", 6, 10, s6);
            room r7 = new room("Teaching Room", 7, 10, s7);
            room r8 = new room("Teaching Room", 8, 10, s8);

            roooms.add(r1);
            roooms.add(r2);
            roooms.add(r3);
            roooms.add(r4);
            roooms.add(r5);
            roooms.add(r6);
            roooms.add(r7);
            roooms.add(r8);

        }
*/

        for (Visitor s : usrData) {
                System.out.println(s.getUsername() + s.getPassword() + s.getType() + s.getId());
            }

        for (Reservation s : Reservations) {
            System.out.println(s.getDate()+ " " + s.getTime() + " " + s.visitor.getUsername() + s.getRoom_id());
        }
        for (room s: roooms) {
            System.out.println(s.getId() + " " + s.slots.get(50).Date + " " + s.slots.get(3).getSlotsCounter()+ " " + s.getName());
        }
        while (Logout) {
            System.out.println("1: for Login");
            System.out.println("2: for register");
            System.out.println("3: for Exit");
            choose = scan.nextInt();
            if (choose == 1)
            {
                user = user.login(usrData);
                if (user instanceof admin)
                {
                    Admin = (admin) user;
                    System.out.println("Admin Has logged in Successfully");
                    System.out.println(Admin.getUsername() + " " + Admin.getPassword());
                    Admin.AdminMenu();
                    break;
                }
                else if (user instanceof Visitor){
                    vis = (Visitor) user;
                }
            }
            else if (choose == 2) {
                vis.Register();
                usrData.add(vis);
            } else {
                System.out.println("Thank you for choosing us");
                return;
            }
            while (x) {
                System.out.println("Please Choose an operation");
                System.out.println("1: make a reservation");
                System.out.println("2: edit a reservation");
                System.out.println("3: delete a reservation");
                System.out.println("4: Logout");
                System.out.println("5: Exit");
                choose = scan.nextInt();
                if (choose == 1)
                    vis.makeReservation(Reservations);
                else if (choose == 2)
                    vis.editReservation();
                else if (choose == 3) {
                    vis.deleteReservation();
                } else if (choose == 4) {
                    System.out.println("Logging out");
                    x = false;

                }
                else {
                    System.out.println("Thank You for Choosing us");
                    x = false;
                    Logout = false;
                }
            }
        }
            WriteUsers(usrData, Reservations, roooms);
        }

    }