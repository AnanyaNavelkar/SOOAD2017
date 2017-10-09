/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import static javafx.scene.input.KeyCode.R;


/**
 * FXML Controller class
 *
 * @author Dharmendra
 */

public class TransactionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label transactions;
    @FXML
    RadioButton allTransactions;
    @FXML
    RadioButton mobileRecharge;
    @FXML
    RadioButton electricityBill;
    @FXML
    RadioButton payAUser;
    @FXML
    RadioButton bookAMovie;
    
   
    
    public void showAllTransactions() throws SQLException
    {
        TransactionModel t = new TransactionModel();
        ResultSet rs = t.getAllTransactions();
        
        StringBuilder sb = new StringBuilder();
        
        while(rs.next()) {
                if(rs.getString("service_type").equals("payElectricityBill"))
                {
                    sb.append("You paid an electricity bill of Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");
                }
                else if(rs.getString("service_type").equals("rechargeMobile"))
                {
                    sb.append("You recharged your mobile number with Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");
                }
                else if(rs.getString("service_type").equals("payUser"))
                {
                    UserModel u = new UserModel();
                    String name = u.retrieveUser(rs.getInt("uid2"));
                    sb.append("You paid a sum of Rs " + rs.getInt("amount") + " to " + name + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");
                }
                else if(rs.getString("service_type").equals("bookedMovie"))
                {
                     sb.append("You booked a movie ticket/s of Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");

                }       
                transactions.setText(sb.toString());
                
//            }
            
          
        }
        
    }
    
    public void checkHandler(int i) throws SQLException {
         DBConnection conn =new DBConnection();
          Statement stmt=conn.connect().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
          TransactionModel t = new TransactionModel();
          StringBuilder sb1= new StringBuilder();
         
        if(i == 1)
        {
            String serviceType = "rechargeMobile";
            ResultSet rs = t.getSpecificTransactions(serviceType);

          
          while(rs.next())
          {
            
             sb1.append("You recharged your mobile number with Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");

          }
        }
        
        else if(i == 2)
        {
            String serviceType = "payElectricityBill";
            ResultSet rs = t.getSpecificTransactions(serviceType);
          
          while(rs.next())
          {
//              System.out.println(rs.getInt("amount"));
             sb1.append("You paid an electricity bill of Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");

          }
        }
        
        else if(i == 3)
        {
            String serviceType = "payUser";
            ResultSet rs = t.getSpecificTransactions(serviceType);
            UserModel u1 = new UserModel();
            String name;
            while(rs.next())
            {
                name = u1.retrieveUser(rs.getInt("uid2"));
                sb1.append("You paid a sum of Rs " + rs.getInt("amount") + " to " + name + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");

            }
            
        }
        
        else if(i == 4)
        {
            String serviceType = "bookedMovie";
            ResultSet rs = t.getSpecificTransactions(serviceType);
          
          while(rs.next())
          {
//              System.out.println(rs.getInt("amount"));
             sb1.append("You booked a movie ticket/s of Rs " + rs.getInt("amount") + " from your EasyPayzee account on " + rs.getDate("date") + "\n\n");

          }
        }

        else
            showAllTransactions();
        transactions.setText(sb1.toString());
    }
    
    public void mobileRechargeOnAction() throws SQLException
    {
        if(mobileRecharge.isSelected())
        {
            System.out.println(mobileRecharge.isSelected());
            checkHandler(1);
        }
        
    }
    public void electricityBillOnAction() throws SQLException
    {
        if(electricityBill.isSelected())
        {
            checkHandler(2);
        }
        
    }
    public void payAUserOnAction() throws SQLException
    {
        if(payAUser.isSelected())
            checkHandler(3);
        
    }
    public void bookAMovieOnAction() throws SQLException
    {
        if(bookAMovie.isSelected())
            checkHandler(4);
//        showAllTransactions();
    }
    
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showAllTransactions();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
