package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddressBook_JDBC {

    public static void Read(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Address_Book_JDBC", "root", "Ankit@12");

            Statement smt = connection.createStatement();
            ResultSet result = smt.executeQuery("select * from Data;");

            while (result.next()) {

                System.out.println("id :" + result.getInt(1));
                System.out.println("First Name :" + result.getString(2));
                System.out.println("Last name :" + result.getString(3));
                System.out.println("Address :" + result.getString(4));
                System.out.println("City :" + result.getString(5));
                System.out.println("State :" + result.getString(6));
                System.out.println("ZIP :" + result.getString(7));
                System.out.println("Phone Number :" + result.getString(8));
                System.out.println("Email ID :" + result.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(String a){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Address_Book_JDBC", "root", "Ankit@12");

            Statement smt = connection.createStatement();
            smt.executeUpdate(a);


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {

        boolean Stopper = true;

        while (Stopper == true){

            System.out.println("Enter the following details");
            System.out.println("1. Read data");
            System.out.println("2. Update data");
            System.out.println("3. Exit");

            Scanner sc = new Scanner(System.in);
            int inp = sc.nextInt();

            if (inp == 1){
                Read();
            } else if (inp == 2) {

                String str = "update Data set first_name='Lalit',last_name='Gupta',address='245/6' where first_name='Ankit';";
                Update(str);

                System.out.println("Data Updated");
            } else if (inp == 3) {
                Stopper = false;
            }

        }

    }
}

