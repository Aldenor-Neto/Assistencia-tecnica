package org.example.dao;

import org.example.config.ConexaoDB;
import org.example.model.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO extends ConexaoDB {

    private static final String INSERT_EMPRESA_SQL = "INSERT INTO empresa (nome_fantasia, cnpj, logo, slogan, id_endereco) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_EMPRESA_BY_ID = "SELECT id, nome_fantasia, cnpj, logo, slogan, id_endereco FROM empresa WHERE id = ?";
    private static final String SELECT_ALL_EMPRESA = "SELECT * FROM empresa;";
    private static final String DELETE_EMPRESA_SQL = "DELETE FROM empresa WHERE id = ?;";
    private static final String UPDATE_EMPRESA_SQL = "UPDATE empresa SET nome_fantasia = ?, cnpj = ?, logo = ?, slogan = ?, id_endereco = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM empresa ;";

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

    public void insertEmpresa(Empresa entidade) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_EMPRESA_SQL)) {
            preparedStatement.setString(1, entidade.getNomeFantasia());
            preparedStatement.setString(2, entidade.getCnpj());
            preparedStatement.setBytes(3, entidade.getLogo());
            preparedStatement.setString(4, entidade.getSlogan());
            preparedStatement.setInt(5, entidade.getIdEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Empresa selectEmpresa(int id) {
        Empresa entidade = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_EMPRESA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nomeFantasia = rs.getString("nome_fantasia");
                String cnpj = rs.getString("cnpj");
                byte[] logo = rs.getBytes("logo");
                String slogan = rs.getString("slogan");
                int idEndereco = rs.getInt("id_endereco");
                entidade = new Empresa(id, nomeFantasia, cnpj, logo, slogan, idEndereco);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Empresa> selectAllEmpresa() {
        List<Empresa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_EMPRESA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeFantasia = rs.getString("nome_fantasia");
                String cnpj = rs.getString("cnpj");
                byte[] logo = rs.getBytes("logo");
                String slogan = rs.getString("slogan");
                int idEndereco = rs.getInt("id_endereco");
                entidades.add(new Empresa(id, nomeFantasia, cnpj, logo, slogan, idEndereco));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEmpresa(int id) throws SQLException {
        try (PreparedStatement statement = prepareSQL(DELETE_EMPRESA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEmpresa(Empresa entidade) throws SQLException {
        try (PreparedStatement statement = prepareSQL(UPDATE_EMPRESA_SQL)) {
            statement.setString(1, entidade.getNomeFantasia());
            statement.setString(2, entidade.getCnpj());
            statement.setBytes(3, entidade.getLogo());
            statement.setString(4, entidade.getSlogan());
            statement.setInt(5, entidade.getIdEndereco());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
