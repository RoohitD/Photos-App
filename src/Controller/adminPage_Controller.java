package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.User;
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
import main.mainApp;

public class adminPage_Controller implements Initializable {

    @FXML
    private Button adminCreateUser;

    @FXML
    private Button adminDeleteUser;

    @FXML
    private Button adminLogout;

    @FXML
    private ListView<User> adminUserList;

    static  ObservableList<User> uList = FXCollections.observableArrayList();



    @FXML
    void adminCreateUser_Handler(ActionEvent event) throws IOException {
        Stage stage = (Stage) adminCreateUser.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/signUpPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
    }

    @FXML
    void adminDeleteUser_Handler(ActionEvent event) {
        uList.remove(adminUserList.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void adminLogout_Handler(ActionEvent event) throws IOException {
        loginPage_Controller.currentUser = null;
        Stage stage = (Stage) adminLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/loginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //uList.addAll(userApp.userList);
        adminUserList.setItems(uList);
    }

}

