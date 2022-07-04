package by.epam.drobyshevskaya.project.dao.impl;

import by.epam.drobyshevskaya.project.bean.User;
import by.epam.drobyshevskaya.project.dao.UserDAO;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    @Override
    public void signIn(String login, String password) throws DAOException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myprojectver2", "root", "assa123assa");
             PreparedStatement statement = con.prepareStatement("SELECT id_user FROM users WHERE login = ? AND password = ?")) {

            statement.setString(1, login);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("Пользователь с таким логином и паролем не найден.");
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void registration(User user) throws DAOException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myprojectver2", "root", "assa123assa");
             PreparedStatement statement = con.prepareStatement("")) {


        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
