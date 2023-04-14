package controller;

import classes.Photo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
    Author: Rohit Deshmukh
    This class is the controller for the image preview screen. 
    It allows the user to view and edit details of a photo.
*/

public class imagePreview_Controller {

    private Photo photoObject;

    @FXML
    private Label date_Label;

    @FXML
    private TextField photoCaption;

    @FXML
    private ImageView photoPreview;

    @FXML
    private Button photoSave;

    @FXML
    private TextField photoTags;

    /**
     * Handles the action of clicking the "Save" button to update the caption and tags of the photo object.
     * Updates the photo object, then closes the current stage.
     *
     * @param event The event triggered by clicking the "Save" button.
     */
    @FXML
    void photoSave_Handler(ActionEvent event) {
        String newCaption = photoCaption.getText();
        String newTags = photoTags.getText();

        photoObject.setCaption(newCaption);
        photoObject.editTags(newTags);


        Stage currentStage = (Stage) photoSave.getScene().getWindow();
        currentStage.close();

    }

    /**
     * Sets the photo object and loads the image, caption, tags, and date for display on the preview screen.
     *
     * @param photo The photo object to be displayed and edited.
     */
    public void setPhoto(Photo photo){
        photoObject = photo;
        photoPreview.setImage(new Image(photo.getImage().toURI().toString())); 
        date_Label.setText(photo.getDate().toString());
        photoCaption.setText(photo.getCaption());
        photoTags.setText(photo.getTags());
    }

}
