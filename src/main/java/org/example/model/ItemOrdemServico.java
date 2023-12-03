package org.example.model;

public class ItemOrdemServico extends GenericModel {

    private String descricao;
    private int preco;
    private int idOrdemServico;

    public ItemOrdemServico(Integer id, String descricao, int preco, int idOrdemServico) {
        super(id);
        this.descricao = descricao;
        this.preco = preco;
        this.idOrdemServico = idOrdemServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    @Override
    public String toString() {
        return "ItemOrdemServico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", idOrdemServico=" + idOrdemServico +
                '}';
    }
}
