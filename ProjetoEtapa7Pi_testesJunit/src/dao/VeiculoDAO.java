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
import model.Veiculo;

/**
 *
 * @author Juliano
 */
public class VeiculoDAO {

    public void inserir(Veiculo v) {
        //instrução sql
        String sql = "INSERT INTO veiculos (modelo, placa, ano, combustivel, capacidadeCarga, renavan, cor, seguro) VALUES(?,?,?,?,?,?,?,?)";

        //tenta a conexao
        try ( Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos    
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getPlaca());
            stmt.setInt(3, v.getAno());
            stmt.setString(4, v.getCombustivel());
            stmt.setDouble(5, v.getCapacidadeCarga());
            stmt.setString(6, v.getRenavan());
            stmt.setString(7, v.getCor());
            stmt.setBoolean(8, v.isSeguro());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o veiculo no Banco.",e);
        }
    }

    public void editar(Veiculo v) {
        //instrucao sql
        String sql = "UPDATE veiculos SET modelo = ?, placa = ?, ano = ?, combustivel = ?, capacidadeCarga = ?, renavan = ?, cor = ?, seguro = ? WHERE id = ?";

        //tenta conectar
        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            //mapeia os campos
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getPlaca());
            stmt.setInt(3, v.getAno());
            stmt.setString(4, v.getCombustivel());
            stmt.setDouble(5, v.getCapacidadeCarga());
            stmt.setString(6, v.getRenavan());
            stmt.setString(7, v.getCor());
            stmt.setBoolean(8, v.isSeguro());
            //id do funcionario para identificar qual sera excluido
            stmt.setInt(9, v.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar o veiculo no Banco.",e);
        }
    }

    public void excluir(int idVeiculo) {
        String sql = "DELETE FROM veiculos WHERE id = ?";

        try ( Connection conn = Conexao.conectar();  PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVeiculo);

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o veiculo no banco de dados.",e);
        }
    }

    public List<Veiculo> listarTodos() {
        //instrucao sql que ira buscar os registros dos veiculos no banco
        String sql = "SELECT id, modelo, placa, ano, combustivel, capacidadeCarga, renavan, cor, seguro FROM veiculos";

        List<Veiculo> lista = new ArrayList<>();

        try ( Connection conn = Conexao.conectar(); //tenta conectar com o banco
                  PreparedStatement stmt = conn.prepareStatement(sql); //prepara a instrucao sql que sera usada
                  ResultSet rs = stmt.executeQuery();) { // executa a consulta e armazena os resultados em rs

            while (rs.next()) {
                Veiculo v = new Veiculo();

                //mapeando os campos
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                v.setAno(rs.getInt("ano"));
                v.setCombustivel(rs.getString("combustivel"));
                v.setCapacidadeCarga(rs.getDouble("capacidadeCarga"));
                v.setRenavan(rs.getString("renavan"));
                v.setCor(rs.getString("cor"));
                v.setSeguro(rs.getBoolean("seguro"));
                //adiciona na lista
                lista.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veiculos.",e);
        }
        return lista;
    }

    public Veiculo buscarPorId(int id) {
        String sql = "SELECT * FROM veiculos WHERE id = ?";
        Veiculo v = null;

        try ( Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            //id que sera buscado
            stmt.setInt(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    v = new Veiculo();
                    v.setId(rs.getInt("id"));
                    v.setModelo(rs.getString("modelo"));
                    v.setPlaca(rs.getString("placa"));
                    v.setAno(rs.getInt("ano"));
                    v.setCombustivel(rs.getString("combustivel"));
                    v.setCapacidadeCarga(rs.getDouble("capacidadeCarga"));
                    v.setRenavan(rs.getString("renavan"));
                    v.setCor(rs.getString("cor"));
                    v.setSeguro(rs.getBoolean("seguro"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o veiculo por id: ",e);
        }
        return v;
    }
}
