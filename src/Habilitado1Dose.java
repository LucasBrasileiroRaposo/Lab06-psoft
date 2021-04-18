public class Habilitado1Dose extends Situacao{

    public void vacinar(Paciente paciente, String data) {

        paciente.setSituacao(new Tomou1Dose());
        paciente.setDataPrimeiraDose(data);

    }


    @Override
    public String toString() {
        return "Habilitado1Dose";
    }
}
