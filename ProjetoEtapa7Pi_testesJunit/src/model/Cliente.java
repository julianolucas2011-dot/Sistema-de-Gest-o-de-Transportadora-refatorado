/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juliano
 */
public class Cliente {
    private int id;
    private String cpfCnpj;
    private String nome;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    private String cep;
    private String bairro;
    private int numero;
    private String complemento;

    public Cliente() {
    }

    public Cliente(String cpfCnpj, String nome, String email, String telefone, String estado, String cidade, String cep, String bairro, int numero, String complemento) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getId() {
        return id;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
