package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApp extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        MainApp.primaryStage = primaryStage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Field.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("2048");
        primaryStage.getIcons().add(new Image("file:Images" + File.separator + "2048.png"));
        primaryStage.setScene(new Scene(root, 900, 664));
        primaryStage.setMinWidth(495);
        primaryStage.setMinHeight(394);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void resize(int mode) {
        switch (mode) {
            case 1: {
                primaryStage.sizeToScene();
                primaryStage.setResizable(false);
            }
            case 2: primaryStage.setResizable(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
