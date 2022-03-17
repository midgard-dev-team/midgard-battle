
package ferraris.ivbi.midgardbattle.entita.eroe;

import ferraris.ivbi.midgardbattle.entita.Entita;
import java.util.Random;
import javafx.scene.image.Image;

public class Eroe extends Entita{
    
    private Image img;
    private Image mini;
    private String nome;
    private int energia_vitale;
    
    public Eroe(Image img, Image mini, String schieramento, String nome){
        super();
        this.img = img;
        this.mini = mini;
        this.schieramento = schieramento;
        this.nome = nome;
        Random r=new Random();
        this.energia_vitale = r.nextInt(10)+1;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setImage(Image img){
        this.img = img;
    }
    
    public void setMiniImage(Image img){
        this.mini = img;
    }

    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public Image getMiniAsset() {
        return mini;
    }

    @Override
    public int calcola_forza() {
        return (50*esperienza_combattimento)+(50*energia_vitale);
    }
    
    public void setEnergiaVitale(int v){
        this.energia_vitale = v;
    }
    
    public int getEnergiaVitale(){
        return this.energia_vitale;
    }
    
}
