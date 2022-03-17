
package ferraris.ivbi.midgardbattle;

import static ferraris.ivbi.midgardbattle.Midgardbattle.music;
import ferraris.ivbi.midgardbattle.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class FXMLSettingsController implements Initializable {

    private Model model;
    private FXMLLoginController loginController;
    @FXML
    private AnchorPane root;
    @FXML
    private CheckBox checkBoxMusica;
    @FXML
    private Button btnSalva;
    @FXML
    private ChoiceBox<String> choiceBoxDimensione;
    @FXML
    private ChoiceBox<String> choiceBoxTruppe;
    @FXML
    private CheckBox checkBoxSfx;
    private String dimCampo[] = { "6", "8", "10" };
    private String numTruppe[] = { "6", "8", "10" };
    @FXML
    private Slider musicSlider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        choiceBoxDimensione.getItems().addAll(dimCampo);
        choiceBoxTruppe.getItems().addAll(numTruppe);
        musicSlider.setValue(1);
    }

    @FXML
    private void switchMusic(ActionEvent event) {
        if (checkBoxMusica.isSelected()) {
            Midgardbattle.music.soundtrack_unmute();
            model.setMusic_toggle(true);
            musicSlider.setDisable(false);
        } else {
            Midgardbattle.music.soundtrack_mute();
            model.setMusic_toggle(false);
            musicSlider.setDisable(true);
        }
    }

    @FXML
    private void handleSalva(ActionEvent event) {
        StackPane stackPane = (StackPane) btnSalva.getScene().getRoot();
        loginController.setCheckBox(checkBoxMusica.isSelected());
        stackPane.getChildren().remove(root);
        try {
            model.setDim_campo(Integer.parseInt(choiceBoxDimensione.getValue()));
        } catch (NumberFormatException e) {
            model.setDim_campo(6);
        }
        try {
            model.setNum_truppe(Integer.parseInt(choiceBoxTruppe.getValue()));
        } catch (NumberFormatException e) {
            model.setNum_truppe(6);
        }
    }

    public void setModel(Model m) {
        this.model = m;
        checkBoxMusica.setSelected(model.isMusic_toggle());
        checkBoxSfx.setSelected(model.getSfxOnOff());
        choiceBoxDimensione.setValue(model.getDim_campo() + "");
        choiceBoxTruppe.setValue(model.getNum_truppe() + "");

        musicSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                model.setVolumeMusica(musicSlider.getValue());
                music.setVolume(model.getVolumeMusica());
            }

        });
        musicSlider.setValue(model.getVolumeMusica());
        musicSlider.setDisable(!model.isMusic_toggle());
    }

    public void setLoginController(FXMLLoginController c) {
        this.loginController = c;
    }

    @FXML
    private void switchSfx(ActionEvent event) {
        if (checkBoxSfx.isSelected()) {
            model.setSfxOnOff(true);
        } else {
            model.setSfxOnOff(false);
        }
    }

}
