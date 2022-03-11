
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
import javafx.application.Application;
import javafx.stage.Stage;

public class Model extends Application{
    //settings
    private boolean music_toggle = true;
    private int dim_campo = 6;
    private int num_truppe = 6;
    private Entita[][] campo;
    
    public void iniziaGioco(){
        this.campo = new Entita[dim_campo][dim_campo];
        
        for(int i=0;i<dim_campo;i++){
            for(int j=0;j<dim_campo;j++){
                this.campo[i][j]= new Vuoto();
            }
        }
        
        int r,c;
        int range;
        //Forze bene
        for(int i=0;i<dim_campo;i++){
            range=(int) (Math.random() * 100);
            do{
                r=(int) (Math.random() * campo.length);
                c=(int) (Math.random() * campo.length);
            }while(!campo[r][c].getClass().getSimpleName().equals("Vuoto"));
            if(range<24) campo[r][c]=new Uomo();
            else if(range<48) campo[r][c]=new Elfo();
            else if(range<72) campo[r][c]=new Nano();
            else if(range<96) campo[r][c]=new Hobbit();
            //else campo[r][c]=new Eroe();
        }
        
        //Forze male
        for(int i=0;i<dim_campo;i++){
            range=(int) (Math.random() * 100);
            do{
                r=(int) (Math.random() * campo.length);
                c=(int) (Math.random() * campo.length);
            }while(!campo[r][c].getClass().getSimpleName().equals("Vuoto"));
            if(range<32) campo[r][c]=new Orco();
            else if(range<64) campo[r][c]=new Urukhai();
            else if(range<96) campo[r][c]=new Sudrone();
            //else campo[r][c]=new Eroe();
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        int grandezza=IOSERVIZIO.inserisciIntero("Inserisci la grandezza del campo: ");
        Campo c = new Campo(grandezza);
        c.popolaCampoInteri();
        c.popolaCampoEntita(grandezza);
    }
    
    
}
