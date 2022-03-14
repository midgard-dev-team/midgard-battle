
package ferraris.ivbi.midgardbattle.entita;

import javafx.scene.image.Image;


public class Vuoto extends Entita{

    private final Image img = new Image("file:resources/img/empty-land.png");
    private final Image mini = new Image("file:resources/img/empty.png");
    
    public Vuoto(){
        this.schieramento = "neutro";
    }
    
    @Override
    public int calcola_forza() {
        setForza_di_combattimento(0);
        return 0;
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
