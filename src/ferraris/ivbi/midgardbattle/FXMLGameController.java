
package ferraris.ivbi.midgardbattle;

import static ferraris.ivbi.midgardbattle.Midgardbattle.music;
import ferraris.ivbi.midgardbattle.entita.Entita;
import ferraris.ivbi.midgardbattle.entita.Vuoto;
import ferraris.ivbi.midgardbattle.entita.eroe.Eroe;
import ferraris.ivbi.midgardbattle.model.Model;
import ferraris.ivbi.midgardbattle.music.Sfx;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    @FXML private Label lblTrubbeBene;
    @FXML private Label lblTrubbeMale;
    @FXML private Label lblForza;
    @FXML private Label lblEsperienza;
    @FXML private Button btnAvanza;
    @FXML private AnchorPane scenaGioco;
    
    private Image mute = new Image("file:resources/img/mute.png");
    private Image unmute = new Image("file:resources/img/speaker.png");
    private Image graveStone = new Image("file:resources/img/death.png");
    
    private ImageView image;
    private int indexBattaglie = 0;
    private int bene_rimasto;
    private int male_rimasto;
    private int x = 0;
    private int offset = 70;
    
    private StackPane stackPane;
    
    private Entita[][] campo;
    private List<Entita> listaAttacchi = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        areaLog.setVisible(false);
        btnAvanza.setVisible(false);
        apriChiudLog.setVisible(false);
        lblTrubbeBene.setVisible(false);
        lblTrubbeMale.setVisible(false);
        nomeTruppa.setVisible(false);
        lblForza.setVisible(false);
        lblEsperienza.setVisible(false);
        checkBoxMute.setVisible(false);
        
        lblForza.setText("");
        lblEsperienza.setText("");
        nomeTruppa.setText("Clicca una casella...");
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
    
    public void setModel(Model m, StackPane stackPane){
        this.model = m;
        checkBoxMute.setSelected(model.isMusic_toggle());
        if(model.isMusic_toggle() == false) imgMute.setImage(mute);
        else imgMute.setImage(unmute);
        
        lblTrubbeBene.setText("Truppe del Bene: "+model.getNum_truppe());
        lblTrubbeMale.setText("Truppe del Male: "+model.getNum_truppe());
        
        bene_rimasto = model.getNum_truppe();
        male_rimasto = model.getNum_truppe();
        this.stackPane = stackPane;

    }

    @FXML
    private void handleAvvia(ActionEvent event) {
        int rc = model.getDim_campo();
        
        boolean eroe = model.iniziaGioco();
        
        if(eroe){
            lblTrubbeBene.setText("Truppe del Bene: "+(model.getNum_truppe()-1)+" + 1 eroe");
            lblTrubbeMale.setText("Truppe del Male: "+(model.getNum_truppe()-1)+" + 1 eroe");
        }
        this.campo = model.getCampo();
        
        if(rc == 6) x = 2;
        if(rc == 8) x = 1;
        if(rc == 10) offset = 45;
        if(rc == 8) offset = 60;
        
        for(int i=0;i<rc;i++)
        {
            for(int j=0;j<rc;j++)
            {
                image = new ImageView(campo[i][j].getMiniAsset());
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
                        if(b.getClass().getSimpleName().equals("Eroe")){
                            Eroe e = (Eroe) b;
                            nomeTruppa.setText(""+e.getNome().toUpperCase()+": "+b.getSchieramento());
                            lblEsperienza.setText(lblEsperienza.getText()+"\nVitalità: "+e.getEnergiaVitale());
                        }
                    }
                });
                
                campo[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(model.getSfxOnOff()){
                            Sfx sfx= new Sfx();
                            sfx.start();
                        }
                    }
                    
                });
                griglia_campo.add(campo[i][j], j+x, i+x);
                campo[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
        }
        btnAvvia.setVisible(false);
        btnAvanza.setVisible(true);
        apriChiudLog.setVisible(true);
        lblTrubbeBene.setVisible(true);
        lblTrubbeMale.setVisible(true);
        nomeTruppa.setVisible(true);
        lblForza.setVisible(true);
        lblEsperienza.setVisible(true);
    }

    @FXML
    private void sfxPlay(MouseEvent event) {
        if(model.getSfxOnOff()){
            Sfx sfx = new Sfx();
            sfx.start();
        }
    }

    @FXML
    private void avanza(ActionEvent event) throws InterruptedException, IOException {
        listaAttacchi = model.attacco();
        if(bene_rimasto == 0) {
            btnAvanza.setDisable(true);
            model.setVincitore("male");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VittoriaSconfitta.fxml"));
            Parent root = loader.load();
            Scene scene = btnAvanza.getScene();
            VittoriaSconfittaController controller = loader.getController();
            controller.setModel(model, stackPane, scenaGioco);

            root.translateYProperty().set(0-scene.getHeight());
            stackPane.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
            
        }else if(male_rimasto == 0) {
            btnAvanza.setDisable(true);
            model.setVincitore("bene");
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VittoriaSconfitta.fxml"));
            Parent root = loader.load();
            Scene scene = btnAvanza.getScene();

            VittoriaSconfittaController controller = loader.getController();
            controller.setModel(model, stackPane, scenaGioco);

            root.translateYProperty().set(0-scene.getHeight());
            stackPane.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        }
        
        if(!listaAttacchi.isEmpty()){
            for(int i=0; i<listaAttacchi.size(); i++){
                if(i%2 == 1){
                    if(listaAttacchi.get(i).getSchieramento().equals("bene")) bene_rimasto--;
                    else male_rimasto--;
                }
            }
            indexBattaglie++;

            areaLog.appendText("============\n");
            areaLog.appendText("BATTAGLIA "+indexBattaglie+"\n");
            for(int i=0; i<listaAttacchi.size(); i++) {
                if(i % 2 == 1){
                    ImageView death = new ImageView(graveStone);
                    death.setFitHeight(offset);
                    death.setPreserveRatio(true);
                    campo[listaAttacchi.get(i).getRiga()][listaAttacchi.get(i).getColonna()].setGraphic(death);
                    areaLog.appendText(listaAttacchi.get(i).getClass().getSimpleName() + " ha combattuto con "+listaAttacchi.get(i-1).getClass().getSimpleName()+"\n");
                    areaLog.appendText("Vince "+listaAttacchi.get(i-1).getClass().getSimpleName()+" ("+listaAttacchi.get(i-1).getForza_di_combattimento()+" contro "+listaAttacchi.get(i).getForza_di_combattimento()+")\n");
                }
            }

        }else{
            model.resetHaCombattuto();            
            griglia_campo.getChildren().clear();
            
            for(int i=0; i<campo.length; i++){
                for(int j=0; j<campo.length; j++){
                    if(campo[i][j].isMorto()) {
                        campo[i][j] = new Vuoto();
                        ImageView image2 = new ImageView(new Image("file:resources/img/empty.png"));
                        image2.setPreserveRatio(true);
                        image2.setFitHeight(offset);
                        campo[i][j].setGraphic(image2);
                        campo[i][j].setBackground(Background.EMPTY);

                        campo[i][j].setOnAction(new EventHandler<ActionEvent>() {

                            public void handle(ActionEvent event) {
                                Entita b=(Entita)event.getSource();
                                nomeTruppa.setText(b.getClass().getSimpleName().toUpperCase());
                                imgTruppa.setImage(b.getImage());
                                lblForza.setText("");
                                lblEsperienza.setText("");
                            }
                        });

                        campo[i][j].setOnMouseEntered(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if(model.getSfxOnOff()){
                                    Sfx sfx= new Sfx();
                                    sfx.start();
                                }
                            }

                        });
                        campo[i][j].getStyleClass().add("cornice");
                        griglia_campo.add(campo[i][j], j+x, i+x);
                    }else {
                        image = new ImageView(campo[i][j].getMiniAsset());
                        image.setPreserveRatio(true);
                        image.setFitHeight(offset);
                        campo[i][j].setGraphic(image);
                        campo[i][j].setBackground(Background.EMPTY);
                        griglia_campo.add(campo[i][j], j+x, i+x);
                    }
                }
            }
            model.movimento();
            griglia_campo.getChildren().clear();
            
            for(int i=0; i<model.getDim_campo(); i++){
                for(int j=0; j<model.getDim_campo(); j++){
                    image = new ImageView(campo[i][j].getMiniAsset());
                    image.setPreserveRatio(true);
                    image.setFitHeight(offset);
                    campo[i][j].setGraphic(image);
                    campo[i][j].setBackground(Background.EMPTY);
                    campo[i][j].getStyleClass().add("cornice");
                    griglia_campo.add(campo[i][j], j+x, i+x);
                }
            }
        }
        
        lblTrubbeBene.setText("Truppe del bene: "+bene_rimasto);
        lblTrubbeMale.setText("Truppe del male: "+male_rimasto);
        
    }
}