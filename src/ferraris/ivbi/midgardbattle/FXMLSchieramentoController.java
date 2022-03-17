
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.model.Model;
import ferraris.ivbi.midgardbattle.music.Sfx;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class FXMLSchieramentoController implements Initializable {

    private Model model;
    private StackPane stackPane;
    
    @FXML private ImageView imgBene;
    @FXML private ImageView imgMale;
    @FXML private AnchorPane anchorPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgBene.getStyleClass().add("glow");
        imgMale.getStyleClass().add("glow");
    }
    
    public void setModel(Model model){
        this.model = model;
    }

    @FXML
    private void apriGiocoBene(MouseEvent event) throws IOException {
        model.setBet("bene");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGame.fxml"));
        Parent root = loader.load();
        Scene scene = imgBene.getScene();
        
        FXMLGameController controller = loader.getController();
        controller.setModel(model, stackPane);
        
        root.translateYProperty().set(0-scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }

    @FXML
    private void apriGiocoMale(MouseEvent event) throws IOException {
        model.setBet("male");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGame.fxml"));
        Parent root = loader.load();
        Scene scene = imgBene.getScene();
        
        FXMLGameController controller = loader.getController();
        controller.setModel(model, stackPane);
        
        root.translateYProperty().set(0-scene.getHeight());
        stackPane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();
    }
    
    
    public void setStackPane(StackPane s){
        this.stackPane = s;
    }

    @FXML
    private void sfx(MouseEvent event) {
        if(model.getSfxOnOff()){
            Sfx sfx= new Sfx();
            sfx.start();
        }
    }
}
