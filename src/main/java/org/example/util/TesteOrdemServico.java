package org.example.util;

import org.example.dao.OrdemServicoDAO;
import org.example.model.OrdemServico;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TesteOrdemServico {

    static OrdemServicoDAO ordemServicoDao = new OrdemServicoDAO();

    public static void main(String[] args) throws SQLException {

        OrdemServico ordemServico = new OrdemServico(1, "Manutenção de notebook", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Pedro", 6, 1);
        //ordemServicoDao.insertOrdemServico(ordemServico);
        ordemServico = ordemServicoDao.selectOrdemServico(4);

        ordemServico.setObservacao("Manutenção no notebook da Dell");
        ordemServicoDao.updateOrdemServico(ordemServico);
        //ordemServicoDao.deleteOrdemServico(3);

        List<OrdemServico> listOrdemServico = ordemServicoDao.selectAllOrdemServico();
        listOrdemServico.forEach(System.out::println);

    }
}
