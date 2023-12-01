package org.example;

import org.example.dao.CidadeDAO;
import org.example.dao.UfDAO;
import org.example.model.Cidade;
import org.example.model.UF;

import java.sql.SQLException;
import java.util.List;

public class Main {

    static UfDAO ufDao = new UfDAO();
    static CidadeDAO cidadeDao = new CidadeDAO();

    public static void main(String[] args)throws SQLException {
/*
        UF uf = new UF(2, "São paulo", 2);
        //ufDao.insertUf(uf);
        uf = ufDao.selectUf(2);
        System.out.println(uf);
uf.setDescricao("Rio de Janeiro");
ufDao.updateUf(uf);
uf = ufDao.selectUf(2);
        System.out.println(uf);

        List<UF> listUf = ufDao.selectAllUf();
        listUf.forEach(System.out::println);

        ufDao.deleteUf(2);
        listUf = ufDao.selectAllUf();
        listUf.forEach(System.out::println);

//Cidade
        Cidade cidade = new Cidade(1, "Fortaleza", 01, 1);
        //cidadeDao.insertCidade(cidade);
        cidade =cidadeDao.selectCidade(2);
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
*/
    }
}