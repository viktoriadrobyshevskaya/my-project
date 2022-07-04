package by.epam.drobyshevskaya.project.service.impl;

import by.epam.drobyshevskaya.project.bean.User;
import by.epam.drobyshevskaya.project.dao.UserDAO;
import by.epam.drobyshevskaya.project.dao.exception.DAOException;
import by.epam.drobyshevskaya.project.dao.factory.DAOFactory;
import by.epam.drobyshevskaya.project.service.ClientService;
import by.epam.drobyshevskaya.project.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void singIn(String login, String password) throws ServiceException {
        // проверяем параметры
        if(login == null){
            throw new ServiceException("Incorrect login");
        }
        //реализуем функционал логинализации пользователя в системе
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            userDAO.signIn(login, password);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
        //
    }

    @Override
    public void singOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User user) throws ServiceException{

    }
}
