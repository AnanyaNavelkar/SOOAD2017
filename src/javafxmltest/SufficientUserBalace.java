/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author Dharmendra
 */
public class SufficientUserBalace  {
    public int checkBalance(int amount)
    {  int a = 10;
    int UserAmount=0;
    try{
        DBConnection conn1 =new DBConnection();   
            Statement stmt1=conn1.connect().createStatement();
       
         ResultSet rs1 = stmt1.executeQuery("select * from user_info where uid='" +JavaFXMLTest.user_id+ "'");
         while(rs1.next())
         {
            UserAmount = rs1.getInt("user_balance");
         }
         
         if(UserAmount<amount)
         {
          System.out.println("Insufficient Balance");
          popup();
          a=0;
          
          
         }
         else
             a=1;
    }
    catch (Exception e)
    {
     System.out.println(e);   
    }
    if(a==0)
        return 0;
    else
        return 1;
}
  public void popup()
  { 
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment not possible");
        alert.setHeaderText("Insufficient Balance");
        alert.setContentText("Due to insufficient balance in your EasyPayzee account,your transaction was not possible.Kindly update your balance");
        alert.showAndWait();
}
}
