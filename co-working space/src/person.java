package com.example.co_working_space1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class person implements Serializable {
    private String username;
    private String password;

    person()
    {
        username = "Not assigned yettt";
        password = "1";
    }
    public person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public person login(ArrayList<Visitor> usr)
    {
        ArrayList<Visitor> usrData = usr;
       // int i = 0;
        while (true) {
            //i++;
            String name, password;
            System.out.println("Enter Your Username");
            Scanner read = new Scanner(System.in);
            name = read.nextLine();
            System.out.println("Enter Your Password");
            password = read.nextLine();

            if (name.equalsIgnoreCase("Admin") && password.equals("admin"))
            {
                return new admin("admin", "admin");
            }
            else {
                for (Visitor i : usrData) {
                    if (name.equalsIgnoreCase(i.getUsername()) && password.equals(i.getPassword())) {
                        String username = i.getUsername();
                        String Password = i.getPassword();
                        int id = i.getId();
                        String type = i.getType();
                        System.out.println("User has logged in Successfully");
                        return new Visitor(username, Password, type, id);
                    }
                }
                System.out.println("Please Enter A valid Username Or password");
            }
        }
    }


}
