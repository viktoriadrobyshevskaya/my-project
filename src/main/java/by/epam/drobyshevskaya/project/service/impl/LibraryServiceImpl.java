package by.epam.drobyshevskaya.project.service.impl;

import by.epam.drobyshevskaya.project.bean.Book;
import by.epam.drobyshevskaya.project.service.LibraryService;
import by.epam.drobyshevskaya.project.service.exception.ServiceException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public void addNewBook(Book book) throws ServiceException {
        try (Connection connection = DriverManager.getConnection("")) {

        } catch (SQLException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addEditedBook(Book book) throws ServiceException {
        try (Connection connection = DriverManager.getConnection("")) {

        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }
}
