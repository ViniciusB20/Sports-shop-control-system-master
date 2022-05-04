package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Nivel;

/*
    DAO = Data Access Object
    Objeto de acesso a dados utilzado para concentrar todas
    as operações relativas à uma tabela do SGBD.
*/
public class NivelDAO {
    
    private final Connection con;   // realizar a conexão com o SGBD
    private PreparedStatement cmd;  // enviar instruções SQL para o SGBD
    
    public NivelDAO(){
        // estabelecer uma conexão com SGBD.
        this.con = Conexao.conectar();
    }
    
    
    public List<Nivel> listar(){
        try {
            String SQL = "SELECT * FROM tb_nivel ORDER BY nome";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //Executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Nivel> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Nivel(
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
    
    public Nivel pesquisarPorId(int id){
        try {
            String SQL = "SELECT * FROM tb_nivel WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1,id);
            
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                return new Nivel(
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
