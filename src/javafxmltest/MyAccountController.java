/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

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
     
     DBConnection conn1 = new DBConnection();
     Statement stmt1 = conn.connect().createStatement();
            
     ResultSet rs1 = stmt1.executeQuery("select user_balance from user_info where uid='" + JavaFXMLTest.user_id + "'");
     while(rs1.next())
     {
         
     }
     
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            viewAccountBalance();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
}
