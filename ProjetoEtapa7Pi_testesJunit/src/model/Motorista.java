/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Juliano
 */
public class Motorista {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private char sexo;
    private String email;
    private String telefone;
    private String cnhCategoria;
    private Date cnhEmissao;
    private String cnhNumero;
    private String endereco;

    public Motorista() {
    }

    public Motorista(String nome, String cpf, String rg, char sexo, String email, String telefone, String cnhCategoria, Date cnhEmissao, String cnhNumero, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.cnhCategoria = cnhCategoria;
        this.cnhEmissao = cnhEmissao;
        this.cnhNumero = cnhNumero;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public char getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnhCategoria() {
        return cnhCategoria;
    }

    public Date getCnhEmissao() {
        return cnhEmissao;
    }

    public String getCnhNumero() {
        return cnhNumero;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCnhCategoria(String cnhCategoria) {
        this.cnhCategoria = cnhCategoria;
    }

    public void setCnhEmissao(Date cnhEmissao) {
        this.cnhEmissao = cnhEmissao;
    }

    public void setCnhNumero(String cnhNumero) {
        this.cnhNumero = cnhNumero;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    
}
