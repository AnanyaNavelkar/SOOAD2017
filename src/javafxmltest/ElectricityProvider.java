/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
/**
 *
 * @author Dharmendra
 */
public class ElectricityProvider   {
    
    static int i=0;
     static int amount; 
    public void generateBill(String billNo) throws SQLException{
    
     try {
           
            int len=billNo.length(); 
            int correctBill=checkBillno(billNo);
            if(correctBill==1)
            {
            DBConnection conn1 =new DBConnection();   
            Statement stmt1=conn1.connect().createStatement();
           int bill = Integer.parseInt(billNo);
            String insertFirstTime = ("insert into electricity_provider"
                + "(uid,bill_amount,BillNumber)"
                + "values( '" + JavaFXMLTest.user_id + "', '" + amount +  "', '" + bill + "')");
          //  String insertBill =("insert into electricity_provider"+ "(BillNumber)" +"values (billNo)");
          stmt1.executeUpdate(insertFirstTime);
          //stmt1.executeUpdate(insertBill);
       
            }
         }
       
        catch(Exception e)
        {
            System.out.println(e);
        }
  }
    public String payment(String billNo ,String inputAmount) throws SQLException{
     
        String Updated;
        
        SufficientUserBalace verify= new SufficientUserBalace();
        int ok = verify.checkBalance(Integer.parseInt(inputAmount)); 
        
       // int len=billNo.length(); 
            int correctBill=checkBillno(billNo);
            
     if (ok==1&&correctBill==1)
     {
      try {
      
            int bill = Integer.parseInt(billNo);
            int ipAmt=Integer.parseInt(inputAmount);
            DBConnection conn =new DBConnection();   
            Statement stmt=conn.connect().createStatement();
            int amount2 = 0;
            
               ResultSet rs1 = stmt.executeQuery("select * from electricity_provider where uid='" +JavaFXMLTest.user_id+ "'");
               
        
       System.out.println(JavaFXMLTest.user_id);
         while(rs1.next())
         {
             amount2 = rs1.getInt("bill_amount");
         }
         
         int updatedAmount= amount2-ipAmt;
         System.out.println(updatedAmount);
            String updateinfo= "update electricity_provider set bill_amount = '"+updatedAmount+"' where uid= '"+ JavaFXMLTest.user_id +"' ";
           
             stmt.executeUpdate(updateinfo);
             
             UserModel u= new UserModel();
             u.reduceUserBalance(ipAmt,JavaFXMLTest.user_id );
             
             Success(updatedAmount);
             Updated = changeLabelText(updatedAmount);
             
             TransactionModel t= new TransactionModel();
             t.updateElectricityBill(ipAmt, '-', "Pay Electricity Bill");
             if(updatedAmount==0)
             {
              String clear= "delete from electricity_provider where uid= '" +JavaFXMLTest.user_id +"' ";
              
              stmt.executeUpdate(clear);
               System.out.println("Record Deleted"); 
              SuccessEntire();
             
              //ElectricityController e= new ElectricityController();
              //e.clearFields();
             
             
             }
             return Updated;
     }
      catch (Exception e)
      {
       System.out.println(e);
      }
     }
     return ("");
    }
     
    public int checkBillno(String billno)
    {
     
       String expression = "^[0-9]{5}+$";
CharSequence inputStr = billno;
Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
   System.out.println("Correct format of bill no");
    return 1;
}
else{
     System.out.println("Incorrect format of bill no");
popupError();
return 0;
}
    
    }
   
    public String displayAmount(String billNo ,String msg)
      {
           int len=billNo.length(); 
            int correctBill=checkBillno(billNo);
            if(correctBill==1)
            {
          if(i==0)
          {
              int Finalamount = ThreadLocalRandom.current().nextInt(1000,3000);
               amount=Finalamount;
              popup(amount);
             String s1= "Kindly make a payment of ";
             String s=Integer.toString(amount);
             s1=s1.concat(s);
             return s1;
             
         }
          else
          {
          popup(amount);
             String s1= "Kindly make a payment of ";
             String s=Integer.toString(amount);
             s1=s1.concat(s);
             return s1;
          }
            }
            return("");
      }
    public void popup(int amount)
    {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bill Amount");
        alert.setHeaderText("Payment Amount");
        alert.setContentText("The Bill amount is :"+amount);
        alert.showAndWait();
        i++;
    }
     public void Success(int updatedAmount)
    {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Recieved");
        alert.setHeaderText("Thank you for making the payment");
        alert.setContentText("Payment Recieved. Amount remaining to be paid :"+updatedAmount);
        alert.showAndWait();
       
    }
      public void SuccessEntire()
    {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Recieved");
        alert.setHeaderText("Thank you for making the entire payment");
        alert.setContentText("Complete Payment done!");
        alert.showAndWait();
       
    }
     public String changeLabelText(int amt)
     {
      String s1= "Kindly make a payment of ";
             String s=Integer.toString(amt);
             s1=s1.concat(s);
             return s1;
     }
      public void popupError()
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Incorrect Bill Number");
        alert.setContentText("Please check the Bill Number. It should be 5 numbers long");
        alert.showAndWait();
  }
}