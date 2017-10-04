/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author Dharmendra
 */
public class mobile {
  
    public void recharge(String mobile ,String amount) throws SQLException
    {
      SufficientUserBalace verify= new SufficientUserBalace();
      int ok = verify.checkBalance(Integer.parseInt(amount));
      int i=verifyMobileNo(mobile);
      if(i==0)
      {
        popupMob();
      }
      else if(i==1 && ok==1)
      {
        int amt=Integer.parseInt(amount);
        try {
            DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        
       String insertRecord = ("insert into mobile_op"
                + "(uid,phone_no,payment_amount)"
                + "values( '" + JavaFXMLTest.user_id + "', '" + mobile +  "', '" +amt + "')");
        System.out.println("Successfully Inserted Record");
        
        UserModel u= new UserModel();
        u.reduceUserBalance(amt,JavaFXMLTest.user_id );
        
        TransactionModel t= new TransactionModel();
        t.updateRechargeMobilePhone(amt, '-', "Recharge Mobile");
        
        stmt.executeUpdate(insertRecord);
        
        successPopup(mobile ,amount);
        }
        catch(Exception e)
        {
         System.out.println(e);
        }
        
      }
      
    }
    
    public int verifyMobileNo(String mobno) throws SQLException
    {
      UserModel u= new UserModel();
      String userMobile = u.retrieveMobileno(JavaFXMLTest.user_id);
      
      if(userMobile.equals(mobno))
      {
          System.out.println("Correct Mobile no");
          return 1;
      }
      else
          return 0;
    }
    
    public void popupMob()
    {
     System.out.println("Incorrect Mobile Number");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Incorrect Mobile Number!");
                alert.setContentText("Please check the Mobile Number that you have entered");
                alert.showAndWait();
    }
    public void successPopup(String mob, String amt)
    {
     System.out.println("Transaction Successful");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Successful Transaction");
                alert.setContentText("Your mobile number "+mob+" has been recharged with Rs "+amt+"");
                alert.showAndWait();
    }
}
