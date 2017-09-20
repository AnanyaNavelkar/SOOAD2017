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
    
    public void update() throws SQLException
    {
        /*
        call verify
        call checkbalance
        */
        /*DBConnection conn =new DBConnection();   
        Statement stmt=conn.connect().createStatement();
         ResultSet rs = stmt.executeQuery("select balance from user_info");
        //update user_info table
        String updateuser= "update user_info"
                + "set balance = '"+rs.getInt("balance")+"'"
                + "where uid='"+  +"' ";
        
        //update bank table
        String updatebank= "update bank"
                + "set bank_balance = '"+rs.getInt("bank_balance")+" //'"
                + "where uid=";
        
        //insert transaction table
        String inserttrans="";*/
    }
    
    public void verify()
    {
        
    }
    
    public void checkbalance()
    {
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    
    
}
