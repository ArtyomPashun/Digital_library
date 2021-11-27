package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTUserService;

public class RegisterUser extends AbsCommand {
    @Override
    public String execute(String request) throws ServiceException, ControllerException {
        String response;

        String login;
        String password;
        String[] requestParams;

        if (currentUser.getUserRole() != UserRole.GUEST) {
            response = "You have been registered";
        } else {
            requestParams = request.split(" ");
            login = requestParams[0];
            password = requestParams[1];

            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTUserService clientService = serviceFactory.getClientService();

            try {
                User user = clientService.register(new User(login, password));
                if (user == null)
                    response = "Invalid input parameters!";
                else {
                    currentUser = user;
                    response = "Successfully registered!";
                }
            } catch (ServiceException e) {
                throw new ControllerException("CRR: Error during registration procedure", e);
            }
        }
        return response;
    }
}
