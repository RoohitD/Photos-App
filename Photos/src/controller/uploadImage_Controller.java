package controller;

import java.io.File;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
    Author: Rohit Deshmukh
    The uploadImage_Controller class is a controller for the upload image page.
    It handles the actions of adding an image, uploading an image, and canceling the upload.
*/

public class uploadImage_Controller {

    File selectedFile;

    @FXML
    private Button addImage_Button;

    @FXML
    private TextField imageCaption_TF;

    @FXML
    private TextField imageTag_TF;

    @FXML
    private Button uploadPhoto_Button;

    @FXML
    private Button upload_Cancel;

    @FXML
    private Label upload_FileName;
    
    /**
     * Handles the action of adding an image.
     * Opens a file chooser dialog for the user to select an image file and displays the file name in the UI.
     * @param event The event triggered by clicking the addImage_Button.
     */
    @FXML
    void addImage_Handler(ActionEvent event) {

        Stage stage = (Stage) ((Button) addImage_Button).getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg"));
        selectedFile = fileChooser.showOpenDialog(stage);
        upload_FileName.setText(selectedFile.getName());
    }

    /**
     * Handles the action of canceling the upload.
     * Redirects the user to the main page.
     * @param event The event triggered by clicking the upload_Cancel button.
     */
    @FXML
    void uploadCancel_Handler(ActionEvent event) {
        try {
            Stage stage = (Stage) upload_Cancel.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {

        }
    }

    /**
     * Handles the action of uploading an image.
     * Validates that an image file, caption, and tag have been selected/entered and then adds the photo to the user's collection.
     * Redirects the user to the main page.
     * @param event The event triggered by clicking the uploadPhoto_Button.
     */
    @FXML
    void uploadPhoto_Handler(ActionEvent event) {

        Alert invalidAlert = new Alert(AlertType.ERROR);
        invalidAlert.setHeaderText("No Image");
        invalidAlert.setContentText("Image does not exist or isn't valid");

        String photoCaption = imageCaption_TF.getText();
        String photoTag = imageTag_TF.getText();

        if(selectedFile != null && !photoCaption.isEmpty() && !photoTag.isEmpty()){
            try {
                User.currentUser.addPhoto(photoCaption, selectedFile, photoTag);
                Stage stage = (Stage) upload_Cancel.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (Exception e) {
            }
            
        } else {
            invalidAlert.showAndWait();
        }
    }
}
