import java.util.ArrayList;
import java.util.Collections;


public class Main {

        public static void main(String[]args){

            ControllerVacinacao controllerVacinacao = new ControllerVacinacao();

            Paciente a = new Paciente("lucas","1","abc","1","@","telefone","nada", new ArrayList<String>(Collections.singleton("nada")) ,20);
            Paciente b = new Paciente("carlos","2","def","2","@3","1","medico",new ArrayList<String>(Collections.singleton("obesidade")),20);
            Paciente c = new Paciente("carla","3","ghi","3","@1","2","atriz",new ArrayList<String>(Collections.singleton("nenhuma")), 30);
            Paciente e = new Paciente("gertrudes","5","ghi","5","#@#","9","aposentado",new ArrayList<String>(Collections.singleton("nenhuma")),65);

            /** TESTANDO O CADASTRO,ALTERAÇÃO E A HABILITAÇÃO PARA VACINAÇÃO DE DETERMINADOS GRUPOS DE PESSOAS
             */

            controllerVacinacao.cadastrarPaciente(a);
            controllerVacinacao.cadastrarPaciente(b);
            controllerVacinacao.cadastrarPaciente(c);
            controllerVacinacao.cadastrarPaciente(e);

            System.out.println("STATUS DOS PACIENTES NO INICIO \n");
            System.out.println(c.getSituacao().toString());
            System.out.println(b.getSituacao().toString());
            System.out.println(a.getSituacao().toString());
            System.out.println(e.getSituacao().toString());


            controllerVacinacao.alterarPaciente("3","comorbidades","asma");
            controllerVacinacao.habilitaVacinacao("profissao","medico");
            controllerVacinacao.habilitaVacinacao("comorbidade","asma");
            controllerVacinacao.habilitaVacinacao("idade","60");
            Paciente d = new Paciente("felipe","4","jkl","3","@#","120","medico",new ArrayList<String>(Collections.singleton("nenhuma")),40);
            controllerVacinacao.cadastrarPaciente(d);

            System.out.println("\nAPOS ALTERÇÃO DO PACIENTE C TESTANDO A MUDANÇA \n");
            System.out.println(c.getComorbidades().toString());

            System.out.println("\nGRUPOS HABILITADOS PARA PRIMEIRA DOSE\n");
            System.out.println("PROFISSOES: " + controllerVacinacao.getVerificaHabilitacaoParaVacina().getGruposHabilitados().getProfissoesLiberadas().toString());
            System.out.println("COMORBIDADES: " + controllerVacinacao.getVerificaHabilitacaoParaVacina().getGruposHabilitados().getComorbidadesLiberadas().toString());
            System.out.println("IDADE: " + controllerVacinacao.getVerificaHabilitacaoParaVacina().getGruposHabilitados().getIdadeLiberada());

            System.out.println("\nTESTE DOS PACIENTES QUE DEVEM ESTAR HABILITADOS PARA TOMAR PRIMEIRA DOSE (QUE DEVEM SER TODOS MENOS O PRIMEIRO)\n");
            System.out.println(a.getSituacao().toString());
            System.out.println(b.getSituacao().toString());
            System.out.println(c.getSituacao().toString());
            System.out.println(d.getSituacao().toString());
            System.out.println(e.getSituacao().toString());

            controllerVacinacao.realizaVacinacaoPrimeiraDose("08/04/2021");
            System.out.println("\nDATA DA APLICAÇÃO DA PRIMEIRA DOSE E PARA OS NÃO VACINADOS O VALOR DEVE SER NULO\n");
            System.out.println(a.getDataPrimeiraDose());
            System.out.println(b.getDataPrimeiraDose());
            System.out.println(c.getDataPrimeiraDose());
            System.out.println(d.getDataPrimeiraDose());
            System.out.println(e.getDataPrimeiraDose());
            System.out.println("\nSITUACAO DOS INDIVIDUOS QUE  TOMARAM A VACINA QUE DEVE ESTAR TOMOU1DOSE, MENOS A DO PRIMEIRO\n");
            System.out.println(a.getSituacao().toString());
            System.out.println(b.getSituacao().toString());
            System.out.println(c.getSituacao().toString());
            System.out.println(d.getSituacao().toString());
            System.out.println(e.getSituacao().toString());

            controllerVacinacao.habilitaVacinacaoSegundaDose("2","27/04/2021");
            controllerVacinacao.habilitaVacinacaoSegundaDose("3","28/04/2021");
            System.out.println("\nCHECA SE OS PACIENTE A E C CONTINUAM APENAS NA SITUACAO TOMOU1DOSE DEPOIS DE TER FALHADO NA CONDICAO DE TER QUE ESPERAR 20 DIAS PARA SEGUNDA DOSE\n");
            System.out.println(b.getSituacao().toString());
            System.out.println(c.getSituacao().toString());

            System.out.println("\nMOSTRA AS DATAS AGENDADAS PARA A SEGUNDA DOSES DOS PACIENTES \n");
            controllerVacinacao.habilitaVacinacaoSegundaDose("2","29/04/2021");
            controllerVacinacao.habilitaVacinacaoSegundaDose("3","01/05/2021");
            controllerVacinacao.habilitaVacinacaoSegundaDose("4","01/05/2021");
            controllerVacinacao.habilitaVacinacaoSegundaDose("5","01/05/2021");
            System.out.println(a.getDataSegundaDose());
            System.out.println(b.getDataSegundaDose());
            System.out.println(c.getDataSegundaDose());
            System.out.println(d.getDataSegundaDose());
            System.out.println(e.getDataSegundaDose());


            System.out.println("\nCHECA SE OS 4 PACIENTES ESTAO HABILITADOS PARA SEGUNDA DOSE E O PRIMEIRO NÃO\n");
            System.out.println(a.getSituacao().toString());
            System.out.println(b.getSituacao().toString());
            System.out.println(c.getSituacao().toString());
            System.out.println(d.getSituacao().toString());
            System.out.println(e.getSituacao().toString());


            controllerVacinacao.realizaVacinacaoSegundaDose();
            System.out.println("\nVERIFICA A FINALIZAÇÃO DA VACINA DOS 4 PACIENTE, MENOS O PRIMEIRO\n");
            System.out.println(a.getSituacao().toString());
            System.out.println(b.getSituacao().toString());
            System.out.println(c.getSituacao().toString());
            System.out.println(d.getSituacao().toString());
            System.out.println(e.getSituacao().toString());


    }
}