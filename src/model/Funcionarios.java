package model;

public class Funcionarios {
    
    private int id;
    //private int id_categoria;
    private Funcao funcao;
    private String nome;
    private double salario;
    

    public Funcionarios() {
    }

    public Funcionarios(int id, Funcao funcao, String nome, double salario) {
        this.id = id;
        this.funcao = funcao;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}


