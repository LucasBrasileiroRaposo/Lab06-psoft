import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ControllerVacinacao {

    private HashMap <String, Paciente> pacientesCadastrados = new HashMap<>();
    private VerificaHabilitacaoParaVacina verificaHabilitacaoParaVacina = new VerificaHabilitacaoParaVacina();

    public void cadastrarPaciente(String nome, String cpf, String endereco, String numeroSUS, String email, String telefone, String profissão, ArrayList<String> comorbidades, int idade){

        if(this.verificaHabilitacaoParaVacina.checaHabilitacaoPrimeiraDose(profissão,comorbidades,idade)){

            Paciente p = this.pacientesCadastrados.get(cpf);
            this.pacientesCadastrados.get(cpf).getSituacao().habilitar(p);

        }
    }

    public void cadastrarPaciente(Paciente paciente) {

        this.pacientesCadastrados.put(paciente.getCpf(),paciente);

        if(this.verificaHabilitacaoParaVacina.checaHabilitacaoPrimeiraDose(paciente.getProfissão(),paciente.getComorbidades(),paciente.getIdade())){

            paciente.getSituacao().habilitar(paciente);

        }
    }
    public void alterarPaciente(String cpfPaciente, String campoASerAlterado, String novoValor){

        if(campoASerAlterado.equalsIgnoreCase("nome")){

            this.pacientesCadastrados.get(cpfPaciente).setNome(novoValor);

        }else if(campoASerAlterado.equalsIgnoreCase("comorbidades")){

            if(this.pacientesCadastrados.get(cpfPaciente).getComorbidades().contains("nada") || this.pacientesCadastrados.get(cpfPaciente).getComorbidades().contains("nenhuma")){

                this.pacientesCadastrados.get(cpfPaciente).getComorbidades().clear();

            }
            this.pacientesCadastrados.get(cpfPaciente).getComorbidades().add(novoValor);

        }else if(campoASerAlterado.equalsIgnoreCase("endereco")){

            this.pacientesCadastrados.get(cpfPaciente).setEndereco(novoValor);

        }else if(campoASerAlterado.equalsIgnoreCase("telefone")){

            this.pacientesCadastrados.get(cpfPaciente).setTelefone(novoValor);

        }else if (campoASerAlterado.equalsIgnoreCase("profissao")){

            this.pacientesCadastrados.get(cpfPaciente).setProfissão(novoValor);

        }else if (campoASerAlterado.equalsIgnoreCase("email")){

            this.pacientesCadastrados.get(cpfPaciente).setEmail(novoValor);

        }
    }

    public void habilitaVacinacao(String requisito, String grupoPessoas){

        if(requisito.equalsIgnoreCase("idade")){

            this.verificaHabilitacaoParaVacina.adicionaIdade(Integer.parseInt(grupoPessoas));

        }else if(requisito.equalsIgnoreCase("profissao")){

            this.verificaHabilitacaoParaVacina.adicionaProfissao(grupoPessoas);

        }else if(requisito.equalsIgnoreCase("comorbidade")){

            this.verificaHabilitacaoParaVacina.adicionaComorbidade(grupoPessoas);

        }
        for(Paciente p : this.pacientesCadastrados.values()){

            if (this.verificaHabilitacaoParaVacina.checaHabilitacaoPrimeiraDose(p.getProfissão(),p.getComorbidades(),p.getIdade())) {

                p.getSituacao().habilitar(p);
            }
        }

    }
    public void realizaVacinacaoPrimeiraDose(String date){

        for(Paciente paciente: this.pacientesCadastrados.values()){

            if(paciente.getSituacao() instanceof Habilitado1Dose){

                paciente.getSituacao().vacinar(paciente,date);

            }
        }
    }
    public void habilitaVacinacaoSegundaDose(String cpfPaciente, String dataParaSegundaDose){

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        long diasDiferenca = 0;
        try {
            Date data1 = data.parse(this.pacientesCadastrados.get(cpfPaciente).getDataPrimeiraDose());
            Date data2 = data.parse(dataParaSegundaDose);

            long diff = data2.getTime() - data1.getTime();
            diasDiferenca = TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(diasDiferenca > 20){

            Paciente aux = this.pacientesCadastrados.get(cpfPaciente);
            aux.getSituacao().habilitarSegundaDose(aux,dataParaSegundaDose);

        }
    }
    public void realizaVacinacaoSegundaDose(){

        for(Paciente paciente : this.pacientesCadastrados.values()){

            if(paciente.getSituacao() instanceof Habilitado2Dose){

                paciente.getSituacao().vacinarSegundaDose(paciente);

            }
        }
    }
    public VerificaHabilitacaoParaVacina getVerificaHabilitacaoParaVacina(){
        return this.verificaHabilitacaoParaVacina;
    }

}
