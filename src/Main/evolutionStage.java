package Main;

import EvoConditions.*;
import javafx.scene.Cursor;
import model.Evolution;

import model.model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class evolutionStage implements Initializable {

    @FXML
    private TextField level_evolution_textfield, evoType_evolution_textfield;
    @FXML
    private ComboBox<String> evolution_item_combobox, to_evolution_combobox, evolution_move_combobox;
    @FXML
    private Button evolution_add_move_btn, evolution_remove_move_btn;
    @FXML
    private ListView<String> evolution_move_list;

    @FXML
    private Button save_evolution_btn, remove_condition_btn, add_condition_btn;

    @FXML
    private ListView<String> condition_list;

    @FXML
    private Tab evolution_tab, condition_tab;

    // Conditions
    // Condition Tab fields
    @FXML
    private ComboBox<EvoConditionTypes> condition_type_combobox;
    private ArrayList<EvoConditionTypes> conditions_list;
    @FXML
    private Button save_condition_btn;

    // Condition panes
    @FXML
    private VBox battleCritical_VBox, biomeCondition_VBox, blocksWalkedOutsideBallCondition_VBox, chanceCondition_VBox,
            evoConditionType_VBox,
            evoRockCondition_VBox, evoScrollCondition_VBox, friendship_VBox, genderCondition_VBox,
            healthAbsenceCondition_VBox, heldItemCondition_VBox,
            levelCondition_VBox, highAltitudeCondition_VBox, moonPhaseCondition_VBox, moveCondition_VBox,
            moveUsesCondition_VBox, moveTypeCondition_VBox, natureCondition_VBox,
            nuggetCondition_VBox, potionEffectCondition_VBox, recoilCondition_VBox, shinyCondition_VBox,
            statRatioCondition_VBox, statusCondition_VBox,
            timeCondition_VBox, weatherCondition_VBox, withinStructureCondition_VBox;
    @FXML
    private HBox paryCondition_HBox;
    private ArrayList<Node> panes;

    // battleCritical Vbox
    @FXML
    private TextField critical_battleCritical_TF;
    // biome VBox
    @FXML
    private ComboBox<String> biome_combobox;
    @FXML
    private Button add_biome_btn, remove_biome_btn;

    @FXML
    private ListView<String> biome_list;
    // blocksToWalkOnCondition
    @FXML
    private TextField blocksToWalk_blocksWalkedOutside_TF;
    // chanceCondition_VBox
    @FXML
    private TextField chance_chanceCondition_TF;
    // evoConditionType_VBox
    @FXML
    private TextField condition_evoCondition_TF;
    // evoRockCondition_VBox
    @FXML
    private TextField maxRangeSquared_evoRockCondition_TF;
    @FXML
    private ChoiceBox<EvolutionRockType> evolutionRock_evoRockCondition_ChoiceBox;
    // evoScrollCondition_VBox
    @FXML
    private TextField maxRangeSquared_evoScrollCondition_TF;
    @FXML
    private ChoiceBox<ScrollBlockType> evolutionScroll_evoScrollCondition_ChoiceBox;
    // Friendship Condition
    @FXML
    private TextField friendship_friendshipCondition_TF;
    // Gender Condition
    @FXML
    private ComboBox<Gender> gender_combobox;
    @FXML
    private Button add_gender_genderCondition_btn, remove_gender_genderCondition_btn;
    @FXML
    private ListView<String> gender_list;
    // Health Absence Condition
    @FXML
    private TextField health_healthAbsenceCondition_TF;
    // Held Item Condition
    @FXML
    private ComboBox<String> itemID_heldItemCondition_comboBox;
    // Level Condition
    @FXML
    private TextField level_levelCondition_TF;
    // High Altitude Condition
    @FXML
    private TextField minAltitude_highAltitudeCondition_TF;
    // Moon Phase Condition
    @FXML
    private TextField moonPhase_moonPhaseCondition_TF;
    // Move Condition
    @FXML
    private TextField attackName_moveCondition_TF;
    // Move Uses Condition
    @FXML
    private TextField uses_moveUsesCondition_TF;
    // Move types Condition
    @FXML
    private TextField type_moveTypeCondition_TF;
    // Nature Condition
    @FXML
    private ComboBox<Nature> nature_combobox;
    @FXML
    private Button add_nature_btn, remove_nature_btn;

    @FXML
    private ListView<String> nature_list;
    // Nugget Condition
    @FXML
    private TextField nuggets_nuggetCondition_TF;

    // Party Condition
    // form VBox
    @FXML
    private ComboBox<String> form_partyCondition_combobox;
    @FXML
    private Button add_form_partyCondition_btn, remove_form_partyCondition_btn;
    @FXML
    private ListView<String> form_partyCondition_list;
    // Palettes VBox
    @FXML
    private ComboBox<String> palette_partyCondition_combobox;
    @FXML
    private Button add_palette_partyCondition_btn, remove_palette_partyCondition_btn;
    @FXML
    private ListView<String> palette_partyCondition_list;
    // Pokemon VBox
    @FXML
    private ComboBox<String> pokemon_partyCondition_combobox;
    @FXML
    private Button add_pokemon_partyCondition_btn, remove_pokemon_partyCondition_btn;
    @FXML
    private ListView<String> pokemon_partyCondition_list;
    // Types VBox
    @FXML
    private ComboBox<String> type_partyCondition_combobox;
    @FXML
    private Button add_type_partyCondition_btn, remove_type_partyCondition_btn;
    @FXML
    private ListView<String> type_partyCondition_list;
    // PotionEffect Condition
    @FXML
    private TextField potionEffect_TF;
    @FXML
    private Button add_potionEffectCondition_btn, remove_potionEffectCondition_btn;
    @FXML
    private ListView<String> potionEffect_list;
    // Recoil Condition
    @FXML
    private TextField recoil_recoilCondition_TF;
    // Shiny Condition
    @FXML
    private CheckBox shinyCondition_checkbox;
    // statRatio Condition
    @FXML
    private TextField ratio_statRatioCondition_TF, stat1_statRatioCondition_TF, stat2_statRatioCondition_TF;
    // Status Condition
    @FXML
    private ComboBox<StatusType> status_statusCondition_combobox;
    // Time Condition
    @FXML
    private ComboBox<WorldTime> timeCondition_combobox;
    // Weather Condition
    @FXML
    private ComboBox<WeatherType> weatherType_weatherCondition_combobox;
    // Within Structure
    @FXML
    private TextField structure_withinStructureCondition_TF;

    public static Stage window;
    public static Evolution _evolution;

    public static Evolution display() throws IOException {
        window = new Stage();
        _evolution = new Evolution();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Evolution");
        window.getIcons().addAll(app.icon32x32, app.icon16x16, app.icon64x64);

        if (_evolution == null)
            _evolution = new Evolution();
        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("evolution_fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1126.0, 733);
        window.setOnCloseRequest(e -> {
            e.consume();
            _evolution = null;
            model.indexOfSelectedEvolution = -1;
            window.close();
        });
        window.setScene(scene);
        try {
            window.showAndWait();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return _evolution;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        condition_tab.setDisable(true);
        // condition type combobox
        conditions_list = new ArrayList<>(Arrays.asList(EvoConditionTypes.values()));
        panes = new ArrayList<>(Arrays.asList(battleCritical_VBox, biomeCondition_VBox,
                blocksWalkedOutsideBallCondition_VBox, chanceCondition_VBox, evoConditionType_VBox,
                evoRockCondition_VBox, evoScrollCondition_VBox, friendship_VBox, genderCondition_VBox,
                healthAbsenceCondition_VBox, heldItemCondition_VBox,
                levelCondition_VBox, highAltitudeCondition_VBox, moonPhaseCondition_VBox, moveCondition_VBox,
                moveUsesCondition_VBox, moveTypeCondition_VBox, natureCondition_VBox,
                nuggetCondition_VBox, paryCondition_HBox, potionEffectCondition_VBox, recoilCondition_VBox,
                shinyCondition_VBox, statRatioCondition_VBox, statusCondition_VBox,
                timeCondition_VBox, weatherCondition_VBox, withinStructureCondition_VBox));

        List<Button> remove_and_edit_btns = Arrays.asList(
                add_potionEffectCondition_btn, remove_potionEffectCondition_btn,add_type_partyCondition_btn, remove_type_partyCondition_btn
                ,add_palette_partyCondition_btn, remove_palette_partyCondition_btn,
                add_form_partyCondition_btn, remove_form_partyCondition_btn,
                add_nature_btn, remove_nature_btn,
                add_gender_genderCondition_btn, remove_gender_genderCondition_btn,
                add_biome_btn, remove_biome_btn,
                save_evolution_btn, remove_condition_btn, add_condition_btn
        );

        remove_and_edit_btns.forEach(btn->{
            btn.setOnMouseEntered(e->{
                btn.setCursor(Cursor.HAND);
            });
            btn.setOnMouseExited(e->{
                btn.setCursor(Cursor.DEFAULT);
            });
        });


        // evolution items

        evolution_item_combobox.getItems().addAll(
                (Arrays.stream(Items.values()).toList()).stream().map(it -> "pixelmon:" + it.toString()).toList());

        evolution_move_combobox.getItems().addAll(constant_list.moves_Array);
        to_evolution_combobox.getItems().addAll(constant_list.pokemon_list);

        evolution_add_move_btn.setOnAction(e -> {
            String text = evolution_move_combobox.getEditor().getText();
            if (evolution_move_list.getItems().contains(text) || text.isEmpty())
                return;
            evolution_move_list.getItems().add(text);
            evolution_move_combobox.getSelectionModel().clearSelection();
            evolution_move_combobox.getEditor().clear();
            if (evolution_move_combobox.isShowing())
                evolution_move_combobox.hide();
        });
        evolution_remove_move_btn.setOnAction(e -> RemoveFromList(
                evolution_move_list, evolution_move_list.getSelectionModel().getSelectedIndex()));

        // Biome Conditions
        biome_combobox.getItems().addAll(Arrays.stream(BiomeTypeList.values()).map(BiomeTypeList::toString).toList());
        add_biome_btn.setOnAction(
                e -> AddIntoList(biome_list, biome_combobox.getEditor().getText(), biome_combobox.getEditor()));
        remove_biome_btn
                .setOnAction(e -> RemoveFromList(biome_list, biome_list.getSelectionModel().getSelectedIndex()));

        // evoRock Condition
        evolutionRock_evoRockCondition_ChoiceBox.getItems().addAll(Arrays.stream(EvolutionRockType.values()).toList());
        evolutionScroll_evoScrollCondition_ChoiceBox.getItems()
                .addAll(Arrays.stream(ScrollBlockType.values()).toList());

        gender_combobox.getItems().addAll(Arrays.stream(Gender.values()).toList());

        itemID_heldItemCondition_comboBox.getItems().addAll(
                (Arrays.stream(Items.values()).toList()).stream().map(it -> "pixelmon:" + it.toString()).toList());

        nature_combobox.getItems().addAll(Arrays.stream(Nature.values()).toList());
        status_statusCondition_combobox.getItems().addAll(Arrays.stream(StatusType.values()).toList());
        timeCondition_combobox.getItems().addAll(Arrays.stream(WorldTime.values()).toList());
        weatherType_weatherCondition_combobox.getItems().addAll(Arrays.stream(WeatherType.values()).toList());

        add_potionEffectCondition_btn.setOnAction(e -> {
            potionEffect_list.getItems().add(potionEffect_TF.getText());
            potionEffect_TF.clear();
        });
        remove_potionEffectCondition_btn.setOnAction(e -> {
            int index = potionEffect_list.getSelectionModel().getSelectedIndex();
            if (index == -1)
                return;
            potionEffect_list.getItems().remove(index);
        });

        add_gender_genderCondition_btn.setOnAction(
                e -> AddIntoList(gender_list, gender_combobox.getEditor().getText(), gender_combobox.getEditor()));
        remove_gender_genderCondition_btn
                .setOnAction(e -> RemoveFromList(gender_list, gender_list.getSelectionModel().getSelectedIndex()));

        add_nature_btn.setOnAction(
                e -> AddIntoList(nature_list, nature_combobox.getEditor().getText(), nature_combobox.getEditor()));
        remove_nature_btn
                .setOnAction(e -> RemoveFromList(nature_list, nature_list.getSelectionModel().getSelectedIndex()));

        ArrayList<TextField> textFieldsIntegers = new ArrayList<>(Arrays.asList(
                critical_battleCritical_TF, blocksToWalk_blocksWalkedOutside_TF, chance_chanceCondition_TF,
                maxRangeSquared_evoRockCondition_TF,
                maxRangeSquared_evoScrollCondition_TF, friendship_friendshipCondition_TF,
                health_healthAbsenceCondition_TF, level_levelCondition_TF, moonPhase_moonPhaseCondition_TF,
                uses_moveUsesCondition_TF, nuggets_nuggetCondition_TF,
                recoil_recoilCondition_TF, level_evolution_textfield));
        ArrayList<TextField> textFieldsDecimal = new ArrayList<>(Arrays.asList(
                minAltitude_highAltitudeCondition_TF, ratio_statRatioCondition_TF));

        setTextFieldOnlyNumeric(textFieldsIntegers);
        setTextFieldsDecimal(textFieldsDecimal);

        add_form_partyCondition_btn.setOnAction(
                e -> AddIntoList(form_partyCondition_list, form_partyCondition_combobox.getEditor().getText(),
                        form_partyCondition_combobox.getEditor()));
        remove_form_partyCondition_btn.setOnAction(e -> RemoveFromList(form_partyCondition_list,
                form_partyCondition_list.getSelectionModel().getSelectedIndex()));

        add_palette_partyCondition_btn.setOnAction(
                e -> AddIntoList(palette_partyCondition_list, palette_partyCondition_combobox.getEditor().getText(),
                        palette_partyCondition_combobox.getEditor()));
        remove_palette_partyCondition_btn.setOnAction(e -> RemoveFromList(palette_partyCondition_list,
                palette_partyCondition_list.getSelectionModel().getSelectedIndex()));

        add_pokemon_partyCondition_btn.setOnAction(
                e -> AddIntoList(pokemon_partyCondition_list, pokemon_partyCondition_combobox.getEditor().getText(),
                        pokemon_partyCondition_combobox.getEditor()));
        remove_pokemon_partyCondition_btn.setOnAction(e -> RemoveFromList(pokemon_partyCondition_list,
                pokemon_partyCondition_list.getSelectionModel().getSelectedIndex()));

        add_type_partyCondition_btn.setOnAction(
                e -> AddIntoList(type_partyCondition_list, type_partyCondition_combobox.getEditor().getText(),
                        type_partyCondition_combobox.getEditor()));
        remove_type_partyCondition_btn.setOnAction(e -> RemoveFromList(type_partyCondition_list,
                type_partyCondition_list.getSelectionModel().getSelectedIndex()));

        save_condition_btn.setOnAction(e -> {
            EvoConditionTypes evoCondition = condition_type_combobox.getSelectionModel().getSelectedItem();
            setCondition(evoCondition);
            UIController
                    .showMessage("Condition Added Successfully!", UIController.bellIcon, Alert.AlertType.INFORMATION)
                    .show();
            condition_list.getItems()
                    .add(_evolution.getConditions().get(_evolution.getConditions().size() - 1).toString());
            evolution_tab.getTabPane().getSelectionModel().select(evolution_tab);
            condition_tab.setDisable(true);
            evolution_tab.setDisable(false);
        });

        add_condition_btn.setOnAction(e -> addEvolutionCondition());
        remove_condition_btn
                .setOnAction(e -> removeConditionFromList(condition_list.getSelectionModel().getSelectedIndex()));

        condition_type_combobox.getItems().setAll(conditions_list);
        condition_type_combobox.getSelectionModel().selectedItemProperty()
                .addListener((changeListener, oldValue, newValue) -> {
                    if (panes == null)
                        return;
                    HideAllPanes(panes);
                    Node paneToShow = getPane(newValue);
                    if (paneToShow != null)
                        showSpecificNode(paneToShow);
                });

        save_evolution_btn.setOnAction(e -> {
            try {
                String level_text = level_evolution_textfield.getText();
                Integer level = null;
                if (level_text.length() != 0)
                    level = Integer.parseInt(level_text);
                String _to = to_evolution_combobox.getEditor().getText();
                String evoType = evoType_evolution_textfield.getText();
                ArrayList<String> moves_array = null;
                if (!evolution_move_list.getItems().isEmpty()) {
                    moves_array = new ArrayList<>(evolution_move_list.getItems());
                }

                _evolution.setLevel(level);
                _evolution.setTo(_to);
                _evolution.setEvoType(evoType);
                _evolution.setMoves(moves_array);

                level_evolution_textfield.clear();
                to_evolution_combobox.getEditor().clear();
                evoType_evolution_textfield.clear();
                evolution_move_list.getItems().clear();

                condition_list.getItems().clear();
                window.close();

            } catch (NumberFormatException nfe) {
                new Alert(Alert.AlertType.INFORMATION, nfe.getMessage()).show();
            }
        });

        if (model.openFile) {
            if (model.indexOfSelectedEvolution != -1) {
                _evolution = model.getNewForm().getEvolutions().get(model.indexOfSelectedEvolution);
                Integer level = _evolution.getLevel();
                if (level != null) {
                    level_evolution_textfield.setText(String.valueOf(level));
                }

                level_evolution_textfield.setText(String.valueOf(_evolution.getLevel()));
                to_evolution_combobox.getEditor().setText(_evolution.getTo());
                evoType_evolution_textfield.setText(_evolution.getEvoType());
                _evolution.getConditions().forEach(cond -> {
                    condition_list.getItems().add(cond.toString());
                });
            }
        }

    }

    public void setCondition(EvoConditionTypes type) {
        switch (type) {
            case critical -> {
                try {
                    BattleCriticalCondition btc = new BattleCriticalCondition();
                    btc.setCritical(Integer.parseInt(critical_battleCritical_TF.getText()));
                    _evolution.getConditions().add(btc);
                    critical_battleCritical_TF.clear();
                    battleCritical_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();

                } catch (NumberFormatException nfe) {
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                    critical_battleCritical_TF.clear();
                }
            }
            case biome -> {
                ArrayList<String> biomes_list = new ArrayList<String>(biome_list.getItems());
                BiomeCondition biome_condition = new BiomeCondition();
                biome_condition.setBiomes(biomes_list);
                _evolution.getConditions().add(biome_condition);
                biome_list.getItems().clear();
                biome_combobox.getSelectionModel().clearSelection();
                biome_combobox.getEditor().clear();
                biomeCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case blocksWalkedOutsideBall -> {
                try {
                    BlocksWalkedOutsideBallCondition bwobc = new BlocksWalkedOutsideBallCondition();
                    bwobc.setBlocksToWalk(Integer.parseInt(blocksToWalk_blocksWalkedOutside_TF.getText()));
                    _evolution.getConditions().add(bwobc);
                    blocksToWalk_blocksWalkedOutside_TF.clear();
                    blocksWalkedOutsideBallCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    UIController.showMessage(nfe.getMessage(), UIController.fireCrackerIcon, Alert.AlertType.WARNING)
                            .show();
                    blocksToWalk_blocksWalkedOutside_TF.clear();
                }
            }
            case chance -> {
                try {
                    ChanceCondition cc = new ChanceCondition();
                    cc.setChance(Integer.parseInt(chance_chanceCondition_TF.getText()));
                    _evolution.getConditions().add(cc);
                    chance_chanceCondition_TF.clear();
                    chanceCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    UIController.showMessage(nfe.getMessage(), UIController.fireCrackerIcon, Alert.AlertType.WARNING)
                            .show();
                    chance_chanceCondition_TF.clear();
                }
            }
            case evoConditionType -> {
                EvoCondition eC = new EvoCondition();
                eC.setEvoConditionType(condition_evoCondition_TF.getText());
                _evolution.getConditions().add(eC);
                condition_evoCondition_TF.clear();
                evoConditionType_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case evolutionRock -> {
                try {
                    EvoRockCondition eRC = new EvoRockCondition();
                    EvolutionRockType rock = evolutionRock_evoRockCondition_ChoiceBox.getValue();
                    if (rock == null)
                        throw new MessageException("RockType is Not Selected!!");
                    eRC.setEvolutionRock(rock);
                    eRC.setMaxRangeSquared(Integer.parseInt(maxRangeSquared_evoRockCondition_TF.getText()));
                    _evolution.getConditions().add(eRC);
                    maxRangeSquared_evoRockCondition_TF.clear();
                    evolutionRock_evoRockCondition_ChoiceBox.getSelectionModel().clearSelection();
                    evoRockCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    UIController.showMessage(nfe.getMessage(), UIController.fireCrackerIcon, Alert.AlertType.WARNING)
                            .show();
                    maxRangeSquared_evoRockCondition_TF.clear();
                } catch (MessageException e) {
                    UIController.showMessage(e.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case evolutionScroll -> {
                try {
                    EvoScrollCondition eSC = new EvoScrollCondition();
                    ScrollBlockType scroll_type = evolutionScroll_evoScrollCondition_ChoiceBox.getValue();
                    if (scroll_type == null)
                        throw new MessageException("ScrollType is Not Selected!!");
                    eSC.setEvolutionScroll(scroll_type);
                    eSC.setMaxRangeSquared(Integer.parseInt(maxRangeSquared_evoScrollCondition_TF.getText()));
                    _evolution.getConditions().add(eSC);
                    maxRangeSquared_evoScrollCondition_TF.clear();
                    evolutionScroll_evoScrollCondition_ChoiceBox.getSelectionModel().clearSelection();
                    evoScrollCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    UIController.showMessage(nfe.getMessage(), UIController.fireCrackerIcon, Alert.AlertType.WARNING)
                            .show();
                    maxRangeSquared_evoScrollCondition_TF.clear();
                } catch (MessageException e) {
                    UIController.showMessage(e.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case friendship -> {
                try {
                    FriendshipCondition fc = new FriendshipCondition(
                            Integer.parseInt(friendship_friendshipCondition_TF.getText()));
                    _evolution.getConditions().add(fc);
                    friendship_friendshipCondition_TF.clear();
                    friendship_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    friendship_friendshipCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case gender -> {
                GenderCondition gc = new GenderCondition(new ArrayList<>(gender_list.getItems()));
                _evolution.getConditions().add(gc);
                gender_list.getSelectionModel().clearSelection();
                gender_combobox.getSelectionModel().clearSelection();
                gender_combobox.getEditor().clear();
                genderCondition_VBox.setVisible(false);
            }
            case healthAbsence -> {
                try {
                    HealthAbsenceCondition hac = new HealthAbsenceCondition(
                            Integer.parseInt(health_healthAbsenceCondition_TF.getText()));
                    _evolution.getConditions().add(hac);
                    health_healthAbsenceCondition_TF.clear();
                    healthAbsenceCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    health_healthAbsenceCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case heldItem -> {
                HeldItemCondition held_item_condition = new HeldItemCondition();
                held_item_condition.setItem(new Item(itemID_heldItemCondition_comboBox.getEditor().getText()));
                _evolution.getConditions().add(held_item_condition);
                itemID_heldItemCondition_comboBox.getEditor().clear();
                itemID_heldItemCondition_comboBox.getSelectionModel().clearSelection();
                heldItemCondition_VBox.setVisible(false);
            }
            case highAltitude -> {
                try {
                    HighAltitudeCondition hac = new HighAltitudeCondition(
                            Double.parseDouble(minAltitude_highAltitudeCondition_TF.getText()));
                    _evolution.getConditions().add(hac);
                    minAltitude_highAltitudeCondition_TF.clear();
                    highAltitudeCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    minAltitude_highAltitudeCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case level -> {
                try {
                    LevelCondition hac = new LevelCondition(Integer.parseInt(level_levelCondition_TF.getText()));
                    _evolution.getConditions().add(hac);
                    level_levelCondition_TF.clear();
                    levelCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    level_levelCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case moonPhase -> {
                try {
                    MoonPhaseCondition mpc = new MoonPhaseCondition(
                            Integer.parseInt(moonPhase_moonPhaseCondition_TF.getText()));
                    _evolution.getConditions().add(mpc);
                    moonPhase_moonPhaseCondition_TF.clear();
                    moonPhaseCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    moonPhase_moonPhaseCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case move -> {
                MoveCondition mc = new MoveCondition(attackName_moveCondition_TF.getText());
                _evolution.getConditions().add(mc);
                attackName_moveCondition_TF.clear();
                moonPhaseCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case moveType -> {
                MoveTypeCondition mtc = new MoveTypeCondition(type_moveTypeCondition_TF.getText());
                _evolution.getConditions().add(mtc);
                type_moveTypeCondition_TF.clear();
                moveTypeCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case moveUses -> {
                try {
                    MoveUsesCondition muc = new MoveUsesCondition(
                            Integer.parseInt(uses_moveUsesCondition_TF.getText()));
                    _evolution.getConditions().add(muc);
                    uses_moveUsesCondition_TF.clear();
                    moveUsesCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    uses_moveUsesCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case nature -> {
                NatureCondition nc = new NatureCondition(new ArrayList<>(nature_list.getItems()));
                _evolution.getConditions().add(nc);
                nature_combobox.getSelectionModel().clearSelection();
                nature_combobox.getEditor().clear();
                nature_list.getSelectionModel().clearSelection();
                natureCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();

            }
            case nugget -> {
                NuggetCondition nc = new NuggetCondition(Integer.parseInt(nuggets_nuggetCondition_TF.getText()));
                _evolution.getConditions().add(nc);
                nuggets_nuggetCondition_TF.clear();
                nuggetCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case party -> {
                ArrayList<String> withForms = new ArrayList<>(), withPokemon = new ArrayList<>(),
                        withTypes = new ArrayList<>(), withPalette = null;
                if (!pokemon_partyCondition_list.getItems().isEmpty())
                    withPokemon = new ArrayList<>(pokemon_partyCondition_list.getItems());
                if (!form_partyCondition_list.getItems().isEmpty())
                    withForms = new ArrayList<>(form_partyCondition_list.getItems());
                if (!type_partyCondition_list.getItems().isEmpty())
                    withTypes = new ArrayList<>(type_partyCondition_list.getItems());
                if (!palette_partyCondition_list.getItems().isEmpty())
                    withPalette = new ArrayList<>(palette_partyCondition_list.getItems());

                PartyCondition pc = new PartyCondition(withForms, withPalette, withPokemon, withTypes);
                _evolution.getConditions().add(pc);
                pokemon_partyCondition_combobox.getEditor().clear();
                pokemon_partyCondition_list.getSelectionModel().clearSelection();
                form_partyCondition_list.getSelectionModel().clearSelection();
                form_partyCondition_combobox.getEditor().clear();
                type_partyCondition_combobox.getEditor().clear();
                type_partyCondition_list.getSelectionModel().clearSelection();
                palette_partyCondition_combobox.getEditor().clear();
                palette_partyCondition_combobox.getSelectionModel().clearSelection();
                paryCondition_HBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case potionEffect -> {
                PotionEffectCondition pec = new PotionEffectCondition(new ArrayList<>(potionEffect_list.getItems()));
                _evolution.getConditions().add(pec);
                potionEffect_TF.clear();
                potionEffect_list.getSelectionModel().clearSelection();
                potionEffectCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case recoil -> {
                try {
                    RecoilCondition rc = new RecoilCondition(Integer.parseInt(recoil_recoilCondition_TF.getText()));
                    _evolution.getConditions().add(rc);
                    recoil_recoilCondition_TF.clear();
                    recoilCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    recoil_recoilCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case shiny -> {
                ShinyCondition sc = new ShinyCondition(shinyCondition_checkbox.isSelected());
                _evolution.getConditions().add(sc);
                sc.setShiny(false);
                shinyCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case statRatio -> {
                try {
                    StatRatioCondition src = new StatRatioCondition(
                            Double.parseDouble(ratio_statRatioCondition_TF.getText()),
                            stat1_statRatioCondition_TF.getText(), stat2_statRatioCondition_TF.getText());
                    _evolution.getConditions().add(src);
                    ratio_statRatioCondition_TF.clear();
                    stat1_statRatioCondition_TF.clear();
                    stat2_statRatioCondition_TF.clear();
                    statusCondition_VBox.setVisible(false);
                    condition_type_combobox.getSelectionModel().clearSelection();
                } catch (NumberFormatException nfe) {
                    ratio_statRatioCondition_TF.clear();
                    UIController.showMessage(nfe.getMessage(), UIController.bombIcon, Alert.AlertType.WARNING).show();
                }
            }
            case status -> {
                StatusCondition sc = new StatusCondition(status_statusCondition_combobox.getEditor().getText());
                _evolution.getConditions().add(sc);
                status_statusCondition_combobox.getSelectionModel().clearSelection();
                status_statusCondition_combobox.getEditor().clear();
                statusCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();

            }
            case time -> {
                TimeCondition tc = new TimeCondition(timeCondition_combobox.getEditor().getText());
                _evolution.getConditions().add(tc);
                timeCondition_combobox.getSelectionModel().clearSelection();
                timeCondition_combobox.getEditor().clear();
                timeCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case weather -> {
                WeatherCondition wc = new WeatherCondition(weatherType_weatherCondition_combobox.getEditor().getText());
                _evolution.getConditions().add(wc);
                weatherType_weatherCondition_combobox.getSelectionModel().clearSelection();
                weatherType_weatherCondition_combobox.getEditor().clear();
                weatherCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }
            case withinStructure -> {
                WithinStructureCondition wsc = new WithinStructureCondition(
                        structure_withinStructureCondition_TF.getText());
                _evolution.getConditions().add(wsc);
                structure_withinStructureCondition_TF.clear();
                withinStructureCondition_VBox.setVisible(false);
                condition_type_combobox.getSelectionModel().clearSelection();
            }

        }
    }

    private void setTextFieldOnlyNumeric(ArrayList<TextField> textFields) {
        textFields.forEach(UIController::integerOnlyFields);
    }

    private static boolean isValidInput(String text) {
        return text.matches("-?\\d*\\.?\\d*");
    }

    private static boolean isValidInputInteger(String text) {
        return text.matches("-?\\d*");
    }

    private void setTextFieldsDecimal(ArrayList<TextField> textFields) {
        textFields.forEach(UIController::decimal_and_neg_Numbers_Fields);
    }

    public static void HideAllPanes(ArrayList<Node> evoPanes) {
        if (evoPanes == null)
            return;
        evoPanes.forEach(node -> node.setVisible(false));
    }

    public static void showSpecificNode(Node pane) {
        if (pane == null)
            return;
        pane.setVisible(true);
    }

    public Node getPane(EvoConditionTypes condition) {
        if (condition == null)
            return null;
        switch (condition) {
            case critical -> {
                return this.battleCritical_VBox;
            }
            case biome -> {
                return this.biomeCondition_VBox;
            }
            case blocksWalkedOutsideBall -> {
                return this.blocksWalkedOutsideBallCondition_VBox;
            }
            case chance -> {
                return this.chanceCondition_VBox;
            }
            case evoConditionType -> {
                return this.evoConditionType_VBox;
            }
            case evolutionRock -> {
                return this.evoRockCondition_VBox;
            }
            case evolutionScroll -> {
                return this.evoScrollCondition_VBox;
            }
            case friendship -> {
                return this.friendship_VBox;
            }
            case gender -> {
                return this.genderCondition_VBox;
            }
            case healthAbsence -> {
                return this.healthAbsenceCondition_VBox;
            }
            case heldItem -> {
                return this.heldItemCondition_VBox;
            }
            case highAltitude -> {
                return this.highAltitudeCondition_VBox;
            }
            case level -> {
                return this.levelCondition_VBox;
            }
            case moonPhase -> {
                return this.moonPhaseCondition_VBox;
            }
            case move -> {
                return this.moveCondition_VBox;
            }
            case moveType -> {
                return this.moveTypeCondition_VBox;
            }
            case moveUses -> {
                return this.moveUsesCondition_VBox;
            }
            case nature -> {
                return this.natureCondition_VBox;
            }
            case nugget -> {
                return this.nuggetCondition_VBox;
            }
            case party -> {
                return this.paryCondition_HBox;
            }
            case potionEffect -> {
                return this.potionEffectCondition_VBox;
            }
            case recoil -> {
                return this.recoilCondition_VBox;
            }
            case shiny -> {
                return this.shinyCondition_VBox;
            }
            case statRatio -> {
                return this.statRatioCondition_VBox;
            }
            case status -> {
                return this.statusCondition_VBox;
            }
            case time -> {
                return this.timeCondition_VBox;
            }
            case weather -> {
                return this.weatherCondition_VBox;
            }
            case withinStructure -> {
                return this.withinStructureCondition_VBox;
            }
            default -> {
                return null;
            }
        }
    }

    public static void AddIntoList(ListView<String> listView, String value, TextField textField) {
        if (value.isBlank())
            return;
        listView.getItems().add(value);
        textField.clear();
    }

    public void RemoveFromList(ListView<String> listView, int value) {
        if (value == -1)
            return;
        listView.getItems().remove(value);
        listView.getSelectionModel().clearSelection();
    }

    public void removeConditionFromList(int index) {
        if (index == -1)
            return;
        condition_list.getItems().remove(index);
        _evolution.getConditions().remove(index);
        condition_list.getSelectionModel().clearSelection();
    }

    public void addEvolutionCondition() {
        condition_tab.getTabPane().getSelectionModel().select(condition_tab);
        condition_tab.setDisable(false);
        evolution_tab.setDisable(true);
    }

}
