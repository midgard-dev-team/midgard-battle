
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.music.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Enrico
 */
public class Midgardbattle extends Application {
    
    public static Music music;
    @Override
    public void start(Stage stage) throws Exception {
        music = new Music();
        music.soundtrack_play();
        
        FXMLLoader loader  = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        FXMLLoginController controller = loader.getController();
        controller.setMusic(music);
        
        scene.getStylesheets().add(getClass().getResource("style/style.css").toExternalForm());
        
        Image icon = new Image("file:resources/icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Midgard Battle");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
