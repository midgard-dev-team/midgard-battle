
package ferraris.ivbi.midgardbattle.entita.bene;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Elfo extends Entita{
    
    private final Image img = new Image("file:resources/img/truppe-bene/elfo.png");
    private final Image mini = new Image("file:resources/img/mini-assets/elfo.png");

    
    public Elfo() {
        super();
        setSchieramento("bene");
    }

    @Override
    public int calcola_forza() {
        int x = 0;
        if(this.getEsperienza_combattimento()<5) x = 20+(3*getEsperienza_combattimento());
        else x = 80+(2*getEsperienza_combattimento());
        setForza_di_combattimento(x);
        return x;
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public Image getMiniAsset() {
        return mini;
    }
    
}
