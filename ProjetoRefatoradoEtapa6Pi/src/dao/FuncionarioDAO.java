/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author Juliano
 */
public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        //instrução sql
        String sql = "INSERT INTO funcionarios (nome, sexo, rg, email, telefone, cpf, dataNascimento) VALUES(?,?,?,?,?,?,?)";

        //tenta a conexao
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos    
            stmt.setString(1, f.getNome());
            stmt.setString(2, String.valueOf(f.getSexo()));
            stmt.setString(3, f.getRg());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getCpf());
            //conversao da data
            java.sql.Date dataSql = new java.sql.Date(f.getDataNascimento().getTime());
            stmt.setDate(7, dataSql);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o funcionario no Banco.",e);
        }
    }

    public void editar(Funcionario f) {
        //instrucao sql
        String sql = "UPDATE funcionarios SET nome = ?, sexo = ?, rg = ?, email = ?, telefone = ?, cpf = ?, dataNascimento = ? WHERE id = ?";

        //tenta conectar
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos
            stmt.setString(1, f.getNome());
            stmt.setString(2, String.valueOf(f.getSexo()));
            stmt.setString(3, f.getRg());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getCpf());
            //conversao da data
            java.sql.Date dataSql = new java.sql.Date(f.getDataNascimento().getTime());
            stmt.setDate(7, dataSql);
            //id do funcionario para identificar qual sera excluido
            stmt.setInt(8, f.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar o funcionario.",e);
        }
    }

    public void excluir(int idFuncionario) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o funcionário.",e);
        }
    }

    public List<Funcionario> listarTodos() {
        //instrucao sql que ira buscar os registros de funcionarios no banco
        String sql = "SELECT id, nome, sexo, rg, email, telefone, cpf, dataNascimento FROM funcionarios";

        List<Funcionario> lista = new ArrayList<>();

        try ( Connection conn = Conexao.conectar(); //tenta conectar com o banco
                  PreparedStatement stmt = conn.prepareStatement(sql); //prepara a instrucao sql que sera usada
                  ResultSet rs = stmt.executeQuery();) { // executa a consulta e armazena os resultados em rs

            while (rs.next()) {
                Funcionario f = new Funcionario();

                //mapeando os campos
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                //converte de char do banco pra String
                f.setSexo(rs.getString("sexo").charAt(0));
                f.setRg(rs.getString("rg"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setCpf(rs.getString("cpf"));
                f.setDataNascimento(rs.getDate("dataNascimento"));
                //adiciona na lista
                lista.add(f);
            }
        } catch (SQLException e) {
           throw new RuntimeException("Erro ao listar funcionarios.",e);
        }
        return lista;
    }

    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        Funcionario f = null;

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            //id que sera buscado
            stmt.setInt(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setSexo(rs.getString("sexo").charAt(0));
                    f.setRg(rs.getString("rg"));
                    f.setEmail(rs.getString("email"));
                    f.setTelefone(rs.getString("telefone"));
                    f.setCpf(rs.getString("cpf"));
                    f.setDataNascimento(rs.getDate("dataNascimento"));
                    
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o funcionario por id: ",e);

        }
        return f;
    }    
}
