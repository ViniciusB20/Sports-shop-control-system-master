package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Meses;
import model.Balanco;

public class BalancoDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public  BalancoDAO() {
        this.con = Conexao.conectar();
    }

    public int inserir(Balanco p) {
        try {
            String SQL = "INSERT INTO tb_balanco (id_meses,"
                    + "ano,montante) VALUES (?,?,?)";

            cmd = con.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            cmd.setInt(1, p.getMeses().getId());
            cmd.setString(2, p.getAno());
            cmd.setDouble(3, p.getMontante());

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

    public int atualizar(Balanco p) {
        try {
            String SQL = "UPDATE tb_balanco SET id_meses=?,"
                    + "ano=?,montante=? WHERE id = ?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, p.getMeses().getId());
            cmd.setString(2, p.getAno());
            cmd.setDouble(3, p.getMontante());
            cmd.setInt(4, p.getId());

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
            String SQL = "DELETE FROM tb_balanco WHERE id = ?";
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

    public List<Balanco> listar() {
        try {
            //String SQL = "SELECT * FROM tb_produto ORDER BY id";
            String SQL = "SELECT p.*, c.ano as meses FROM tb_balanco as p INNER JOIN tb_meses as c ON (p.id_meses = c.id) ORDER BY id";

            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Balanco> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Balanco(
                                rs.getInt("id"),
                                new Meses(rs.getInt("id_meses"), rs.getString("meses")),
                                rs.getString("ano"),
                                rs.getDouble("montante")
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

    public List<Balanco> pesquisarPorNome(String nome) {
        try {
            //String SQL = "SELECT * FROM tb_produto WHERE nome ILIKE ? ORDER BY nome";
            String SQL = "SELECT p.*, c.ano as meses FROM tb_balanco as p INNER JOIN tb_meses as c ON (p.id_meses = c.id) WHERE p.ano ILIKE ? ORDER BY ano";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Balanco> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Balanco(
                                rs.getInt("id"),
                                new Meses(rs.getInt("id_meses"), rs.getString("meses")),
                                rs.getString("ano"),
                                rs.getDouble("montante")
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

    public List<Balanco> pesquisarPorId(int id) {
        try {
            String SQL = "SELECT p.*, c.ano as meses FROM tb_balanco as p INNER JOIN tb_meses as c ON (p.id_meses = c.id) WHERE p.id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Balanco> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Balanco(
                                rs.getInt("id"),
                                new Meses(rs.getInt("id_meses"), rs.getString("meses")),
                                rs.getString("ano"),
                                rs.getDouble("montante")
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
