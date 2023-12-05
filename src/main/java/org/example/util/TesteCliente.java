package org.example.util;

import org.example.dao.ClienteDAO;
import org.example.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class TesteCliente {

    static ClienteDAO clienteDao = new ClienteDAO();

    public static void main(String[] args) throws SQLException {

        Cliente cliente = new Cliente(1, "Davi", new java.sql.Date(1987 - 11 - 30), "4", "francisco@gmail.com", 4);
        //clienteDao.insertCliente(cliente);
        cliente = clienteDao.selectCliente(7);
        System.out.println(cliente);

        cliente.setNome("Jonatas");
        clienteDao.updateCliente(cliente);
        cliente = clienteDao.selectCliente(7);
        System.out.println(cliente);

        //clienteDao.deleteCliente(3);
        System.out.println(clienteDao.count());

        List<Cliente> listCliente = clienteDao.selectAllCliente();
        listCliente.forEach(System.out::println);

    }
}
