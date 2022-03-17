/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class VittoriaSconfittaController implements Initializable {

    private Model model;
    private StackPane stackPane;
    private AnchorPane scenaGioco;
    @FXML private AnchorPane anchorPane;
    @FXML private Label lblVincitore;
    @FXML private ImageView imgVincitore;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close(MouseEvent event) throws IOException {                
        stackPane.getChildren().remove(scenaGioco);
        stackPane.getChildren().remove(anchorPane);

        model.setSpawn(false);
    
    }
    
    public void setModel(Model m, StackPane stackpane, AnchorPane scena){
        this.model = m;
        if(model.getVincitore().equalsIgnoreCase(model.getBet())){
            imgVincitore.setImage(new Image("file:resources/img/vittoria.png"));
        }else{
            imgVincitore.setImage(new Image("file:resources/img/sconfitta.png"));
        }
        lblVincitore.setText("VINCE IL "+model.getVincitore().toUpperCase()+"!");
        this.stackPane = stackpane;
        this.scenaGioco = scena;
    }
    
}
