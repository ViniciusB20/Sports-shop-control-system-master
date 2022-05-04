package model;

public class Balanco {
    
    private int id;
    //private int id_categoria;
    private Meses meses;
    private String ano;
    private double montante;

    public Balanco() {
    }

    public Balanco(int id,Meses meses, String ano, double montante) {
        this.id = id;
        this.meses = meses;
        this.ano = ano;
        this.montante = montante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meses getMeses() {
        return meses;
    }

    public void setMeses(Meses meses) {
        this.meses = meses;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    @Override
    public String toString() {
        return ano;
    }
    
}

