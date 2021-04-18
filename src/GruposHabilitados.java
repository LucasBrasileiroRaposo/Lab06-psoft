import java.util.ArrayList;
import java.util.HashSet;

public class GruposHabilitados {

    private HashSet<String> profissoesLiberadas;
    private HashSet<String> comorbidadesLiberadas;
    private int idadeLiberada;

    public GruposHabilitados(){

        this.profissoesLiberadas = new HashSet<>();
        this.comorbidadesLiberadas = new HashSet<>();
        this.idadeLiberada = 0;
    }

    public boolean checaSeEstaContido(String valor) {

        return this.profissoesLiberadas.contains(valor);

    }
    public boolean checaSeEstaContidoDiferente(ArrayList<String> lista){

        boolean saida = false;

        for (String s : lista){

            if (this.comorbidadesLiberadas.contains(s)){

                saida = true;

            }
        }
        return saida;
    }

    public HashSet<String> getProfissoesLiberadas() {
        return profissoesLiberadas;
    }

    public void setProfissoesLiberadas(HashSet<String> profissoesLiberadas) {
        this.profissoesLiberadas = profissoesLiberadas;
    }

    public HashSet<String> getComorbidadesLiberadas() {
        return comorbidadesLiberadas;
    }

    public void setComorbidadesLiberadas(HashSet<String> comorbidadesLiberadas) {
        this.comorbidadesLiberadas = comorbidadesLiberadas;
    }

    public int getIdadeLiberada() {
        return idadeLiberada;
    }

    public void setIdadeLiberada(int idadeLiberada) {
        this.idadeLiberada = idadeLiberada;
    }
}
