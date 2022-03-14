
package ferraris.ivbi.midgardbattle.model;

import ferraris.ivbi.midgardbattle.entita.Campo;
import ferraris.ivbi.midgardbattle.entita.bene.Elfo;
import ferraris.ivbi.midgardbattle.entita.Entita;
import ferraris.ivbi.midgardbattle.entita.bene.Hobbit;
import ferraris.ivbi.midgardbattle.entita.bene.Nano;
import ferraris.ivbi.midgardbattle.entita.male.Orco;
import ferraris.ivbi.midgardbattle.entita.male.Sudrone;
import ferraris.ivbi.midgardbattle.entita.bene.Uomo;
import ferraris.ivbi.midgardbattle.entita.male.Urukhai;
import ferraris.ivbi.midgardbattle.entita.Vuoto;
import ferraris.ivbi.midgardbattle.entita.eroe.Eroe;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Model extends Application{
    //impostazioni
    private boolean music_toggle = true;
    private int dim_campo = 6;
    private int num_truppe = 6;
    private boolean sfxOnOff = true;
    //
    private String bet;
    private String vincitore;
    
    private Entita[][] campo;
    private final Eroe[] eroi_bene = {
        new Eroe(new Image("file:resources/img/eroi/elrond.png"), new Image("file:resources/img/mini-assets/elrond.png"), "bene", "Elrond"),
        new Eroe(new Image("file:resources/img/eroi/aragorn.png"), new Image("file:resources/img/mini-assets/aragorn.png"), "bene", "Aragorn"),
        new Eroe(new Image("file:resources/img/eroi/gandalf.png"), new Image("file:resources/img/mini-assets/gandalf.png"), "bene", "Gandalf")
    };
    
    private final Eroe[] eroi_male = {
        new Eroe(new Image("file:resources/img/eroi/sauron.png"), new Image("file:resources/img/mini-assets/sauron.png"), "male", "Sauron"),
        new Eroe(new Image("file:resources/img/eroi/saruman.png"), new Image("file:resources/img/mini-assets/saruman.png"), "male", "Saruman"),
        new Eroe(new Image("file:resources/img/eroi/nazgul.png"), new Image("file:resources/img/mini-assets/nazgul.png"), "male", "Nazgul")
    };
    
    private boolean spuntau = false;
    
    public boolean iniziaGioco(){
        this.campo = new Entita[dim_campo][dim_campo];
        
        for(int i=0;i<dim_campo;i++){
            for(int j=0;j<dim_campo;j++){
                this.campo[i][j] = new Vuoto();
            }
        }
        
        int r,c;
        int range;
        //Forze bene
        for(int i=0;i<num_truppe;i++){
            range=(int) (Math.random() * 100);
            do{
                r = (int) (Math.random() * campo.length);
                c = (int) (Math.random() * campo.length);
            }while(!campo[r][c].getClass().getSimpleName().equals("Vuoto"));
            if(range<24) {
                campo[r][c]=new Uomo();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(range<48) {
                campo[r][c]=new Elfo();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(range<72) {
                campo[r][c]=new Nano();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(range<96) {
                campo[r][c] = new Hobbit();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(spuntau == false) {
                int x = (int)(Math.random()*3);
                campo[r][c] = eroi_bene[x];
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
                spuntau = true;
            }
        }
        
        //Forze male
        int offset = 0;
        do{
            r=(int) (Math.random() * campo.length);
            c=(int) (Math.random() * campo.length);
        }while(!campo[r][c].getClass().getSimpleName().equals("Vuoto"));
        if(spuntau == true){
            offset = 1;
            int x = (int)(Math.random()*3);
            campo[r][c] = eroi_male[x];
            campo[r][c].setRiga(r);
            campo[r][c].setColonna(c);
        }
        for(int i=0; i<num_truppe-offset; i++){
            range=(int) (Math.random() * 100);
            do{
                r=(int) (Math.random() * campo.length);
                c=(int) (Math.random() * campo.length);
            }while(!campo[r][c].getClass().getSimpleName().equals("Vuoto"));
            
            if(range<33) {
                campo[r][c]=new Orco();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(range<66) {
                campo[r][c]=new Urukhai();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
            else if(range<100) {
                campo[r][c]=new Sudrone();
                campo[r][c].setRiga(r);
                campo[r][c].setColonna(c);
            }
        }
        
        for(int i=0; i<dim_campo; i++){
            for(int j=0; j<dim_campo; j++) this.campo[i][j].getStyleClass().add("cornice");
        }
        
        return spuntau;
    }
    
    public List<Entita> attacco() throws InterruptedException{
        List<Entita> lista = new ArrayList<>();
        for(int i=0;i<campo.length;i++){
            for(int j=0;j<campo.length;j++){
                if(campo[i][j].getClass().getSimpleName().equals("Vuoto")) continue;
                if(campo[i][j].isHaconbattuto()) continue;
                if(campo[i][j].getSchieramento().equals("bene")){
                    if(i!=0 && j!=0 && campo[i-1][j-1].getSchieramento().equals("male") && campo[i-1][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);         
                    }else if(i!=0 && campo[i-1][j].getSchieramento().equals("male") && campo[i-1][j].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=0 && j!=campo.length-1 && campo[i-1][j+1].getSchieramento().equals("male") && campo[i-1][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(j!=0 && campo[i][j-1].getSchieramento().equals("male") && campo[i][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(j!=campo.length-1 && campo[i][j+1].getSchieramento().equals("male") && campo[i][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && j!=0 && campo[i+1][j-1].getSchieramento().equals("male") && campo[i+1][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && campo[i+1][j].getSchieramento().equals("male") && campo[i+1][j].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && j!=campo.length-1 && campo[i+1][j+1].getSchieramento().equals("male") && campo[i+1][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                }else if(campo[i][j].getSchieramento().equals("male")){
                        if(i!=0 && j!=0 && campo[i-1][j-1].getSchieramento().equals("bene") && campo[i-1][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=0 && campo[i-1][j].getSchieramento().equals("bene") && campo[i-1][j].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=0 && j!=campo.length-1 && campo[i-1][j+1].getSchieramento().equals("bene") && campo[i-1][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i-1][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(j!=0 && campo[i][j-1].getSchieramento().equals("bene") && campo[i][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(j!=campo.length-1 && campo[i][j+1].getSchieramento().equals("bene") && campo[i][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && j!=0 && campo[i+1][j-1].getSchieramento().equals("bene") && campo[i+1][j-1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j-1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && campo[i+1][j].getSchieramento().equals("bene") && campo[i+1][j].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                    }else if(i!=campo.length-1 && j!=campo.length-1 && campo[i+1][j+1].getSchieramento().equals("bene") && campo[i+1][j+1].isHaconbattuto()==false){
                        Entita vet[]=duello(campo[i][j],campo[i+1][j+1]);
                        lista.add(vet[0]);
                        lista.add(vet[1]);
                        }
                    }
                }
            }
        } 
        return lista;
    }
    
    public Entita[] duello(Entita b,Entita m){
        b.setHaconbattuto(true);
        m.setHaconbattuto(true);
        Entita vet[] = new Entita[2];
        if(b.calcola_forza()> m.calcola_forza()){
            vet[0] = b;
            m.setMorto(true);
            vet[1] = m;
        }else if(m.calcola_forza() > b.calcola_forza()){
            vet[0] = m;
            b.setMorto(true);
            vet[1] = b;
        }else if(m.calcola_forza() == b.calcola_forza()){
            if(b.getEsperienza_combattimento() > m.getEsperienza_combattimento()){
                vet[0] = b;
                m.setMorto(true);
                vet[1] = m;
            }else if(b.getEsperienza_combattimento()< m.getEsperienza_combattimento()){
                vet[0] = m;
                b.setMorto(true);
                vet[1] = b;
            }else{
                vet[0] = b;
                m.setMorto(true);
                vet[1] = m;
            }
        }
        return vet;
    }
    
    public void resetHaCombattuto(){
        for(int i=0; i<campo.length; i++){
            for(int j=0;j<campo.length;j++){
                if(campo[i][j].getClass().getSimpleName().equals("Vuoto")) continue;
                campo[i][j].setHaconbattuto(false);
            }
        }
    }
    
    public void movimento(){
        for(int i=0; i<campo.length; i++){
            for(int j=0; j<campo.length; j++){
                campo[i][j].setSpostato(false);
            }
        }
        Entita temp = new Vuoto();
        for(int i=0; i<campo.length; i++){
            for(int j=0; j<campo.length; j++){
                if(campo[i][j].getClass().getSimpleName().equals("Vuoto")) continue;
                if(i < campo.length/2 && j < campo.length/2){
                    if(campo[i+1][j+1].getClass().getSimpleName().equals("Vuoto") && !campo[i][j].isSpostato()){
                        campo[i][j].setSpostato(true);
                        campo[i][j].setRiga(i+1);
                        campo[i][j].setColonna(j+1);

                        temp = campo[i+1][j+1];
                        campo[i+1][j+1] = campo[i][j];
                        campo[i][j] = temp;
                    }
                    
                    }else if(i >= campo.length/2 && j >= campo.length/2){
                        if(campo[i-1][j-1].getClass().getSimpleName().equals("Vuoto") && !campo[i][j].isSpostato()){
                            campo[i][j].setSpostato(true);
                            campo[i][j].setRiga(i-1);
                            campo[i][j].setColonna(j-1);

                            temp = campo[i-1][j-1];
                            campo[i-1][j-1] = campo[i][j];
                            campo[i][j] = temp;
                        }
                        
                    }else if(i < campo.length/2 && j >= campo.length/2){
                        if(campo[i+1][j-1].getClass().getSimpleName().equals("Vuoto") && !campo[i][j].isSpostato()){
                            campo[i][j].setSpostato(true);
                            campo[i][j].setRiga(i+1);
                            campo[i][j].setColonna(j-1);

                            temp = campo[i+1][j-1];
                            campo[i+1][j-1] = campo[i][j];
                            campo[i][j] = temp;
                            
                        }
                    }else if(i >= campo.length/2 && j < campo.length/2){
                        if(campo[i-1][j+1].getClass().getSimpleName().equals("Vuoto") && !campo[i][j].isSpostato()){
                            campo[i][j].setSpostato(true);
                            campo[i][j].setRiga(i-1);
                            campo[i][j].setColonna(j+1);

                            temp = campo[i-1][j+1];
                            campo[i-1][j+1] = campo[i][j];
                            campo[i][j] = temp;
                            
                        }

                }
            }
        }
    }
    public Entita[][] getCampo(){
        return campo;
    }
    
    public void setCampo(Entita[][] campo){
        this.campo = campo;
    }
    
    
    public boolean isMusic_toggle() {
        return music_toggle;
    }

    public void setMusic_toggle(boolean music_toggle) {
        this.music_toggle = music_toggle;
    }

    public int getDim_campo() {
        return dim_campo;
    }

    public void setDim_campo(int dim_campo) {
        this.dim_campo = dim_campo;
    }

    public int getNum_truppe() {
        return num_truppe;
    }

    public void setNum_truppe(int num_truppe) {
        this.num_truppe = num_truppe;
    }
    
    public void setSfxOnOff(boolean b){
        this.sfxOnOff = b;
    }
    
    public boolean getSfxOnOff(){
        return this.sfxOnOff;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        int grandezza=IO.inserisciIntero("Inserisci la grandezza del campo: ");
        Campo c = new Campo(grandezza);
        c.popolaCampoInteri();
        c.popolaCampoEntita(grandezza);
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }
    
    
}
