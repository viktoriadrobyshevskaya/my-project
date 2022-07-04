package by.epam.drobyshevskaya.project.dao.impl;

import by.epam.drobyshevskaya.project.dao.AuthorDAO;
import by.epam.drobyshevskaya.project.bean.Author;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    @Override
    public void addAuthor(Author author) throws DAOException {
        String sql = "INSERT INTO authors(name, middleName, surName, booksNumber) VALUES (?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getMiddleName());
            ps.setString(3, author.getSurname());
            ps.setInt(4, author.getBooksNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void removeAuthor(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM authors WHERE id_author = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Author getById(int id) {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM authors WHERE id_author = ?")) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                Author author = new Author();
                author.setId_author(id);
                author.setName(resultSet.getString(2));
                author.setMiddleName(resultSet.getString(3));
                author.setSurname(resultSet.getString(4));
                author.setBooksNumber(resultSet.getInt(5));
                return author;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBooksNumber(int number, int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE authors SET booksNumber = ? WHERE id_author = ?")) {
            statement.setInt(1, number);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> allAuthors = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM authors")) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Author author = new Author();
                    author.setId_author(resultSet.getInt(1));
                    author.setName(resultSet.getString(2));
                    author.setMiddleName(resultSet.getString(3));
                    author.setSurname(resultSet.getString(4));
                    author.setBooksNumber(resultSet.getInt(5));
                    allAuthors.add(author);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAuthors;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "assa123assa");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
