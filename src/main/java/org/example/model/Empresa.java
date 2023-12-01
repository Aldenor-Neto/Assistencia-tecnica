package org.example.model;

import java.util.Arrays;

public class Empresa extends GenericModel {

    private String nomeFantasia;
    private String cnpj;
    private byte[] logo;
    private String slogan;
    private int idEndereco;

    public Empresa(Integer id, String nomeFantasia, String cnpj, byte[] logo, String slogan, int idEndereco) {
        super(id);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.logo = logo;
        this.slogan = slogan;
        this.idEndereco = idEndereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", logo=" + Arrays.toString(logo) +
                ", slogan='" + slogan + '\'' +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
