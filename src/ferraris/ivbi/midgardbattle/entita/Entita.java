package ferraris.ivbi.midgardbattle.entita;

import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public abstract class Entita extends Button {
    protected int esperienza_combattimento;
    protected int forza_di_combattimento;
    protected String schieramento;
    protected int riga;
    protected int colonna;
    protected Image image;
    protected Image miniAsset;
    protected boolean haconbattuto;
    protected boolean morto;
    protected boolean spostato;

    public Entita() {
        Random r=new Random();
        this.esperienza_combattimento = r.nextInt(10)+1;
        this.forza_di_combattimento = 0;
        this.haconbattuto = false;
        this.morto = false;
        this.spostato = false;
    }

    public boolean isSpostato() {
        return spostato;
    }

    public void setSpostato(boolean spostato) {
        this.spostato = spostato;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public boolean isHaconbattuto() {
        return haconbattuto;
    }

    public void setHaconbattuto(boolean haconbattuto) {
        this.haconbattuto = haconbattuto;
    }
    
    public abstract Image getImage();
    public abstract Image getMiniAsset();
    public abstract int calcola_forza();
        
    public int getForza_di_combattimento(){
        return this.forza_di_combattimento;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }    
    
    public int getEsperienza_combattimento() {
        return esperienza_combattimento;
    }

    public void setEsperienza_combattimento(int esperienza_combattimento) {
        this.esperienza_combattimento = esperienza_combattimento;
    }
    
    public void setForza_di_combattimento(int forza_di_combattimento) {
        this.forza_di_combattimento = forza_di_combattimento;
    }

    public String getSchieramento() {
        return schieramento;
    }

    public void setSchieramento(String schieramento) {
        this.schieramento = schieramento;
    }
    
    public void trovaNemico(Entita[][] campo){
        System.out.println("Da fare");
    }
    
}