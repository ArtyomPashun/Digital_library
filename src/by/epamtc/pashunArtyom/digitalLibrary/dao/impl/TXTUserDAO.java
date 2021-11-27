package by.epamtc.pashunArtyom.digitalLibrary.dao.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.UserDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.dao.properties.PropertiesHolder;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TXTUserDAO implements UserDAO {

    public final static String PATH_TO_USER_LIST = PropertiesHolder.getProperty("USERS_FILE_PATH");
    public final static String DELIMITER = "/";

    @Override
    public void register(User newUser) throws DAOException {
        List<User> userList;

        try {
            userList = scanUsersFromFile();
            for (User u : userList) {
                if (newUser.getUserLogin().equals(u.getUserLogin())) {
                    throw new DAOException("DAO ERROR: This login is already in use");
                }
            }
            userList.add(newUser);
            addUsersInformationInFile(userList);
        } catch (IOException e) {
            throw new DAOException("DAO ERROR: Registration process error", e);
        }
    }

    @Override
    public void delete(String login, String password) throws DAOException {
        List<User> userList;

        try {
            userList = scanUsersFromFile();
            for (int i = 0; i < userList.size(); i++) {
                if (login.equals(userList.get(i).getUserLogin())) {
                    if (!password.equals(userList.get(i).getUserPassword())) {
                        throw new DAOException("DAO ERROR: Wrong password input");
                    }
                    userList.remove(i);
                    break;
                }
            }
            addUsersInformationInFile(userList);
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            throw new DAOException("DAO ERROR: User deleting process error", e);
        }
    }

    @Override
    public User logIn(String login, String password) throws DAOException {
        User user = User.getGuestInstance();
        List<User> userList;

        try {
            userList = scanUsersFromFile();
            for (User value : userList)
                if (login.equals(value.getUserLogin()) && password.equals(value.getUserPassword())) {
                    user = value;
                }
        } catch (IOException | NumberFormatException e) {
            throw new DAOException("DAO ERROR: Authorization process error", e);
        }
        return user;
    }

    public List<User> scanUsersFromFile() throws DAOException, IOException {
        List<User> userList = new ArrayList<>();
        String temp;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_USER_LIST));
            while ((temp = reader.readLine()) != null) {
                String[] array = temp.split(DELIMITER);
                User user = new User();
                user.setUserLogin(array[0]);
                user.setUserPassword(array[1]);
                user.setUserRole(UserRole.valueOf(array[2]));
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            throw new DAOException("DAO ERROR: can not read user file", e);
        }
        return userList;
    }

    public void addUsersInformationInFile(List<User> userList) throws DAOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_USER_LIST, false));
            for (User u : userList) {
                writer.append(String.valueOf(u.getUserLogin())).append(DELIMITER)
                        .append(u.getUserPassword()).append(DELIMITER)
                        .append(u.getUserRole().toString())
                        .append('\n');
            }
            writer.close();
        } catch (IOException e) {
            throw new DAOException("DAO ERROR:users.txt file could not be open", e);
        }
    }
}
