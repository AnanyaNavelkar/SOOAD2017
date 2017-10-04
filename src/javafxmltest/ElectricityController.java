/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Dharmendra
 */
public class ElectricityController  implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @FXML
    private TextField billNo;
    @FXML
    private TextField billAmount;
    @FXML
    private Label msg;
    int i=0;
    
   
  public void KnowBill() throws SQLException
  {
   
      ElectricityProvider e= new ElectricityProvider();
    String s2 = e.displayAmount(billNo.getText(), msg.getText());
    msg.setText(s2);
    e.generateBill(billNo.getText());
  
  }
    
  public void PayBill() throws SQLException
  {
     
      ElectricityProvider e= new ElectricityProvider();
      String a= e.payment(billNo.getText(),billAmount.getText());
      msg.setText(a);
     // clearFields();
  }
  public void clearFields()
  {
   billNo.setText("");
   billAmount.setText("");
   msg.setText("");
  
  }
 
  
  
   
   
   
  
}
