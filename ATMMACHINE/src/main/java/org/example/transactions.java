package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class transactions {
    public static ResultSet history(String name, int pin) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "Dev@7704");
            String useridquery = "select id from userinfo where name='" + name + "' and pin=" + pin;
            PreparedStatement stm1 = c.prepareStatement(useridquery);
            ResultSet rs1 = stm1.executeQuery();
            String userid ="";
            while(rs1.next())
            {
                userid=rs1.getString(1);
            }
            String query="select transactiontime,transaction from "+userid;
            PreparedStatement stmt=c.prepareStatement(query);
//            stmt.setString(1,userid);
            return stmt.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
