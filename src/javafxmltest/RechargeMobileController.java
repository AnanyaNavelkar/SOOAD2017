/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dharmendra
 */
   

public class RechargeMobileController implements Initializable {

     @FXML
    private JFXTextField mobNo;
    @FXML
    private JFXTextField amount;
    /**
     * Initializes the controller class.
     */
    public void rechargeMobile() throws SQLException{
    
     mobile m= new mobile();
     m.recharge(mobNo.getText(),amount.getText());
     resetFields();
    
    }
    public void resetFields()
    {
      mobNo.setText("");
      amount.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
