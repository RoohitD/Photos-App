package Controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class mainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/src/Controller/Login-page.fxml"));

        AnchorPane root = (AnchorPane)loader.load();

        primaryStage.setTitle("Song Library");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
