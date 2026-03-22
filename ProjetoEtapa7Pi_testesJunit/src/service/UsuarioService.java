/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

private UsuarioDAO dao;

public UsuarioService() {
    dao = new UsuarioDAO();
}

public void salvarUsuario(Usuario usuario) {
    dao.salvarUsuario(usuario);
}

public boolean verificarLogin(String login, String senha) {
    return dao.verificarCredenciais(login, senha);
}

public boolean verificarCredenciais(String login, String senha) {
    UsuarioDAO dao = new UsuarioDAO();
    return dao.verificarCredenciais(login, senha);
}

}
