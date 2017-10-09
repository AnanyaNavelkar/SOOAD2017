/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import static javafxmltest.ElectricityProvider.amount;

/**
 *
 * @author Dharmendra
 */
public class theatre {
    static int no;
    static int toPay;
    public void showAmount(String number, String seatNo)
    {
        no=Integer.parseInt(number);
      // int seatno= Integer.parseInt(seatNo);
        System.out.println(no +" "+ seatNo);
        int i= checkNumberofSeats(no);
        int j=checkSeatNumber(seatNo,no);
        if(i==1&&j==1)
        {
          paymentAmount();
          
        }
    }
    
    public void bookShow(String name, String number, String seatNo) throws SQLException
    {
     SufficientUserBalace b =new SufficientUserBalace();
     int x =b.checkBalance(toPay);
     if(x==1)
     {
     DBConnection conn1 =new DBConnection();   
            Statement stmt1=conn1.connect().createStatement();
           //int bill = Integer.parseInt(billNo);
            String insert = ("insert into movie"
                + "(uid,movie_name,numberSeats,seatNumber,ticket_cost)"
                + "values( '" + JavaFXMLTest.user_id + "', '" + name +  "', '" + no +"', '" + seatNo +"', '" + toPay + "')"); 
     
             stmt1.executeUpdate(insert);
             System.out.println(no+" Ticket booked for "+name+" ");
              UserModel u= new UserModel();
             u.reduceUserBalance(toPay,JavaFXMLTest.user_id );
             TransactionModel t= new TransactionModel();
             t.moviebooked(toPay, '-', "bookedMovie");
             success(name);
     }
             
    
    }
    
    
    public int checkNumberofSeats(int n)
    {
  if(n<7 &&n>0)
  {
    return 1;
}
else{
     System.out.println("Seat number from 1-6 only");
popupWrongNumber();
return 0;
    
    }

    }
    public int checkSeatNumber(String sno,int number)
    {
        int y=sno.length();
        System.out.println(y);
        int r= (number*2) + number -1;
        if(y==r)
        {
            return 1;
        }
        else
        {       
            errorSeatNumber();
            return 0;
        }
    
    }
    public void paymentAmount()
    {
      toPay=no*100;
      //return(Integer.toString(toPay));
      makePaymentof(toPay);
    }
    
void popupWrongNumber()
{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Number of Seats");
        alert.setContentText("You have exceeded the number of seats you can choose, which is 6");
        alert.showAndWait();
    
}
void errorSeatNumber()
{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Seat Number");
        alert.setContentText("Kindly check the seat numbers entered. Number of seats and seat number required doesnt match");
        alert.showAndWait();
    
}
void success(String name)
{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Ticket booked");
        alert.setContentText("Successfullt boooked "+no +"ticket for"+name+" ");
        alert.showAndWait();
    
}
void makePaymentof(int n)
{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Amount");
        alert.setContentText("Make a payment of "+n);
        alert.showAndWait();
    
}
}