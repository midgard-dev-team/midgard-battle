
package ferraris.ivbi.midgardbattle.music;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music extends Thread{
    private String soundtrack_path = "resources/music/soundtrack.mp3";
    private String sfx_path = "resources/music/hover_sfx.mp3";
    private MediaPlayer st = new MediaPlayer(new Media(Paths.get(soundtrack_path).toUri().toString()));
    private MediaPlayer sfx = new MediaPlayer(new Media(Paths.get(sfx_path).toUri().toString()));

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
    
    public void sfx(){
        sfx.play();
    }
}
