package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Photo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class mainPage_Controller implements Initializable{
    @FXML Button uploadButton;
    @FXML Button logoutButton;
    @FXML Button createAlbum;
    @FXML Button editAlbum;
    @FXML private TableView<Photo> mainPage_Table;
    @FXML private TableColumn<Photo, String> tableCaption;
    @FXML private TableColumn<Photo, File> tableImage;
    ObservableList<Photo> list = FXCollections.observableArrayList();
        

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableCaption.setCellValueFactory(new PropertyValueFactory<Photo, String>("caption"));
        tableImage.setCellValueFactory(new PropertyValueFactory<Photo, File>("image"));

        if(list.isEmpty()){
            list.addAll(loginPage_Controller.currentUser.photoList);
            mainPage_Table.setItems(list);
        }

    }

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
