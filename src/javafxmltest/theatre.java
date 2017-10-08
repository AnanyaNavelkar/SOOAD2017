/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author Dharmendra
 */
public class theatre {
    public void bookShow(String number, String seatNo)
    {
       int no=Integer.parseInt(number);
       int seatno= Integer.parseInt(seatNo);
        System.out.println(no +""+ seatno);
        int i= checkNumberofSeats(no);
        int j=checkSeatNumber(seatno);
        if(i==1&&j==1)
        {
          
        }
    }
    
    public int checkNumberofSeats(int n)
    {
  if(n<6 &&n>0)
  {
    return 1;
}
else{
     System.out.println("Seat number from 1-5 only");
popupWrongNumber();
return 0;
    
    }

    }
    public int checkSeatNumber(int sno)
    {
     return 1;
    
    }
    
void popupWrongNumber()
{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Number of Seats");
        alert.setContentText("You have exceeded the number of seats you can choose, which is 5");
        alert.showAndWait();
    
}
}