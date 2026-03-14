/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;

public class ClienteService {

    private ClienteDAO dao;

    public ClienteService() {
        dao = new ClienteDAO();
    }

    public List<Cliente> listarClientes() {
        return dao.listarTodos();
    }

    public void inserirCliente(Cliente cliente) {
        dao.inserir(cliente);
    }

    public void excluirCliente(int id) {
        dao.excluir(id);
    }

    public void editarCliente(Cliente cliente) {
        dao.editar(cliente);
    }
}
