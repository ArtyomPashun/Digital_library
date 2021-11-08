package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public class Register implements Command {
    @Override
    public String toDo(String request) throws ControllerException {
        String response = null;
        String[] temp = request.split("; ");
        User newUser = new User();
        newUser.setUserLogin(temp[0]);
        newUser.setUserPassword(temp[1]);
        newUser.setUserRole(UserRole.USER);
        try {
            ServiceFactory.getServiceLink().getClientService().register(newUser);
            response = "User has been registered successfully";
        } catch (ServiceException e) {
            throw new ControllerException("CONTROLLER ERROR: can not register new user");
        }
        return response;
    }
}
