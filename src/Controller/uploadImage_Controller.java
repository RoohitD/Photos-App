package Controller;

import java.io.File;

import Classes.Photo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class uploadImage_Controller {
    @FXML Button uploadImage_Button;
    @FXML Button addImage_Button;
    @FXML Button upload_Cancel;
    @FXML TextField imageTag_TF;
    @FXML TextField imageCaption_TF;
    @FXML Label upload_FileName;
    File selectedFile;
    String photoCaption;
    String photoTag;

    public void addImage_Handler(ActionEvent e) throws Exception {

        photoCaption = imageCaption_TF.getText();
        photoTag = imageTag_TF.getText();

        

        Stage stage = (Stage) ((Button) addImage_Button).getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        selectedFile = fileChooser.showOpenDialog(stage);
        upload_FileName.setText(selectedFile.getName());

        
    }

    public void uploadImage_Handler(ActionEvent e) throws Exception {

        Alert invalidAlert = new Alert(AlertType.ERROR);
        invalidAlert.setHeaderText("No Image");
        invalidAlert.setContentText("Image does not exist or isn't valid");

        Stage stage = (Stage) ((Button) uploadImage_Button).getScene().getWindow();
        if(selectedFile != null && !photoCaption.isEmpty() && !photoTag.isEmpty()){
            loginPage_Controller.currentUser.addPhoto(photoCaption, selectedFile, null);
            System.out.println(loginPage_Controller.currentUser.photoLength());
            //Stage stage = (Stage) login_Login.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/upload-image-page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else {
            invalidAlert.showAndWait();
        }  
    }

    public void uploadCancel_Handler(ActionEvent e) throws Exception {

    }


}

