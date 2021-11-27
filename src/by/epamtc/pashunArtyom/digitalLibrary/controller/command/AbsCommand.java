package by.epamtc.pashunArtyom.digitalLibrary.controller.command;

import by.epamtc.pashunArtyom.digitalLibrary.entity.User;

public abstract class AbsCommand implements Command {
    public static User currentUser = User.getGuestInstance();
}
