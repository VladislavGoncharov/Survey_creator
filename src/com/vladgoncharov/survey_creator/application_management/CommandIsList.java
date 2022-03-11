package com.vladgoncharov.survey_creator.application_management;

import com.vladgoncharov.survey_creator.SurveyCreatorApplication;

import java.util.ArrayList;
import java.util.List;

public class CommandIsList {

    public static List<CommandIsCreate> fullListOfSurveys = new ArrayList<>();

    public CommandIsList() {
        showFullSurvey();
        SurveyCreatorApplication.startMenuApplication.startMenu();
    }

    private void showFullSurvey() {
        System.out.println("-------------------------");
        System.out.println("List of created surveys");
        System.out.println("-------------------------");
        if (fullListOfSurveys.isEmpty()) {
            System.out.println("You haven't created any surveys yet");
        } else {
            for (CommandIsCreate survey : fullListOfSurveys) {
                System.out.println(survey.getSurveyName() + " ( " + survey.getTopic() + " )");
            }
        }
    }
}
