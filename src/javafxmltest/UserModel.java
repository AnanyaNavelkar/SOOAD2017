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
   
   public void updateUserBalance(String amount) throws SQLException
   {
       
            DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        
         ResultSet rs = stmt.executeQuery("select * from user_info where uid='" +JavaFXMLTest.user_id+ "'");
//         System.out.println(rs.next());
         int user_bal=0;
        int user_updated;
        
       System.out.println(JavaFXMLTest.user_id);
         while(rs.next())
         {
             user_bal = rs.getInt("user_balance");
         }
            user_updated = user_bal + Integer.parseInt(amount); 
            System.out.println(user_updated);
            //update user_info table
        String updateuser= "update user_info set user_balance = '"+user_updated+"' where uid= '"+ JavaFXMLTest.user_id +"' ";
        stmt.executeUpdate(updateuser);
        
   }
    
}
