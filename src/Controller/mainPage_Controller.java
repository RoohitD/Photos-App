package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainPage_Controller {
    @FXML Button uploadButton;
    @FXML Button logoutButton;
    @FXML Button createAlbum;
    @FXML Button editAlbum;

    public void uploadButton_Handler(ActionEvent e) throws Exception {
        Stage stage = (Stage) uploadButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/upload-image-page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void logoutButton_Handler(ActionEvent e) throws Exception {
        loginPage_Controller.currentUser = null;
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/loginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void createAlbum_Handler(ActionEvent e) throws Exception {
        Stage stage = (Stage) createAlbum.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/album-Creation-page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void editAlbum_Handler(ActionEvent e) throws Exception {
        Stage stage = (Stage) editAlbum.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scene/album-Creation-page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
