package model;

public class Exame {
    private int codExame;
    private String tipo;
    private double valor;
    private String especialidade;

    public Exame(String tipo, double valor, String especialidade) {
        this.tipo = tipo;
        this.valor = valor;
        this.especialidade = especialidade;
    }

    public int getCodExame() {
        return codExame;
    }

    public void setCodExame(int codExame) {
        this.codExame = codExame;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

        
    
}
