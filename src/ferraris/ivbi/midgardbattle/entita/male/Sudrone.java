
package ferraris.ivbi.midgardbattle.entita.male;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Sudrone extends Entita{
    
    private final Image img = new Image("file:resources/img/truppe-male/sudrone.png");
    private final Image mini = new Image("file:resources/img/mini-assets/sudrone.png");

    public Sudrone() {
        super();
        setSchieramento("male");
    }

    @Override
    public int calcola_forza() {
        setForza_di_combattimento(40+(5*getEsperienza_combattimento()));
        return 40+(5*getEsperienza_combattimento());
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
