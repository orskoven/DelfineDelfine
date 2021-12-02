package UI;


import factory.Result;
import database.WriteResult;
import persons.EliteSwimmer;

import java.io.IOException;

public class CoachMenu {
    private Menu menu = new Menu();

    private WriteResult writeResult = new WriteResult();
    private EliteSwimmer eliteSwimmer = new EliteSwimmer();
    private Result result = new Result();


    public void showCoachMenu() throws IOException {
        int coachMenuChoice;
        int coachTrainingResultChoice;
        int coachCompetitionChoice;

        do {
            optionsForCoach();
            coachMenuChoice = menu.getUserInput();

            if (coachMenuChoice == 1) {
                //Show top 5
                showResultsOptions();
                coachTrainingResultChoice = menu.getUserInput();

                //Skal der opdeles så det kun er træningsresultater der bliver vist?
                result.getTop5Result("butterfly",coachTrainingResultChoice);
                System.out.println();
                result.getTop5Result("breast stroke",coachTrainingResultChoice);
                System.out.println();
                result.getTop5Result("crawl",coachTrainingResultChoice);
                System.out.println();
                result.getTop5Result("back crawl",coachTrainingResultChoice);



            } else if (coachMenuChoice ==2){
                //Show Competitions Results
                showCompetitionOptions();
                coachCompetitionChoice = menu.getUserInput();

                result.getCompetitionResults(coachCompetitionChoice);


            } else if (coachMenuChoice == 3) {
                //Show elite swimmers
                eliteSwimmer.showJuniorTeam();
                System.out.println();
                eliteSwimmer.showSeniorTeam();

            } else if (coachMenuChoice == 4) {
                //create training result
                writeResult.writerToFile(result.writeTrainingToCsv());
            } else if (coachMenuChoice == 5){
                //competition rersult
                writeResult.writerToFile(result.writeCompetitionToCsv());

            } else if (coachMenuChoice == 9) {
                break;
            }
            System.out.println();


        } while (coachMenuChoice != 9);
    }

    public void optionsForCoach(){
        System.out.println("Coach options:");
        System.out.println("1. Show top 5 results"); //juniors + seniors
        System.out.println("2. Show competition results");
        System.out.println("3. Show elite swimmers");
        System.out.println("4. Create a training result");
        System.out.println("5. Create a competition result");
        System.out.println("9. Return");
    }

    public void showResultsOptions(){
        System.out.println("Show top 5 results: ");
        System.out.println("1. Junior");
        System.out.println("2. Senior");
    }

    public void showCompetitionOptions(){
        System.out.println("Show competitions results: ");
        System.out.println("1. Junior");
        System.out.println("2. Senior");
    }




}
