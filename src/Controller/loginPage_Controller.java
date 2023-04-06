package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class loginPage_Controller implements Initializable {

    @FXML private TextField login_username;
    @FXML private TextField login_password;
    @FXML Button login_Login;
    @FXML Button login_cancel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }

    public void loginButtonHandler(ActionEvent e) throws IOException {
        String username = login_username.getText().trim(); 
        String password = login_password.getText().trim();

        // Alert for Invalid 
        Alert nodataAlert = new Alert(AlertType.ERROR);
        nodataAlert.setHeaderText("Input not valid");
        nodataAlert.setContentText("Account does not exist");

        User user = new User(username, password);

    }
}
