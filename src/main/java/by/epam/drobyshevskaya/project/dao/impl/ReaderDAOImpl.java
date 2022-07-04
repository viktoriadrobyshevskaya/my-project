package by.epam.drobyshevskaya.project.dao.impl;

import by.epam.drobyshevskaya.project.dao.ReaderDAO;
import by.epam.drobyshevskaya.project.bean.UserDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOImpl implements ReaderDAO {

    @Override
    public void addReader(UserDetail reader) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO readers (name, middleName, surname, address, phone) VALUES (?,?,?,?,?)")) {
            statement.setString(1, reader.getName());
            statement.setString(2, reader.getMiddleName());
            statement.setString(3, reader.getSurname());
            statement.setString(4, reader.getAddress());
            statement.setString(5, reader.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeReader(int id) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("DELETE FROM readers WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAddressById(String newAddress, int id) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("UPDATE readers SET address = ? WHERE id = ?")) {
            statement.setString(1, newAddress);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePhoneById(String newPhone, int id) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("UPDATE readers SET phone = ? WHERE id = ?")) {
            statement.setString(1, newPhone);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDetail getReaderById(int id) {
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM readers WHERE id = ?")) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                UserDetail reader = new UserDetail();
                reader.setId(id);
                reader.setName(rs.getString(2));
                reader.setMiddleName(rs.getString(3));
                reader.setSurname(rs.getString(4));
                reader.setAddress(rs.getString(5));
                reader.setPhone(rs.getString(6));
                return reader;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetail> getAllReaders() {
        List<UserDetail> readers = new ArrayList<>();
        try (Connection con = getConnection();
             Statement statement = con.createStatement();
             ResultSet set = statement.executeQuery("SELECT * FROM readers")) {

            while (set.next()) {
                UserDetail reader = new UserDetail();
                reader.setId(set.getInt(1));
                reader.setName(set.getString(2));
                reader.setMiddleName(set.getString(3));
                reader.setSurname(set.getString(4));
                reader.setAddress(set.getString(5));
                reader.setPhone(set.getString(6));
                readers.add(reader);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return readers;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "assa123assa");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
