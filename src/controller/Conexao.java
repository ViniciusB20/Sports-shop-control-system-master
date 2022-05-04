package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "127.0.0.1";
    private static final  String PORTA = "5433";
    private static final  String USUARIO = "postgres";
    private static final  String SENHA = "828622";
    private static final  String BANCO = "MVPEsportes";
    
    public static Connection conectar(){
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://" + URL + ":" + PORTA + "/" + BANCO,
                USUARIO, SENHA
            );
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public static void desconectar(Connection con){
        try {
            con.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        //Teste de CONEXÃO com o banco de dados
        Connection con = conectar();
        if (con != null){
            System.out.println("Conexão realizada com sucesso!");
        }
    }    
    
}
