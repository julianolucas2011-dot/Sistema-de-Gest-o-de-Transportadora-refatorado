/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Motorista;

/**
 *
 * @author Juliano
 */
public class MotoristaDAO {

    public void inserir(Motorista m) {
        //instrução sql
        String sql = "INSERT INTO motoristas (nome, cpf, rg, sexo, email, telefone, cnhCategoria, cnhEmissao, cnhNumero, endereco) VALUES(?,?,?,?,?,?,?,?,?,?)";

        //tenta a conexao
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos    
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getCpf());
            stmt.setString(3, m.getRg());
            stmt.setString(4, String.valueOf(m.getSexo()));
            stmt.setString(5, m.getEmail());
            stmt.setString(6, m.getTelefone());
            stmt.setString(7, m.getCnhCategoria());
            Date dataSql = new Date(m.getCnhEmissao().getTime());
            stmt.setDate(8, dataSql);
            stmt.setString(9, m.getCnhNumero());
            stmt.setString(10, m.getEndereco());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o motorista no Banco.",e);
        }
    }

    public void editar(Motorista m) {
        //instrucao sql
        String sql = "UPDATE motoristas SET nome = ?, cpf = ?, rg = ?, sexo = ?, email = ?, telefone = ?, cnhCategoria = ?, cnhEmissao = ?, cnhNumero = ?, endereco = ? WHERE id = ?";

        //tenta conectar
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getCpf());
            stmt.setString(3, m.getRg());
            stmt.setString(4, String.valueOf(m.getSexo()));
            stmt.setString(5, m.getEmail());
            stmt.setString(6, m.getTelefone());
            stmt.setString(7, m.getCnhCategoria());
            Date dataSql = new Date(m.getCnhEmissao().getTime());
            stmt.setDate(8, dataSql);
            stmt.setString(9, m.getCnhNumero());
            stmt.setString(10, m.getEndereco());
            stmt.setInt(11, m.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar o motorista.",e);
        }
    }

    public void excluir(int idMotorista) {
        String sql = "DELETE FROM motoristas WHERE id = ?";

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMotorista);

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o motorista.",e);
        }
    }

    public List<Motorista> listarTodos() {
        //instrucao sql que ira buscar os registros de motoristas no banco
        String sql = "SELECT id, nome, cpf, rg, sexo, email, telefone, cnhCategoria, cnhEmissao, cnhNumero, endereco FROM motoristas";

        List<Motorista> lista = new ArrayList<>();

        try ( Connection conn = Conexao.conectar(); //tenta conectar com o banco
                  PreparedStatement stmt = conn.prepareStatement(sql); //prepara a instrucao sql que sera usada
                  ResultSet rs = stmt.executeQuery();) { // executa a consulta e armazena os resultados em rs

            while (rs.next()) {
                Motorista m = new Motorista();

                //mapeando os campos
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setCpf(rs.getString("cpf"));
                m.setRg(rs.getString("rg"));
                //converte de char do banco pra String
                m.setSexo(rs.getString("sexo").charAt(0));
                m.setEmail(rs.getString("email"));
                m.setTelefone(rs.getString("telefone"));
                m.setCnhCategoria(rs.getString("cnhCategoria"));
                m.setCnhEmissao(rs.getDate("cnhEmissao"));
                m.setCnhNumero(rs.getString("cnhNumero"));
                m.setEndereco(rs.getString("endereco"));
                //adiciona na lista
                lista.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar motoristas.",e);
        }
        return lista;
    }

    public Motorista buscarPorId(int id) {
        String sql = "SELECT * FROM motoristas WHERE id = ?";
        Motorista m = null;

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            //id que sera buscado
            stmt.setInt(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    m = new Motorista();
                    m.setId(rs.getInt("id"));
                    m.setNome(rs.getString("nome"));
                    m.setCpf(rs.getString("cpf"));
                    m.setRg(rs.getString("rg"));
                    m.setSexo(rs.getString("sexo").charAt(0));
                    m.setEmail(rs.getString("email"));
                    m.setTelefone(rs.getString("telefone"));
                    m.setCnhCategoria(rs.getString("cnhCategoria"));
                    m.setCnhEmissao(rs.getDate("cnhEmissao"));
                    m.setCnhNumero(rs.getString("cnhNumero"));
                    m.setEndereco(rs.getString("endereco"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o motorista por id: ",e);
        }
        return m;
    }    
}
