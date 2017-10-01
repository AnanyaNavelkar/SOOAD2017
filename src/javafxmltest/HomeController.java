
package javafxmltest;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class HomeController {

  @FXML 
  private MenuItem viewAccount;

  @FXML 
  private MenuItem close;

  @FXML 
  private MenuItem viewPayBill;

    @FXML 
  private MenuItem viewBookMovie;
    
      @FXML 
  private MenuItem viewRechargeMobile;
      
     @FXML 
  private MenuItem viewUpdateBalance;
        
        @FXML 
  private MenuItem viewPayUser;
  
  @FXML
  void viewAccount(ActionEvent event) throws IOException {
    switchscene("myAccount.fxml");
  }

   @FXML
  void viewPayBill(ActionEvent event) throws IOException {
   switchscene("payBill.fxml"); 
  }

   @FXML
  void viewBookMovie(ActionEvent event) throws IOException {
   switchscene("bookMovie.fxml"); 
  }

   @FXML
  void viewRechargeMobile(ActionEvent event) throws IOException {
   switchscene("rechargeMobile.fxml"); 
  }

  @FXML
  void viewUpdateBalance(ActionEvent event) throws IOException {
      switchscene("updateBalance.fxml"); 
  }

 @FXML
  void viewPayUser(ActionEvent event) throws IOException {
   switchscene("payUser.fxml"); 
  }
  
  void switchscene(String fxml) throws IOException
  {
      
      URL paneUrl = getClass().getResource(fxml);
      AnchorPane pane = FXMLLoader.load( paneUrl );
      BorderPane border = JavaFXMLTest.getRoot();
      border.setCenter(pane);
      
  }
  
  
  @FXML
  void close(ActionEvent event) {

      //Close application

  }
}