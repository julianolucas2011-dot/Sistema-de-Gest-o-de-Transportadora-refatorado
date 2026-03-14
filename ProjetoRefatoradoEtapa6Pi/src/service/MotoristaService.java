/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.MotoristaDAO;
import java.util.List;
import model.Motorista;
/**
 *
 * @author Juliano
 */
public class MotoristaService {
    private MotoristaDAO dao;

    public MotoristaService() {
        dao = new MotoristaDAO();
    }

    public List<Motorista> listarMotoristas() {
        return dao.listarTodos();
    }

    public void inserirMotorista(Motorista motorista) {
        dao.inserir(motorista);
    }

    public void excluirMotorista(int id) {
        dao.excluir(id);
    }

    public void editarMotorista(Motorista motorista) {
        dao.editar(motorista);
    }    
}
