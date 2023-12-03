package org.example;

import org.example.dao.*;
import org.example.model.ItemOrdemServico;

import java.sql.SQLException;
import java.util.List;

public class Main {

    static UfDAO ufDao = new UfDAO();
    static CidadeDAO cidadeDao = new CidadeDAO();
    static EnderecoDAO enderecoDao = new EnderecoDAO();
    static EmpresaDAO empresaDao = new EmpresaDAO();
    static ClienteDAO clienteDao = new ClienteDAO();
    static OrdemServicoDAO ordemServicoDao = new OrdemServicoDAO();
    static ItemOrdemServicoDAO itemOrdemServicoDao = new ItemOrdemServicoDAO();

    public static void main(String[] args) throws SQLException {
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

        cidade.setDescricao("Bahia");10
        cidadeDao.updateCidade(cidade);
        cidade = cidadeDao.selectCidade(2);
        System.out.println(cidade);

        List<Cidade> listCidades = cidadeDao.selectAllCidade();
        listCidades.forEach(System.out::println);

        //cidadeDao.deleteCidade(1);
        listCidades = cidadeDao.selectAllCidade();
        listCidades.forEach(System.out::println);

        System.out.println(cidadeDao.count());

        //endereco
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

//empresa
        Empresa empresa = new Empresa(1, "mundo da tecnologia", "111111", new byte[]{01,02,03,04}, "a tecnologia que você precisa", 4);
        //empresaDao.insertEmpresa(empresa);
        empresa = empresaDao.selectEmpresa(2);
        System.out.println(empresa);

        empresa.setNomeFantasia("mar tec");
        empresa.setSlogan("o mar de tecnologia");
        empresaDao.updateEmpresa(empresa);
        empresa = empresaDao.selectEmpresa(3);
        System.out.println(empresa);

        //empresaDao.deleteEmpresa(3);
        System.out.println(empresaDao.count());

        List<Empresa> listEmpresa = empresaDao.selectAllEmpresa();
        listEmpresa.forEach(System.out::println);

//Cliente
        Cliente cliente = new Cliente(1, "Davi", new java.sql.Date(1987-11-30), "4", "francisco@gmail.com", 4);
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

//Ordem Servico
        OrdemServico ordemServico = new OrdemServico(1, "Manutenção de notebook", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Pedro", 6, 1);
        //ordemServicoDao.insertOrdemServico(ordemServico);
        ordemServico = ordemServicoDao.selectOrdemServico(4);

        ordemServico.setObservacao("Manutenção no notebook da Dell");
        ordemServicoDao.updateOrdemServico(ordemServico);
    //ordemServicoDao.deleteOrdemServico(3);

    List<OrdemServico> listOrdemServico = ordemServicoDao.selectAllOrdemServico();
    listOrdemServico.forEach(System.out::println);

        System.out.println(ordemServicoDao.count());
 */
        //Item Ordem Servico
        ItemOrdemServico itemOrdemServico = new ItemOrdemServico(1, "Notebook não liga", 350, 2);
        //itemOrdemServicoDao.insertItemOrdemServico(itemOrdemServico);
        System.out.println(itemOrdemServicoDao.count());

        itemOrdemServico = itemOrdemServicoDao.selectItemOrdemServico(3);
        System.out.println(itemOrdemServico);

        itemOrdemServico.setDescricao("computador com a fonte queimada");
        itemOrdemServico.setPreco(200);
        itemOrdemServicoDao.updateItemOrdemServico(itemOrdemServico);
        itemOrdemServico = itemOrdemServicoDao.selectItemOrdemServico(3);
        System.out.println(itemOrdemServico);

        List<ItemOrdemServico> listItemOrdemServico = itemOrdemServicoDao.selectAllItemOrdemServico();
        listItemOrdemServico.forEach(System.out::println);

        //itemOrdemServicoDao.deleteItemOrdemServico(2);
        System.out.println(itemOrdemServicoDao.count());
    }
}
