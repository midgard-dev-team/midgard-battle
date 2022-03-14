
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.model.Model;
import ferraris.ivbi.midgardbattle.music.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Midgardbattle extends Application {
    
    public static Music music;
    @Override
    public void start(Stage stage) throws Exception {
        music = new Music();
        music.soundtrack_play();
        
        FXMLLoader loader  = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Model model = new Model();
        FXMLLoginController controller = loader.getController();
        controller.setModel(model);
        
        scene.getStylesheets().add(getClass().getResource("style/style.css").toExternalForm());
        
        Image icon = new Image("file:resources/icon.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Midgard Battle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
