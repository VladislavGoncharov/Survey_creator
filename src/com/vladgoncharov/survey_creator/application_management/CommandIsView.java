package com.vladgoncharov.survey_creator.application_management;

import com.vladgoncharov.survey_creator.SurveyCreatorApplication;

public class CommandIsView extends CommandAbstract {

    private StringBuilder surveyName;

    public CommandIsView(String[] surveyName) {
        this.surveyName = changeNameOfSurvey(surveyName);
        CommandIsCreate survey = searchForSurveyByName(this.surveyName);
        showSurvey(survey);
        SurveyCreatorApplication.startMenuApplication.startMenu();
    }


    private void  showSurvey(CommandIsCreate survey) {
        if (survey == null) System.out.println("There is no such survey");
        else {
            System.out.println(
                    survey.getSurveyName() + "\n"+
                    survey.getTopic()
            );
            survey.getPossibleAnswers().forEach(System.out::println);
        }
    }

}
