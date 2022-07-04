package by.epam.drobyshevskaya.project.dao;

import by.epam.drobyshevskaya.project.bean.UserDetail;

import java.util.List;

public interface ReaderDAO {

    public void addReader(UserDetail reader);

    public void removeReader(int id);

    public void updateAddressById(String newAddress, int id);

    public void updatePhoneById(String newPhone, int id);

    public UserDetail getReaderById(int id);

    public List<UserDetail> getAllReaders();
}
