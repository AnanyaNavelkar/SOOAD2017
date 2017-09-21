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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Ananya
 */
public class RegisterController extends AnchorPane implements Initializable {
    
    @FXML
        private TextField name;
    @FXML
        private TextField mobile;
    @FXML
        private TextField email;
    @FXML   
        private PasswordField password;
    @FXML
        private TextField loginUserName;
    @FXML
        private TextField loginPassword;
    
          private JavaFXMLTest application;
    
    public void registerOnClick() throws SQLException
    {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();

        String sql=("insert into user_info"
                    + "(user_name, user_mobile, user_email, user_password)"
                   + "values('"+name.getText()+"', '"+mobile.getText()+"', '"+email.getText()+"','"+password.getText()+"')");
        
        
        name.setText("");
        mobile.setText("");
        email.setText("");
        password.setText("");
        
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Thanks for registering!");
        alert.setContentText("You have successfully registered");
        alert.showAndWait();
        
        
        stmt.executeUpdate(sql);
       
         
    }
   
    public void loginOnClick() throws IOException, SQLException, NullPointerException 
    {
        try {
            DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet rs = stmt.executeQuery("select * from user_info where user_name='"+loginUserName.getText()+"' and user_password='"+loginPassword.getText()+"'");
        int count=0;
           while(rs.next()){
           count++;
          }
        if(count>0){
            
            System.out.println("LoggedIn");
        application.userLogging();  
        }
          else{
           System.out.println("NotRegistered");
          }
        //stmt.executeQuery("select * from user_info where user_name='"+loginUserName.getText()+"' and user_password='"+loginPassword.getText()+"'");
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("LoadingRegisterView");
    }

       public void setApp(JavaFXMLTest application){
        this.application = application;
    }
    
    
 
}
