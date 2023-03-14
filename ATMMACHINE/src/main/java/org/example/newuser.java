package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class newuser {
    public static void register(String name, int pin, float balance){
        try
        {
            Class.forName ("org.postgresql.Driver");
           Connection c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres","Dev@7704");
            PreparedStatement stm=c.prepareStatement("insert into userinfo values(?,?,?,?)");
            PreparedStatement stm1=c.prepareStatement("select count(*) from userinfo");
            ResultSet count=stm1.executeQuery();
            int id=0;
            while (count.next()) id = Integer.parseInt(count.getString(1));
            id++;
            String temp="create table "+name+id+"(transactiontime text,transaction text)";
            PreparedStatement stm2=c.prepareStatement(temp);
            stm.setString(1,name);
            stm.setInt(2,pin);
            stm.setFloat(3,balance);
            stm.setString(4,name+id);
                    stm.executeUpdate();
            stm2.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
