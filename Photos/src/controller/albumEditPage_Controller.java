package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import classes.Album;
import classes.Photo;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class albumEditPage_Controller implements Initializable {

    ObservableList<Photo> allPhotos = FXCollections.observableArrayList();

    ObservableList<Photo> addedPhotos = FXCollections.observableArrayList();

    String albumN;

    @FXML
    private Button addImageToAlbum;

    @FXML
    private ListView<Photo> albumAdded;

    @FXML
    private Button albumCancel;

    @FXML
    private TextField albumName;

    @FXML
    private ListView<Photo> albumPhotoList;

    @FXML
    private Button editAlbum;

    @FXML
    private Button removeImageFromAlbum;

    @FXML
    void addImageToAlbum_Handler(ActionEvent event) {
        addedPhotos.add(albumPhotoList.getSelectionModel().getSelectedItem());
    }

    @FXML
    void albumCancel_Handler(ActionEvent event) {
        try {
            Stage stage = (Stage) albumCancel.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
        }
    }

    @FXML
    void editAlbum_Handler(ActionEvent event) {
        try {
            ArrayList<Photo> albumP = new ArrayList<Photo>();
            albumN = albumName.getText();
            for (int i = 0; i < addedPhotos.size(); i++) {
                albumP.add(addedPhotos.get(i));
            }
            User.currentUser.createAlbum(albumN, albumP);
            Stage stage = (Stage) editAlbum.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/scene/mainPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
        }
            
    }

    public void setAlbum(Album album){
        albumN = album.getAlbumName();
        addedPhotos.addAll(album.getAlbumPhotos());
        albumName.setText(albumN);
    }

    @FXML
    void removeImageFromAlbum_Handler(ActionEvent event) {
        addedPhotos.remove(albumPhotoList.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allPhotos.addAll(User.currentUser.getAlbumList().get(0).getAlbumPhotos());
        albumPhotoList.setItems(allPhotos);

        albumAdded.setItems(addedPhotos);
    }

}
