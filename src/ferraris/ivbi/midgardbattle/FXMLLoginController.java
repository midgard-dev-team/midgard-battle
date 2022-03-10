
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.music.Music;
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
    private Music music;
    @FXML private CheckBox checkBoxMusica;
    @FXML private AnchorPane rootPane;
    @FXML private StackPane stackPane;
    @FXML private Button btnSettings;
    @FXML private ImageView imgSpeaker;
    
    private Image mute = new Image("file:resources/img/mute.png");
    private Image unmute = new Image("file:resources/img/speaker.png");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgSpeaker.setImage(unmute);
        checkBoxMusica.setSelected(true);
    }    
    
    public void setMusic(Music m){
        this.music = m;
    }
    
    @FXML
    public void change(ActionEvent event){
        if(checkBoxMusica.isSelected()){
            music.soundtrack_unmute();
            imgSpeaker.setImage(unmute);
        }else{
            music.soundtrack_mute();
            imgSpeaker.setImage(mute);
        }
    }

    private void handleSfx(MouseEvent event) {
        music.sfx();
    }

    @FXML
    private void handleSettings(ActionEvent event) throws IOException {
        /*AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLSettings.fxml"));
        rootPane.getChildren().setAll(pane);
        pane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        FXMLLoader loader  = new FXMLLoader(getClass().getResource("FXMLSettings.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        Stage stage = new Stage();
        
        Image icon = new Image("file:resources/icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Midgard Battle - Settings");
        stage.setScene(scene);
        stage.show();*/
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSettings.fxml"));
        Scene scene = btnSettings.getScene();
        
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
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGame.fxml"));
        Scene scene = btnSettings.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
}
