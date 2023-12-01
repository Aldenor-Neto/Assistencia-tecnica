package org.example.model;

public class Cidade extends GenericModel {

    private String descricao;
    private int codigo;
    private int idUf;

    public Cidade(Integer id, String descricao, int codigo, int idUf) {
        super(id);
        this.descricao = descricao;
        this.codigo = codigo;
        this.idUf = idUf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdUf() {
        return idUf;
    }

    public void setIdUf(int idUf) {
        this.idUf = idUf;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", idUf=" + idUf +
                '}';
    }
}
