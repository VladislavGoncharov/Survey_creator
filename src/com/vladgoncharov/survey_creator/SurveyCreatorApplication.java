package com.vladgoncharov.survey_creator;

import com.vladgoncharov.survey_creator.application_management.StartMenuApplication;

public class SurveyCreatorApplication {

    public static final StartMenuApplication startMenuApplication = new StartMenuApplication();

    public static void main(String[] args) {

        startMenuApplication.startMenu();

    }
}
