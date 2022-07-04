package by.epam.drobyshevskaya.project.dao;

import by.epam.drobyshevskaya.project.bean.User;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

public interface UserDAO {
    public void signIn(String login, String password) throws DAOException;

    public void registration(User user) throws DAOException;
}
