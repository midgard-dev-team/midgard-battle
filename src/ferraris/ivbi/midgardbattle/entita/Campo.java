
package ferraris.ivbi.midgardbattle.entita;

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
    
}
