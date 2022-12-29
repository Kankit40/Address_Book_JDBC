package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressBook_JDBC {

    public static void main(String[] args) {

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
}

