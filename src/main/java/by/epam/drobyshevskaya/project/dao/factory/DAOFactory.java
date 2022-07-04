package by.epam.drobyshevskaya.project.dao.factory;

import by.epam.drobyshevskaya.project.dao.*;
import by.epam.drobyshevskaya.project.dao.impl.*;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new UserDAOImpl();
    private final AuthorDAO authorDAO = new AuthorDAOImpl();
    private final ReaderDAO readerDAO = new ReaderDAOImpl();
    private final BookDAO bookDAO = new BookDAOImpl();

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public ReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
