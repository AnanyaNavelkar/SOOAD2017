/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ananya
 */
public class UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField amount;
    @FXML
    private TextField bankacc;
    @FXML
    private TextField cvvno;
    @FXML
    private TextField bankname;
    @FXML
    private Tab update;
    
   private JavaFXMLTest application;
   
   
   public void updateOnClick() throws SQLException //updatebalance
    {
        /*
        call verify
        call checkbalance
        */
        DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
        
        
         int count = 0;
         ResultSet rs = stmt.executeQuery("select * from bank where acc_no='" + bankacc.getText() + "' and cvv='" + Integer.parseInt(cvvno.getText()) + "'and bank_name='" + bankname.getText() + "'");
         while (rs.next()) {
          
                count++;
            }
            if (count > 0) {
                Statement stmt1=conn.connect().createStatement();
                ResultSet rs1 = stmt1.executeQuery("select * from user_info where uid= '" +JavaFXMLTest.user_id+ "'");
                int amountWithdrawn = Integer.parseInt(amount.getText());
                int amountUpdateUser;
                if(rs1.getInt("user_balance") == NULL)
                {
                    amountUpdateUser =  amountWithdrawn;
                }
                else
                    amountUpdateUser = rs1.getInt("user_balance") + amountWithdrawn;
                 
                String updateuser = ("update user_info"
                + "set user_balance = '"+ amountUpdateUser +"'"
                + "where uid='"+ JavaFXMLTest.user_id +"'");
                stmt1.executeUpdate(updateuser);
            }
            
            else {
                System.out.println("Hmm");
            }
            
        //update user_info table
//        String updateuser= "update user_info"
//                + "set balance = '"+rs.getInt("balance")+"'"
//                + "where uid='"+  +"' ";
//        
//        //update bank table
//        String updatebank= "update bank"
//                + "set bank_balance = '"+rs.getInt("bank_balance")+" //'"
//                + "where uid=";
//        
//        //insert transaction table
//        String inserttrans="";*/
    }
    
    public void verify() //updatebalance
    {
        
    }
    
    public void checkbalance() //updatebalance
    {
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setApp(JavaFXMLTest application){
        this.application = application;
    }
}
