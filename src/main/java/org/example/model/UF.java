package org.example.model;

public class UF extends GenericModel {

    private String descricao;
    private int codigo;

    public UF(Integer id, String descricao, int codigo) {
        super(id);
        this.descricao = descricao;
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "UF{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                '}';
    }

}
