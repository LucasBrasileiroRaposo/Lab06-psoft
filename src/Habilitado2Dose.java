public class Habilitado2Dose extends Situacao{

    public void vacinarSegundaDose(Paciente paciente){

        paciente.setSituacao(new FinalizadaVacinacao());

    }

    @Override
    public String toString() {
        return "Habilitado2Dose";
    }
}
