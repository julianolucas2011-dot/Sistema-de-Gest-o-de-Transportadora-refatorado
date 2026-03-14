/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import service.ClienteService;
import service.MotoristaService;
import service.VeiculoService;

/**
 *
 * @author Juliano
 */
public class testeMain {
    public static void main(String[] args) {
        try {
            ClienteService cs = new ClienteService();
            System.out.println("Clientes cadastrados: " + cs.listarClientes().size());

            MotoristaService ms = new MotoristaService();
            System.out.println("Motoristas cadastrados: " + ms.listarMotoristas().size());

            VeiculoService vs = new VeiculoService();
            System.out.println("Veículos cadastrados: " + vs.listarVeiculos().size());

            System.out.println("Teste concluído: não houve erro ao carregar dados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
