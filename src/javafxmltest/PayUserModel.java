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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class PayUserModel implements Initializable {

        public void updateInfo(String username, String amount) throws SQLException
        {
            int uid = 0;
            if(checkBalance(amount))
            {
                try {
                    UserModel user = new UserModel();
                    user.updateUserBalance(-Integer.parseInt(amount),JavaFXMLTest.user_id);
                    UserModel user1 = new UserModel();
                    uid = user1.selectUser(username);
                    user1.updateUserBalance(Integer.parseInt(amount), uid);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                try {
                        TransactionModel transaction = new TransactionModel();
                        transaction.updateTransactionPayUser(Integer.parseInt(amount),'-', "payUser", uid);

                }
                
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Successful!");
                alert.setContentText("You have successfully counducted the transaction");
                alert.showAndWait();
            }
            else
            {
                System.out.println("Insufficient balance");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Insufficient balance!");
                alert.setContentText("You do not have enough balance in your EasyPayzee Account to carry out this transaction");
                alert.showAndWait();
            }
        }
    
    
        public boolean checkBalance(String amount)
        {
            try {
            DBConnection conn = new DBConnection();
            Statement stmt = conn.connect().createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from user_info where uid='" +JavaFXMLTest.user_id+ "'");
            
            while (rs.next()) {
              if(rs.getInt("user_balance") > Integer.parseInt(amount))
                  return true;
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            return false;
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    
    
}
