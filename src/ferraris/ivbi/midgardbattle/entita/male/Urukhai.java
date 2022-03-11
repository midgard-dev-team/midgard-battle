
package ferraris.ivbi.midgardbattle.entita.male;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Urukhai extends Entita{
    
    private final Image img = new Image("file:resources/img/truppe-male/urukhai.png");
    private final Image mini = new Image("file:resources/img/mini-assets/urukhai.png");

    public Urukhai() {
        super();
        setSchieramento("male");
    }

    @Override
    public int calcola_forza() {
        setForza_di_combattimento(50+(5*getEsperienza_combattimento()));
        return 50+(5*getEsperienza_combattimento());
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
