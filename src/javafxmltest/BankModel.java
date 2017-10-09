/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sanjay
 */
public class BankModel {
    
    public void generate_random_bankacc(String email, String bankacc, String bankname) throws SQLException
    {
        DBConnection conn = new DBConnection();
        Statement stmt = conn.connect().createStatement();
        
       
        ResultSet rs = stmt.executeQuery("select * from user_info where user_email= '" + email + "'");
         
        int randomNumBal = ThreadLocalRandom.current().nextInt(10000, 20001);
        int randomNumCvv = ThreadLocalRandom.current().nextInt(100, 1000);
        System.out.println("Your cvv is " + randomNumCvv);
        //String cvvToString = Integer.toString(randomNumCvv);
               
              try {
                  
              if(rs.next())
            {
                String sql1 = ("insert into bank"
                + "(uid, acc_no, bank_name, bank_balance, cvv)"
                + "values('" +rs.getInt("uid")+ "', '" +bankacc+ "', '" +bankname+ "', '" +randomNumBal+ "', '" +randomNumCvv+ "')");
                stmt.executeUpdate(sql1);
            }
    
                  
              }
              
              catch (Exception e)
              {
                  System.out.println(e);
           
              }

        
    }
    
    public String cvvEncrypt(String cvvToHash) throws SQLException {
       String generatedCvv = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(cvvToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedCvv = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println(generatedCvv);
        return generatedCvv;
   }
    
    public void updateBankBalance(int amount) throws SQLException
    {
         
            DBConnection conn1 =new DBConnection();   
            Statement stmt1=conn1.connect().createStatement();
        
         ResultSet rs1 = stmt1.executeQuery("select * from bank where uid='" +JavaFXMLTest.user_id+ "'");
//         System.out.println(rs.next());
         int bank_bal=0;
        int bank_updated;
        
       System.out.println(JavaFXMLTest.user_id);
         while(rs1.next())
         {
             bank_bal = rs1.getInt("bank_balance");
         }
            bank_updated = bank_bal - amount; 
            System.out.println(bank_updated);
            
        String updateuser= "update bank set bank_balance = '"+bank_updated+"' where uid= '"+ JavaFXMLTest.user_id +"' ";
        stmt1.executeUpdate(updateuser);
         
         }
       
    }
    

