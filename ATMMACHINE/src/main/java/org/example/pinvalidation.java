package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class pinvalidation {
    public static boolean validate(int pin) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "Dev@7704");
            PreparedStatement stm = c.prepareStatement("select count(*) from userinfo where pin=?");
            stm.setInt(1,pin);
            ResultSet rs=stm.executeQuery();
            int x=0;
           while(rs.next())
           {
               x=Integer.parseInt(rs.getString(1));
           }
           return x<=0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}