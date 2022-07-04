package by.epam.drobyshevskaya.project.dao;

import by.epam.drobyshevskaya.project.bean.Author;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

import java.util.List;

public interface AuthorDAO {
    public void addAuthor(Author author) throws DAOException;
    public void removeAuthor(int id);
    public Author getById(int id);
    public void updateBooksNumber(int number, int id);
    public List<Author> getAllAuthors();

}
