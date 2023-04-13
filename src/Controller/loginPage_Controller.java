package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.utility;

public class loginPage_Controller implements Initializable {

    @FXML private TextField login_Username;
    @FXML private TextField login_Password;
    @FXML Button login_Login;
    @FXML Button login_Cancel;
    @FXML Hyperlink login_signUp;
    public static User currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loginButtonHandler(ActionEvent e) throws IOException {
        String username = login_Username.getText().trim(); 
        String password = login_Password.getText().trim();

        // Alert for Invalid 
        Alert nodataAlert = new Alert(AlertType.ERROR);
        nodataAlert.setHeaderText("Input not valid");
        nodataAlert.setContentText("Account does not exist");


        
        if(User.verifyUser(username, password)){
            currentUser = User.getUser(username, password);
            if(currentUser.getUsername().compareTo("stock") == 0){
                utility.loadPhotosFromFolder("src/stock");
            } else {
                System.out.println("Not a stock user");
                // utilitiy.loadPhotosFromFolder("Desktop/" + currentUser.getUsername());
            }
            

            Stage stage = (Stage) login_Login.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }  else {
            nodataAlert.showAndWait();
        }
        
    }

    public void handleHyperlinkClick(ActionEvent event) throws Exception {
        Hyperlink hyperlink = (Hyperlink) event.getSource();
        Stage stage = (Stage) hyperlink.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/signUpPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
