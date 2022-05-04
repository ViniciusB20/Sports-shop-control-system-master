package model;

public class Cliente{
    
    private int id;
    //private int id_categoria;
    private Nivel nivel;
    private String nome;
  

    public Cliente() {
    }

    public Cliente(int id,Nivel nivel, String nome) {
        this.id = id;
        this.nivel = nivel;
        this.nome = nome;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nivel getNivel(){
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}



