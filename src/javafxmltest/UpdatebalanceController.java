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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ananya
 */
public class UpdatebalanceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXTextField bankacc;
    @FXML
    private JFXTextField cvv;
    @FXML
    private JFXTextField bankname;
//    @FXML
//    private Label loggeduser_name;
    
    public void update() throws SQLException
    {
        UpdateBalanceModel updateUserAndBank = new UpdateBalanceModel();
        updateUserAndBank.updateInfo(amount.getText(), bankacc.getText(), cvv.getText(), bankname.getText());
        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    
    
}
