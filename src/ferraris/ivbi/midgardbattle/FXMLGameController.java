/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ferraris.ivbi.midgardbattle;

import static ferraris.ivbi.midgardbattle.Midgardbattle.music;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Utente
 */
public class FXMLGameController implements Initializable {

    @FXML private GridPane griglia_campo;
    @FXML private CheckBox checkBoxMute;
    @FXML private ImageView imgMute;
    @FXML private Label nomeTruppa;
    @FXML private ImageView imgTruppa;
    
    private Image mute = new Image("file:resources/img/mute.png");
    private Image unmute = new Image("file:resources/img/speaker.png");
    //truppe del bene
    private Image elfo = new Image("file:resources/img/truppe-bene/elfo.png");
    private Image hobbit = new Image("file:resources/img/truppe-bene/hobbit.png");
    private Image nano = new Image("file:resources/img/truppe-bene/nano.png");
    private Image umano = new Image("file:resources/img/truppe-bene/umano.png");

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int rc=8, x = 0, offset = 60;
        Button matButton[][]=new Button[rc][rc];
        
        if(rc == 6) x = 2;
        if(rc == 8) x = 1;
        if(rc == 10) offset = 40;
        
        for(int i=0;i<rc;i++)
        {
            for(int j=0;j<rc;j++)
            {
                Image img = new Image("file:resources/img/empty.png");
                ImageView empty = new ImageView(img);
                empty.setFitHeight(offset);
                empty.setPreserveRatio(true);
                matButton[i][j]=new Button();
                matButton[i][j].setGraphic(empty);
                matButton[i][j].setBackground(Background.EMPTY);
                
                matButton[i][j].setOnAction(new EventHandler<ActionEvent>() {
 
                    public void handle(ActionEvent event) {
                        Button b=(Button)event.getSource();
                        nomeTruppa.setText("ELFO");
                        imgTruppa.setImage(elfo);
                    }
                });
                griglia_campo.add(matButton[i][j], i+x, j+x);
                matButton[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
        }
        imgMute.setImage(unmute);
        checkBoxMute.setSelected(true);
    }    

    @FXML
    private void change(ActionEvent event) {
        if(checkBoxMute.isSelected()){
            music.soundtrack_unmute();
            imgMute.setImage(unmute);
        }else{
            music.soundtrack_mute();
            imgMute.setImage(mute);
        }
    }
    
}
