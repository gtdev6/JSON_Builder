
package Main;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import model.*;
import model.Moves.LevelUpMove;
import model.Moves.Moves;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;



public class UIController implements Initializable {
    @FXML
    private Pane main_frame, animation_pane, hammer_pane;
    @FXML
    private HBox hbox_pane;
    @FXML
    private Pane ridingOffSets_parameters_pane, swimmingParameters_pane, flyingParameters_pane,
            mountedFlyingParameters_pane;
    @FXML
    private ImageView hammer_image_viewer, left_curve, right_curve;
    @FXML
    private Button createJSONButton, openJSONButton, closeJSONButton;
    @FXML
    private TabPane tab_pane;

    private javafx.collections.ObservableList<javafx.scene.control.Tab> tabs;

    // Aggression Textfields
    @FXML
    private TextField timid_aggression_textfield, passive_aggression_textfield, aggressive_aggression_textfield;

    // BattleStats Float Textfields
    @FXML
    private TextField hp_battlestats_textfield, attack_battlestats_textfield, defense_battlestats_textfield,
            special_attack_battlestats_textfield, special_defense_battlestats_textfield, speed_battlestats_textfield;

    // Title_tab Textfields
    @FXML
    private TextField name_textField, dex_textfield;

    // defaultforms_tab Elements
    @FXML
    private TextField defaultforms_textfield;
    @FXML
    private Button defaultform_add_btn, defaultform_remove_btn;
    @FXML
    private ListView<String> defaultForms_list;

    // forms-preview tab Elements
    @FXML
    private ListView<String> forms_list;
    @FXML
    private TextField generation_textfield;
    @FXML
    private Button add_form_btn, remove_form_btn, finish_Json_btn, edit_form_btn;

    // Forms Elements
    @FXML
    private TextField name_forms_textfield, experience_group_forms_textfield,
            height_forms_textfield, width__forms_textfield, length_forms_textfield,
            eyeheight_forms_textfield, hover_height_forms_textfield;

    @FXML
    private Button forms_next_btn;

    // Moves Elements
    @FXML
    private ComboBox<String> moves_combobox = new ComboBox<>();
    @FXML
    private Pane levelUpMove_pane, otherMoves_pane;
    @FXML
    private ListView<String> moves_list, attack_moves_list;
    @FXML
    private TextField attack_moves_textfield, level_moves_textfield, moves_textfield;
    @FXML
    private Button remove_attack_moves_btn, remove_levelUpMove_btn, moves_remove_btn,
            moves_add_btn, add_levelUpMove_btn, add_attack_moves_btn;

    // Abilities Elements
    @FXML
    private Button abilities_next_btn, add_ability_btn, add_hiddenability_btn, remove_abiltites_btn,
            remove_hiddenabiltites_btn;
    @FXML
    private ListView<String> abilities_list, hidden_ability_list;
    @FXML
    private TextField abilities_textfield, hidden_ability_textfield;

    // ----------------------------------------------// Movement Elements//
    // -----------------------------
    @FXML
    private Button movement_next_btn;
    @FXML
    private CheckBox rideable, can_surf, can_ride_shoulder, can_fly;
    @FXML
    private ComboBox<LandingMaterials> landing_material_combo_box;

    // Riding offsets
    @FXML
    private TextField standingXTF, standingYTF, standingZTF, movingXTF, movingYTF, movingZTF;
    // Swimming offsets
    @FXML
    private TextField depthRangeStartTF, depthRangeEndTF, swimSpeedTF, decayRateTF, refreshRateTF,
            chanceToSopOnBlockTF, minStopTimeTF, maxStopTimeTF, minStopCooldownTimeTF,
            maxStopCooldownTimeTF;
    @FXML
    private ComboBox<BlockTypes> blocksToStopOn_combo_box;
    @FXML
    private ListView<String> block_list;
    @FXML
    private Button addBlock_btn, removeBlock_btn;
    @FXML
    private CheckBox addBlockPart_checkBox, canRotateWhileStoppedCheckBox, addCanRotateWhileStopped_CheckBox;
    @FXML
    private Pane block_pane;
    @FXML
    private Label canRotateWhileStopped_Label;

    ArrayList<BlockTypes> allBlocks = new ArrayList<>(List.of(BlockTypes.values()));

    // flying offsets
    @FXML
    private TextField flyHeightMinTF, flyHeightMaxTF, flySpeedModifierTF, flyRefreshRateYTF,
            flyRefreshRateXZTF, flyRefreshRateSpeedTF, flightTimeMinTF, flightTimeMaxTF, flapRateTF;

    // mountedFlying parameters
    @FXML
    private TextField type_mounted_TF, upper_angle_limit_TF, lower_angle_limit_TF,
            max_fly_speed_TF, deceleration_rate_TF, hover_deceleration_rate_TF,
            acceleration_rate_TF, strafe_acceleration_rate, strafe_roll_conversion_TF,
            turn_rate_TF, pitch_rate_TF, gravity_drop_per_tick_TF, continuous_forward_motion_TF,
            flying_stamina_charges_TF, hover_ticks_TF;
    @FXML
    private CheckBox stays_horizontal_flying_checkbox, continuous_forward_motion_checkbox;

    // --------------------------------------------------

    // Tags Elements
    @FXML
    private ListView<String> tag_list;
    @FXML
    private Button add_tag_btn, remove_tag_btn;
    @FXML
    private TextField tag_textfield;

    // Spawn Elements
    @FXML
    private TextField baseExp_spawn_textfield, baseFriendship_spawn_textfield, spawn_level_spawn_textfield,
            spawn_level_range_spawn_textfield, spawn_location__spawn_textfield;
    @FXML
    private Button spawn_next_btn, add_location_spawn_btn, remove_location_spawn_btn;
    @FXML
    private ListView<String> spawn_location_list;

    // Possible Gender Elements
    @FXML
    private ComboBox<String> gender_possibleGender_combobox;
    @FXML
    private Button add_gender_btn, remove_gender_btn, possible_next_btn;
    @FXML
    private ListView<String> gender_list;

    // Gender Properties Elements
    @FXML
    private TextField genderproperties_gender_textfield;
    @FXML
    private Button add_gender_property_btn, remove_genderproperty_btn, genderproperties_next_btn,
            edit_genderProperty_btn;
    @FXML
    private ListView<String> genderProperties_list;
    private ArrayList<Palette> paletteArrayList = new ArrayList<>();

    // Other Objects Elements
    @FXML
    private TextField objects_textfield;
    @FXML
    private ComboBox<String> other_objects_combobox;
    @FXML
    private Button add_object_btn, remove_object_btn, otherobject_next_btn;
    @FXML
    private TextField defaultBaseForm_textfield, eggCycles_textfield, weight_textfield, catchRate_textfield,
            malePercentage_textfield, form_other_textfield, move_other_textfield;
    @FXML
    private CheckBox canHaveFactor, canGiganTamax;
    @FXML
    private ListView<String> objects_listview;

    // Evolutions
    @FXML
    private TextField hp_evolution_textfield, attack_evolution_textfield,
            defense_evolution_textfield, specialAttack_evolution_textfield, specialDefense_evolution_textfield,
            speed_evolution_textfield;
    @FXML
    private Button add_evolution_btn, remove_evolution_btn, evolutions_next_btn, edit_evolution_btn;
    @FXML
    private ListView<String> evolution_list;
    private ArrayList<Evolution> evolutions_array = new ArrayList<>();

    // Final Stage Elements
    @FXML
    private TextArea final_textbox;
    @FXML
    private Button load_saved_btn, export_file_btn;

    // Next Buttons
    @FXML
    private Button title_next_btn, defaultform_next_btn, moves_next_btn,
            aggression_next_btn, battlestats_next_btn,
            tags_next_btn;

    // Add Buttons
    @FXML
    private Button add_palette_btn;

    static Font nunitoRegular, nunitoMedium, nunitoSemiBold, nunitoBold;
    static Image addIcon, createIcon, editIcon, exportIcon, loadIcon, openIcon, removeIcon, bombIcon, fireCrackerIcon,
            bellIcon, partyPopperIcon, warningIcon;
    static ImageView addIconIV, createIconIV, editIconIV, exportIconIV, loadIconIV, openIconIV, removeIconIV;
    ArrayList<Node> allNodes = new ArrayList<>();

    ArrayList<ImageView> imageViews;

    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FileInputStream font_path_Regular = new FileInputStream(getClass().getResource("Fonts/Nunito-Regular.ttf").getPath());
            FileInputStream font_path_Medium = new FileInputStream(
                    getClass().getResource("Fonts/Nunito-Medium.ttf").getPath());
            FileInputStream font_path_SemiBold = new FileInputStream(
                    getClass().getResource("Fonts/Nunito-SemiBold.ttf").getPath());
            FileInputStream font_path_Bold = new FileInputStream(
                    getClass().getResource("Fonts/Nunito-Bold.ttf").getPath());

