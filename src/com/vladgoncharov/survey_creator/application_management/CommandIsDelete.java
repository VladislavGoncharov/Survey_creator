package com.vladgoncharov.survey_creator.application_management;

import com.vladgoncharov.survey_creator.SurveyCreatorApplication;

public class CommandIsDelete extends CommandAbstract {

    private StringBuilder surveyName;

    public CommandIsDelete(String[] surveyName) {
        this.surveyName = changeNameOfSurvey(surveyName);

        deleteSurveyByName();

        SurveyCreatorApplication.startMenuApplication.startMenu();
    }

    private void deleteSurveyByName() {
        CommandIsCreate deleteSurvey = searchForSurveyByName(surveyName);

        if (deleteSurvey != null) {
            CommandIsList.fullListOfSurveys.remove(deleteSurvey);
            System.out.println("\nThe " + deleteSurvey.getSurveyName() + " was deleted successfully!\n");
        } else System.out.println("There is no such survey");

    }
}
