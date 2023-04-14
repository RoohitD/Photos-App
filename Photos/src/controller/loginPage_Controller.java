package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
    Author: Rohit Deshmukh
    This class represents the controller for the login page of the application.
    It is responsible for handling events and user input on the login page.
*/

public class loginPage_Controller implements Initializable {

    @FXML
    private Button login_Cancel;

    @FXML
    private Button login_Login;

    @FXML
    private TextField login_Password;

    @FXML
    private TextField login_Username;

    @FXML
    private Hyperlink login_signUp;


    /**
     * Event handler for the hyperlink click event.
     * Changes the scene to the sign up page.
     *
     * @param event The ActionEvent object that triggered the method call.
     * @throws IOException If there is an error loading the sign up page.
     */
    @FXML
    void handleHyperlinkClick(ActionEvent event) throws IOException {
        Hyperlink hyperlink = (Hyperlink) event.getSource();
        Stage stage = (Stage) hyperlink.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/signUpPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    /**
     * Event handler for the login button click event.
     * Validates user input and logs the user in if the input is valid.
     * Changes the scene to the main page or the admin page, depending on the user.
     *
     * @param event The ActionEvent object that triggered the method call.
     * @throws IOException If there is an error loading the main or admin page.
     */
    @FXML
    void loginButtonHandler(ActionEvent event) throws IOException {
        String username = login_Username.getText().trim();
        String password = login_Password.getText().trim();

    
        if(username.compareTo("admin") == 0 && password.compareTo("admin") == 0){
            Stage stage = (Stage) login_Login.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/adminPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else if(User.verifyUser(username, password)){
                User.currentUser = User.getUser(username, password);
                Stage stage = (Stage) login_Login.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
        } else {
            Alert invalidAlert = new Alert(AlertType.ERROR);
            invalidAlert.setHeaderText("Input not valid");
            invalidAlert.setContentText("Account does not exist");
            invalidAlert.showAndWait();
        } 
    }

    /**
     * Initializes the login page by reading all the user data and storing them in the static User.userList
     * for the current App session
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(User.getUserList().isEmpty()){
            User.load();
        }   
    }
}
