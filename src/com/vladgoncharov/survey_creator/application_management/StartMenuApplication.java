package com.vladgoncharov.survey_creator.application_management;

import com.vladgoncharov.survey_creator.SurveyCreatorApplication;

import java.util.Scanner;

public class StartMenuApplication {

    public static Scanner scanner;
    private String[] command;

    public StartMenuApplication() {
    }

    public void startMenu() {
        System.out.println(
                "------------------------- \n" +
                "Enter one of the commands \n" +
                "-------------------------\n" +
                "○  create <name> \n" +
                "○  list \n" +
                "○  view <name> \n" +
                "○  delete <name> \n" +
                "○  exit \n" +
                "-------------------------");

        scanner = new Scanner(System.in);
        command = scanner.nextLine().split(" ");

        switch (command[0].toLowerCase()) {
            case "create":
                new CommandIsCreate(command);
                break;
            case "list":
                new CommandIsList();
                break;
            case "view":
                new CommandIsView(command);
                break;
            case "delete":
                new CommandIsDelete(command);
                break;
            case "exit":
                new CommandIsExit();
                break;
            default:
                System.out.println(command[0] + " - this is the wrong command, try again");
                SurveyCreatorApplication.startMenuApplication.startMenu();
        }
    }
}
