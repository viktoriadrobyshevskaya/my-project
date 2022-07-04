package by.epam.drobyshevskaya.project.dao.impl;

import by.epam.drobyshevskaya.project.dao.RoleDAO;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {

    @Override
    public void changeRoleById(String role, int id) throws DAOException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "assa123assa");
             PreparedStatement statement = connection.prepareStatement("UPDATE roles SET title = ? where id_role = ?")) {
            statement.setString(1, role);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
