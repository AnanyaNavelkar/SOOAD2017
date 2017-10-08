
package javafxmltest;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class HomeController {

  @FXML 
  private MenuItem viewAccount;
 @FXML 
  private MenuItem viewTransaction;

  @FXML 
  private MenuItem Logout;

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
   switchscene("Electricity.fxml"); 
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
  @FXML
  void Logout(ActionEvent event) throws IOException {
       JavaFXMLTest j= new JavaFXMLTest();
        j.gotoRegister();       
        popupLogout();

  }
  @FXML
  void viewTransaction(ActionEvent event) throws IOException {

       switchscene("transaction.fxml");
       

  }
  void switchscene(String fxml) throws IOException
  {
      
      URL paneUrl = getClass().getResource(fxml);
      AnchorPane pane = FXMLLoader.load( paneUrl );
      BorderPane border = JavaFXMLTest.getRoot();
      border.setCenter(pane);
      
  }
  void popupLogout()
  {
                System.out.println("Logged Out");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("EasyPayzee");
                alert.setHeaderText("Logged Out!");
                alert.setContentText("Thank you for using EasyPayzee. To continue using our services, Login");
                alert.showAndWait();
  }
  
  
  
}