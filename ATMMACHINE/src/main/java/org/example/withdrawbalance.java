package org.example;

import java.sql.*;

public class withdrawbalance {
    public static boolean withdraw(String name,int pin,float amount)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "Dev@7704");
            String useridquery="select id from userinfo where name='"+name+"' and pin="+pin;
            PreparedStatement stm1=c.prepareStatement(useridquery);
            ResultSet rs1= stm1.executeQuery();
            String userid="";
            while(rs1.next()) {
                userid = rs1.getString(1);
            }
            String query="select salary from userinfo where id='"+userid+"'";
            PreparedStatement stm=c.prepareStatement(query);
            ResultSet rs= stm.executeQuery();
            float balance=0;
            while(rs.next())
            {
                balance=Float.parseFloat(rs.getString(1));
            }
            float temp= (float) (balance-amount);
            if(balance>=amount)
            {
//                String query1=;
                PreparedStatement stm2=c.prepareStatement("update userinfo set salary=? where id=?");
                stm2.setFloat(1,temp);
                stm2.setString(2,userid);
                stm2.executeUpdate();
                Timestamp dateTime = new Timestamp(System.currentTimeMillis());
                String date= String.valueOf(dateTime);
                String query2="insert into "+userid+" values('"+date+"', "+amount+")";
                PreparedStatement stm3 = c.prepareStatement(query2);
                stm3.executeUpdate();
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
