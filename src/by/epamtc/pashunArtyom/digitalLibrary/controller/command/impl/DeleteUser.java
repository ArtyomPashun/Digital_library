package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTUserService;

public class DeleteUser extends AbsCommand {
    @Override
    public String execute(String request) throws ServiceException, ControllerException {
        String response;

        String login;
        String password;
        String[] requestParams;

        if (currentUser.getUserRole() == UserRole.ADMIN)
            response = "You have no permission to delete User";
        else {
            requestParams = request.split(" ");
            login = requestParams[0];
            password = requestParams[1];

            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTUserService clientService = serviceFactory.getClientService();

            try {
                clientService.delete(login, password);
                response = "User is deleted";
            } catch (ServiceException e) {
                response = "deleting error";
                throw new ControllerException("CRR ERROR: Error during user deleting", e);
            }
        }
        return response;
    }
}