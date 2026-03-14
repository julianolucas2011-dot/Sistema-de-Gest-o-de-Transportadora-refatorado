/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.FuncionarioDAO;
import java.util.List;
import model.Funcionario;
/**
 *
 * @author Juliano
 */
public class FuncionarioService {
    private FuncionarioDAO dao;

    public FuncionarioService() {
        dao = new FuncionarioDAO();
    }

    public List<Funcionario> listarFuncionarios() {
        return dao.listarTodos();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        dao.inserir(funcionario);
    }

    public void excluirFuncionario(int id) {
        dao.excluir(id);
    }

    public void editarFuncionario(Funcionario funcionario) {
        dao.editar(funcionario);
    }    
}
