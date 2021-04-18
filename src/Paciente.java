import java.util.ArrayList;
import java.util.Objects;

public class Paciente {

    private String nome;
    private String cpf;
    private String endereco;
    private String numeroSUS;
    private String email;
    private String telefone;
    private String profissão;
    private ArrayList<String> comorbidades;
    private int idade;
    private Situacao situacao;
    private String dataPrimeiraDose;
    private String dataSegundaDose;

    public Paciente(String nome, String cpf, String endereco, String numeroSUS, String email, String telefone, String profissão, ArrayList<String> comorbidades, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroSUS = numeroSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissão = profissão;
        this.comorbidades =  comorbidades;
        this.idade = idade;
        this.situacao = new NaoHabilitado();
        this.dataPrimeiraDose = null;
        this.dataSegundaDose = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroSUS() {
        return numeroSUS;
    }

    public void setNumeroSUS(String numeroSUS) {
        this.numeroSUS = numeroSUS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissão() {
        return profissão;
    }

    public void setProfissão(String profissão) {
        this.profissão = profissão;
    }

    public ArrayList<String> getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(ArrayList comorbidades) {
        this.comorbidades = comorbidades;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getDataPrimeiraDose(){return this.dataPrimeiraDose;}
    public void setDataPrimeiraDose(String data) {
        this.dataPrimeiraDose = data;
    }
    public String getDataSegundaDose(){return this.dataSegundaDose;}
    public void setDataSegundaDose(String data){this.dataSegundaDose = data;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return getNome().equals(paciente.getNome()) && getCpf().equals(paciente.getCpf()) && getNumeroSUS().equals(paciente.getNumeroSUS()) && getEmail().equals(paciente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf(), getNumeroSUS(), getEmail());
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numeroSUS='" + numeroSUS + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", profissão='" + profissão + '\'' +
                ", comorbidades=" + comorbidades +
                ", idade=" + idade +
                ", situacao=" + situacao +
                ", dataPrimeiraDose='" + dataPrimeiraDose + '\'' +
                ", dataSegundaDose='" + dataSegundaDose + '\'' +
                '}';
    }
}
