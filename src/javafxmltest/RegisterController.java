/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ananya
 */
public class RegisterController implements Initializable {
    
    
    @FXML
        private TextField name;
    @FXML
        private TextField mobile;
    @FXML
        private TextField email;
    @FXML   
        private PasswordField password;
    @FXML  
        private TextField balance;
    
    
    public void submit() throws SQLException
    {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();

        String sql=("insert into user_info"
                    + "(user_name, user_mobile, user_email, user_password, user_balance)"
                   + "values('"+name.getText()+"', '"+mobile.getText()+"', '"+email.getText()+"','"+password.getText()+"','"+balance.getText()+"')");
        
         stmt.executeUpdate(sql);
        
    }
    
    public void viewlogin() throws IOException 
    {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("LoadingRegisterView");
    }    
    
}
