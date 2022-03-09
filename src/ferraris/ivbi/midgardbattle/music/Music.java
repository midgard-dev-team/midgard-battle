
package ferraris.ivbi.midgardbattle.music;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Enrico
 */
public class Music {
    private String soundtrack_path = "resources/music/soundtrack.mp3";
    private String sfx_path = "resources/music/hover_sfx.mp3";
    public MediaPlayer st = new MediaPlayer(new Media(Paths.get(soundtrack_path).toUri().toString()));
    public MediaPlayer sfx = new MediaPlayer(new Media(Paths.get(sfx_path).toUri().toString()));

    public void soundtrack_play(){
        st.play();
        st.setVolume(0.1);
    }
    
    public void soundtrack_mute(){
        st.setMute(true);
    }
    
    public void soundtrack_unmute(){
        st.setMute(false);
    }
    
    public void sfx(){
        sfx.play();
    }
}
