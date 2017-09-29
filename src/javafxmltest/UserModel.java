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
                + "(user_name, user_mobile, user_email, user_password)"
                + "values('" + name + "', '" + mobile + "', '" + email + "','" + password + "')");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Thanks for registering!");
        alert.setContentText("You have successfully registered");
        alert.showAndWait();
        stmt.executeUpdate(sqluser_info);
        
    }
    
}
