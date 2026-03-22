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
import model.Cliente;

/**
 *
 * @author Juliano
 */
public class ClienteDAO {
public void inserir(Cliente c) {
        //instrução sql
        String sql = "INSERT INTO clientes (cpfCnpj, nome, email, telefone, estado, cidade, cep, bairro, numero, complemento) VALUES(?,?,?,?,?,?,?,?,?,?)";

        //tenta a conexao
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos    
            stmt.setString(1, c.getCpfCnpj());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEstado());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getCep());
            stmt.setString(8, c.getBairro());
            stmt.setInt(9, c.getNumero());
            stmt.setString(10, c.getComplemento());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o cliente no Banco.",e);
        }
    }

    public void editar(Cliente c) {
        //instrucao sql
        String sql = "UPDATE clientes SET cpfCnpj = ?, nome = ?, email = ?, telefone = ?, estado = ?, cidade = ?, cep = ?, bairro = ?, numero = ?, complemento = ? WHERE id = ?";

        //tenta conectar
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos
            stmt.setString(1, c.getCpfCnpj());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEstado());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getCep());
            stmt.setString(8, c.getBairro());
            stmt.setInt(9, c.getNumero());
            stmt.setString(10, c.getComplemento());
            stmt.setInt(11, c.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException( "Erro ao editar o cliente.",e);
        }
    }

    public void excluir(int idCliente) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idCliente);

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o cliente.",e);
        }
    }

    public List<Cliente> listarTodos() {
        //instrucao sql que ira buscar os registros dos clientes no banco
        String sql = "SELECT id, cpfCnpj, nome, email, telefone, estado, cidade, cep, bairro, numero, complemento FROM clientes";

        List<Cliente> lista = new ArrayList<>();

        try ( Connection conn = Conexao.conectar(); //tenta conectar com o banco
                  PreparedStatement stmt = conn.prepareStatement(sql); //prepara a instrucao sql que sera usada
                  ResultSet rs = stmt.executeQuery();) { // executa a consulta e armazena os resultados em rs

            while (rs.next()) {
                Cliente c = new Cliente();

                //mapeando os campos
                c.setId(rs.getInt("id"));
                c.setCpfCnpj(rs.getString("cpfCnpj"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setCep(rs.getString("cep"));
                c.setBairro(rs.getString("bairro"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                //adiciona na lista
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os clientes.",e);
        }
        return lista;
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        Cliente c = null;

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            //id que sera buscado
            stmt.setInt(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setCpfCnpj(rs.getString("cpfCnpj"));
                    c.setNome(rs.getString("nome"));
                    c.setEmail(rs.getString("email"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEstado(rs.getString("estado"));
                    c.setCidade(rs.getString("cidade"));
                    c.setCep(rs.getString("cep"));
                    c.setBairro(rs.getString("bairro"));
                    c.setNumero(rs.getInt("numero"));
                    c.setComplemento(rs.getString("complemento"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o cliente por id: ",e);
        }
        return c;
    }     
}
