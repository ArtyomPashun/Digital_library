package by.epamtc.pashunArtyom.digitalLibrary.dao.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.UserDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TXTUserDAO implements UserDAO {

    public final static String PATH_TO_USER_LIST = "./resources/users.txt";
    public final static String DELIMITER = "; ";

    @Override
    public void register(User user) throws DAOException {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_USER_LIST, true)) {
            fileWriter.append(user.getUserLogin() + DELIMITER + user.getUserPassword() + DELIMITER);
        } catch (Exception e) {
            throw new DAOException("DAO ERROR: User file is not found");
        }
    }

    @Override
    public void authorize(String login, String password) throws DAOException {

    }

    public List<User> readAll() throws DAOException, IOException {
        List<User> result = new ArrayList<>();
        String temp;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_USER_LIST));
            while ((temp = reader.readLine()) != null) {
                String[] array = temp.split(DELIMITER);
                User user = new User();
                user.setUserLogin((array[0]));
                user.setUserPassword(array[1]);
                result.add(user);
            }
        } catch (Exception e) {
            throw new DAOException("DAO ERROR: File is not found");
        }
        return result;
    }
}
