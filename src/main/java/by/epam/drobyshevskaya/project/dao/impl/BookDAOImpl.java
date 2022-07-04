package by.epam.drobyshevskaya.project.dao.impl;

import by.epam.drobyshevskaya.project.bean.Author;
import by.epam.drobyshevskaya.project.bean.Book;
import by.epam.drobyshevskaya.project.dao.BookDAO;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {
    @Override
    public void addBook(Book book) throws DAOException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO books (id_author, title, year, number) VALUES (?,?,?,?)")) {
            statement.setInt(1, book.getId_author());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getYear());
            statement.setInt(4, book.getNumber());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Something wrong!");
        }
    }

    @Override
    public void deleteBookById(int id) throws DAOException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something wrong!");
        }
    }

    @Override
    public void updateBookById(int id, int number) throws DAOException {

        // тут пишем код, который апдейтит количество экземпляров книги
    }

    @Override
    public void getAllBooksByAuthor(Author author) throws DAOException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("")) {

            // код, который выводит все книги запрошенного автора

        } catch (SQLException e) {
            throw new DAOException("Something wrong!");
        }
    }

    public Connection getConnection() throws DAOException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "assa123assa");
            return connection;
        } catch (SQLException e) {
            throw new DAOException("Something wrong!");
        }
    }
}
