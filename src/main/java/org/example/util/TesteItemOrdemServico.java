package org.example.util;

import org.example.dao.ItemOrdemServicoDAO;
import org.example.model.ItemOrdemServico;

import java.sql.SQLException;
import java.util.List;

public class TesteItemOrdemServico {

    static ItemOrdemServicoDAO itemOrdemServicoDao = new ItemOrdemServicoDAO();

    public static void main(String[] args) throws SQLException {

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
