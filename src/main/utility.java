package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


public class utility {

    public static void switchScene(Hyperlink hyperlink, Scene newScene) {
        hyperlink.setOnAction(event -> {
            Stage currentStage = (Stage) hyperlink.getScene().getWindow();
            currentStage.setScene(newScene);
        });
    }

    public static void saveFile(InputStream inputStream, String directoryPath, String fileName) throws IOException {
        // Create directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create file and write data to it
        File file = new File(directoryPath + File.separator + fileName);
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
    
}


