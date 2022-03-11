
package ferraris.ivbi.midgardbattle;

import static ferraris.ivbi.midgardbattle.Midgardbattle.music;
import ferraris.ivbi.midgardbattle.entita.Entita;
import ferraris.ivbi.midgardbattle.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

public class FXMLGameController implements Initializable {

    private Model model;
    @FXML private GridPane griglia_campo;
    @FXML private CheckBox checkBoxMute;
    @FXML private ImageView imgMute;
    @FXML private Label nomeTruppa;
    @FXML private ImageView imgTruppa;
    @FXML private TextArea areaLog;
    @FXML private Button apriChiudLog;
    @FXML private Button btnAvvia;
    @FXML private Button btnAttacca;
    @FXML private Label lblTrubbeBene;
    @FXML private Label lblTrubbeMale;
    @FXML private Label lblForza;
    @FXML private Label lblEsperienza;
    
    private Image mute = new Image("file:resources/img/mute.png");
    private Image unmute = new Image("file:resources/img/speaker.png");
    
    private Entita[][] campo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        areaLog.setVisible(false);
        btnAttacca.setVisible(false);
        apriChiudLog.setVisible(false);
        lblTrubbeBene.setVisible(false);
        lblTrubbeMale.setVisible(false);
        nomeTruppa.setVisible(false);
        lblForza.setVisible(false);
        lblEsperienza.setVisible(false);
        checkBoxMute.setVisible(false);
        
        lblForza.setText("");
        lblEsperienza.setText("");
    }    

    @FXML
    private void change(MouseEvent event) {
        if(checkBoxMute.isSelected()){
            music.soundtrack_mute();
            imgMute.setImage(mute);
            checkBoxMute.setSelected(false);
        }else{
            music.soundtrack_unmute();
            imgMute.setImage(unmute);
            checkBoxMute.setSelected(true);
        }
    }

    @FXML
    private void handleLog(ActionEvent event) {
        if(areaLog.isVisible()) areaLog.setVisible(false);
        else  areaLog.setVisible(true);
    }
    
    public void setModel(Model m){
        this.model = m;
        checkBoxMute.setSelected(model.isMusic_toggle());
        if(model.isMusic_toggle() == false) imgMute.setImage(mute);
        else imgMute.setImage(unmute);
        
        lblTrubbeBene.setText("Truppe del Bene: "+model.getNum_truppe());
        lblTrubbeMale.setText("Truppe del Male: "+model.getNum_truppe());
    }

    @FXML
    private void handleAvvia(ActionEvent event) {
        int rc = model.getDim_campo(), x = 0, offset = 60;
        model.iniziaGioco();
        this.campo = model.getCampo();

        
        if(rc == 6) x = 2;
        if(rc == 8) x = 1;
        if(rc == 10) offset = 40;
        
        for(int i=0;i<rc;i++)
        {
            for(int j=0;j<rc;j++)
            {
                ImageView image = new ImageView(campo[i][j].getMiniAsset());
                image.setPreserveRatio(true);
                image.setFitHeight(offset);
                campo[i][j].setGraphic(image);
                campo[i][j].setBackground(Background.EMPTY);
                
                campo[i][j].setOnAction(new EventHandler<ActionEvent>() {
 
                    public void handle(ActionEvent event) {
                        Entita b=(Entita)event.getSource();
                        nomeTruppa.setText(b.getClass().getSimpleName().toUpperCase());
                        imgTruppa.setImage(b.getImage());
                        if(!b.getClass().getSimpleName().equals("Vuoto")){
                            lblForza.setText("Forza: "+b.calcola_forza());
                            lblEsperienza.setText("Esperienza: "+b.getEsperienza_combattimento());
                        }else{
                            lblForza.setText("");
                            lblEsperienza.setText("");
                        }
                    }
                });
                griglia_campo.add(campo[i][j], i+x, j+x);
                campo[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
        }
        btnAvvia.setVisible(false);
        btnAttacca.setVisible(true);
        apriChiudLog.setVisible(true);
        lblTrubbeBene.setVisible(true);
        lblTrubbeMale.setVisible(true);
        nomeTruppa.setVisible(true);
        lblForza.setVisible(true);
        lblEsperienza.setVisible(true);
    }


    
}
