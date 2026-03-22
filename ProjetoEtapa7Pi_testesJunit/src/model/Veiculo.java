/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juliano
 */
public class Veiculo {

    private int id;
    private String modelo;
    private String placa;
    private int ano;
    private String combustivel;
    private double capacidadeCarga;
    private String renavan;
    private String cor;
    private boolean seguro;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa, int ano, String combustivel, double capacidadeCarga, String renavan, String cor, boolean seguro) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.combustivel = combustivel;
        this.capacidadeCarga = capacidadeCarga;
        this.renavan = renavan;
        this.cor = cor;
        this.seguro = seguro;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public String getRenavan() {
        return renavan;
    }

    public String getCor() {
        return cor;
    }

    public boolean isSeguro() {
        return seguro;
    }
    
    public int getId() {
        return id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "modelo=" + modelo + ", placa=" + placa + ", ano=" + ano + ", combustivel=" + combustivel + ", capacidadeCarga=" + capacidadeCarga + ", renavan=" + renavan + ", cor=" + cor + ", seguro=" + seguro + '}';
    }    
}
