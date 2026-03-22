/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.VeiculoDAO;
import java.util.List;
import model.Veiculo;
/**
 *
 * @author Juliano
 */
public class VeiculoService {
    private VeiculoDAO dao;

    public VeiculoService() {
        dao = new VeiculoDAO();
    }

    public List<Veiculo> listarVeiculos() {
        return dao.listarTodos();
    }

    public void inserirVeiculo(Veiculo veiculo) {
        dao.inserir(veiculo);
    }

    public void excluirVeiculo(int id) {
        dao.excluir(id);
    }

    public void editarVeiculo(Veiculo veiculo) {
        dao.editar(veiculo);
    }    
}
