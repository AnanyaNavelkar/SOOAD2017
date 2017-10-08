/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.SQLException;

import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dharmendra
 */
public class SeatController implements Initializable {

    /**
     * Initializes the controller class.
     */ @FXML
    private JFXTextField number;
    @FXML
    private JFXTextField seatNumber;
    @FXML
    private Label movieName;
       @FXML
    private Label amount;
     
       String mName;      
    public void getMoviename(String name)
    {
    
     mName=name;
      
      //amount.setText("random");
    }
    public void payNow()
    {
      System.out.println("Movie chosen is"+mName);
      movieName.setText(mName);
    
      amount.setText("");
      theatre t= new theatre();
      t.bookShow(number.getText(),seatNumber.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
