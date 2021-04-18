public class Tomou1Dose extends Situacao{

    public void habilitarSegundaDose(Paciente paciente, String data) {

        paciente.setSituacao(new Habilitado2Dose());
        paciente.setDataSegundaDose(data);

    }

    @Override
    public String toString() {
        return "Tomou1Dose";
    }
}
