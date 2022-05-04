package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionarios;
import model.Funcao;

public class FuncionariosDAO {

    private final Connection con;
    private PreparedStatement cmd;

    public FuncionariosDAO() {
        this.con = Conexao.conectar();
    }

    public int inserir(Funcionarios p) {
        try {
            String SQL = "INSERT INTO tb_funcionario (id_funcao,"
                    + "nome,salario) VALUES (?,?,?)";

            cmd = con.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            cmd.setInt(1, p.getFuncao().getId());
            cmd.setString(2, p.getNome());
            cmd.setDouble(3, p.getSalario());

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

    public int atualizar(Funcionarios p) {
        try {
            String SQL = "UPDATE tb_funcionario SET id_funcao=?,"
                    + "nome=?,salario=? WHERE id = ?";

            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, p.getFuncao().getId());
            cmd.setString(2, p.getNome());
            cmd.setDouble(3, p.getSalario());
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
            String SQL = "DELETE FROM tb_funcionario WHERE id = ?";
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

    public List<Funcionarios> listar() {
        try {
            //String SQL = "SELECT * FROM tb_produto ORDER BY id";
            String SQL = "SELECT p.*, c.nome as funcao FROM tb_funcionario as p INNER JOIN tb_funcao as c ON (p.id_funcao = c.id) ORDER BY id";

            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Funcionarios> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Funcionarios(
                                rs.getInt("id"),
                                new Funcao(rs.getInt("id_funcao"), rs.getString("funcao")),
                                rs.getString("nome"),
                                rs.getDouble("salario")
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

    public List<Funcionarios> pesquisarPorNome(String nome) {
        try {
            //String SQL = "SELECT * FROM tb_produto WHERE nome ILIKE ? ORDER BY nome";
            String SQL = "SELECT p.*, c.nome as categoria FROM tb_funcionario as p INNER JOIN tb_funcao as c ON (p.id_categoria = c.id) WHERE p.nome ILIKE ? ORDER BY nome";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Funcionarios> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Funcionarios(
                                rs.getInt("id"),
                                new Funcao(rs.getInt("id_funcao"), rs.getString("funcao")),
                                rs.getString("nome"),
                                rs.getDouble("salario")
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

    public List<Funcionarios> pesquisarPorId(int id) {
        try {
            String SQL = "SELECT p.*, c.nome as funcao FROM tb_funcionario as p INNER JOIN tb_funcao as c ON (p.id_funcao = c.id) WHERE p.id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);

            //Executar a instrução
            ResultSet rs = cmd.executeQuery();

            List<Funcionarios> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(
                        new Funcionarios(
                                rs.getInt("id"),
                                new Funcao(rs.getInt("id_funcao"), rs.getString("funcao")),
                                rs.getString("nome"),
                                rs.getDouble("salario")
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
