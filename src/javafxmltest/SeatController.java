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
import java.util.logging.Level;
import java.util.logging.Logger;

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
     
    static String mName;      
    theatre t= new theatre();
    public void getMoviename(String name)
    {
    
     mName=name;
     //movieName.getText();
    // movieName.setText(mName);
    
      //amount.setText("random");
    }
    public void setMovie(){
    //    movieName.setText(mName);   
    }
    public void payNow()
    {
      try{
        
    // movieName.setText(mName);
   
      
      t.showAmount(number.getText(),seatNumber.getText());
      // System.out.println("Hi");
      
      
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
    public void bookNow() throws SQLException
    {
    //System.out.println("Hi");
    System.out.println("Movie chosen is "+mName);
    t.bookShow(mName,number.getText(),seatNumber.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
