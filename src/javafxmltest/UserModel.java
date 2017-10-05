/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Alert;

/**
 *
 * @author sanjay
 */
public class UserModel {
    
   public void store_register_details(String name,String mobile,String email, String password) throws SQLException {
        DBConnection conn = new DBConnection();
        Statement stmt = conn.connect().createStatement();
        
        
        
        String sqluser_info = ("insert into user_info"
                + "(user_name, user_mobile, user_email, user_password, user_balance)"
                + "values('" + name + "', '" + mobile + "', '" + email + "','" + password + "', '" +100+ "')");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Thanks for registering!");
        alert.setContentText("You have successfully registered");
        alert.showAndWait();
        stmt.executeUpdate(sqluser_info);
        
    }
   
   public void updateUserBalance(int amount, int uid) throws SQLException
   {
       
            DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        
         ResultSet rs = stmt.executeQuery("select * from user_info where uid='" +uid+ "'");
//         System.out.println(rs.next());
         int user_bal=0;
        int user_updated;
        
       
         while(rs.next())
         {
             user_bal = rs.getInt("user_balance");
         }
            user_updated = user_bal + amount; 
            System.out.println(user_updated);
            //update user_info table
        String updateuser= "update user_info set user_balance = '"+user_updated+"' where uid= '"+ uid +"' ";
        stmt.executeUpdate(updateuser);
        
   }
    public void reduceUserBalance(int amount, int uid) throws SQLException
   {
       
            DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        
         ResultSet rs = stmt.executeQuery("select * from user_info where uid='" +uid+ "'");
//         System.out.println(rs.next());
         int user_bal=0;
        int user_updated;
        
       
         while(rs.next())
         {
             user_bal = rs.getInt("user_balance");
         }
            user_updated = user_bal - amount; 
            System.out.println(user_updated);
            //update user_info table
        String updateuser= "update user_info set user_balance = '"+user_updated+"' where uid= '"+ uid +"' ";
        stmt.executeUpdate(updateuser);
        
   }
   public int selectUser(String username) throws SQLException
   {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_info where user_name='" +username+ "' or user_mobile='" +username+ "' or user_email='" +username+ "'");
        int uid=0, count=0;
        while(rs.next())
        {
            uid = rs.getInt("uid");
            
        }
        
        return uid;
   }
   public String retrieveMobileno(int uid) throws SQLException
   {
    DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_info where uid='" +uid+ "'");
        String number="a";
        while(rs.next())
        {
            number = rs.getString("user_mobile");
        }
        System.out.println(number);
        return number;
   }
   public int ExistingUser( String mobile,String email,String bankAcc,String bankName) throws SQLException
   {
       int count=0;
       int accNo= Integer.parseInt(bankAcc);
     DBConnection conn =new DBConnection();   
       Statement stmt=conn.connect().createStatement();
       String query ="SELECT * from user_info inner join bank on user_info.uid = bank.uid where user_info.user_mobile='" +mobile+ "' and user_info.user_email='" +email+ "' and bank.acc_no=" +accNo+ " and bank.bank_name='" +bankName+ "'";
       ResultSet rs= stmt.executeQuery(query);
       while(rs.next())
       {
        System.out.println(rs.getInt("uid"));
        count++;
       }
       if(count==0)
       {
        return 0;
       }
       else
           return 1;
    
   }
   
   public boolean checkCorrectPassword(String password) throws SQLException {
       try {
           DBConnection conn = new DBConnection();
           Statement stmt = conn.connect().createStatement();
            
            ResultSet rs = stmt.executeQuery("select user_password from user_info where uid='" + JavaFXMLTest.user_id + "'");
            while(rs.next())
            {
                System.out.println(rs.getString("user_password"));
                System.out.println(password);
               if(rs.getString("user_password").equals(password))
                   return true;
               
            }
            
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       return false;
   }
   
   public void change_user_name(String usernameNew) throws SQLException {
       try {
           DBConnection conn = new DBConnection();
           Statement stmt = conn.connect().createStatement();
           String query = "update user_info set user_name = '"+usernameNew+"' where uid= '"+ JavaFXMLTest.user_id +"' ";;
           stmt.executeUpdate(query);
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }
   
   public void change_password(String password1new) throws SQLException {
       try {
           DBConnection conn = new DBConnection();
           Statement stmt = conn.connect().createStatement();
           String query = "update user_info set user_password = '"+password1new+"' where uid= '"+ JavaFXMLTest.user_id +"' ";;
           stmt.executeUpdate(query);
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }
   
    
}
