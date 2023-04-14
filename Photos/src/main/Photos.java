package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
    Author: Rohit Deshmukh
    The Photos class is the main class for the photo management application.
    It launches the application and displays the login page.
*/

public class Photos extends Application {
    
    /**
    The main method for launching the application.
    @param args the command line arguments
    */
    public static void main(String[] args){
        launch(args);
    }

    /**
        Displays the login page when the application is launched.
        @param primaryStage the primary stage for the application
        @throws IOException if the login page FXML file cannot be loaded
    */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/scene/loginPage.fxml"));
        
        Pane root = (Pane)loader.load();
        primaryStage.setTitle("Photo");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
