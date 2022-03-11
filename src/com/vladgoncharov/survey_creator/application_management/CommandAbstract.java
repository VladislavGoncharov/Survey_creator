package com.vladgoncharov.survey_creator.application_management;

public abstract class CommandAbstract {

    public StringBuilder changeNameOfSurveyWithChecked(String[] surveyNameArray) {
        try {
            char firstLetterUpperCase = surveyNameArray[1].toUpperCase().charAt(0);


            StringBuilder surveyName = new StringBuilder();
            for (int i = 1; i < surveyNameArray.length; i++) {
                if (i == 1) {
                    surveyNameArray[1] = firstLetterUpperCase + surveyNameArray[1].substring(1);
                }
                surveyName.append(surveyNameArray[i]).append(" ");
            }

            CommandIsCreate checkingForAnIndividualName = searchForSurveyByName(surveyName);

            if (checkingForAnIndividualName != null)
                surveyName.append("№").append(CommandIsList.fullListOfSurveys.size());

            return surveyName;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return new StringBuilder("Noname №" + CommandIsList.fullListOfSurveys.size());
        }
    }

    public StringBuilder changeNameOfSurvey(String[] surveyNameArray) {
        try {
            StringBuilder surveyName = new StringBuilder();
            for (int i = 1; i < surveyNameArray.length; i++) {
                surveyName.append(surveyNameArray[i]).append(" ");
            }
            return surveyName;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return new StringBuilder("Noname №" + CommandIsList.fullListOfSurveys.size());
        }
    }

    public CommandIsCreate searchForSurveyByName(StringBuilder surveyName) {

        CommandIsCreate searchResult = null;
        for (CommandIsCreate survey : CommandIsList.fullListOfSurveys) {
            if (surveyName.toString().trim().equalsIgnoreCase(survey.getSurveyName().toString().trim())) {
                searchResult = survey;
                break;
            }
        }

        return searchResult;
    }
}
