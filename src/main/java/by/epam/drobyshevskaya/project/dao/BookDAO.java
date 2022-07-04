package by.epam.drobyshevskaya.project.dao;

import by.epam.drobyshevskaya.project.bean.Author;
import by.epam.drobyshevskaya.project.bean.Book;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;

public interface BookDAO {
    public void addBook(Book book) throws DAOException;

    public void deleteBookById(int id) throws DAOException;

    public void updateBookById(int id, int number) throws DAOException;

    public void getAllBooksByAuthor(Author author) throws DAOException;
}
