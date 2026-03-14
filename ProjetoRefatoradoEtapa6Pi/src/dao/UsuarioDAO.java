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
import model.Usuario;

/**
 *
 * @author Juliano
 */
public class UsuarioDAO {
    public void salvarUsuario(Usuario u) {
        String sql = "INSERT INTO usuarios (nome,senha) VALUES (?,?)";

        try (Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(sql)) { // Abre a conexão
            

            //Configurar os parâmetros os "?" na instrução SQL
            stmt.setString(1, u.getNomeUsuario());
            stmt.setString(2, u.getSenha());

            //Executar a instrução
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar inserir o registro no banco de dados. ",e);
        }
    }

    public boolean verificarCredenciais(String login, String senha) {
        String sql = "SELECT id FROM usuarios WHERE nome = ? AND senha = ?";
        try ( Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
        //define os parametros
        stmt.setString(1, login);
        stmt.setString(2, senha);
        
        //executa a query
        try(ResultSet rs = stmt.executeQuery()){
            if (rs.next()) {
                int count = rs.getInt(1); // Pega o resultado do COUNT(*)
                
                // Se COUNT(*) for maior que 0, significa que a combinação existe.
                return count > 0;
            }
        }
        
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar as credenciais no BD",e);
        }
        return false;
    }    
}
