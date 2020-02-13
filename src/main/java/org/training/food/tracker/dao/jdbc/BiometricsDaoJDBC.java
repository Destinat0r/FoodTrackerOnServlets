package org.training.food.tracker.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.training.food.tracker.dao.BiometricsDao;
import org.training.food.tracker.dao.DaoException;
import org.training.food.tracker.dao.util.ConnectionFactory;
import org.training.food.tracker.model.Biometrics;

import java.sql.*;
import java.util.List;

public class BiometricsDaoJDBC implements BiometricsDao {

    private static final String CREATE_QUERY = "INSERT INTO biometrics (user_id, age, height, weight, lifestyle, sex) "
                                                 + "VALUES (?,?,?,?,?,?)";

    private static final Logger LOG = LoggerFactory.getLogger(BiometricsDaoJDBC.class.getName());

    @Override public Biometrics create(Biometrics biometrics) throws DaoException {
        LOG.debug("create()");
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            LOG.debug("create() :: prepared statement created");

            setPreparedStatement(biometrics, statement);
            LOG.debug("create() :: executing statement");
            statement.executeUpdate();

            setGeneratedId(biometrics, statement);
        } catch (SQLException e) {
            LOG.error("biometrics creation failed");
            throw new DaoException("biometrics creation failed", e);
        }
        return biometrics;
    }

    private void setGeneratedId(Biometrics biometrics, PreparedStatement statement) throws SQLException {
        LOG.debug("setGeneratedId()");
        try (ResultSet resultSet = statement.getGeneratedKeys()) {

            LOG.debug("Result set was created. Setting id from DB to biometrics object to return");
            resultSet.next();
            biometrics.setId(resultSet.getLong(1));
        }
    }

    private void setPreparedStatement(Biometrics biometrics, PreparedStatement statement) throws SQLException {
        LOG.debug("setPreparedStatement()");
        statement.setLong(1, biometrics.getOwner().getId());
        statement.setBigDecimal(2, biometrics.getAge());
        statement.setBigDecimal(3, biometrics.getHeight());
        statement.setBigDecimal(4, biometrics.getWeight());
        statement.setString(5, biometrics.getLifestyle().toString());
        statement.setString(6, biometrics.getSex().toString());
    }

    @Override public Biometrics findById(Long id) throws DaoException {
        return null;
    }

    @Override public Biometrics update(Biometrics biometrics) {
        return null;
    }

    @Override public List<Biometrics> findAll() throws DaoException {
        return null;
    }

    @Override public void deleteById(Long id) {

    }
}
