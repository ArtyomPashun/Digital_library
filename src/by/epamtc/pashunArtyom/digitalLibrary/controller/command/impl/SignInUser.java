package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTUserService;

public class SignInUser extends AbsCommand {

    @Override
    public String execute(String request) throws ControllerException {
        String response;
        if (currentUser.getUserRole() != UserRole.GUEST) {
            response = "You have logged in";
        } else {
            String[] args = request.split(" ");
            String login = args[0];
            String password = args[1];

            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTUserService clientService = serviceFactory.getClientService();

            try {
                User user = clientService.logIn(login, password);
                if (user == null) {
                    response = "Can not logIn " + login;
                } else {
                    currentUser = user;
                    response = currentUser.getUserRole() == UserRole.GUEST ? "Wrong login or password"
                            : "Welcome, " + currentUser.getUserLogin() + "!";}
            } catch (ServiceException e) {
                throw new ControllerException("CRR ERROR: Can not log in", e);
            }
        }
        return response;
    }
}
