package model;

public class Estoque {
    
    private int id;
    //private int id_categoria;
    private Categoria categoria;
    private String nome;
    private double valorunitario;

    public Estoque() {
    }

    public Estoque(int id, Categoria categoria, String nome, double valorunitario) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.valorunitario = valorunitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(double valorunitario) {
        this.valorunitario = valorunitario;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}

