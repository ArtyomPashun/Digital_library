package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.UserService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public class SignIn implements Command {
    @Override
    public String toDo(String request) throws ControllerException {
        String response = null;

        String[] req = request.split("; ");
        String userLogin = req[0];
        String userPassword = req[1];

        ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
        UserService userService = serviceFactory.getClientService();

        try {
            userService.signIn(userLogin, userPassword);
            response = "Welcome " + userLogin;
        } catch (ServiceException e) {
            response = "CONTROLLER ERROR: can not log in";
        }
        return response;
    }
}
