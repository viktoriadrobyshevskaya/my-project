package by.epam.drobyshevskaya.project;

import by.epam.drobyshevskaya.project.bean.Book;
import by.epam.drobyshevskaya.project.dao.BookDAO;
import by.epam.drobyshevskaya.project.dao.UserDAO;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;
import by.epam.drobyshevskaya.project.dao.impl.BookDAOImpl;
import by.epam.drobyshevskaya.project.dao.impl.UserDAOImpl;

public class Main {
    public static void main(String[] args) throws DAOException {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.signIn("smirno", "85245");

    }
}
