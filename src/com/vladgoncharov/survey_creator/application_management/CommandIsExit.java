package com.vladgoncharov.survey_creator.application_management;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandIsExit {

    public CommandIsExit() {
        saveFile();
        System.exit(0);
    }

    private void saveFile() {
        File file;

        try {
            file = getNewFile();
        } catch (Exception e) {
            file = new File("Survey.txt");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (CommandIsCreate survey : CommandIsList.fullListOfSurveys) {

                bufferedWriter.write("\t" + survey.getSurveyName() + "\n");
                bufferedWriter.write("\t\t" + survey.getTopic() + "\n");

                for (String line : survey.getPossibleAnswers()) {
                    bufferedWriter.write("\t\t" + line + "\n");
                }

                bufferedWriter.write("*************************************************************************\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StartMenuApplication.scanner.close();
        }

        System.out.println("The file is saved in the following path");
        System.out.println(file.getAbsolutePath());

    }

    private File getNewFile() throws Exception {
        File file = null;

        // определяет путь до папки Документы
        Path path = Path.of(FileSystemView.getFileSystemView().getDefaultDirectory().getPath());

        if (path.isAbsolute()) {
            // изменяю путь и проверяю, существует ли папка с именем "Survey_create"
            path = Path.of(path + "\\Survey_create");

            if (!Files.isDirectory(path)) {
                Files.createDirectories(path);
            }

            file = new File(createNewPathWithFileName(path.toString()));
        }


        return file;
    }

    private String createNewPathWithFileName(String pathToDirectory) {
        Path pathToFile = Path.of(pathToDirectory + "\\Survey №1.txt");

        // проверка на индивидуальность имени файла
        while (Files.exists(pathToFile)) {

            String[] arrayPathToFile = pathToFile.toString().split("№");
            // нахожу номер опроса и кладу в переменную i
            int i = Integer.parseInt(arrayPathToFile[1].substring(0, arrayPathToFile[1].indexOf(".")));
            // создаю новый путь и увеличиваю номер опроса на 1 и вновь проверяю
            pathToFile = Path.of(arrayPathToFile[0] + "№" + (++i) + ".txt");

        }

        return pathToFile.toString();
    }
}
