package org.example.dao;

import org.example.config.ConexaoDB;
import org.example.model.UF;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UfDAO extends ConexaoDB {

    private static final String INSERT_UF_SQL = "INSERT INTO uf (descricao, codigo) VALUES (?, ?);";
    private static final String SELECT_UF_BY_ID = "SELECT id, descricao, codigo FROM uf WHERE id = ?";
    private static final String SELECT_ALL_UF = "SELECT * FROM uf;";
    private static final String DELETE_UF_SQL = "DELETE FROM uf WHERE id = ?;";
    private static final String UPDATE_UF_SQL = "UPDATE uf SET descricao = ?, codigo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM uf ;";

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

    public void insertUf(UF entidade) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_UF_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public UF selectUf(int id) {
        UF entidade = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_UF_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int codigo = rs.getInt("codigo");
                entidade = new UF(id, descricao, codigo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<UF> selectAllUf() {
        List<UF> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_UF)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int codigo = rs.getInt("codigo");
                entidades.add(new UF(id, descricao, codigo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteUf(int id) throws SQLException {
        try (PreparedStatement statement = prepareSQL(DELETE_UF_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUf(UF entidade) throws SQLException {
        try (PreparedStatement statement = prepareSQL(UPDATE_UF_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getCodigo());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
