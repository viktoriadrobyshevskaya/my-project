package by.epam.drobyshevskaya.project.service;

import by.epam.drobyshevskaya.project.bean.User;
import by.epam.drobyshevskaya.project.service.exception.ServiceException;

public interface ClientService {
    public void singIn(String login, String password) throws ServiceException;

    public void singOut(String login) throws ServiceException;

    public void registration(User user) throws ServiceException;
}
