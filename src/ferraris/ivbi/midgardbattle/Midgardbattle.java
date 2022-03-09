/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package ferraris.ivbi.midgardbattle;

import ferraris.ivbi.midgardbattle.music.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Utente
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
        
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
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
    
    public Music getMusic(){
        return this.music;
    }
    
}
