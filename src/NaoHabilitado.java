public class NaoHabilitado extends Situacao{

    public void habilitar(Paciente paciente){

        paciente.setSituacao(new Habilitado1Dose());

    }

    @Override
    public String toString() {
        return "NaoHabilitado";
    }
}
