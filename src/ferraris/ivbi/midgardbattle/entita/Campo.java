/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferraris.ivbi.midgardbattle.entita;

import ferraris.ivbi.midgardbattle.entita.male.Sudrone;
import ferraris.ivbi.midgardbattle.entita.male.Orco;
import ferraris.ivbi.midgardbattle.entita.male.Urukhai;
import ferraris.ivbi.midgardbattle.entita.bene.Nano;
import ferraris.ivbi.midgardbattle.entita.bene.Uomo;
import ferraris.ivbi.midgardbattle.entita.bene.Hobbit;
import ferraris.ivbi.midgardbattle.entita.bene.Elfo;

public class Campo {
    private Entita[][] campo;
    private int[][] campoInteri;

    public Campo(int grandezza) {
        this.campo = new Vuoto[grandezza][grandezza];
        this.campoInteri = new int[grandezza][grandezza];
    }

    public Entita[][] getCampo() {
        return campo;
    }

    public int[][] getCampoInteri() {
        return campoInteri;
    }
    
    public void popolaCampoInteri(){
        for(int i=0;i<campoInteri.length;i++){
            for(int j=0;j<campoInteri.length;j++){
                campoInteri[i][j]=0;
            }
        }
    }
    
    public void popolaCampoEntita(int g){
        for(int i=0;i<g;i++){
            for(int j=0;j<g;j++){
                this.campo[i][j]= new Vuoto();
            }
        }

    }
    
    public void generaEntita(int num){
        int r,c;
        int range;
        //Forze bene
        for(int i=0;i<num;i++){
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
        for(int i=0;i<num;i++){
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
    
}
