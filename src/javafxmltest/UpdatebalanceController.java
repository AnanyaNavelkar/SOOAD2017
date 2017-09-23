/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField amount;
    @FXML
    private TextField bankacc;
    @FXML
    private Label loggeduser_name;
    @FXML
    private TextField CvvNo;
    
    public void update() throws SQLException
    {
        /*
        call verify
        call checkbalance
        */
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        /// ResultSet rs = stmt.executeQuery("select balance from user_info");
        //update user_info table
         ResultSet rs = stmt.executeQuery("select * from user_info where user_id='" + JavaFXMLTest.user_id);
          ResultSet bs = stmt.executeQuery("select * from bank where uid='" + JavaFXMLTest.user_id);
         int check= checkbalance();
         int verify= verifyCVV();
         
         if(check==1&&verify==1)
         {
             int user_updated = rs.getInt("user_balance") +parseInt(amount.getText());
       String UpdateUserBalance = "update user_info set user_balance = " + user_updated + "where uid=" + JavaFXMLTest.user_id ; 
       
//       String sql = ("insert into user_info"
//                + "(user_name, user_mobile, user_email, user_password)"
//                + "values('" + name.getText() + "', '" + mobile.getText() + "', '" + email.getText() + "','" + password.getText() + "')");

        //update bank table
         int bank_updated = bs.getInt("bank_balance") - parseInt(amount.getText());
         String UpdateBankBalance = "update bank set bank_balance = " + bank_updated + "where uid=" + JavaFXMLTest.user_id ; 
        stmt.executeUpdate(UpdateBankBalance);
        stmt.executeUpdate(UpdateUserBalance);
        //insert transaction table
         }
         else if( check==0)
         {System.out.println("Insufficent Balance!!");
    }
    else if(verify==0)
    {      System.out.println("Incorrect CVV!!");
    }
    }
    public int verifyCVV() throws SQLException
    {
         DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet BaS =stmt.executeQuery("select * from bank where uid=" + JavaFXMLTest.user_id);
       if(parseInt(CvvNo.getText())==BaS.getInt("cvv"))
       {
        return 1;
       }
       else return 0;
    }
    
    public int checkbalance()throws SQLException
    {
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        ResultSet bs = stmt.executeQuery("select * from bank where uid=" + JavaFXMLTest.user_id);
        if( parseInt(amount.getText())> bs.getInt("bank_balance"))
        {
         return 0;
        }
        else
            return 1;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    
    
}
