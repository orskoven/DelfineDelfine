// AUTHOR : ELISA & LAURA


package UI;


import analysis.ResultAnalysis;
import database.MemberToSave;
import persons.Result;
import database.WriteResult;
import factory.ResultGenerator;
import analysis.CoachAnalysis;

import java.io.IOException;

public class CoachMenu {
    private Menu menu = new Menu();

    private WriteResult writeResult = new WriteResult();
    private CoachAnalysis eliteSwimmer = new CoachAnalysis();
    private Result result = new Result();
    private ResultGenerator resultGenerator = new ResultGenerator();
    private ResultAnalysis resultAnalysis = new ResultAnalysis();

    public void optionsForCoach(){
        System.out.println("Coach options:");
        System.out.println("1. Show top 5 training results");
        System.out.println("2. Show competition results");
        System.out.println("3. Show elite swimmers");
        System.out.println("4. Create a training result");
        System.out.println("5. Create a competition result");
        System.out.println("9. Return");
    }

    public void showResultsOptions(){
        System.out.println("Show top 5 training results: ");
        System.out.println("1. Junior");
        System.out.println("2. Senior");
    }

    public void showCompetitionOptions(){
        System.out.println("Show competitions results: ");
        System.out.println("1. Junior");
        System.out.println("2. Senior");
    }

    public void showCoachMenu() throws IOException {
        int coachMenuChoice;
        int coachTrainingResultChoice;
        int coachCompetitionChoice;

        do {
            optionsForCoach();
            coachMenuChoice = menu.getUserInput();

            if (coachMenuChoice == 1) {
                //Show top 5 training
                showResultsOptions();
                coachTrainingResultChoice = menu.getUserInput();

                resultAnalysis.getTop5Result("butterfly",coachTrainingResultChoice);
                System.out.println();
                resultAnalysis.getTop5Result("breast stroke",coachTrainingResultChoice);
                System.out.println();
                resultAnalysis.getTop5Result("crawl",coachTrainingResultChoice);
                System.out.println();
                resultAnalysis.getTop5Result("back crawl",coachTrainingResultChoice);



            } else if (coachMenuChoice ==2){
                //Show Competitions Results
                showCompetitionOptions();
                coachCompetitionChoice = menu.getUserInput();

                resultAnalysis.getCompetitionResults(coachCompetitionChoice);


            } else if (coachMenuChoice == 3) {
                //Show elite swimmers
                eliteSwimmer.showJuniorTeam();
                System.out.println();
                eliteSwimmer.showSeniorTeam();

            } else if (coachMenuChoice == 4) {
                //create training result
                MemberToSave.writerToFile(resultGenerator.writeTrainingToCsv());
            } else if (coachMenuChoice == 5){
                //competition result
                MemberToSave.writerToFile(resultGenerator.writeCompetitionToCsv());

            } else if (coachMenuChoice == 9) {
                break;
            }
            System.out.println();


        } while (coachMenuChoice != 9);
    }
}