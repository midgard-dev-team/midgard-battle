/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferraris.ivbi.midgardbattle.entita.bene;

import ferraris.ivbi.midgardbattle.entita.Entita;
import javafx.scene.image.Image;

public class Uomo extends Entita {
    
    private final Image img = new Image("file:resources/img/truppe-bene/umano.png");
    private final Image mini = new Image("file:resources/img/mini-assets/uomo.png");

    public Uomo() {
        super();
        setSchieramento("bene");
    }

    @Override
    public int calcola_forza() {
        setForza_di_combattimento(30+(6*getEsperienza_combattimento()));
        return 30+(6*getEsperienza_combattimento());
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