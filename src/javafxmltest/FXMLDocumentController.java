/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.net.URL;
import java.sql.*;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Ananya
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
     TextField name;
    private TextField mobile;
    private TextField email;
    private TextField password;
    private TextField balance;
    
    
    public void submit() throws SQLException
    {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
         
        String sql=("insert into user_info"
                    + "(user_name, user_mobile, user_email, user_password, user_balance)"
                   + "values('ananya', '9900', 'ananya.navelkar@gmail.com','ananya','12345')");
         
         /*while(myRs.next())
         {
            System.out.println(myRs.getString("user_name"));
         }*/
         
         stmt.executeUpdate(sql);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("LoadingRegisterView");
    }    
    
}
