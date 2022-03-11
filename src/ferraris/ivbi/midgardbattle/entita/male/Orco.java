
package ferraris.ivbi.midgardbattle.entita.male;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Orco extends Entita{
    
    private final Image img = new Image("file:resources/img/truppe-male/orco.png");
    private final Image mini = new Image("file:resources/img/mini-assets/orco.png");

    public Orco() {
        super();
        setSchieramento("male");
    }

    @Override
    public int calcola_forza() {
        int x = 0;
        if(getEsperienza_combattimento()<5) x = 30+(2*getEsperienza_combattimento());
        else x = 70+(3*getEsperienza_combattimento());
        
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
