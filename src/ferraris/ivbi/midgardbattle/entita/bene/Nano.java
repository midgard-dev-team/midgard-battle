
package ferraris.ivbi.midgardbattle.entita.bene;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Nano extends Entita{
    
    private final Image img = new Image("file:resources/img/truppe-bene/nano.png");
    private final Image mini = new Image("file:resources/img/mini-assets/nano.png");

    public Nano() {
        super();
        setSchieramento("bene");
    }

    @Override
    public int calcola_forza() {
        setForza_di_combattimento(20+(4*getEsperienza_combattimento()));
        return 20+(4*getEsperienza_combattimento());
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
