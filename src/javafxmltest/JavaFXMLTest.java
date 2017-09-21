/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;
//import demo.model.User;
//import demo.security.Authenticator;

/**
 *
 * @author Ananya
 */
public class JavaFXMLTest extends Application {

    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;

    public static int user_id;

    @Override
    public void start(Stage primaryStage) {
       
        try {
            stage = primaryStage;
            stage.setTitle("EasyPayzee");
            stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoRegister();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(JavaFXMLTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Application.launch(JavaFXMLTest.class, (java.lang.String[]) null);
    }

    public void userLogging() {

        gotoHome();

    }

    private void gotoHome() {
        try {
            HomeController home = (HomeController) replaceSceneContent("Home.fxml");
            home.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(JavaFXMLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gotoRegister() {
        try {
            RegisterController register = (RegisterController) replaceSceneContent("Register.fxml");
            register.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(JavaFXMLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = JavaFXMLTest.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(JavaFXMLTest.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 620, 620);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

}
