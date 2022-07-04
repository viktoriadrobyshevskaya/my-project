package by.epam.drobyshevskaya.project.service;

import by.epam.drobyshevskaya.project.bean.Book;
import by.epam.drobyshevskaya.project.service.exception.ServiceException;

public interface LibraryService {
    public void addNewBook(Book book) throws ServiceException;
    public void addEditedBook(Book book) throws ServiceException;
}
