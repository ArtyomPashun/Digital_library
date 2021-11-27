package by.epamtc.pashunArtyom.digitalLibrary.view;

import by.epamtc.pashunArtyom.digitalLibrary.controller.Controller;

import java.util.Scanner;

public class View {
    private final static Controller controller = new Controller();
    private final static Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to the library");

        String request;
        String response;

        try {
            do {
                request = scanner.nextLine();
                response = controller.executeTask(request);
                if (response != null)
                    System.out.println(response);
                else break;
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
