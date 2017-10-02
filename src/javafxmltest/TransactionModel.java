/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Alert;

/**
 *
 * @author sanjay
 */
public class TransactionModel {
    public void updateTransaction(int amount, char type, String service_type) throws SQLException
    {
        DBConnection conn1 =new DBConnection();   
            Statement stmt1=conn1.connect().createStatement();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(cal.getTime());
            String transactionUpdate = ("insert into transaction"
                + "(uid, amount, service_type, type_of_tran, date)"
                + "values('" + JavaFXMLTest.user_id + "', '" + amount + "', '" +service_type+ "','" +type+ "', '" +formatted+ "')");
                stmt1.executeUpdate(transactionUpdate);
    }
}
    