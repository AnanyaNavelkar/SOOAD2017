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
   
   public int selectUser(String username) throws SQLException
   {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_info where user_name='" +username+ "' or user_mobile='" +username+ "' or user_email='" +username+ "'");
        int uid=0;
        while(rs.next())
        {
            uid = rs.getInt("uid");
        }
        return uid;
   }
    
}
