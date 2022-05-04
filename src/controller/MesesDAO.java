package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Meses;

/*
    DAO = Data Access Object
    Objeto de acesso a dados utilzado para concentrar todas
    as operações relativas à uma tabela do SGBD.
*/
public class MesesDAO {
    
    private final Connection con;   // realizar a conexão com o SGBD
    private PreparedStatement cmd;  // enviar instruções SQL para o SGBD
    
    public MesesDAO(){
        // estabelecer uma conexão com SGBD.
        this.con = Conexao.conectar();
    }
    
    
    public List<Meses> listar(){
        try {
            String SQL = "SELECT * FROM tb_meses ORDER BY nome";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //Executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Meses> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Meses(
                        rs.getInt("id"),
                        rs.getString("nome")
                    )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public Meses pesquisarPorId(int id){
        try {
            String SQL = "SELECT * FROM tb_meses WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1,id);
            
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                return new Meses(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }

}
