package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
    Author: Rohit Deshmukh
    Controller class for the admin page GUI. Implements the Initializable interface.
*/

public class adminPage_Controller implements Initializable{

    // ObservableList for the list of users
    ObservableList<User> uList = FXCollections.observableArrayList();

    @FXML
    private Button adminCreateUser;

    @FXML
    private Button adminDeleteUser;

    @FXML
    private Button adminLogout;

    @FXML
    private ListView<User> adminUserList;

    /**
     * Handles the "Create User" button click event. Loads the sign up page GUI.
     * @param event The ActionEvent triggered by the user clicking the button.
     * @throws IOException if the sign up page FXML file is not found.
     */
    @FXML
    void adminCreateUser_Handler(ActionEvent event) throws IOException {
        Stage stage = (Stage) adminCreateUser.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/signUpPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    /**
     * Handles the "Delete User" button click event. Removes the selected user from the user list.
     * @param event The ActionEvent triggered by the user clicking the button.
     */
    @FXML
    void adminDeleteUser_Handler(ActionEvent event) {
        User.delete(adminUserList.getSelectionModel().getSelectedItem());
        User.getUserList().remove(adminUserList.getSelectionModel().getSelectedItem());
        uList.remove(adminUserList.getSelectionModel().getSelectedItem());
    }

    /**
     * Handles the "Logout" button click event. Logs the current user out and loads the login page GUI.
     * @param event The ActionEvent triggered by the user clicking the button.
     */
    @FXML
    void adminLogout_Handler(ActionEvent event) {
        try {User.currentUser = null;
            Stage stage = (Stage) adminLogout.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/loginPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (Exception e) {
        }
    }

    /**
     * Initializes the controller class. Populates the user list with the list of users.
     * @param location The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uList.addAll(User.getUserList());
        adminUserList.setItems(uList);
    }

}
