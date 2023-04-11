package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class albumCreationPage_Controller {

    @FXML Button albumCancel;
    
    public void albumCancel_Handler(ActionEvent e) throws Exception {
        Stage stage = (Stage) albumCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
