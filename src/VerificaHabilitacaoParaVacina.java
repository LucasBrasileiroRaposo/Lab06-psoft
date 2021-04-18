import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VerificaHabilitacaoParaVacina {

    private GruposHabilitados gruposHabilitados = new GruposHabilitados();

    
    public void adicionaIdade(int grupo) {

        this.gruposHabilitados.setIdadeLiberada(grupo);

    }

    public void adicionaProfissao(String grupo) {

        this.gruposHabilitados.getProfissoesLiberadas().add(grupo);

    }

    public void adicionaComorbidade(String grupo) {

        this.gruposHabilitados.getComorbidadesLiberadas().add(grupo);

    }
    public boolean checaHabilitacaoPrimeiraDose(String profissao, ArrayList<String> comorbidades, int idade){

        if (this.gruposHabilitados.checaSeEstaContido(profissao)){

            return true;

        }
        if(this.gruposHabilitados.checaSeEstaContidoDiferente(comorbidades)){

            return true;

        }
        if(idade >= this.gruposHabilitados.getIdadeLiberada() && this.gruposHabilitados.getIdadeLiberada() != 0){

            return true;

        }
        else {
            return false;
        }
    }
    public GruposHabilitados getGruposHabilitados(){

        return this.gruposHabilitados;

    }
}
