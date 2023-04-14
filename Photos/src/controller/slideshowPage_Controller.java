package controller;

import classes.Photo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
    Author: Rohit Deshmukh
    The controller for the slideshow page of the application.
*/

public class slideshowPage_Controller {

    @FXML
    private Button nextImageButton;

    @FXML
    private Button previousImageButton;

    @FXML
    private ImageView slideshowImage;

    private ObservableList<Photo> photos;
    private int currentIndex;


    /**
     * Handles the "next image" button event by incrementing the current index and updating the image view.
     * @param event the ActionEvent triggered by the user clicking the "next image" button
     */
    @FXML
    void nextImageButton_Handler(ActionEvent event) {
        if(nextImageButton.isPressed()){
            if (currentIndex > -1) {
                currentIndex++;
                updateImageView();
            }
        }
    }


    /**
     * Handles the "previous image" button event by decrementing the current index and updating the image view.
     * @param event the ActionEvent triggered by the user clicking the "previous image" button
     */
    @FXML
    void previousImageButton_Handler(ActionEvent event) {
        
            if (currentIndex < photos.size() - 1) {
                currentIndex--;
                updateImageView();
            }
    }

    /**
     * Sets the list of photos to be displayed in the slideshow and the index of the currently displayed photo.
     * @param selectedAlbumPhotos the list of photos to be displayed in the slideshow
     * @param currentIndex the index of the currently displayed photo
     */
    public void setPhotos(ObservableList<Photo> selectedAlbumPhotos, int currentIndex) {
        this.photos = selectedAlbumPhotos;
        this.currentIndex = currentIndex;
        updateImageView();
    }

    /**
     * Updates the image view with the currently selected photo.
     */
    private void updateImageView() {
        Photo photo = photos.get(currentIndex);
        Image image = new Image(photo.getImage().toURI().toString());
        slideshowImage.setImage(image);
    }

}
