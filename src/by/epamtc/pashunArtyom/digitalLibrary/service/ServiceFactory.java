
package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTUserService;

public class ServiceFactory {

    private static final ServiceFactory serviceLink = new ServiceFactory();
    private final TXTLibService bookService = new TXTLibService();
    private final TXTUserService userService = new TXTUserService();

    public ServiceFactory() {
    }

    public static ServiceFactory getServiceLink() {
        return serviceLink;
    }

    public TXTLibService getBookService() {
        return bookService;
    }

    public TXTUserService getClientService() {
        return userService;
    }
}
