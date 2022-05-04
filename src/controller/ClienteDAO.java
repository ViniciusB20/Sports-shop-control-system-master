package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Nivel;


public class ClienteDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public ClienteDAO() {
        this.con = Conexao.conectar();
    }

    public int inserir(Cliente p) {
        try {
            String SQL = "INSERT INTO tb_fidelidade (id_nivel,"
                    + "nome) VALUES (?,?,?)";

            cmd = con.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            cmd.setInt(1, p.getNivel().getId());
            cmd.setString(2, p.getNome());

            if (cmd.executeUpdate() > 0) {
                //descobrir o ID que foi gerado
                ResultSet rs = cmd.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // Retornar o ID
                } else {
                    return -1;  // ID não foi gerado
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public int atualizar(Cliente p) {
        try {
            String SQL = "UPDATE tb_fidelidade SET id_nivel=?,"
                    + "nome=?, WHERE id = ?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, p.getNivel().getId());
            cmd.setString(2, p.getNome());
            cmd.setInt(3, p.getId());

            return (cmd.executeUpdate() > 0) ? p.getId() : -1;

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public int deletar(int id) {
        try {
            String SQL = "DELETE FROM tb_fidelidade WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            return (cmd.executeUpdate() > 0) ? id : -1;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public List<Cliente> listar() {
        try {
            //String SQL = "SELECT * FROM tb_produto ORDER BY id";
            String SQL = "SELECT p.*, c.nome as nivel FROM tb_fidelidade as p INNER JOIN tb_nivel as c ON (p.id_nivel = c.id) ORDER BY id";

            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getInt("id"),
                                new Nivel(rs.getInt("id_nivel"), rs.getString("nivel")),
                                rs.getString("nome")                
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public List<Cliente> pesquisarPorNome(String nome) {
        try {
            //String SQL = "SELECT * FROM tb_produto WHERE nome ILIKE ? ORDER BY nome";
            String SQL = "SELECT p.*, c.nome as nivel FROM tb_fidelidade as p INNER JOIN tb_nivel as c ON (p.id_nivel = c.id) WHERE p.nome ILIKE ? ORDER BY nome";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getInt("id"),
                                new Nivel(rs.getInt("id_nivel"), rs.getString("nivel")),
                                rs.getString("nome")                     
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public List<Cliente> pesquisarPorId(int id) {
        try {
            String SQL = "SELECT p.*, c.nome as nivel FROM tb_fidelidade as p INNER JOIN tb_nivelo as c ON (p.id_nivel = c.id) WHERE p.id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getInt("id"),
                                new Nivel(rs.getInt("id_nivel"), rs.getString("nivel")),
                                rs.getString("nome")
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.desconectar(con);
        }
    }

}