            nunitoRegular = Font.loadFont(font_path_Regular, 16);
            nunitoMedium = Font.loadFont(font_path_Medium, 16);
            nunitoSemiBold = Font.loadFont(font_path_SemiBold, 16);
            nunitoBold = Font.loadFont(font_path_Bold, 16);

        } catch (FileNotFoundException ioException) {
            showMessage(ioException.getMessage(), bombIcon, Alert.AlertType.ERROR);
        }
        try{
            addIcon = new Image("Main/Icons/addWhiteIcon.png");
            createIcon = new Image("Main/Icons/create.png");
            editIcon = new Image("Main/Icons/edit.png");
            exportIcon = new Image("Main/Icons/export.png");
            loadIcon = new Image("Main/Icons/load.png");
            openIcon = new Image("Main/Icons/openFile.png");
            removeIcon = new Image("Main/Icons/removeIcon.png");
            bombIcon = new Image("Main/Icons/bomb.png");
            fireCrackerIcon = new Image("Main/Icons/firecracker.png");
            bellIcon = new Image("Main/Icons/bell.png");
            partyPopperIcon = new Image("Main/Icons/partypopper.png");
            warningIcon = new Image("Main/Icons/Warning.png");

            addIconIV = new ImageView(addIcon);
            createIconIV = new ImageView(createIcon);
            editIconIV = new ImageView(editIcon);
            exportIconIV = new ImageView(exportIcon);
            loadIconIV = new ImageView(loadIcon);
            openIconIV = new ImageView(openIcon);
            removeIconIV = new ImageView(removeIcon);

            imageViews = new ArrayList<>(FXCollections.observableArrayList(addIconIV, createIconIV, editIconIV,
                    exportIconIV, loadIconIV, openIconIV, removeIconIV));
            imageViews.forEach(e -> {
                e.setFitWidth(32);
                e.setFitHeight(32);
            });



        } catch (Exception ioException) {
            showMessage(ioException.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
        }

        final_textbox.setEditable(false);
        if (nunitoRegular != null)
            final_textbox.setFont(nunitoRegular);

        hbox_pane.getChildrenUnmodifiable().remove(tab_pane);
        // hbox_pane.getChildrenUnmodifiable().add()

        RotateTransition rotateTransition = new RotateTransition();
        TranslateTransition translate = new TranslateTransition();

        // shifting the X coordinate of the centre of the circle by 400
        translate.setByX(-50);
        translate.setByY(-50);

        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setByAngle(50);
        rotateTransition.setAutoReverse(true);
        // setting the duration for the Translate transition
        translate.setDuration(Duration.millis(800));
        rotateTransition.setDuration(Duration.millis(1000));

        // setting cycle count for the Translate transition
        translate.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        // the transition will set to be auto reversed by setting this to true
        translate.setAutoReverse(true);

        // setting Circle as the node onto which the transition will be applied
        translate.setNode(left_curve);
        rotateTransition.setNode(hammer_pane);
        // playing the transition
        // translate.play();
        // rotateTransition.play();
        // translate.setDelay(Duration.millis(1000));
        // translate.play();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), new KeyValue(left_curve.translateXProperty(), -50),
                        new KeyValue(left_curve.translateYProperty(), -50),
                        new KeyValue(right_curve.translateXProperty(), 50),
                        new KeyValue(right_curve.translateYProperty(), 50)),
                new KeyFrame(Duration.seconds(3), new KeyValue(hammer_pane.rotateProperty(), 60)),
                new KeyFrame(Duration.seconds(6), new KeyValue(hammer_pane.rotateProperty(), 18.8)),
                new KeyFrame(Duration.seconds(4), new KeyValue(left_curve.translateXProperty(), 0),
                        new KeyValue(left_curve.translateYProperty(), 0),
                        new KeyValue(right_curve.translateXProperty(), 0),
                        new KeyValue(right_curve.translateYProperty(), 0)));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        createJSONButton.setGraphic(createIconIV);
        createJSONButton.setGraphicTextGap(10);
        if (nunitoMedium != null)
            createJSONButton.setFont(nunitoMedium);
        createJSONButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createJSONButton.setTextFill(Color.WHITE);
                createIcon = new Image("Main/Icons/createFileWhiteIcon.png");
                createJSONButton.setStyle(
                        "-fx-background-color: #1f8fe8;-fx-font-weight: 900; -fx-font-size: 16; -fx-border-color: #1f8fe8; -fx-border-width: 2px; -fx-border-radius: 5;");
                createIconIV.setImage(createIcon);
                createJSONButton.getScene().setCursor(Cursor.HAND);
            }
        });

        createJSONButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createIcon = new Image("Main/Icons/create.png");
                createIconIV.setImage(createIcon);
                createJSONButton.setBackground(Background.fill(Color.WHITE));
                createJSONButton.getScene().setCursor(Cursor.DEFAULT);
                createJSONButton.setStyle(
                        "-fx-background-color: white; -fx-font-weight: 900; -fx-border-color: #1f8fe8; -fx-border-width: 2px; -fx-border-radius: 5; -fx-text-fill: #1f8fe8;  -fx-font-size: 16;");
            }
        });
        createJSONButton.setStyle(
                "-fx-background-color: white; -fx-font-weight: bold; -fx-border-color: #1f8fe8; -fx-border-width: 2px; -fx-border-radius: 5; -fx-text-fill: #1f8fe8;  -fx-font-size: 16;");

        closeJSONButton.setStyle(
                "-fx-background-color: #576c77;-fx-font-weight: 900; -fx-font-size: 16; -fx-border-radius: 5;");
        closeJSONButton.setOnMouseEntered(e -> {
            closeJSONButton.setStyle(
                    "-fx-background-color: rgb(48,59,65);-fx-font-weight: 900; -fx-font-size: 16; -fx-border-radius: 5;");
            closeJSONButton.setCursor(Cursor.HAND);
        });

        closeJSONButton.setOnMouseExited(e -> {
            closeJSONButton.setStyle(
                    "-fx-background-color: #576c77;-fx-font-weight: 900; -fx-font-size: 16; -fx-border-radius: 5;");
            closeJSONButton.setCursor(Cursor.DEFAULT);
        });

        List<Button> remove_and_edit_btns = Arrays.asList(
                defaultform_remove_btn,remove_form_btn,edit_form_btn,moves_remove_btn,remove_levelUpMove_btn,
                remove_abiltites_btn, remove_hiddenabiltites_btn,remove_tag_btn, remove_location_spawn_btn,
                removeBlock_btn, remove_gender_btn, remove_genderproperty_btn, remove_evolution_btn,
                edit_evolution_btn, edit_genderProperty_btn, remove_object_btn
        );

        remove_and_edit_btns.forEach(btn->{
            btn.setOnMouseEntered(e->{
                btn.setCursor(Cursor.HAND);
            });
            btn.setOnMouseExited(e->{
                btn.setCursor(Cursor.DEFAULT);
            });
        });


        List<Button> blue_btns = Arrays.asList(openJSONButton, title_next_btn, defaultform_next_btn,
                defaultform_add_btn, forms_next_btn, moves_next_btn,
                abilities_next_btn, movement_next_btn, aggression_next_btn, battlestats_next_btn,
                tags_next_btn, spawn_next_btn, possible_next_btn, genderproperties_next_btn,
                otherobject_next_btn, finish_Json_btn, add_form_btn, evolutions_next_btn, add_attack_moves_btn,
                add_levelUpMove_btn, moves_add_btn, add_ability_btn,
                add_hiddenability_btn, add_tag_btn, add_location_spawn_btn, add_gender_btn,
                add_palette_btn, add_gender_property_btn, add_object_btn, add_evolution_btn,
                load_saved_btn, export_file_btn);
        blue_btns.forEach(btn -> {
            if (nunitoMedium != null)
                btn.setFont(nunitoMedium);
            btn.setStyle("-fx-background-color: #1f8fe8; -fx-font-weight: 900; -fx-font-size: 16;");
            btn.setOnMouseEntered(e -> onMouseEntered(btn));
            btn.setOnMouseExited(e -> onMouseExited(btn));
        });

        openJSONButton.setGraphic(openIconIV);
        openJSONButton.setGraphicTextGap(10);
        tab_pane.setVisible(false);
        tab_pane.getTabs().forEach(tab -> {
            tab.setStyle("-fx-font-size: 16px; -fx-font-family: Nunito Medium;");
        });
        tab_pane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observableValue, Tab oldTab, Tab newTab) {
                oldTab.setStyle("-fx-font-weight: 400;-fx-font-size: 16px;");
                newTab.setStyle("-fx-font-weight: 900;-fx-font-size: 16px;");
            }
        });

        createJSONButton.setOnAction(e -> {
            viewTabPane();
            tabs = tab_pane.getTabs();
            tabs.forEach(tab -> {
                tab.setDisable(true);
            });
            Tab firstTab = tabs.get(0);
            if (firstTab.getId().equals("title_tab"))
                firstTab.setDisable(false);

            createJSONButton.setDisable(true);
            openJSONButton.setDisable(true);
            finish_Json_btn.setDisable(true);
            closeJSONButton.setDisable(false);
            closeJSONButton.setVisible(true);

            // sets the createFile variable true
            model.openFile = false;
        });

        openJSONButton.setOnAction(e -> {

            FileChooser file_chooser = new FileChooser();
            file_chooser.setTitle("Open File");
            file_chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
            File file_path = file_chooser.showOpenDialog(null);
            // File file_path = new File("D:\\species\\species\\868_milcery.json");
            // File file_path = new File("D:\\species\\species\\099_kingler.json");
            // D:\species\species\848_toxel.json
            // D:\species\species\004_charmander.json
            // D:\\species\\species\\099_kingler.json
            // System.out.println(file_path);

            try {
                if (file_path == null)
                    throw new MessageException("Invalid File Path, try again!");
                JsonNode jsonNode = Json.parse(file_path);
                model.data = Json.formJson(jsonNode, PrototypeJSON.class);
                name_textField.setText(model.data.getName());
                dex_textfield.setText(String.valueOf(model.data.getDex()));
                viewTabPane();
                tabs = tab_pane.getTabs();
                tabs.forEach(tab -> {
                    tab.setDisable(true);
                });
                Tab firstTab = tabs.get(0);
                if (firstTab.getId().equals("title_tab"))
                    firstTab.setDisable(false);
                openJSONButton.setDisable(true);
                createJSONButton.setDisable(true);
                closeJSONButton.setDisable(false);
                closeJSONButton.setVisible(true);
                model.openFile = true;
            } catch (JsonParseException parseException) {
                showMessage("Wrong Pattern Json File!!", bombIcon, Alert.AlertType.ERROR).show();
            } catch (IOException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            } catch (MessageException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }

        });

        title_next_btn.setOnAction(e -> {
            if (model.openFile) {
                if (model.data == null)
                    return;
                model.data.getDefaultForms().forEach(defaultForms_list.getItems()::add);
            }

            String name = name_textField.getText();
            Integer dex = getIntegerFromField(dex_textfield);
            model.data.setName(name);
            model.data.setDex(dex);

        });

        // --------------------------------------------------------------------------------------------------------------------
        // Handles code that only accepts number in textfields
        List<TextField> items = Arrays.asList(dex_textfield,
                length_forms_textfield, level_moves_textfield, timid_aggression_textfield,
                passive_aggression_textfield, aggressive_aggression_textfield,
                hp_battlestats_textfield, attack_battlestats_textfield, defense_battlestats_textfield,
                special_attack_battlestats_textfield,
                special_defense_battlestats_textfield, speed_battlestats_textfield, baseExp_spawn_textfield,
                baseFriendship_spawn_textfield,
                spawn_level_spawn_textfield, spawn_level_range_spawn_textfield, eggCycles_textfield,
                catchRate_textfield, generation_textfield, hp_evolution_textfield, attack_evolution_textfield,
                defense_evolution_textfield,
                specialAttack_evolution_textfield, specialDefense_evolution_textfield, speed_evolution_textfield);

        List<TextField> decimalTextfields = Arrays.asList(height_forms_textfield, width__forms_textfield,
                eyeheight_forms_textfield,
                hover_height_forms_textfield, weight_textfield, malePercentage_textfield, chanceToSopOnBlockTF);

        items.forEach(UIController::integerOnlyFields);
        decimalTextfields.forEach(UIController::decimal_and_neg_Numbers_Fields);
        // --------------------------------------------------------------------------------------------------------------------

        // --------------------------------------------------------------------------------------------------------------------

        // Saving Title Tab Data
        title_next_btn.setOnAction(e -> {
            try {
                String name = name_textField.getText();
                Integer dex = getIntegerFromField(dex_textfield);
                model.data.setName(name);
                model.data.setDex(dex);

                clearTitleFields();

                if (model.openFile && model.data.getDefaultForms() != null) {
                    model.data.getDefaultForms().forEach(defaultForms_list.getItems()::add);
                }
                shiftTabs(tab_pane);

            } catch (NumberFormatException nfe) {
                dex_textfield.clear();
                name_textField.clear();
                UIController.showMessage("Invalid Number in Dex Field, Try Again!!",fireCrackerIcon, Alert.AlertType.INFORMATION).show();

            }
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// DEFAULT FORM
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        defaultform_add_btn.setOnAction(e -> {
            String text = defaultforms_textfield.getText();
            if (text.isEmpty())
                return;
            defaultForms_list.getItems().add(text);
            defaultforms_textfield.clear();

        });

        defaultform_remove_btn.setOnAction(e -> {
            int index = defaultForms_list.getSelectionModel().getSelectedIndex();
            if (index == -1)
                return;
            defaultForms_list.getItems().remove(index);
        });

        defaultform_next_btn.setOnAction(e -> {

            if (!defaultForms_list.getItems().isEmpty()) {
                model.data.setDefaultForms(new ArrayList<>(defaultForms_list.getItems()));
            }
            clearDefaultFormFields();
            if (model.openFile) {
                model.data.getForms().forEach(form -> forms_list.getItems().add(form.toString()));
                edit_form_btn.setVisible(true);
                generation_textfield.setText(String.valueOf(model.data.getGeneration()));
            }
            shiftTabs(tab_pane);
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Preview Forms
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        add_form_btn.setOnAction(e -> {
            model.initializeForm();
            shiftTabs(tab_pane);
        });

        edit_form_btn.setOnAction(e -> {
            int index = forms_list.getSelectionModel().getSelectedIndex();
            if (index == -1)
                return;
            model.newForm = model.data.getForms().get(index);
            model.isEditing = true;
            model.indexOfEditingForm = index;

            if (model.getNewForm().getName() != null)
                name_forms_textfield.setText(model.getNewForm().getName());
            if (model.getNewForm().getExperienceGroup() != null)
                experience_group_forms_textfield.setText(model.getNewForm().getExperienceGroup());
            if (model.getNewForm().getDimensions() != null) {
                if (model.getNewForm().getDimensions().getHeight() != null)
                    height_forms_textfield.setText(model.getNewForm().getDimensions().getHeight().toString());
                if (model.getNewForm().getDimensions().getWidth() != null)
                    width__forms_textfield.setText(String.valueOf(model.getNewForm().getDimensions().getWidth()));
                if (model.getNewForm().getDimensions().getLength() != null)
                    length_forms_textfield.setText(String.valueOf(model.getNewForm().getDimensions().getLength()));
                if (model.getNewForm().getDimensions().getEyeHeight() != null)
                    eyeheight_forms_textfield
                            .setText(String.valueOf(model.getNewForm().getDimensions().getEyeHeight()));
                if (model.getNewForm().getDimensions().getHoverHeight() != null)
                    hover_height_forms_textfield
                            .setText(String.valueOf(model.getNewForm().getDimensions().getHoverHeight()));
            }
            shiftTabs(tab_pane);
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Forms
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------
        forms_next_btn.setOnAction(e -> {
            try {
                String form_name = name_forms_textfield.getText();
                String form_experience_group = experience_group_forms_textfield.getText();
                Double height = getDoubleFromTextField(height_forms_textfield);
                Double width = getDoubleFromTextField(width__forms_textfield);
                Integer length = getIntegerFromTextField(length_forms_textfield);
                Double eyeHeight = getDoubleFromTextField(eyeheight_forms_textfield);
                Double hoverHeight = getDoubleFromTextField(hover_height_forms_textfield);
                model.getNewForm().setName(form_name);
                model.getNewForm().setExperienceGroup(form_experience_group);
                if (height != null && width != null && length != null && eyeHeight != null && hoverHeight != null) {
                    model.getNewForm().setDimensions(new Dimensions());
                    model.getNewForm().getDimensions().setHeight(height);
                    model.getNewForm().getDimensions().setWidth(width);
                    model.getNewForm().getDimensions().setLength(length);
                    model.getNewForm().getDimensions().setEyeHeight(eyeHeight);
                    model.getNewForm().getDimensions().setHoverHeight(hoverHeight);
                } else {
                    model.getNewForm().setDimensions(null);
                }
                if (model.openFile && model.isEditing) {
                    // Loading Levelupmoves in moves tab
                    if (model.getNewForm().getMoves() != null
                            && model.getNewForm().getMoves().getLevelUpMoves() != null)
                        model.getNewForm().getMoves().getLevelUpMoves()
                                .forEach(move -> moves_list.getItems().add(move.toString()));
                }
                //

                shiftTabs(tab_pane);
                clearFormFields();
            } catch (NumberFormatException nfe) {
                showMessage("Something is wrong with dimensions!!", bombIcon, Alert.AlertType.ERROR).show();
                clearFormFields();
            }
        });

        // --------------------------------------------------------------------------------------------------------
        // ==================================///////
        // Moves////////=======================================
        // --------------------------------------------------------------------------------------------------------

        moves_combobox.setEditable(false);
        ObservableList<String> moves_list_box = FXCollections.observableArrayList("levelUpMoves",
                "tutorMoves", "eggMoves", "tmMoves8", "trMoves", "hmMoves", "transferMoves", "tmMoves7", "tmMoves6",
                "tmMoves5", "tmMoves4", "tmMoves3", "tmMoves2", "tmMoves1", "tmMoves");
        moves_combobox.setItems(moves_list_box);
        moves_combobox.getSelectionModel().selectedItemProperty().addListener((observableValue, old, newSelection) -> {
            if (newSelection.equals("levelUpMoves")) {
                moves_list.getItems().clear();
                levelUpMove_pane.setVisible(true);
                otherMoves_pane.setVisible(false);
                if (model.getNewForm() == null)
                    return;
                if (model.getNewForm().getMoves() != null)
                    model.getNewForm().getMoves().getLevelUpMoves().forEach(level_up_move -> {
                        moves_list.getItems().add(level_up_move.toString());
                    });
            } else {
                moves_list.getItems().clear();
                levelUpMove_pane.setVisible(false);
                otherMoves_pane.setVisible(true);
                if (model.getNewForm() == null)
                    return;
                if (model.getNewForm().getMoves() != null)
                    model.getNewForm().getMoves().getMoves(newSelection).forEach(move -> {
                        moves_list.getItems().add(move);
                    });
            }

        });
        moves_combobox.getSelectionModel().selectFirst();

        // Add Attack Btn
        add_attack_moves_btn.setOnAction(e -> {
            String attack = attack_moves_textfield.getText();
            if (attack.isEmpty())
                return;
            attack_moves_list.getItems().add(attack);
            attack_moves_textfield.clear();
        });
        // Remove Attack Btn
        remove_attack_moves_btn.setOnAction(e -> {
            attack_moves_list.getItems().remove(attack_moves_list.getSelectionModel().getSelectedItem());
            attack_moves_list.getSelectionModel().clearSelection();
        });

        // Add Level Up Move Btn
        add_levelUpMove_btn.setOnAction(e -> {
            try {
                if (model.getNewForm().getMoves() == null)
                    model.getNewForm().setMoves(new Moves());
                int level = Integer.parseInt(level_moves_textfield.getText());
                ArrayList<String> attacks = new ArrayList<>(attack_moves_list.getItems());
                LevelUpMove newlevelUpmove = new LevelUpMove();
                newlevelUpmove.setLevel(level);
                newlevelUpmove.setAttacks(attacks);
                model.getNewForm().getMoves().getLevelUpMoves().add(newlevelUpmove);
                moves_list.getItems().add(newlevelUpmove.toString());
                level_moves_textfield.clear();
                attack_moves_textfield.clear();
                attack_moves_list.getItems().clear();

            } catch (NumberFormatException npe) {
                showMessage("Something wrong in the LevelUP Move panel", bombIcon, Alert.AlertType.ERROR).show();

            }
        });

        // Add Level Up Move Btn
        remove_levelUpMove_btn.setOnAction(e -> {
            String selectedItem = moves_list.getSelectionModel().getSelectedItem();
            if (selectedItem.isEmpty())
                return;
            moves_list.getItems().remove(selectedItem);
            if (model.getNewForm().getMoves() != null)
                model.getNewForm().getMoves().getLevelUpMoves().remove(model.levelUpMoveParser(selectedItem));
            moves_list.getSelectionModel().clearSelection();
        });

        // Add Moves Btn
        moves_add_btn.setOnAction(e -> {
            String text = moves_textfield.getText();
            if (text.isEmpty())
                return;
            moves_list.getItems().add(text);
            if (model.getNewForm().getMoves() == null)
                model.getNewForm().setMoves(new Moves());
            model.getNewForm().getMoves().getMoves(moves_combobox.getSelectionModel().getSelectedItem()).add(text);
            moves_textfield.clear();
        });

        // Remove Moves Btn
        moves_remove_btn.setOnAction(e -> {
            String selectedItem = moves_list.getSelectionModel().getSelectedItem();
            if (selectedItem.isEmpty())
                return;
            moves_list.getItems().remove(selectedItem);
            if (model.getNewForm().getMoves() != null)
                model.getNewForm().getMoves().getMoves(moves_combobox.getSelectionModel().getSelectedItem())
                        .remove(selectedItem);
            moves_list.getSelectionModel().clearSelection();
        });

        moves_next_btn.setOnAction(e -> {
            if (model.openFile && model.isEditing) {
                if (model.getNewForm().getAbilities() != null) {
                    model.getNewForm().getAbilities().getAbilities().forEach(abilities_list.getItems()::add);
                    model.getNewForm().getAbilities().getHiddenAbilities().forEach(hidden_ability_list.getItems()::add);
                }
            }
            shiftTabs(tab_pane);
            clearMoveFields();

        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Abilities
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------
        abilities_next_btn.setOnAction(e -> {
            if (model.openFile && model.isEditing) {
                if (model.getNewForm().getMovement() != null) {
                    rideable.setSelected(model.newForm.getMovement().isRideable());
                    can_fly.setSelected(model.newForm.getMovement().isCanFly());
                    can_surf.setSelected(model.newForm.getMovement().isCanSurf());
                    can_ride_shoulder.setSelected(model.newForm.getMovement().isCanRideShoulder());
                    if (model.getNewForm().getMovement().getRidingOffSets() != null) {
                        standingXTF.setText(
                                String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getStanding()
                                        .getX()));
                        standingYTF.setText(
                                String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getStanding()
                                        .getY()));
                        standingZTF.setText(
                                String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getStanding()
                                        .getZ()));
                        movingXTF.setText(String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getMoving()
                                .getX()));
                        movingYTF.setText(String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getMoving()
                                .getX()));
                        movingZTF.setText(String.valueOf(model.getNewForm().getMovement().getRidingOffSets().getMoving()
                                .getX()));

                    }
                    if (model.getNewForm().getMovement().getFlyingParameters() != null) {
                        flyHeightMinTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlyHeightMin()));
                        flyHeightMaxTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlyHeightMax()));
                        flyRefreshRateYTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlyRefreshRateY()));
                        flyRefreshRateXZTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlyRefreshRateXZ()));
                        flyRefreshRateSpeedTF.setText(String.valueOf(
                                model.getNewForm().getMovement().getFlyingParameters().getFlyRefreshRateSpeed()));
                        flightTimeMinTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlightTimeMin()));
                        flightTimeMaxTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlightTimeMax()));
                        flapRateTF.setText(
                                String.valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlapRate()));
                        flySpeedModifierTF.setText(String
                                .valueOf(model.getNewForm().getMovement().getFlyingParameters().getFlySpeedModifier()));
                        if (model.getNewForm().getMovement().getFlyingParameters().getLandingMaterials() != null)
                            landing_material_combo_box.getEditor().setText(
                                    model.getNewForm().getMovement().getFlyingParameters().getLandingMaterials());
                    }

                    if (model.getNewForm().getMovement().getMountedFlyingParameters() != null) {
                        MountedFlyingParameters mountedFlyingParameters = model.getNewForm().getMovement()
                                .getMountedFlyingParameters();
                        type_mounted_TF.setText(mountedFlyingParameters.getType());
                        upper_angle_limit_TF.setText(String.valueOf(mountedFlyingParameters.getUpper_angle_limit()));
                        lower_angle_limit_TF.setText(String.valueOf(mountedFlyingParameters.getLower_angle_limit()));
                        max_fly_speed_TF.setText(String.valueOf(mountedFlyingParameters.getMax_fly_speed()));
                        strafe_roll_conversion_TF
                                .setText(String.valueOf(mountedFlyingParameters.getStrafe_roll_conversion()));
                        turn_rate_TF.setText(String.valueOf(mountedFlyingParameters.getTurn_rate()));
                        pitch_rate_TF.setText(String.valueOf(mountedFlyingParameters.getPitch_rate()));
                        continuous_forward_motion_TF
                                .setText(String.valueOf(mountedFlyingParameters.getContinuous_forward_motion_ticks()));
                        flying_stamina_charges_TF
                                .setText(String.valueOf(mountedFlyingParameters.getFlying_stamina_charges()));
                        hover_ticks_TF.setText(String.valueOf(mountedFlyingParameters.getHover_ticks()));
                        deceleration_rate_TF.setText(String.valueOf(mountedFlyingParameters.getDeceleration_rate()));
                        hover_deceleration_rate_TF
                                .setText(String.valueOf(mountedFlyingParameters.getHover_deceleration_rate()));
                        acceleration_rate_TF.setText(String.valueOf(mountedFlyingParameters.getAcceleration_rate()));
                        strafe_acceleration_rate
                                .setText(String.valueOf(mountedFlyingParameters.getStrafe_acceleration_rate()));
                        gravity_drop_per_tick_TF
                                .setText(String.valueOf(mountedFlyingParameters.getGravity_drop_per_tick()));
                        stays_horizontal_flying_checkbox
                                .setSelected(mountedFlyingParameters.isStays_horizontal_flying());
                        continuous_forward_motion_checkbox
                                .setSelected(mountedFlyingParameters.isContinuous_forward_motion());
                    }

                    if (model.getNewForm().getMovement().getSwimmingParameters() != null) {
                        SwimmingParameters swimmingParameters = model.getNewForm().getMovement()
                                .getSwimmingParameters();
                        depthRangeStartTF.setText(String.valueOf(swimmingParameters.getDepthRangeStart()));
                        depthRangeEndTF.setText(String.valueOf(swimmingParameters.getDepthRangeEnd()));
                        refreshRateTF.setText(String.valueOf(swimmingParameters.getRefreshRate()));
                        swimSpeedTF.setText(String.valueOf(swimmingParameters.getSwimSpeed()));
                        decayRateTF.setText(String.valueOf(swimmingParameters.getDecayRate()));
                        if (swimmingParameters.getBlockParameter() != null
                                && swimmingParameters.isHasBlockParameter()) {
                            addBlockPart_checkBox.setSelected(true);
                            chanceToSopOnBlockTF.setText(
                                    String.valueOf(swimmingParameters.getBlockParameter().getChanceToStopOnBlock()));
                            minStopTimeTF.setText(
                                    String.valueOf(swimmingParameters.getBlockParameter().getChanceToStopOnBlock()));
                            maxStopTimeTF.setText(
                                    String.valueOf(swimmingParameters.getBlockParameter().getChanceToStopOnBlock()));
                            minStopCooldownTimeTF.setText(
                                    String.valueOf(swimmingParameters.getBlockParameter().getChanceToStopOnBlock()));
                            maxStopCooldownTimeTF.setText(
                                    String.valueOf(swimmingParameters.getBlockParameter().getChanceToStopOnBlock()));
                            block_list.getItems().setAll(swimmingParameters.getBlockParameter().getBlocksToStopOn());
                            addCanRotateWhileStopped_CheckBox.setSelected(swimmingParameters.isCanRotateParameter());
                            if (swimmingParameters.isCanRotateParameter()) {
                                canRotateWhileStoppedCheckBox
                                        .setSelected(swimmingParameters.getBlockParameter().getCanRotateWhileStopped());
                            }
                        }
                    }

                }
            }
            shiftTabs(tab_pane);
            clearAbilitiesFields();
        });

        add_ability_btn.setOnAction(e -> {
            if (model.getNewForm().getAbilities() == null)
                model.getNewForm().setAbilities(new Abilities());
            addIntoList(abilities_textfield, abilities_list,
                    model.getNewForm().getAbilities().getAbilities());
        });
        add_hiddenability_btn.setOnAction(e -> {
            if (model.getNewForm().getAbilities() == null)
                model.getNewForm().setAbilities(new Abilities());
            addIntoList(hidden_ability_textfield, hidden_ability_list,
                    model.getNewForm().getAbilities().getHiddenAbilities());
        });
        remove_abiltites_btn
                .setOnAction(e -> {
                    if (model.getNewForm().getAbilities() == null)
                        model.getNewForm().setAbilities(new Abilities());
                    removeFromList(abilities_list, model.getNewForm().getAbilities().getAbilities());
                });
        remove_hiddenabiltites_btn.setOnAction(
                e -> {
                    if (model.getNewForm().getAbilities() == null)
                        model.getNewForm().setAbilities(new Abilities());
                    removeFromList(hidden_ability_list, model.getNewForm().getAbilities().getHiddenAbilities());
                });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Movement
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        addBlockPart_checkBox.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            block_pane.setVisible(newValue);
        });

        ArrayList<TextField> decimalPointFields = new ArrayList<>(
                Arrays.asList(movingXTF, movingYTF, movingZTF, standingXTF, standingYTF, standingZTF,
                        flySpeedModifierTF, deceleration_rate_TF, hover_deceleration_rate_TF, strafe_acceleration_rate,
                        gravity_drop_per_tick_TF, swimSpeedTF, decayRateTF, chanceToSopOnBlockTF));
        ArrayList<TextField> integerFields = new ArrayList<>(
                Arrays.asList(flyHeightMinTF, flyHeightMaxTF, flyRefreshRateYTF, flyRefreshRateXZTF,
                        flyRefreshRateSpeedTF, flightTimeMinTF, flightTimeMaxTF, flapRateTF, upper_angle_limit_TF,
                        lower_angle_limit_TF, max_fly_speed_TF,
                        strafe_roll_conversion_TF, turn_rate_TF, pitch_rate_TF, continuous_forward_motion_TF,
                        flying_stamina_charges_TF, hover_ticks_TF,
                        depthRangeStartTF, depthRangeEndTF, minStopTimeTF, maxStopTimeTF, minStopCooldownTimeTF,
                        maxStopCooldownTimeTF));

        decimalPointFields.forEach(UIController::decimal_and_neg_Numbers_Fields);
        integerFields.forEach(UIController::integerOnlyFields);

        addCanRotateWhileStopped_CheckBox.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            canRotateWhileStopped_Label.setVisible(newValue);
            canRotateWhileStoppedCheckBox.setVisible(newValue);
        });

        blocksToStopOn_combo_box.setEditable(true);
        blocksToStopOn_combo_box.getEditor().textProperty().addListener((changeListener, oldValue, newValue) -> {
            ArrayList<BlockTypes> blocks = new ArrayList<>(allBlocks.stream().filter(s -> {
                return s.name().contains(newValue.toUpperCase());
            }).toList());
            if (blocks.isEmpty())
                return;
            blocksToStopOn_combo_box.show();
            blocksToStopOn_combo_box.setItems(FXCollections.observableArrayList(blocks));
        });

        addBlock_btn.setOnAction(e -> {
            String currBlock = blocksToStopOn_combo_box.getEditor().getText();
            if (currBlock.equals("blocksToStopOn") || currBlock.isBlank())
                return;
            block_list.getItems().add("minecraft:" + currBlock.toUpperCase());
            blocksToStopOn_combo_box.getEditor().clear();
            blocksToStopOn_combo_box.hide();
        });

        removeBlock_btn.setOnAction(e -> {
            int index = block_list.getSelectionModel().getSelectedIndex();
            if (index == -1)
                return;
            block_list.getItems().remove(index);
        });

        addCanRotateWhileStopped_CheckBox.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            canRotateWhileStoppedCheckBox.setVisible(newValue);
        });

        movement_next_btn.setOnAction(e -> {
            RidingOffSets ridingOffSets = null;
            SwimmingParameters swimmingOffSets = null;
            FlyingParameters flyingOffSets = null;
            MountedFlyingParameters mountedOffSets = null;
            try {
                if (rideable.isSelected()) {
                    try {
                        ridingOffSets = new RidingOffSets(
                                new Moving(Double.parseDouble(movingXTF.getText()),
                                        Double.parseDouble(movingYTF.getText()),
                                        Double.parseDouble(movingZTF.getText())),
                                new Standing(Double.parseDouble(standingXTF.getText()),
                                        Double.parseDouble(standingYTF.getText()),
                                        Double.parseDouble(standingZTF.getText())));
                    } catch (NumberFormatException nfe) {
                        showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
                    }
                }

                if (can_surf.isSelected()) {

                    swimmingOffSets = new SwimmingParameters(
                            Integer.parseInt(String.valueOf(depthRangeStartTF.getText())),
                            Integer.parseInt(String.valueOf(depthRangeEndTF.getText())),
                            Integer.parseInt(String.valueOf(refreshRateTF.getText())),
                            Double.parseDouble(String.valueOf(swimSpeedTF.getText())),
                            Double.parseDouble(String.valueOf(decayRateTF.getText())));

                    swimmingOffSets.setHasBlockParameter(addBlockPart_checkBox.isSelected());
                    if (addBlockPart_checkBox.isSelected()) {
                        BlockParameter blockParameter;
                        Double chanceToStopOnBlock = getDoubleFromField(chanceToSopOnBlockTF);
                        ArrayList<String> blocksToStopOn = new ArrayList<>(block_list.getItems());
                        Integer minStopTime = getIntegerFromField(minStopTimeTF);
                        Integer maxStopTime = getIntegerFromField(maxStopTimeTF);
                        Integer minStopCooldownTime = getIntegerFromField(minStopCooldownTimeTF);
                        Integer maxStopCooldownTime = getIntegerFromField(maxStopCooldownTimeTF);
                        Boolean canRotateWhileStopped = (addCanRotateWhileStopped_CheckBox.isSelected())
                                ? canRotateWhileStoppedCheckBox.isSelected()
                                : null;

                        swimmingOffSets.setCanRotateParameter(addCanRotateWhileStopped_CheckBox.isSelected());

                        blockParameter = new BlockParameter(chanceToStopOnBlock, blocksToStopOn, minStopTime,
                                maxStopTime, minStopCooldownTime, maxStopCooldownTime,
                                canRotateWhileStopped);
                        if (swimmingOffSets != null) {
                            swimmingOffSets.setBlockParameter(blockParameter);
                        }

                    }

                }

                if (can_fly.isSelected()) {
                    flyingOffSets = new FlyingParameters(
                            Integer.parseInt(flyHeightMinTF.getText()),
                            Integer.parseInt(flyHeightMaxTF.getText()),
                            Integer.parseInt(flyRefreshRateYTF.getText()),
                            Integer.parseInt(flyRefreshRateXZTF.getText()),
                            Integer.parseInt(flyRefreshRateSpeedTF.getText()),
                            Integer.parseInt(flightTimeMinTF.getText()),
                            Integer.parseInt(flightTimeMaxTF.getText()),
                            Integer.parseInt(flapRateTF.getText()),
                            Double.parseDouble(flySpeedModifierTF.getText()),
                            landing_material_combo_box.getEditor().getText());
                }

                if (rideable.isSelected() && can_fly.isSelected()) {

                    mountedOffSets = new MountedFlyingParameters(
                            type_mounted_TF.getText(),
                            Integer.parseInt(upper_angle_limit_TF.getText()),
                            Integer.parseInt(lower_angle_limit_TF.getText()),
                            Integer.parseInt(max_fly_speed_TF.getText()),
                            Integer.parseInt(strafe_roll_conversion_TF.getText()),
                            Integer.parseInt(turn_rate_TF.getText()),
                            Integer.parseInt(pitch_rate_TF.getText()),
                            Integer.parseInt(continuous_forward_motion_TF.getText()),
                            Integer.parseInt(flying_stamina_charges_TF.getText()),
                            Integer.parseInt(hover_ticks_TF.getText()),
                            Double.parseDouble(deceleration_rate_TF.getText()),
                            Double.parseDouble(hover_deceleration_rate_TF.getText()),
                            Double.parseDouble(acceleration_rate_TF.getText()),
                            Double.parseDouble(strafe_acceleration_rate.getText()),
                            Double.parseDouble(gravity_drop_per_tick_TF.getText()),
                            stays_horizontal_flying_checkbox.isSelected(),
                            continuous_forward_motion_checkbox.isSelected());

                }

                if (model.getNewForm().getMovement() == null) {
                    Movement movement = new Movement(rideable.isSelected(), can_fly.isSelected(), can_surf.isSelected(),
                            can_ride_shoulder.isSelected(), ridingOffSets, flyingOffSets, swimmingOffSets,
                            mountedOffSets);
                    model.getNewForm().setMovement(movement);
                }

                if (model.openFile) {
                    timid_aggression_textfield.setText(String.valueOf(model.getNewForm().getAggression().getTimid()));
                    passive_aggression_textfield
                            .setText(String.valueOf(model.getNewForm().getAggression().getPassive()));
                    aggressive_aggression_textfield
                            .setText(String.valueOf(model.getNewForm().getAggression().getAggressive()));

                }
                shiftTabs(tab_pane);
                clearAllMovementField(integerFields, decimalPointFields);
            } catch (NumberFormatException nfe) {
                showMessage(nfe.getLocalizedMessage(), fireCrackerIcon, Alert.AlertType.WARNING).show();
            }
        });

        // Showing offSets when each checkbox is true. (mountedOffSets are true if both
        // isRideable and flying is true)
        rideable.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            ridingOffSets_parameters_pane.setVisible(newValue);
            mountedFlyingParameters_pane.setVisible(newValue && can_fly.isSelected());
        });
        can_surf.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            swimmingParameters_pane.setVisible(newValue);
        });
        can_fly.selectedProperty().addListener((changeListener, oldValue, newValue) -> {
            flyingParameters_pane.setVisible(newValue);
            mountedFlyingParameters_pane.setVisible(newValue && rideable.isSelected());
        });

        landing_material_combo_box.setItems(FXCollections.observableArrayList(LandingMaterials.GRASS,
                LandingMaterials.LEAVES, LandingMaterials.LEAVES_AND_GRASS, LandingMaterials.NONE));

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Aggression
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------
        aggression_next_btn.setOnAction(e -> {
            try {
                Integer timid = (timid_aggression_textfield.getText().isEmpty()
                        || timid_aggression_textfield.getText().isBlank()) ? null
                                : Integer.parseInt(timid_aggression_textfield.getText());
                Integer passive = (passive_aggression_textfield.getText().isEmpty()
                        || passive_aggression_textfield.getText().isBlank()) ? null
                                : Integer.parseInt(passive_aggression_textfield.getText());
                Integer aggressive = (aggressive_aggression_textfield.getText().isEmpty()
                        || aggressive_aggression_textfield.getText().isBlank()) ? null
                                : Integer.parseInt(aggressive_aggression_textfield.getText());
                if (timid == null && passive == null && aggressive == null) {
                    model.getNewForm().setAggression(null);
                } else {
                    if (model.getNewForm().getAggression() == null)
                        model.getNewForm().setAggression(new Aggression());
                    model.getNewForm().getAggression().setAll(timid, passive, aggressive);
                }

                if (model.openFile && model.isEditing && model.getNewForm().getBattleStats() != null) {
                    hp_battlestats_textfield.setText(String.valueOf(model.getNewForm().getBattleStats().getHp()));
                    attack_battlestats_textfield
                            .setText(String.valueOf(model.getNewForm().getBattleStats().getAttack()));
                    defense_battlestats_textfield
                            .setText(String.valueOf(model.getNewForm().getBattleStats().getDefense()));
                    special_attack_battlestats_textfield
                            .setText(String.valueOf(model.getNewForm().getBattleStats().getSpecialAttack()));
                    special_defense_battlestats_textfield
                            .setText(String.valueOf(model.getNewForm().getBattleStats().getSpecialDefense()));
                    speed_battlestats_textfield.setText(String.valueOf(model.getNewForm().getBattleStats().getSpeed()));
                }
                shiftTabs(tab_pane);
                clearAggressionFields();
            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
                clearAggressionFields();
            }

        });

        // ------------------------------------------------------------------------------------------------------
        // ==========================================/////// BattleStats
        // ////////================================
        // ------------------------------------------------------------------------------------------------------

        battlestats_next_btn.setOnAction(e -> {
            try {
                Integer hp = getIntegerFromField(hp_battlestats_textfield);
                Integer attack = getIntegerFromField(attack_battlestats_textfield);
                Integer defense = getIntegerFromField(defense_battlestats_textfield);
                Integer specialAttack = getIntegerFromField(special_attack_battlestats_textfield);
                Integer specialDefense = getIntegerFromField(special_defense_battlestats_textfield);
                Integer speed = getIntegerFromField(speed_battlestats_textfield);

                if (hp != null || attack != null || defense != null || specialAttack != null || specialDefense != null
                        || speed != null) {
                    if (model.getNewForm().getBattleStats() == null)
                        model.getNewForm().setBattleStats(new BattleStats());
                    model.getNewForm().getBattleStats().addAll(hp, attack, defense, specialAttack, specialDefense,
                            speed);
                }
                shiftTabs(tab_pane);
                clearBattleStats();
                if (model.openFile && model.isEditing && model.getNewForm().getTags() != null) {
                    model.getNewForm().getTags().forEach(tag_list.getItems()::add);
                }

            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
                clearBattleStats();
            }
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// tags
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        add_tag_btn.setOnAction(e -> {
            if (model.getNewForm().getTags() == null)
                model.getNewForm().setTags(new ArrayList<>());
            addIntoList(tag_textfield, tag_list, model.getNewForm().getTags());
        });
        remove_tag_btn.setOnAction(e -> {
            if (model.getNewForm().getTags() == null)
                return;
            removeFromList(tag_list, model.getNewForm().getTags());
        });
        tags_next_btn.setOnAction(e -> {

            if (tag_list.getItems().isEmpty())
                model.getNewForm().setTags(null);

            if (model.openFile && model.isEditing && model.getNewForm().getSpawn() != null) {
                baseExp_spawn_textfield.setText(String.valueOf(model.getNewForm().getSpawn().getBaseExp()));
                baseFriendship_spawn_textfield
                        .setText(String.valueOf(model.getNewForm().getSpawn().getBaseFriendship()));
                spawn_level_spawn_textfield.setText(String.valueOf(model.getNewForm().getSpawn().getSpawnLevel()));
                spawn_level_range_spawn_textfield
                        .setText(String.valueOf(model.getNewForm().getSpawn().getSpawnLevelRange()));
                model.getNewForm().getSpawn().getSpawnLocations().forEach(spawn_location_list.getItems()::add);
            }
            shiftTabs(tab_pane);
            clearTagFields();
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Spawn
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        add_location_spawn_btn.setOnAction(e -> {
            if (model.getNewForm().getSpawn() == null)
                model.getNewForm().setSpawn(new Spawn());
            addIntoList(spawn_location__spawn_textfield, spawn_location_list,
                    model.getNewForm().getSpawn().getSpawnLocations());
        });
        remove_location_spawn_btn.setOnAction(
                e -> {
                    if (model.getNewForm().getSpawn() == null)
                        return;
                    removeFromList(spawn_location_list, model.getNewForm().getSpawn().getSpawnLocations());
                });
        spawn_next_btn.setOnAction(e -> {
            try {
                Integer baseExp = getIntegerFromField(baseExp_spawn_textfield);
                Integer baseFriendship = getIntegerFromField(baseFriendship_spawn_textfield);
                Integer spawnLevel = getIntegerFromField(spawn_level_spawn_textfield);
                Integer spawnLevelRange = getIntegerFromField(spawn_level_range_spawn_textfield);
                if (baseExp != null || baseFriendship != null || spawnLevel != null || spawnLevelRange != null) {
                    if (model.getNewForm().getSpawn() == null)
                        model.getNewForm().setSpawn(new Spawn());
                    model.getNewForm().getSpawn().addAll(baseExp, baseFriendship, spawnLevel, spawnLevelRange);
                }

                if (model.openFile && model.getNewForm().getPossibleGenders() != null)
                    model.getNewForm().getPossibleGenders().forEach(gender_list.getItems()::add);

                clearSpawnLevelFields();
                shiftTabs(tab_pane);

            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
                clearSpawnLevelFields();
            }
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Possible Gender
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        gender_possibleGender_combobox.getItems().addAll(new ArrayList<>(Arrays.asList(
                "MALE", "FEMALE", "NONE")));

        add_gender_btn.setOnAction(e -> {
            if (model.getNewForm().getPossibleGenders() == null)
                model.getNewForm().setPossibleGenders(new ArrayList<>());
            addIntoList(gender_possibleGender_combobox.getEditor(), gender_list,
                    model.getNewForm().getPossibleGenders());
        });
        remove_gender_btn.setOnAction(e -> {
            if (model.getNewForm().getPossibleGenders() == null)
                return;
            removeFromList(gender_list, model.getNewForm().getPossibleGenders());
        });
        possible_next_btn.setOnAction(e -> {
            if (model.openFile && model.getNewForm().getGenderProperties() != null) {
                model.getNewForm().getGenderProperties()
                        .forEach(genderProperty -> genderProperties_list.getItems().add(genderProperty.toString()));
            }
            shiftTabs(tab_pane);
            clearPossibleGenderFields();
        });

        // --------------------------------------------------------------------------------------------------------------------
        // =================================/////// Gender Properties
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        genderProperties_list.getSelectionModel().selectedIndexProperty()
                .addListener((changeListener, oldValue, newValue) -> {
                    model.selectedGP = newValue.intValue();
                    if (newValue.intValue() == -1)
                        return;
                    genderproperties_gender_textfield
                            .setText(model.getNewForm().getGenderProperties().get(newValue.intValue()).getGender());
                });

        add_palette_btn.setOnAction(e -> {
            try {
                if (model.selectedGP != -1) {
                    paletteArrayList = paletteStage.display();
                    model.getNewForm().getGenderProperties().get(model.selectedGP)
                            .setPalettes(new ArrayList<>(paletteArrayList));
                    genderProperties_list.getSelectionModel().clearSelection();
                    paletteArrayList.clear();
                    model.selectedGP = -1;
                    genderproperties_gender_textfield.clear();
                } else {
                    paletteArrayList.clear();
                    paletteArrayList = paletteStage.display();
                }
            } catch (IOException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }
        });

        edit_genderProperty_btn.setOnAction(e -> {
            if (!model.openFile)
                return;
            int index = genderProperties_list.getSelectionModel().getSelectedIndex();
            if (index == -1)
                return;
            GenderProperty gp = model.getNewForm().getGenderProperties().get(index);
            genderproperties_gender_textfield.setText(gp.getGender());
            model.selectedGP = index;
            if (model.getNewForm().getGenderProperties().get(index).getGender() != null)
                genderproperties_gender_textfield
                        .setText(model.getNewForm().getGenderProperties().get(index).getGender());
            try {
                paletteArrayList = paletteStage.display();
                String gender = genderproperties_gender_textfield.getText();
                gp.setGender(gender);
                gp.setPalettes(new ArrayList<>(paletteArrayList.stream().toList()));
                model.getNewForm().getGenderProperties().set(index, gp);
                genderProperties_list.getItems().set(index, gp.toString());
                genderproperties_gender_textfield.clear();
                paletteArrayList.clear();
                genderProperties_list.getSelectionModel().clearSelection();
                model.selectedGP = -1;
            } catch (IOException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }
        });

        add_gender_property_btn.setOnAction(e -> {
            if (genderproperties_gender_textfield.getText().isEmpty() || paletteArrayList.isEmpty())
                return;
            String gender = genderproperties_gender_textfield.getText();
            GenderProperty gp = new GenderProperty();
            gp.setGender(gender);
            gp.setPalettes(new ArrayList<>(paletteArrayList));
            if (model.getNewForm().getGenderProperties() == null)
                model.getNewForm().setGenderProperties(new ArrayList<>());
            model.getNewForm().getGenderProperties().add(gp);
            genderProperties_list.getItems().add(gp.toString());

            genderproperties_gender_textfield.clear();
            paletteArrayList.clear();
        });

        remove_genderproperty_btn.setOnAction(e -> {
            if (model.getNewForm().getGenderProperties() == null)
                return;
            int selectedItem = genderProperties_list.getSelectionModel().getSelectedIndex();
            if (selectedItem == -1)
                return;
            genderProperties_list.getItems().remove(selectedItem);
            model.getNewForm().getGenderProperties().remove(selectedItem);
            genderProperties_list.getSelectionModel().clearSelection();
        });

        genderproperties_next_btn.setOnAction(e -> {
            if (model.openFile && model.isEditing) {
                if (model.getNewForm().getDefaultBaseForm() != null)
                    defaultBaseForm_textfield.setText(model.getNewForm().getDefaultBaseForm());
                if (model.getNewForm().getEggCycles() != null)
                    eggCycles_textfield.setText(String.valueOf(model.getNewForm().getEggCycles()));
                if (model.getNewForm().getWeight() != null)
                    weight_textfield.setText(String.valueOf(model.getNewForm().getWeight()));
                if (model.getNewForm().getCatchRate() != null)
                    catchRate_textfield.setText(String.valueOf(model.getNewForm().getCatchRate()));
                if (model.getNewForm().getMalePercentage() != null)
                    malePercentage_textfield.setText(String.valueOf(model.getNewForm().getMalePercentage()));
                if (model.getNewForm().getGigantamax() != null) {
                    canGiganTamax.setSelected(model.getNewForm().getGigantamax().isCanGigantamax());
                    canHaveFactor.setSelected(model.getNewForm().getGigantamax().isCanHaveFactor());
                }
                if (model.getNewForm().getEggGroups() != null)
                    model.getNewForm().getEggGroups().forEach(objects_listview.getItems()::add);
            }
            shiftTabs(tab_pane);

            clearGenderPropertiesFields();

        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Other Objects
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        other_objects_combobox.setEditable(false);
        ObservableList<String> other_object_names = FXCollections.observableArrayList("eggGroups", "types",
                "preEvolutions",
                "megaItems", "megas");
        other_objects_combobox.setItems(other_object_names);
        other_objects_combobox.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, old, newSelection) -> {
                    objects_listview.getItems().clear();
                    if (model.getNewForm() == null)
                        return;
                    if (model.getNewForm().getParticularObjects(newSelection) != null) {
                        model.getNewForm().getParticularObjects(newSelection).forEach(object -> {
                            objects_listview.getItems().add(object);
                        });
                    }
                });
        other_objects_combobox.getSelectionModel().selectFirst();

        add_object_btn.setOnAction(e -> {
            String currentSelection = other_objects_combobox.getSelectionModel().getSelectedItem();
            if (currentSelection.isEmpty())
                return;
            switch (currentSelection) {
                case ("eggGroups") -> {
                    if (model.getNewForm().getEggGroups() == null)
                        model.getNewForm().setEggGroups(new ArrayList<>());
                }
                case ("types") -> {
                    if (model.getNewForm().getTypes() == null)
                        model.getNewForm().setTypes(new ArrayList<>());
                }
                case ("preEvolutions") -> {
                    if (model.getNewForm().getPreEvolutions() == null)
                        model.getNewForm().setPreEvolutions(new ArrayList<>());
                }
                case ("megaItems") -> {
                    if (model.getNewForm().getMegaItems() == null)
                        model.getNewForm().setMegaItems(new ArrayList<>());
                }
                case ("megas") -> {
                    if (model.getNewForm().getMegas() == null)
                        model.getNewForm().setMegas(new ArrayList<>());
                }
            }
            addIntoList(objects_textfield, objects_listview, model.getNewForm().getParticularObjects(currentSelection));
            objects_textfield.clear();
        });

        remove_object_btn.setOnAction(e -> {
            String currentSelectionCombo = other_objects_combobox.getSelectionModel().getSelectedItem();
            String currentSelection = objects_listview.getSelectionModel().getSelectedItem();
            if (currentSelection.isEmpty() || currentSelectionCombo.isEmpty())
                return;
            if (model.getNewForm().getParticularObjects(currentSelectionCombo) == null)
                return;
            removeFromList(objects_listview, model.getNewForm().getParticularObjects(currentSelectionCombo));
        });

        otherobject_next_btn.setOnAction(e -> {
            String default_Base_Form = defaultBaseForm_textfield.getText();
            boolean can_have_factor = canHaveFactor.isSelected();
            boolean can_gigan_tamax = canGiganTamax.isSelected();
            String form = form_other_textfield.getText();
            String move = move_other_textfield.getText();
            try {
                Integer egg_cycles = getIntegerFromField(eggCycles_textfield);
                Double weight = getDoubleFromField(weight_textfield);
                Integer catch_rate = getIntegerFromField(catchRate_textfield);
                Double male_percentage = getDoubleFromField(malePercentage_textfield);
                Gigantamax _giganTamax = new Gigantamax(can_have_factor, can_gigan_tamax, form, move);

                if (default_Base_Form != null)
                    model.getNewForm().setDefaultBaseForm(default_Base_Form);
                model.getNewForm().setGigantamax(_giganTamax);
                if (egg_cycles != null)
                    model.getNewForm().setEggCycles(egg_cycles);
                if (weight != null)
                    model.getNewForm().setWeight(weight);
                if (catch_rate != null)
                    model.getNewForm().setCatchRate(catch_rate);
                if (male_percentage != null)
                    model.getNewForm().setMalePercentage(male_percentage);

                clearOtherObjectFields();

                if (model.openFile && model.isEditing) {
                    if (model.getNewForm().getEvolutions() != null) {
                        model.getNewForm().getEvolutions()
                                .forEach(_evolution -> evolution_list.getItems().add(_evolution.toString()));
                        evolutions_array.addAll(model.getNewForm().getEvolutions());
                        if (model.getNewForm().getEvYields() != null) {
                            speed_evolution_textfield
                                    .setText(getStringFromEvYields(model.getNewForm().getEvYields().getSpeed()));
                            hp_evolution_textfield
                                    .setText(getStringFromEvYields(model.getNewForm().getEvYields().getHp()));
                            attack_evolution_textfield
                                    .setText(getStringFromEvYields(model.getNewForm().getEvYields().getAttack()));
                            defense_evolution_textfield
                                    .setText(getStringFromEvYields(model.getNewForm().getEvYields().getDefense()));
                            specialAttack_evolution_textfield.setText(
                                    getStringFromEvYields(model.getNewForm().getEvYields().getSpecialAttack()));
                            specialDefense_evolution_textfield.setText(
                                    getStringFromEvYields(model.getNewForm().getEvYields().getSpecialDefense()));
                        }
                    }
                }

                shiftTabs(tab_pane);
            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }

        });

        // ---------------------------------------------------------------------------------------------------------
        // ======================================/////// Evolutions Objects
        // ////////===============================
        // ---------------------------------------------------------------------------------------------------------

        add_evolution_btn.setOnAction(e -> {
            Evolution evl = null;
            try {
                evl = Evolution.copyEvolution(evolutionStage.display());
                if (evl == null)
                    return;
                evolution_list.getItems().add(evl.toString());
                evolutions_array.add(evl);
            } catch (IOException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }

        });
        remove_evolution_btn.setOnAction(e -> {
            String selectedItem = evolution_list.getSelectionModel().getSelectedItem();
            if (selectedItem.isEmpty())
                return;
            int index = evolution_list.getItems().indexOf(selectedItem);
            evolution_list.getItems().remove(selectedItem);
            evolutions_array.remove(index);
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////

        edit_evolution_btn.setOnAction(e -> {
            if (model.getNewForm().getEvolutions() != null) {
                int selectedIndex = evolution_list.getSelectionModel().getSelectedIndex();
                if (selectedIndex == -1)
                    return;
                try {
                    model.indexOfSelectedEvolution = selectedIndex;

                    Evolution evl = Evolution.copyEvolution(evolutionStage.display());
                    if (evl == null)
                        return;
                    evolution_list.getItems().set(selectedIndex, evl.toString());
                    evolutions_array.set(selectedIndex, evl);
                    model.indexOfSelectedEvolution = -1;
                    evolution_list.getSelectionModel().clearSelection();
                } catch (IOException ex) {
                    showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////

        evolutions_next_btn.setOnAction(e -> {
            try {

                EvYields evy = new EvYields(parseEvYields(hp_evolution_textfield),
                        parseEvYields(attack_evolution_textfield),
                        parseEvYields(defense_evolution_textfield),
                        parseEvYields(specialAttack_evolution_textfield),
                        parseEvYields(specialDefense_evolution_textfield),
                        parseEvYields(speed_evolution_textfield));
                model.getNewForm().setEvolutions(new ArrayList<>(evolutions_array));
                model.getNewForm().setEvYields(evy);

                clearEvolutionFields();

                int currentTab = tab_pane.getTabs().indexOf(tab_pane.getSelectionModel().getSelectedItem());
                tab_pane.getTabs().get(currentTab).setDisable(true);
                tab_pane.getTabs().get(2).setDisable(false);
                tab_pane.getSelectionModel().select(2);
                finish_Json_btn.setDisable(false);

                if (model.openFile && model.isEditing) {
                    model.data.getForms().set(model.indexOfEditingForm, model.getNewForm());
                    forms_list.getItems().set(model.indexOfEditingForm, model.newForm.toString());
                }
                if (!model.openFile) {
                    model.data.getForms().add(model.getNewForm());
                    forms_list.getItems().add(model.newForm.toString());
                }
                generation_textfield.setText(String.valueOf(model.data.getGeneration()));

                model.newForm = null;
                model.isEditing = false;
                model.indexOfEditingForm = -1;
                model.indexOfSelectedEvolution = -1;

            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }
        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// PreForms Objects
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------

        remove_form_btn.setOnAction(e -> {
            String selectedItem = forms_list.getSelectionModel().getSelectedItem();
            if (selectedItem == null)
                return;
            int index = forms_list.getSelectionModel().getSelectedIndex();
            forms_list.getItems().remove(index);
            model.data.getForms().remove(index);
        });

        finish_Json_btn.setOnAction(e -> {

            try {
                int generation = Integer.parseInt(generation_textfield.getText());
                model.data.setGeneration(generation);
                forms_list.getItems().clear();
                generation_textfield.clear();

                int currentTab = tab_pane.getTabs().indexOf(tab_pane.getSelectionModel().getSelectedItem());
                tab_pane.getTabs().get(currentTab).setDisable(true);
                tab_pane.getSelectionModel().selectLast();
                Tab currentSelectedTab = tab_pane.getSelectionModel().getSelectedItem();
                currentSelectedTab.setDisable(false);
            } catch (NumberFormatException nfe) {
                showMessage(nfe.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }

        });

        // --------------------------------------------------------------------------------------------------------------------
        // ============================================/////// Final Stage Objects
        // ////////=======================================
        // --------------------------------------------------------------------------------------------------------------------
        load_saved_btn.setOnAction(e -> {
            JsonNode node = Json.toJson(model.data);
            try {
                final_textbox.setText(BeautifulJson.beautiful(Json.prettyPrint(node, false)));
            } catch (JsonProcessingException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }
        });

        export_file_btn.setOnAction(e -> {
            if (model.data == null)
                return;
            FileChooser file_chooser = new FileChooser();
            file_chooser.setTitle("Export File");
            file_chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
            File file_path = file_chooser.showSaveDialog(null);
            try {
                FileWriter fileWriter = new FileWriter(file_path);
                fileWriter.write(BeautifulJson.beautiful(Json.prettyPrint(Json.toJson(model.data), false)));
                fileWriter.close();
            } catch (IOException ex) {
                showMessage(ex.getMessage(), bombIcon, Alert.AlertType.ERROR).show();
            }

        });

        closeJSONButton.setOnAction(e -> {
            model.data = null;
            model.data = new PrototypeJSON();
            tab_pane.getTabs().forEach(tab -> tab.setDisable(true));
            tab_pane.getSelectionModel().select(0);
            clearTitleFields();
            clearDefaultFormFields();
            clearFormPreviewFields();
            clearFormFields();
            clearMoveFields();
            clearAbilitiesFields();
            clearAllMovementField(integerFields, decimalPointFields);
            clearAggressionFields();
            clearBattleStats();
            clearTagFields();
            clearSpawnLevelFields();
            clearPossibleGenderFields();
            clearGenderPropertiesFields();
            clearOtherObjectFields();
            clearEvolutionFields();
            final_textbox.clear();

            model.isEditing = false;
            model.indexOfSelectedEvolution = -1;
            model.indexOfEditingForm = -1;
            model.openFile = false;
            model.newForm = null;
            finish_Json_btn.setDisable(false);

            createJSONButton.setDisable(false);
            openJSONButton.setDisable(false);
            closeJSONButton.setDisable(true);
            closeJSONButton.setVisible(false);
            hideTabPane();

        });

    }

    private void viewTabPane() {
        timeline.pause();
        hbox_pane.getChildren().remove(animation_pane);
        hbox_pane.getChildren().add(tab_pane);
        tab_pane.setVisible(true);
    }

    private void hideTabPane() {
        hbox_pane.getChildren().remove(tab_pane);
        hbox_pane.getChildren().add(animation_pane);
        tab_pane.setVisible(false);
        timeline.play();

    }

    private void clearTitleFields() {
        name_textField.clear();
        dex_textfield.clear();
    }

    private void clearDefaultFormFields() {
        defaultForms_list.getItems().clear();
        defaultforms_textfield.clear();
    }

    private void clearEvolutionFields() {
        hp_evolution_textfield.clear();
        attack_evolution_textfield.clear();
        defense_evolution_textfield.clear();
        specialAttack_evolution_textfield.clear();
        specialDefense_evolution_textfield.clear();
        speed_battlestats_textfield.clear();
        evolution_list.getItems().clear();
        evolutions_array.clear();
        evolutionStage._evolution = null;
    }

    private void clearOtherObjectFields() {
        eggCycles_textfield.clear();
        weight_textfield.clear();
        catchRate_textfield.clear();
        malePercentage_textfield.clear();
        canGiganTamax.setSelected(false);
        canHaveFactor.setSelected(false);
        form_other_textfield.clear();
        move_other_textfield.clear();
        objects_textfield.clear();
        defaultBaseForm_textfield.clear();
        objects_listview.getItems().clear();
    }

    private void clearGenderPropertiesFields() {
        genderproperties_gender_textfield.clear();
        genderProperties_list.getItems().clear();
    }

    private void clearPossibleGenderFields() {
        gender_possibleGender_combobox.getEditor().clear();
        gender_list.getItems().clear();
    }

    private void clearSpawnLevelFields() {
        baseExp_spawn_textfield.clear();
        baseFriendship_spawn_textfield.clear();
        spawn_level_spawn_textfield.clear();
        spawn_level_range_spawn_textfield.clear();
        spawn_location__spawn_textfield.clear();
        spawn_location_list.getItems().clear();
    }

    private void clearTagFields() {
        tag_list.getItems().clear();
        tag_textfield.clear();
    }

    private void clearBattleStats() {
        hp_battlestats_textfield.clear();
        attack_battlestats_textfield.clear();
        defense_battlestats_textfield.clear();
        special_attack_battlestats_textfield.clear();
        special_defense_battlestats_textfield.clear();
        speed_battlestats_textfield.clear();
    }

    private void clearAggressionFields() {
        timid_aggression_textfield.clear();
        passive_aggression_textfield.clear();
        aggressive_aggression_textfield.clear();
    }

    private void clearAbilitiesFields() {
        abilities_textfield.clear();
        hidden_ability_textfield.clear();
        abilities_list.getItems().clear();
        hidden_ability_list.getItems().clear();
    }

    private void clearMoveFields() {
        moves_list.getItems().clear();
        attack_moves_list.getItems().clear();
        moves_textfield.clear();
        moves_combobox.getSelectionModel().selectFirst();
        level_moves_textfield.clear();
        attack_moves_textfield.clear();
    }

    private void clearFormFields() {
        name_forms_textfield.clear();
        experience_group_forms_textfield.clear();
        height_forms_textfield.clear();
        width__forms_textfield.clear();
        length_forms_textfield.clear();
        eyeheight_forms_textfield.clear();
        hover_height_forms_textfield.clear();
    }

    private Double getDoubleFromTextField(TextField textField) {
        return (textField.getText().isEmpty() || textField.getText().isBlank())
                ? null
                : Double.parseDouble(textField.getText());
    }

    private Integer getIntegerFromTextField(TextField textField) {
        return (textField.getText().isEmpty() || textField.getText().isBlank())
                ? null
                : (int) Double.parseDouble(textField.getText());
    }

    private Integer parseEvYields(TextField field) {
        return (field.getText().isBlank() ||
                field.getText().isEmpty()) ? null : Integer.parseInt(field.getText());
    }

    private static String getStringFromEvYields(Integer evYield) {
        return (evYield != null) ? String.valueOf(evYield) : "";
    }

    // Helping Methods

    private static void shiftTabs(TabPane tab_pane) {
        if (tab_pane == null)
            return;
        int currentTab = tab_pane.getTabs().indexOf(tab_pane.getSelectionModel().getSelectedItem());
        tab_pane.getSelectionModel().selectNext();
        tab_pane.getTabs().get(currentTab).setDisable(true);
        tab_pane.getTabs().get(++currentTab).setDisable(false);
    }

    // Handle cursor changing on buttons
    public static void onMouseEntered(Button btn) {

        // btn.setPrefWidth(btn.getWidth()-1);
        // btn.setPrefHeight(btn.getHeight()-1);
        btn.setTextFill(Color.WHITE);
        btn.getScene().setCursor(Cursor.HAND);
        btn.setStyle("-fx-background-color: #186fb4; -fx-font-weight: 900;");
        if (!btn.getText().isEmpty()) {
            if (nunitoMedium != null)
                btn.setFont(nunitoMedium);
            btn.setStyle("-fx-background-color: #186fb4; -fx-font-weight: 900;-fx-font-size: 16;");
        }

    }

    public static void onMouseExited(Button btn) {
        // btn.setPrefWidth(btn.getWidth()+1);
        // btn.setPrefHeight(btn.getHeight()+1);
        btn.getScene().setCursor(Cursor.DEFAULT);
        btn.setStyle("-fx-background-color: #1f8fe8; -fx-font-weight: 900;");
        if (!btn.getText().isEmpty()) {
            if (nunitoMedium != null)
                btn.setFont(nunitoMedium);
            btn.setStyle("-fx-background-color: #1f8fe8; -fx-font-weight: 900; -fx-font-size: 16;");
        }

    }

    public static void addIntoList(TextField textField, ListView<String> listView, ArrayList<String> data) {
        String text = textField.getText();
        if (text.isEmpty())
            return;
        listView.getItems().add(text);
        data.add(text);
        textField.clear();
    }

    public static void removeFromList(ListView<String> listView, ArrayList<String> data) {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem.isEmpty())
            return;
        listView.getItems().remove(selectedItem);
        data.remove(selectedItem);
        listView.getSelectionModel().clearSelection();
    }

    public static Alert showMessage(String message, Image image, Alert.AlertType alertType) {
        ImageView graphic = new ImageView(image);
        graphic.setFitWidth(35);
        graphic.setFitHeight(35);
        Alert alert = new Alert(alertType, message);
        alert.setGraphic(graphic);
        alert.setTitle(alertType.toString());
        return alert;
    }

    public static void integerOnlyFields(TextField text_field) {
        TextFormatter<Integer> textFormatter = new TextFormatter<>(
                new IntegerStringConverter(),
                null, // Default value
                change -> {
                    String newText = change.getControlNewText();
                    if (isValidInputInteger(newText)) {
                        return change;
                    } else {
                        return null; // Reject the change
                    }
                });

        text_field.setTextFormatter(textFormatter);
    }

    public static void decimal_and_neg_Numbers_Fields(TextField text_field) {
        // Create a TextFormatter with a UnaryOperator to handle changes
        TextFormatter<Double> textFormatter = new TextFormatter<>(
                new DoubleStringConverter(),
                null, // Default value
                change -> {
                    String newText = change.getControlNewText();
                    if (isValidInput(newText)) {
                        return change;
                    } else {
                        return null; // Reject the change
                    }
                });

        text_field.setTextFormatter(textFormatter);
    }

    private static boolean isValidInput(String text) {
        return text.matches("-?\\d*\\.?\\d*");
    }

    private static boolean isValidInputInteger(String text) {
        return text.matches("-?\\d*");
    }

    private void clearAllMovementField(ArrayList<TextField> numberFields, ArrayList<TextField> decimalTextfields) {
        numberFields.forEach(TextField::clear);
        decimalTextfields.forEach(TextField::clear);
        rideable.setSelected(false);
        can_fly.setSelected(false);
        can_surf.setSelected(false);
        can_ride_shoulder.setSelected(false);
        landing_material_combo_box.getSelectionModel().clearSelection();
        landing_material_combo_box.getEditor().clear();
        stays_horizontal_flying_checkbox.setSelected(false);
        continuous_forward_motion_checkbox.setSelected(false);
        block_list.getItems().clear();
        addBlockPart_checkBox.setSelected(false);
        addCanRotateWhileStopped_CheckBox.setSelected(false);
    }

    private void clearFormPreviewFields() {
        forms_list.getItems().clear();
        generation_textfield.clear();
    }

    private boolean isFieldEmpty(TextField textfield) {
        return textfield.getText().isEmpty() || textfield.getText().isBlank();
    }

    private Integer getIntegerFromField(TextField textField) {
        return (isFieldEmpty(textField)) ? null : Integer.parseInt(textField.getText());
    }

    private Double getDoubleFromField(TextField textField) {
        return (isFieldEmpty(textField)) ? null : Double.parseDouble(textField.getText());
    }

}