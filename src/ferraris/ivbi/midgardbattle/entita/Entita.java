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

    public Entita() {
        Random r=new Random();
        this.esperienza_combattimento = r.nextInt(10)+1;
        this.forza_di_combattimento = 0;
        this.haconbattuto = false;
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
    
    public void movimento(Entita[][] campo){
        
        for(int i=0;i<campo.length;i++){
            for(int j=0;j<campo.length;j++){
                if(campo.getClass().getSimpleName().equals("Vuoto")) continue;
                else{
                    
                    if(campo[i][j].getRiga()<campo.length/2 && campo[i][j].getColonna()<campo.length/2){
                            if(!campo[getRiga()+1][getColonna()+1].getClass().getSimpleName().equals("Vuoto")) return;
                                campo[getRiga()+1][getColonna()+1]=campo[i][j];
                                campo[i][j].setRiga(i+1);
                                campo[i][j].setColonna(j+1);
                                
                    }else if(this.getRiga()>=campo.length/2 && this.getColonna()>=campo.length/2){
                        
                        if(!campo[getRiga()-1][getColonna()-1].getClass().getSimpleName().equals("Vuoto")) return;
                            campo[getRiga()-1][getColonna()-1]=campo[i][j];
                            campo[i][j].setRiga(i-1);
                            campo[i][j].setColonna(j-1);
                            
                    }else if(this.getRiga()<campo.length/2 && this.getColonna()>=campo.length/2){
                        
                        if(!campo[getRiga()+1][getColonna()-1].getClass().getSimpleName().equals("Vuoto")) return;
                            campo[getRiga()+1][getColonna()-1]=campo[i][j];
                            campo[i][j].setRiga(i+1);
                            campo[i][j].setColonna(j-1);
                            
                    }else if(this.getRiga()>=campo.length/2 && this.getColonna()<campo.length/2){
                        
                        if(!campo[getRiga()-1][getColonna()+1].getClass().getSimpleName().equals("Vuoto")) return;
                            campo[getRiga()-1][getColonna()+1]=campo[i][j];
                            campo[i][j].setRiga(i-1);
                            campo[i][j].setColonna(j+1);
                    }
                }
            }
        }
        
        /*if(this.getRiga()<campo.length/2 && this.getColonna()<campo.length/2){
            if(campo[getRiga()+1][getColonna()+1].isPiazzato()) return;
            campo[getRiga()+1][getColonna()+1].setPiazzato(true);
        }else if(this.getRiga()>=campo.length/2 && this.getColonna()>=campo.length/2){
            if(campo[getRiga()-1][getColonna()-1].isPiazzato()) return;
            campo[getRiga()-1][getColonna()-1].setPiazzato(true);
        }else if(this.getRiga()<campo.length/2 && this.getColonna()>=campo.length/2){
            if(campo[getRiga()+1][getColonna()-1].isPiazzato()) return;
            campo[getRiga()+1][getColonna()-1].setPiazzato(true);
        }else if(this.getRiga()>=campo.length/2 && this.getColonna()<campo.length/2){
            if(campo[getRiga()-1][getColonna()+1].isPiazzato()) return;
            campo[getRiga()-1][getColonna()+1].setPiazzato(true);
        }*/
    
    }
}