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
public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private char sexo;
    private Date dataNascimento;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String rg, String email, String telefone, char sexo, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }    
}
