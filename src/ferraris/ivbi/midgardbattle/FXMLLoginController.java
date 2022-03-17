
package ferraris.ivbi.midgardbattle;

import static ferraris.ivbi.midgardbattle.Midgardbattle.music;
import ferraris.ivbi.midgardbattle.model.Model;
import ferraris.ivbi.midgardbattle.music.Sfx;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Enrico
 */
public class FXMLLoginController implements Initializable {
    private Model model;
    @FXML private CheckBox checkBoxMusica;
    @FXML private AnchorPane rootPane;
    @FXML public StackPane stackPane;
    @FXML private Button btnSettings;
    @FXML private ImageView imgSpeaker;
    
    private Image mute = new Image("file:resources/img/mute.png");
    private Image unmute = new Image("file:resources/img/speaker.png");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgSpeaker.setImage(unmute);
        checkBoxMusica.setVisible(false);
    }    
    
    @FXML
    private void change(MouseEvent event) {
        if(checkBoxMusica.isSelected()){
            model.setMusic_toggle(false);
            music.soundtrack_mute();
            imgSpeaker.setImage(mute);
            checkBoxMusica.setSelected(false);
        }else{
            model.setMusic_toggle(true);
            music.soundtrack_unmute();
            imgSpeaker.setImage(unmute);
            checkBoxMusica.setSelected(true);
        }
    }

    @FXML
    private void handleSettings(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSettings.fxml"));
        Parent root = loader.load();
        Scene scene = btnSettings.getScene();
        FXMLSettingsController controller = loader.getController();
        controller.setModel(model);
        controller.setLoginController(this);
        
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void handleGioca(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSchieramento.fxml"));
        Parent root = loader.load();
        Scene scene = btnSettings.getScene();
        
        FXMLSchieramentoController controller = loader.getController();
        controller.setModel(model);
        controller.setStackPane(stackPane);
        
        root.translateYProperty().set(0-scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    
    public void setModel(Model m){
        this.model = m;
        checkBoxMusica.setSelected(model.isMusic_toggle());
        
    }
    
    public void setCheckBox(boolean b){
        checkBoxMusica.setSelected(b);
        if(b == false) imgSpeaker.setImage(mute);
        else imgSpeaker.setImage(unmute);
    }

    @FXML
    private void handleInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInfo.fxml"));
        Parent root = loader.load();
        Scene scene = btnSettings.getScene();
        
        FXMLInfoController controller = loader.getController();
        controller.setModel(stackPane);
        
        root.translateYProperty().set(0-scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void sfxPlay(MouseEvent event) {
        if(model.getSfxOnOff()){
            Sfx sfx = new Sfx();
            sfx.start();
        }
    }


}
