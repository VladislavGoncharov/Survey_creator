package com.vladgoncharov.survey_creator.application_management;

import com.vladgoncharov.survey_creator.SurveyCreatorApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommandIsCreate extends CommandAbstract {

    private StringBuilder surveyName;
    private String topic;
    private int numberOfPossibleAnswers;
    private List<String> possibleAnswers;

    public CommandIsCreate(String[] surveyName) {
        this.surveyName = changeNameOfSurveyWithChecked(surveyName);
        possibleAnswers = new ArrayList<>();
        createSurvey();


        SurveyCreatorApplication.startMenuApplication.startMenu();
    }

    private void createSurvey() {
        createTopic();
        createNumberOfPossibleAnswers();
        createPossibleAnswers();

        CommandIsList.fullListOfSurveys.add(this);

        System.out.println("\nThe survey was created successfully!\n");
    }

    private void createTopic() {
        System.out.println("Enter a topic");
        StartMenuApplication.scanner = new Scanner(System.in);
        topic = StartMenuApplication.scanner.nextLine().trim();
        if (topic.isEmpty()) topic = "Noname";
    }

    private void createNumberOfPossibleAnswers() {
        System.out.println("Enter the number of possible answers");
        StartMenuApplication.scanner = new Scanner(System.in);
        try {
            numberOfPossibleAnswers = StartMenuApplication.scanner.nextInt();
            if (numberOfPossibleAnswers < 2 || numberOfPossibleAnswers > 15) {
                System.out.println("Range from 2 to 15");
                System.out.println("!****************!");
                createNumberOfPossibleAnswers();
            }
        } catch (InputMismatchException exception) {
            System.out.println("You only need to enter numbers!Try again");
            System.out.println("!**************************************!");
            createNumberOfPossibleAnswers();
        }
    }

    private void createPossibleAnswers() {

        for (int i = 1; i <= numberOfPossibleAnswers; i++) {
            System.out.println("Enter possible answers № " + i);

            StartMenuApplication.scanner = new Scanner(System.in);
            String answers = StartMenuApplication.scanner.nextLine();

            if (answers.isEmpty()) possibleAnswers.add("\t- the answer №" + i + " option was skipped");
            else possibleAnswers.add("   - " + answers);
        }
    }

    public StringBuilder getSurveyName() {
        return surveyName;
    }

    public String getTopic() {
        return topic;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}
