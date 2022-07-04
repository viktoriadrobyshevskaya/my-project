package by.epam.drobyshevskaya.project.dao;

import by.epam.drobyshevskaya.project.dao.exception.DAOException;

public interface RoleDAO {
    public void changeRoleById(String role, int id) throws DAOException;
}
