/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ananya
 */
public class PayUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField amount;
    
    public void payUser() throws SQLException {


    try {
        PayUserModel pay = new PayUserModel();
        pay.updateInfo(username.getText(), amount.getText());
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
