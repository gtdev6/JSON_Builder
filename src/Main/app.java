package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class app extends Application {

    public static Image icon16x16, icon32x32, icon64x64;

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = null;
        try {
            fxmlLoader = new FXMLLoader(app.class.getResource("UI.fxml"));

            icon16x16 = new Image("Main/Icons/Program_icon/16x16.png");
            icon32x32 = new Image("Main/Icons/Program_icon/32x32.png");
            icon64x64 = new Image("Main/Icons/Program_icon/64x64.png");

            stage.getIcons().addAll(icon64x64, icon32x32, icon16x16);

            Scene scene = new Scene(fxmlLoader.load(), 1400, 740);
            stage.setTitle("JSON Builder!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception io) {
            UIController.showMessage(io.getMessage(), UIController.bombIcon, Alert.AlertType.ERROR).show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}