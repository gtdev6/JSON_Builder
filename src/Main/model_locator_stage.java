package Main;

import javafx.scene.Cursor;
import model.ModelLocator.ModelLocator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class model_locator_stage implements Initializable {
    static ModelLocator locator;

    @FXML
    private Button save_model_locator_btn, add_pqc_btn, remove_pqc_btn;
    @FXML
    private TextField factory_type_locator_textfield, yRotation_textfield, pqc_textfield,
            animation_Increment_textfield, movementThreshold_textfield, rotateAngleX_TF,
            rotateAngleY_TF, transparency_TF, transparency2_TF, x_Offset_TF, y_Offset_TF, z_Offset_TF,
            xRotation_textfield, zRotation_textfield;
    @FXML
    private ListView<String> pqc_list;

    ArrayList<String> pqcData = new ArrayList<>();
    static Stage window;

    public static ModelLocator display(ModelLocator modelLocator) throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Model Locator");
        window.getIcons().addAll(app.icon32x32, app.icon16x16, app.icon64x64);

        locator = modelLocator;

        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("model_Locator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1139, 750);

        window.setScene(scene);
        window.showAndWait();

        return locator;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<TextField> textFieldsDoubles = new ArrayList<>(Arrays.asList(
                animation_Increment_textfield, movementThreshold_textfield, rotateAngleX_TF,
                rotateAngleY_TF, transparency_TF, transparency2_TF, x_Offset_TF, y_Offset_TF, z_Offset_TF,
                xRotation_textfield, yRotation_textfield, zRotation_textfield));
        window.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "All Data will be lost, Do you want to close Model Locator?", ButtonType.YES, ButtonType.CANCEL);
            ImageView imageView = new ImageView(UIController.warningIcon);
            imageView.setFitHeight(48);
            imageView.setFitWidth(60);
            imageView.setStyle("-fx-font-size: 16; -fx-font-weight: 900;");
            alert.setGraphic(imageView);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.isPresent() && option.get().equals(ButtonType.YES)) {
                locator = null;
                clearAll();
                window.close();
            }

        });

        List<Button> remove_and_edit_btns = Arrays.asList(
                save_model_locator_btn, add_pqc_btn, remove_pqc_btn
        );

        remove_and_edit_btns.forEach(btn->{
            btn.setOnMouseEntered(e->{
                btn.setCursor(Cursor.HAND);
            });
            btn.setOnMouseExited(e->{
                btn.setCursor(Cursor.DEFAULT);
            });
        });

        textFieldsDoubles.forEach(textField -> {
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    textField.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            });
        });

        if (locator != null) {
            if (locator.getFactoryType() != null)
                factory_type_locator_textfield.setText(locator.getFactoryType());
            if (locator.getAnimationIncrement() != null)
                animation_Increment_textfield.setText(
                        String.valueOf(locator.getAnimationIncrement()));
            if (locator.getMovementThreshold() != null)
                movementThreshold_textfield.setText(
                        String.valueOf(locator.getMovementThreshold()));
            if (locator.getRotateAngleX() != null)
                rotateAngleX_TF.setText(
                        String.valueOf(locator.getRotateAngleX()));
            if (locator.getRotateAngleY() != null)
                rotateAngleY_TF.setText(
                        String.valueOf(locator.getRotateAngleY()));
            if (locator.getTransparency() != null)
                transparency_TF.setText(
                        String.valueOf(locator.getTransparency()));
            if (locator.getTransparency2() != null)
                transparency2_TF.setText(
                        String.valueOf(locator.getTransparency2()));
            if (locator.getxOffset() != null)
                x_Offset_TF.setText(
                        String.valueOf(locator.getxOffset()));
            if (locator.getyOffset() != null)
                y_Offset_TF.setText(
                        String.valueOf(locator.getyOffset()));
            if (locator.getzOffset() != null)
                z_Offset_TF.setText(
                        String.valueOf(locator.getzOffset()));
            if (locator.getxRotation() != null)
                xRotation_textfield.setText(
                        String.valueOf(locator.getxRotation()));
            if (locator.getyRotation() != null)
                yRotation_textfield.setText(
                        String.valueOf(locator.getyRotation()));
            if (locator.getzRotation() != null)
                zRotation_textfield.setText(
                        String.valueOf(locator.getzRotation()));
            if (locator.getPqc() != null && !locator.getPqc().isEmpty()) {
                locator.getPqc().forEach(pqc_list.getItems()::add);
            }
        }

        save_model_locator_btn.setOnAction(e -> {
            if (locator == null)
                locator = new ModelLocator();
            try {
                String factoryType = factory_type_locator_textfield.getText();
                Double animation_Increment = (animation_Increment_textfield.getText().isEmpty()
                        || animation_Increment_textfield.getText().isBlank()) ? null
                                : Double.parseDouble(animation_Increment_textfield.getText());
                Double movementThreshold = (movementThreshold_textfield.getText().isEmpty()
                        || movementThreshold_textfield.getText().isBlank()) ? null
                                : Double.parseDouble(movementThreshold_textfield.getText());
                Double rotateAngleX = (rotateAngleX_TF.getText().isEmpty() || rotateAngleX_TF.getText().isBlank())
                        ? null
                        : Double.parseDouble(rotateAngleX_TF.getText());
                Double rotateAngleY = (rotateAngleY_TF.getText().isEmpty() || rotateAngleY_TF.getText().isBlank())
                        ? null
                        : Double.parseDouble(rotateAngleY_TF.getText());
                Double transparency = (transparency_TF.getText().isEmpty() || transparency_TF.getText().isBlank())
                        ? null
                        : Double.parseDouble(transparency_TF.getText());
                Double transparency2 = (transparency2_TF.getText().isEmpty() || transparency2_TF.getText().isBlank())
                        ? null
                        : Double.parseDouble(transparency2_TF.getText());
                Double x_Offset = (x_Offset_TF.getText().isEmpty() || x_Offset_TF.getText().isBlank()) ? null
                        : Double.parseDouble(x_Offset_TF.getText());
                Double y_Offset = (y_Offset_TF.getText().isEmpty() || y_Offset_TF.getText().isBlank()) ? null
                        : Double.parseDouble(y_Offset_TF.getText());
                Double z_Offset = (z_Offset_TF.getText().isEmpty() || z_Offset_TF.getText().isBlank()) ? null
                        : Double.parseDouble(z_Offset_TF.getText());
                Double xRotation = (xRotation_textfield.getText().isEmpty() || xRotation_textfield.getText().isBlank())
                        ? null
                        : Double.parseDouble(xRotation_textfield.getText());
                Double yRotation = (yRotation_textfield.getText().isEmpty() || yRotation_textfield.getText().isBlank())
                        ? null
                        : Double.parseDouble(yRotation_textfield.getText());
                Double zRotation = (zRotation_textfield.getText().isEmpty() || zRotation_textfield.getText().isBlank())
                        ? null
                        : Double.parseDouble(zRotation_textfield.getText());
                ArrayList<String> pqcArrayList = new ArrayList<>(pqc_list.getItems());

                locator = new ModelLocator(factoryType, pqcArrayList, animation_Increment, movementThreshold,
                        rotateAngleX, rotateAngleY, transparency, transparency2, x_Offset, xRotation,
                        y_Offset, yRotation, z_Offset, zRotation);
                clearAll();

            } catch (NumberFormatException nfe) {
                new Alert(Alert.AlertType.INFORMATION, nfe.getMessage()).show();
                locator = null;
            }
            window.close();
        });

        add_pqc_btn.setOnAction(e -> UIController.addIntoList(pqc_textfield, pqc_list, this.pqcData));
        remove_pqc_btn.setOnAction(e -> UIController.removeFromList(pqc_list, this.pqcData));
    }

    public void clearAll() {
        ArrayList<TextField> textFields = new ArrayList<>(Arrays.asList(factory_type_locator_textfield,
                animation_Increment_textfield, movementThreshold_textfield, rotateAngleX_TF,
                rotateAngleY_TF, transparency_TF, transparency2_TF, x_Offset_TF, y_Offset_TF, z_Offset_TF,
                xRotation_textfield, yRotation_textfield, zRotation_textfield, pqc_textfield));
        textFields.forEach(TextField::clear);
        pqc_list.getItems().clear();
        pqc_list.getSelectionModel().clearSelection();
    }

}
