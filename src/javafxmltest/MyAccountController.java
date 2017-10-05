/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ananya
 */
public class MyAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label accountBalance;
    @FXML
    private Label username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField usernameNew;
    @FXML
    private JFXPasswordField password1;
    @FXML
    private JFXPasswordField password1new;
   
    public void viewAccountBalance() throws SQLException {
     DBConnection conn = new DBConnection();
     Statement stmt = conn.connect().createStatement();
            
     ResultSet rs = stmt.executeQuery("select user_balance from user_info where uid='" + JavaFXMLTest.user_id + "'");
     while(rs.next())
     {
         System.out.println(rs.getInt("user_balance"));
         int bal = rs.getInt("user_balance");
         accountBalance.setText(Integer.toString(bal));
     }
     
     }
    
    public void viewUsername() throws SQLException {
        DBConnection conn = new DBConnection();
     Statement stmt = conn.connect().createStatement();
            
     ResultSet rs = stmt.executeQuery("select user_name from user_info where uid='" + JavaFXMLTest.user_id + "'");
     while(rs.next())
     {
        // System.out.println(rs.getInt("user_name"));
         username.setText(rs.getString("user_name"));
     }
    }
    
    public void changeUsername() throws SQLException {
        UserModel user = new UserModel();
        if(user.checkCorrectPassword(password.getText()))
        {
            user.change_user_name(usernameNew.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Successful!");
                alert.setContentText("Your username has been successfully updated");
                alert.showAndWait();
            password.setText("");
            username.setText("");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Oops!");
                alert.setContentText("The password you have entered is incorrect");
                alert.showAndWait();
        }
    }
    
    public void changePassword() throws SQLException{
        UserModel user = new UserModel();
        if(user.checkCorrectPassword(password1.getText()))
        {
            user.change_password(password1new.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Successful!");
                alert.setContentText("Your password has been successfully updated");
                alert.showAndWait();
                
            password1.setText("");
            password1new.setText("");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Oops!");
                alert.setContentText("The old password you have entered is incorrect");
                alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            viewAccountBalance();
            viewUsername();
        } catch (SQLException ex) {
            Logger.getLogger(MyAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
}
