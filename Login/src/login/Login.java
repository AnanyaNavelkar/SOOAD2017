package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN = "jdbc:mysql://localhost/ApplicationUser";
    
    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        
       // Class.forName(com.mysql.jdbc.Driver);
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
            System.out.println("Connected");
            
        }
        
        catch(SQLException e) {
            System.err.print(e);
        }
        finally {
            if(con != null) {
                con.close();
            }
        }
        launch(args);
       }
        

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EasyPayzee");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text signInTitle = new Text("Sign in (for existing users)");
        signInTitle.setId("signin-text");
        grid.add(signInTitle, 0, 0, 2, 1);

        Label userNameSignIn = new Label("Username/Mobile number:");
        grid.add(userNameSignIn, 0, 1);

        TextField enterUserNameSignIn = new TextField();
        grid.add(enterUserNameSignIn, 1, 1);

        Label pwSignIn = new Label("Password:");
        grid.add(pwSignIn, 0, 2);

        PasswordField pwBoxSignIn = new PasswordField();
        grid.add(pwBoxSignIn, 1, 2);

        Button signInButton = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(signInButton);
        grid.add(hbBtn, 1, 3);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");
        
        //---------------------------------------------------
        
        Text signUpTitle = new Text("Sign up (for new users)");
        signUpTitle.setId("signup-text");
        grid.add(signUpTitle, 3, 0, 2, 1);
        
        Label nameSignUp = new Label("Name:");
        grid.add(nameSignUp, 3, 1);
        
        TextField enterNameSignUp = new TextField();
        grid.add(enterNameSignUp, 4, 1);
        
        Label  mobileNumbeSignUp = new Label("Mobile Number:");
        grid.add(mobileNumbeSignUp, 3, 2);
        
        TextField entermobileNumberSignUp = new TextField();
        grid.add(entermobileNumberSignUp, 4, 2);
        
        Label emailIdSignUp = new Label("Email ID:");
        grid.add(emailIdSignUp, 3, 3);
        
        TextField enterEmailIdSignUp = new TextField();
        grid.add(enterEmailIdSignUp, 4, 3);
        
        Label passwordSignUp = new Label("Password:");
        grid.add(passwordSignUp, 3, 4);
        
        PasswordField pwBoxSignUp = new PasswordField();
        grid.add(pwBoxSignUp, 4, 4);
        
        Button signUpButton = new Button("Sign up");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(signUpButton);
        grid.add(hbBtn1, 4, 5);
        
        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 1, 6);
        actiontarget1.setId("actiontarget1");

        signInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //actiontarget.setText(enterUserNameSignIn.getText());
                
                
                
            }
        });
        
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget1.setText("Sign up button pressed");
            }
        });
        
        


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
}