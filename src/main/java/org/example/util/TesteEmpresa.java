package org.example.util;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.EmpresaDAO;
import org.example.model.Empresa;

public class TesteEmpresa {

    static EmpresaDAO empresaDao = new EmpresaDAO();

    public static void main(String[] args) throws SQLException {

        Empresa empresa = new Empresa(1, "mundo da tecnologia", "111111", new byte[] { 01, 02, 03, 04 },
                "a tecnologia que você precisa", 4);
        // empresaDao.insertEmpresa(empresa);
        empresa = empresaDao.selectEmpresa(2);
        System.out.println(empresa);

        empresa.setNomeFantasia("mar tec");
        empresa.setSlogan("o mar de tecnologia");
        empresaDao.updateEmpresa(empresa);
        empresa = empresaDao.selectEmpresa(3);
        System.out.println(empresa);

        // empresaDao.deleteEmpresa(3);
        System.out.println(empresaDao.count());

        List<Empresa> listEmpresa = empresaDao.selectAllEmpresa();
        listEmpresa.forEach(System.out::println);

    }
}