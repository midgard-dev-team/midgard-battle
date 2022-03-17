/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ferraris.ivbi.midgardbattle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Utente
 */
public class FXMLInfoController implements Initializable {

    private StackPane stackPane;
    
    @FXML private ImageView elfo;
    @FXML private ImageView hobbit;
    @FXML private ImageView uomo;
    @FXML private ImageView nano;
    @FXML private ImageView gandalf;
    @FXML private ImageView elrond;
    @FXML private ImageView aragorn;
    @FXML private ImageView orco;
    @FXML private ImageView urukhai;
    @FXML private ImageView sudrone;
    @FXML private ImageView saruman;
    @FXML private ImageView sauron;
    @FXML private ImageView nazgul;
    @FXML private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        elfo.setImage(new Image("file:resources/img/mini-assets/elfo.png"));
        hobbit.setImage(new Image("file:resources/img/mini-assets/hobbit.png"));
        uomo.setImage(new Image("file:resources/img/mini-assets/uomo.png"));
        nano.setImage(new Image("file:resources/img/mini-assets/nano.png"));
        gandalf.setImage(new Image("file:resources/img/mini-assets/gandalf.png"));
        elrond.setImage(new Image("file:resources/img/mini-assets/elrond.png"));
        aragorn.setImage(new Image("file:resources/img/mini-assets/aragorn.png"));
        orco.setImage(new Image("file:resources/img/mini-assets/orco.png"));
        urukhai.setImage(new Image("file:resources/img/mini-assets/urukhai.png"));
        sudrone.setImage(new Image("file:resources/img/mini-assets/sudrone.png"));
        saruman.setImage(new Image("file:resources/img/mini-assets/saruman.png"));
        sauron.setImage(new Image("file:resources/img/mini-assets/sauron.png"));
        nazgul.setImage(new Image("file:resources/img/mini-assets/nazgul.png"));
        elfo.getStyleClass().add("cornice");
        hobbit.getStyleClass().add("cornice");
        uomo.getStyleClass().add("cornice");
        nano.getStyleClass().add("cornice");
        gandalf.getStyleClass().add("cornice");
        elrond.getStyleClass().add("cornice");
        aragorn.getStyleClass().add("cornice");
        orco.getStyleClass().add("cornice");
        urukhai.getStyleClass().add("cornice");
        sudrone.getStyleClass().add("cornice");
        saruman.getStyleClass().add("cornice");
        sauron.getStyleClass().add("cornice");
        nazgul.getStyleClass().add("cornice");
    }    

    @FXML
    private void esci(Event event) {
        stackPane.getChildren().remove(root);
    }
    
    public void setModel(StackPane stackPane){
        this.stackPane = stackPane;
    }
    
}
