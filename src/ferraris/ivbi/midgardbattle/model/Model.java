
package ferraris.ivbi.midgardbattle.model;

/**
 *
 * @author Enrico
 */
public class Model {
    //settings
    private boolean music_toggle;
    private int dim_campo;
    private int num_truppe;
    
    //other

    //
    public boolean isMusic_toggle() {
        return music_toggle;
    }

    public void setMusic_toggle(boolean music_toggle) {
        this.music_toggle = music_toggle;
    }

    public int getDim_campo() {
        return dim_campo;
    }

    public void setDim_campo(int dim_campo) {
        this.dim_campo = dim_campo;
    }

    public int getNum_truppe() {
        return num_truppe;
    }

    public void setNum_truppe(int num_truppe) {
        this.num_truppe = num_truppe;
    }
    
    
}
