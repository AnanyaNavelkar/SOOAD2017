/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package javafxmltest;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ananya
 */
public class RegisterController extends AnchorPane implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField mobile;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField bankacc;
    @FXML
    private TextField bankname;
    @FXML
    private TextField loginUserName;
    @FXML
    private PasswordField loginPassword;
   //  @FXML 
   // private Label incorrect;
      @FXML 
    private Label hoverNo;
       @FXML 
    private Label hoverId;
        @FXML 
    private Label hoverName;
     @FXML 
    private Label hoverAccount;

    private JavaFXMLTest application;

    public void registerOnClick() throws SQLException {
        
        //validate();
        
         int i= validatePhone();
         int j=validateEmail();
         int k=validateBank();
         int l=validateBankName();
         int m=userExists();
         if(i==1 && j==1 &&k ==1 && l==1 && m==0)
         {
         UserModel user =new UserModel();
        
        user.store_register_details(name.getText(),mobile.getText(),email.getText(),password.getText());
        
        BankModel bank =new BankModel();
        
        bank.generate_random_bankacc(email.getText(), bankacc.getText(), bankname.getText());
        successfulRegister();
        clearFields();
        //incorrect.setOpacity(0);
         }
         else if (i==0||j==0||k==0||l==0)
         {
           failurePopup();
           // animateMessage();
            mobile.setText("");
            email.setText("");
            bankname.setText("");
            bankacc.setText("");   
         }
         else if(m==1)
         {
          System.out.println("Existing");
          ExistingPopup();
         }
         
    }
    public int userExists() throws SQLException
    {
       UserModel u= new UserModel();
       return(u.ExistingUser(mobile.getText(),email.getText(),bankacc.getText(),bankname.getText()));
       
    
    }
    public int validatePhone()
    {
boolean isValid = false;

        /* Examples: Matches following phone numbers:
         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890

*/
//Initialize reg ex for phone number. 
   String expression = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$";
   CharSequence inputStr = mobile.getText();
   Pattern pattern = Pattern.compile(expression);
   Matcher matcher = pattern.matcher(inputStr);
    if(matcher.matches()){
       isValid = true;
       return 1;
     }
   else{
   System.out.println("Incorrect Phone");
   hoverNo.setText("Invalid Format");
   return 0;
      }

   }
    
    public  int validateEmail(){
/*
Email format: A valid email address will have following format:
        [\\w\\.-]+: Begins with word characters, (may include periods and hypens).
	@: It must have a '@' symbol after initial characters.
	([\\w\\-]+\\.)+: '@' must follow by more alphanumeric characters (may include hypens.).
This part must also have a "." to separate domain and subdomain names.
	[A-Z]{2,4}$ : Must end with two to four alaphabets.
(This will allow domain names with 2, 3 and 4 characters e.g pa, com, net, wxyz)

Examples: Following email addresses will pass validation
abc@xyz.net; ab.c@tx.gov
*/

//Initialize reg ex for email.
String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
CharSequence inputStr = email.getText();
Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
return 1;
}
else{
System.out.println("Incorrect Email");
hoverId.setText("Invalid Email ID");
return 0;
}
}
    
    public int validateBank()
            {
            String expression = "^[0-9]{10}+$";
CharSequence inputStr = bankacc.getText();
Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(inputStr);
if(matcher.matches()){
return 1;
}
else{
System.out.println("Invalid account number");
hoverAccount.setText("Invalid Account Number");
return 0;
}
                
            }
    
     public int validateBankName()
            {
            String expression = "^[\\p{L} .'-]+$";
            CharSequence inputStr = bankname.getText();
            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            if(matcher.matches()){
            return 1;
             }
                 else{
                 System.out.println("Invalid bank name");
                 hoverName.setText("Invalid Bank Name");
                 return 0;
                   }
            }
          /*  private void animateMessage() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), incorrect);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }*/
    

            

    public void loginOnClick() throws IOException, SQLException, NullPointerException {
        try {
            DBConnection conn = new DBConnection();
            Statement stmt = conn.connect().createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from user_info where user_name='" + loginUserName.getText() + "' and user_password='" + loginPassword.getText() + "'");
            int count = 0;
            while (rs.next()) {
                JavaFXMLTest.user_id = rs.getInt("uid");

                count++;
            }
            if (count > 0) {

                System.out.println("LoggedIn");
                
                application.userLogging();
            } else {
                System.out.println("NotRegistered");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void failurePopup()
    {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Oops!Unsuccessful Register");
        alert.setContentText("Kindl check the details filled while registering and try again");
        alert.showAndWait();
    
    }
    public void clearFields(){        
            mobile.setText("");
            email.setText("");
            bankname.setText("");
            bankacc.setText(""); 
            name.setText("");
            password.setText("");
            hoverAccount.setText("");
            hoverName.setText("");
            hoverNo.setText("");
            hoverId.setText("");
            

    }
    public void successfulRegister(){   
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Congratulations");
        alert.setContentText("You have just earned Rs 100 for registering with us!Welcome to our community");
        alert.showAndWait();
    }
    public void ExistingPopup(){   
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EasyPayzee");
        alert.setHeaderText("Already Registered!");
        alert.setContentText("Looks like you have already registered.To use our services, Login.");
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("LoadingRegisterView");
    }

    public void setApp(JavaFXMLTest application) {
        this.application = application;
    }

}
