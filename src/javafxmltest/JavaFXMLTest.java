/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import demo.model.User;
//import demo.security.Authenticator;

/**
 *
 * @author Ananya
 */
public class JavaFXMLTest extends Application {

    public static Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;

    public static int user_id;

    private static BorderPane root;
    
    public static BorderPane getRoot() {
        return root;
    }

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

    public void userLogging() throws IOException {

        gotoHome();

    }

    private void gotoHome() throws IOException {

        URL menuBarUrl = getClass().getResource("Home.fxml");
        MenuBar bar = FXMLLoader.load(menuBarUrl);

        URL paneOneUrl = getClass().getResource("myAccount.fxml");
        AnchorPane paneOne = FXMLLoader.load(paneOneUrl);
            BorderPane newroot = new BorderPane();
            this.root=newroot;
        root.setTop(bar);
        root.setCenter(paneOne);
        Scene scene = new Scene(root, 640, 480);

        stage.setScene(scene);

    }

    public void gotoRegister() {
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
