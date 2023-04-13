package main;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.URL;

import Classes.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class mainApp extends Application {


    public static void main(String[] args) {

        User.userList.addAll(utility.readUsersFromFiles());
        launch(args);
        
    }
    
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
