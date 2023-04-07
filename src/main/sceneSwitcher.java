package main;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


public class sceneSwitcher {

    public static void switchScene(Hyperlink hyperlink, Scene newScene) {
        hyperlink.setOnAction(event -> {
            Stage currentStage = (Stage) hyperlink.getScene().getWindow();
            currentStage.setScene(newScene);
        });
    }
    
}


