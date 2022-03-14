
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.model.Model;
import ferraris.ivbi.midgardbattle.music.Sfx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * 
 * @author Enrico
 */
public class FXMLSettingsController implements Initializable {

    private Model model;
    private FXMLLoginController loginController;
    @FXML private AnchorPane root;
    @FXML private CheckBox checkBoxMusica;
    @FXML private Button btnSalva;
    @FXML private ChoiceBox<String> choiceBoxDimensione;
    @FXML private ChoiceBox<String> choiceBoxTruppe;
    @FXML private CheckBox checkBoxSfx;
    private String dimCampo[] = {"6","8","10"};
    private String numTruppe[] = {"6","8","10"};

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        choiceBoxDimensione.getItems().addAll(dimCampo);
        choiceBoxTruppe.getItems().addAll(numTruppe);
    }    

    @FXML
    private void switchMusic(ActionEvent event) {
        if(checkBoxMusica.isSelected()){
            Midgardbattle.music.soundtrack_unmute();
            model.setMusic_toggle(true);
        }else{
            Midgardbattle.music.soundtrack_mute();
            model.setMusic_toggle(false);
        }
    }

    @FXML
    private void handleSalva(ActionEvent event) {
        StackPane stackPane = (StackPane) btnSalva.getScene().getRoot();
        loginController.setCheckBox(checkBoxMusica.isSelected());
        stackPane.getChildren().remove(root);
        try{
            model.setDim_campo(Integer.parseInt(choiceBoxDimensione.getValue()));   
        }catch(NumberFormatException e){
            model.setDim_campo(6);
        }
        try{
            model.setNum_truppe(Integer.parseInt(choiceBoxTruppe.getValue()));
        }catch(NumberFormatException e){
            model.setNum_truppe(6);
        }
    }
    
    public void setModel(Model m){
        this.model = m;
        checkBoxMusica.setSelected(model.isMusic_toggle());
        checkBoxSfx.setSelected(model.getSfxOnOff());
        choiceBoxDimensione.setValue(model.getDim_campo()+"");
        choiceBoxTruppe.setValue(model.getNum_truppe()+"");
    }
    
    public void setLoginController(FXMLLoginController c){
        this.loginController = c;
    }

    @FXML
    private void switchSfx(ActionEvent event) {
        if(checkBoxSfx.isSelected()){
            model.setSfxOnOff(true);
        }else{
            model.setSfxOnOff(false);
        }
    }
    
}
