
package ferraris.ivbi.midgardbattle.music;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music{
    private String soundtrack_path = "resources/music/soundtrack.mp3";
    private MediaPlayer st = new MediaPlayer(new Media(Paths.get(soundtrack_path).toUri().toString()));

    public void soundtrack_play(){
        st.play();
        st.setVolume(1);
        st.setCycleCount(100);
    }
    
    public void soundtrack_mute(){
        st.setMute(true);
    }
    
    public void soundtrack_unmute(){
        st.setMute(false);
    }

}
