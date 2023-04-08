package Controller;

import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class signUpPage_Controller {

    @FXML TextField signUp_username;
    @FXML TextField signUp_password;
    @FXML Button signUp_Cancel;
    @FXML Button signUp_Create;

     public void signUp_cancel_Handler(ActionEvent e) throws Exception {
        Stage stage = (Stage) signUp_Cancel.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/loginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    

    // To do: Check if the username & password are not the same as one of the previous user
    public void signUp_create_Handler(ActionEvent e) throws Exception {

        String username = signUp_username.getText().trim();
        String password = signUp_password.getText().trim();

        Alert invalidAlert = new Alert(AlertType.ERROR);
        invalidAlert.setHeaderText("Input not valid");
        invalidAlert.setContentText("Input is not valid");

        if(username.isEmpty() || password.isEmpty()){
            invalidAlert.showAndWait();
        } else {
            User user = new User(username, password);
            Stage stage = (Stage) signUp_Create.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/loginPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }   
    }
    
}
