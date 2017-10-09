/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafxmltest.JavaFXMLTest.stage;

/**
 * FXML Controller class
 *
 * @author Dharmendra
 */

public class BookMovieController implements Initializable {

      
        SeatController s = new SeatController();
       
    /**
     * Initializes the controller class.
     */public void bookTicketN()
     {
        scenechange();
       s.getMoviename("Newton"); 
       //s.payNow();  
     
     }
     public void bookTicketI()
     {
         scenechange();           
         s.getMoviename("IT");
     //    s.payNow();
     
     }
     public void bookTicketC()
     {
         scenechange();
         s.getMoviename("Chef");
         //s.payNow();
     
     }
     public void bookTicketY()
     {
         scenechange();
         s.getMoviename("You are My Sunday");
       //  s.payNow();
     
     }
     public void scenechange()
     
     {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seat.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                 stage.setTitle("EasyPayzee-Ticket Booking");
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
           System.out.println(e);
          }   
         
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
