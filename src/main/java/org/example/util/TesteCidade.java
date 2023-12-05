package org.example.util;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.CidadeDAO;
import org.example.model.Cidade;

public class TesteCidade {

    static CidadeDAO cidadeDao = new CidadeDAO();

    public static void main(String[] args) throws SQLException {

        Cidade cidade = new Cidade(1, "Fortaleza", 01, 1);
        //cidadeDao.insertCidade(cidade);
        cidade = cidadeDao.selectCidade(2);
        System.out.println(cidade);

        cidade.setDescricao("Bahia");
        cidadeDao.updateCidade(cidade);
        cidade = cidadeDao.selectCidade(2);
        System.out.println(cidade);

        List<Cidade> listCidades = cidadeDao.selectAllCidade();
        listCidades.forEach(System.out::println);

        //cidadeDao.deleteCidade(1);
        listCidades = cidadeDao.selectAllCidade();
        listCidades.forEach(System.out::println);

        System.out.println(cidadeDao.count());

    }
}
