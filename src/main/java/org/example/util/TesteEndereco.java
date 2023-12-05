package org.example.util;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.EnderecoDAO;
import org.example.model.Endereco;

public class TesteEndereco {

    static EnderecoDAO enderecoDao = new EnderecoDAO();
    
    public static void main(String[] args) throws SQLException {

        Endereco endereco = new Endereco(1, "Noventa", "145", "Jereissaati II", "61800-000", 2);
        //enderecoDao.insertEndereco(endereco);
        endereco = enderecoDao.selectEndereco(6);
        System.out.println(endereco);

        endereco.setRua("Avenida XXi");
        endereco.setNumero("10");
        enderecoDao.updateEndereco(endereco);
        endereco = enderecoDao.selectEndereco(6);
        System.out.println(endereco);

        List<Endereco> listEndereco = enderecoDao.selectAllEndereco();
        listEndereco.forEach(System.out::println);

        //enderecoDao.deleteEndereco(5);
        listEndereco = enderecoDao.selectAllEndereco();
        listEndereco.forEach(System.out::println);

        System.out.println(enderecoDao.count());

    }
}
