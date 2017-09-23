/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmltest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ananya
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
   private JavaFXMLTest application;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setApp(JavaFXMLTest application){
        this.application = application;
    }
}
