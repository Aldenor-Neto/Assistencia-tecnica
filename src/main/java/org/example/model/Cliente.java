package org.example.model;

import java.sql.Date;

public class Cliente extends GenericModel {

    private String nome;
    private java.sql.Date dtNascimento;
    private String cpf;
    private String email;
    private int idEndereco;

    public Cliente(Integer id, String nome, Date dtNascimento, String cpf, String email, int idEndereco) {
        super(id);
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.sql.Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(java.sql.Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
