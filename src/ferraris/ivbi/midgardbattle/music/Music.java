
package ferraris.ivbi.midgardbattle.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music{
    private String soundtrack_path;
    private MediaPlayer st;

    public Music(String d){
        soundtrack_path = d + "/resources/music/soundtrack.mp3";
        st = new MediaPlayer(new Media(soundtrack_path));
    }

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
    
    public void setVolume(double x){
        st.setVolume(x);
    }

}
