package org.example.dao;

import org.example.config.ConexaoDB;
import org.example.model.ItemOrdemServico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOrdemServicoDAO extends ConexaoDB {

    private static final String INSERT_ITEM_ORDEM_SERVICO_SQL = "INSERT INTO item_ordem_servico (descricao, preco, id_ordem_servico) VALUES (?, ?, ?);";
    private static final String SELECT_ITEM_ORDEM_SERVICO_BY_ID = "SELECT id, descricao, preco, id_ordem_servico FROM item_ordem_servico WHERE id = ?";
    private static final String SELECT_ALL_ITEM_ORDEM_SERVICO = "SELECT * FROM item_ordem_servico;";
    private static final String DELETE_ITEM_ORDEM_SERVICO_SQL = "DELETE FROM item_ordem_servico WHERE id = ?;";
    private static final String UPDATE_ITEM_ORDEM_SERVICO_SQL = "UPDATE item_ordem_servico SET descricao = ?, preco = ?, id_ordem_servico = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM item_ordem_servico ;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepareSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertItemOrdemServico(ItemOrdemServico entidade) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ITEM_ORDEM_SERVICO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getPreco());
            preparedStatement.setInt(3, entidade.getIdOrdemServico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemOrdemServico selectItemOrdemServico(int id) {
        ItemOrdemServico entidade = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ITEM_ORDEM_SERVICO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int preco = rs.getInt("preco");
                int idOrdemServico = rs.getInt("id_ordem_servico");
                entidade = new ItemOrdemServico(id, descricao, preco, idOrdemServico);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ItemOrdemServico> selectAllItemOrdemServico() {
        List<ItemOrdemServico> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ITEM_ORDEM_SERVICO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int preco = rs.getInt("preco");
                int idOrdemServico = rs.getInt("id_ordem_servico");
                entidades.add(new ItemOrdemServico(id, descricao, preco, idOrdemServico));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteItemOrdemServico(int id) throws SQLException {
        try (PreparedStatement statement = prepareSQL(DELETE_ITEM_ORDEM_SERVICO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateItemOrdemServico(ItemOrdemServico entidade) throws SQLException {
        try (PreparedStatement statement = prepareSQL(UPDATE_ITEM_ORDEM_SERVICO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getPreco());
            statement.setInt(3, entidade.getIdOrdemServico());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
