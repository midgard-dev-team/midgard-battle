
package ferraris.ivbi.midgardbattle;

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

    @FXML private AnchorPane root;
    @FXML private CheckBox checkBoxMusica;
    @FXML private Button btnSalva;
    @FXML private ChoiceBox<String> choiceBoxDimensione;
    @FXML private ChoiceBox<String> choiceBoxTruppe;

    private String dimCampo[] = {"6","8","10"};
    private String numTruppe[] = {"6","8","10"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkBoxMusica.setSelected(true);
        
        choiceBoxDimensione.getItems().addAll(dimCampo);
        choiceBoxTruppe.getItems().addAll(numTruppe);
    }    

    @FXML
    private void switchMusic(ActionEvent event) {
        if(checkBoxMusica.isSelected()){
            Midgardbattle.music.soundtrack_unmute();
        }else{
            Midgardbattle.music.soundtrack_mute();
        }
    }

    @FXML
    private void handleSalva(ActionEvent event) {
        StackPane stackPane = (StackPane) btnSalva.getScene().getRoot();
        stackPane.getChildren().remove(root);
        
        //Stage stage = (Stage) btnSalva.getScene().getWindow();
        //stage.close();
    }
    
}
