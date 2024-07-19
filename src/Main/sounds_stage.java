package Main;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
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

public class sounds_stage implements Initializable {
    static ArrayList<String> sounds;
    @FXML
    private TextField sound_textfield;
    @FXML
    private Button save_sounds_btn, add_sound_btn, remove_sound_btn;
    @FXML
    private ListView<String> sound_list;

    static Stage window;

    public static ArrayList<String> display(ArrayList<String> sounds_para) throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.setTitle("Sounds");
        window.getIcons().addAll(app.icon32x32,app.icon16x16,app.icon64x64);

        sounds = sounds_para;


        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("sounds_panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1140, 659);

        window.setScene(scene);
        window.showAndWait();
        return (sounds == null || sounds.isEmpty()) ? null : sounds;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        add_sound_btn.setOnAction(e->{
            if(sounds == null) sounds = new ArrayList<>();
            UIController.addIntoList(sound_textfield, sound_list, sounds);
        });
        remove_sound_btn.setOnAction(e->{
            if(sound_list.getSelectionModel().getSelectedIndex() == -1)
                return;
            UIController.removeFromList( sound_list, sounds);
        });

        save_sounds_btn.setOnAction(e-> {
            window.close();
        });

        if(sounds != null){
            sound_list.getItems().addAll(sounds);

        }

        List<Button> remove_and_edit_btns = Arrays.asList(
                save_sounds_btn, add_sound_btn, remove_sound_btn
        );

        remove_and_edit_btns.forEach(btn->{
            btn.setOnMouseEntered(e->{
                btn.setCursor(Cursor.HAND);
            });
            btn.setOnMouseExited(e->{
                btn.setCursor(Cursor.DEFAULT);
            });
        });


    }
}
