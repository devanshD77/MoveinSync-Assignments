package org.example;

import java.sql.*;

public class Uservalidation {
    public static boolean ifvalid(String name, int pin)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "Dev@7704");
            String sql="select count(*) from userinfo where name='"+name+"' and pin="+pin;
            PreparedStatement stm=c.prepareStatement(sql);
            ResultSet rs= stm.executeQuery();
            int id=0;
            while(rs.next())
            {
                id=Integer.parseInt(rs.getString(1));
            }
            return id==1;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
