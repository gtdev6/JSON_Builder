package Main;

import javafx.scene.Cursor;
import model.GenderProperty;
import model.ModelLocator.ModelLocator;
import model.model;
import model.Palette;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class paletteStage implements Initializable {
    static ArrayList<Palette> property = new ArrayList<>();
    static ArrayList<String> propertyList = new ArrayList<>();

    @FXML
    private TextField name_palette_textfield, texture_palette_textfield, sprite_palette_textfield,
            particle_palette_textfield,
            emissive_palette_textfield, normalMap_palette_textfield, translationKey_palette_textfield;
    @FXML
    private ListView<String> palette_list_view;
    @FXML
    private Button add_model_locator_btn, add_sounds_btn, save_palette_btn, add_flying_model_locator_btn,
            remove_palette_btn, save_property_btn;

    public ModelLocator model_locator;
    public ModelLocator flying_model_locator;
    public ArrayList<String> sounds;

    private int selectedPalette = -1;

    static Stage window;
    private GenderProperty genderProperty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sounds = null;
        flying_model_locator = null;
        model_locator = null;
        property.clear();
        propertyList.clear();

        add_model_locator_btn.setOnMouseEntered(e -> UIController.onMouseEntered(add_model_locator_btn));
        add_flying_model_locator_btn.setOnMouseEntered(e -> UIController.onMouseEntered(add_flying_model_locator_btn));
        add_sounds_btn.setOnMouseEntered(e -> UIController.onMouseEntered(add_sounds_btn));
        save_palette_btn.setOnMouseEntered(e -> UIController.onMouseEntered(save_palette_btn));
        add_model_locator_btn.setOnMouseExited(e -> UIController.onMouseExited(add_model_locator_btn));
        add_flying_model_locator_btn.setOnMouseExited(e -> UIController.onMouseExited(add_flying_model_locator_btn));
        add_sounds_btn.setOnMouseExited(e -> UIController.onMouseExited(add_sounds_btn));
        save_palette_btn.setOnMouseExited(e -> UIController.onMouseExited(save_palette_btn));


        List<Button> remove_and_edit_btns = Arrays.asList(
                add_model_locator_btn, add_sounds_btn, save_palette_btn, add_flying_model_locator_btn,
                remove_palette_btn, save_property_btn
        );

        remove_and_edit_btns.forEach(btn->{
            btn.setOnMouseEntered(e->{
                btn.setCursor(Cursor.HAND);
            });
            btn.setOnMouseExited(e->{
                btn.setCursor(Cursor.DEFAULT);
            });
        });

        add_model_locator_btn.setOnAction(e -> {
            try {
                if (selectedPalette != -1) {
                    ModelLocator modelLocator = property.get(selectedPalette).getModelLocator();
                    model_locator = (modelLocator != null) ? model_locator_stage.display(modelLocator)
                            : model_locator_stage.display(null);

                } else {
                    model_locator = model_locator_stage.display(null);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add_flying_model_locator_btn.setOnAction(e -> {
            try {
                if (selectedPalette != -1) {
                    ModelLocator modelFlyingLocator = property.get(selectedPalette).getFlyingModelLocator();
                    flying_model_locator = (modelFlyingLocator != null)
                            ? model_locator_stage.display(modelFlyingLocator)
                            : model_locator_stage.display(null);

                } else {
                    flying_model_locator = model_locator_stage.display(null);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add_sounds_btn.setOnAction(e -> {
            try {
                if (selectedPalette != -1) {
                    ArrayList<String> sounds_array = property.get(selectedPalette).getSounds();
                    sounds = (sounds_array != null) ? sounds_stage.display(sounds_array) : sounds_stage.display(null);
                } else {
                    sounds = sounds_stage.display(null);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        save_property_btn.setOnAction(e -> {

            window.close();
        });

        save_palette_btn.setOnAction(e -> {

            String namePalette = name_palette_textfield.getText();
            String texturePalette = texture_palette_textfield.getText();
            String spritePalette = sprite_palette_textfield.getText();
            String particlePalette = particle_palette_textfield.getText();
            String emissivePalette = (emissive_palette_textfield.getText().isBlank()
                    || emissive_palette_textfield.getText().isEmpty()) ? null : emissive_palette_textfield.getText();
            String normalMapPalette = (normalMap_palette_textfield.getText().isBlank()
                    || normalMap_palette_textfield.getText().isEmpty()) ? null : normalMap_palette_textfield.getText();
            String translationKeyPalette = (translationKey_palette_textfield.getText().isBlank()
                    || translationKey_palette_textfield.getText().isEmpty()) ? null
                            : translationKey_palette_textfield.getText();

            Palette new_palette = new Palette();
            new_palette.setName(namePalette);
            new_palette.setTexture(texturePalette);
            new_palette.setSprite(spritePalette);
            new_palette.setParticle(particlePalette);
            new_palette.setEmissive(emissivePalette);
            new_palette.setNormalMap(normalMapPalette);
            new_palette.setTranslationKey(translationKeyPalette);

            if (model_locator != null)
                new_palette.setModelLocator(model_locator);
            if (flying_model_locator != null)
                new_palette.setFlyingModelLocator(flying_model_locator);
            if (sounds != null)
                new_palette.setSounds(sounds);

            if (selectedPalette != -1) {
                palette_list_view.getItems().set(selectedPalette, new_palette.toString());
                propertyList.set(selectedPalette, new_palette.toString());
                property.set(selectedPalette, new_palette);
                selectedPalette = -1;

                if (this.genderProperty != null) {
                    this.genderProperty.getPalettes().set(selectedPalette, new_palette);
                }

            } else {
                palette_list_view.getItems().add(new_palette.toString());
                propertyList.add(new_palette.toString());
                property.add(new_palette);

                if (this.genderProperty != null) {
                    this.genderProperty.getPalettes().add(new_palette);
                }

            }

            name_palette_textfield.clear();
            texture_palette_textfield.clear();
            sprite_palette_textfield.clear();
            particle_palette_textfield.clear();
            emissive_palette_textfield.clear();
            normalMap_palette_textfield.clear();
            translationKey_palette_textfield.clear();
            model_locator = null;
            flying_model_locator = null;
            sounds = null;
            palette_list_view.getSelectionModel().clearSelection();
            selectedPalette = -1;
        });
        remove_palette_btn.setOnAction(e -> {
            String selectedItem = palette_list_view.getSelectionModel().getSelectedItem();
            if (selectedItem.isEmpty())
                return;
            int index = propertyList.indexOf(selectedItem);
            if (index == -1)
                return;
            propertyList.remove(index);
            palette_list_view.getItems().remove(index);
            property.remove(index);
            palette_list_view.getSelectionModel().clearSelection();
            if (this.genderProperty != null) {
                this.genderProperty.getPalettes().remove(index);
            }
        });

        palette_list_view.getSelectionModel().selectedIndexProperty()
                .addListener((changeListener, oldValue, newValue) -> {
                    selectedPalette = newValue.intValue();
                    if (newValue.intValue() == -1)
                        return;
                    if (property != null && !property.isEmpty() && property.get(newValue.intValue()) != null) {
                        Palette paletteSelected = property.get(newValue.intValue());
                        if (paletteSelected.getName() != null)
                            name_palette_textfield.setText(property.get(newValue.intValue()).getName());
                        if (paletteSelected.getParticle() != null)
                            particle_palette_textfield.setText(paletteSelected.getParticle());
                        if (paletteSelected.getTexture() != null)
                            texture_palette_textfield.setText(paletteSelected.getTexture());
                        if (paletteSelected.getSprite() != null)
                            sprite_palette_textfield.setText(paletteSelected.getSprite());
                        if (paletteSelected.getEmissive() != null)
                            emissive_palette_textfield.setText(paletteSelected.getEmissive());
                        if (paletteSelected.getNormalMap() != null)
                            normalMap_palette_textfield.setText(paletteSelected.getNormalMap());
                        if (paletteSelected.getTranslationKey() != null)
                            translationKey_palette_textfield.setText(paletteSelected.getTranslationKey());
                        if (paletteSelected.getModelLocator() != null)
                            model_locator = paletteSelected.getModelLocator();
                        if (paletteSelected.getFlyingModelLocator() != null)
                            flying_model_locator = paletteSelected.getFlyingModelLocator();
                        if (paletteSelected.getSounds() != null)
                            sounds = paletteSelected.getSounds();
                    }
                });

        if (model.openFile) {
            if (model.selectedGP != -1) {
                model.getNewForm().getGenderProperties().get(model.selectedGP).getPalettes()
                        .forEach(e -> palette_list_view.getItems().add(e.toString()));
                property.addAll(model.getNewForm().getGenderProperties().get(model.selectedGP).getPalettes());
                model.getNewForm().getGenderProperties().get(model.selectedGP).getPalettes()
                        .forEach(e -> propertyList.add(e.toString()));

            }

        }

    }

    public static ArrayList<Palette> display() throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Gender Property");
        window.getIcons().addAll(app.icon32x32, app.icon16x16, app.icon64x64);

        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("add_palette.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1139, 750);

        window.setScene(scene);
        window.showAndWait();
        return property;
    }

}
