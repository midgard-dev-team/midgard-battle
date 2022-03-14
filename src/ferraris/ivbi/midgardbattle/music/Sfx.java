
package ferraris.ivbi.midgardbattle.music;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sfx extends Thread {
    private final String sfx_path = "resources/music/hover_sfx.mp3";
    private final MediaPlayer sfx = new MediaPlayer(new Media(Paths.get(sfx_path).toUri().toString()));
    
    @Override
    public void run(){
        sfx.play();
        sfx.setVolume(0.3);
    }
    
}
