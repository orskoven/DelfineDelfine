package UI;

import database.LoadTeams;
import database.Result;
import database.WriteResult;
import factory.DisciplineGenerator;
import factory.DisciplineGeneratorTraining;
import factory.MemberUpdate;
import persons.EliteSwimmer;

import java.io.IOException;

public class CoachMenu {
    private Menu menu = new Menu();
    private LoadTeams loadAllEliteSwimmers = new LoadTeams();
    private WriteResult writeResult = new WriteResult();
    private EliteSwimmer eliteSwimmer = new EliteSwimmer();
    private Result result = new Result();




    public void showCoachMenu() throws IOException {
        int coachChoice;

        do {
            optionsForCoach();
            coachChoice = menu.getUserInput();

            if (coachChoice == 1) {
                result.getTop5Result("butterfly");
                System.out.println();
                result.getTop5Result("breast stroke");
                System.out.println();
                result.getTop5Result("crawl");
                System.out.println();
                result.getTop5Result("back crawl");

                //new ResultsMenu();
                        /*
                        System.out.println("Choose:");
                        System.out.println("1. Junior\n2. Senior");
                        int topTeamInput = scanner.nextInt();
                        if (topTeamInput == 1) {
                        showTop5Junior.getOptions();
                    }
                    else if (topTeamInput == 2) {
                        showTop5Senior.getOptions();
                    }

                         */

            } else if (coachChoice == 2) {
                //Show elite swimmers
                eliteSwimmer.showJuniorTeam();
                System.out.println();
                eliteSwimmer.showSeniorTeam();

            } else if (coachChoice == 3) {
                //create training result
                writeResult.writerToFile(result.writeTrainingToCsv());
            } else if (coachChoice == 4){
                //competition rersult
                writeResult.writerToFile(result.writeCompetitionToCsv());

            } else if (coachChoice == 9) {
                break;
            }
            System.out.println();


        } while (coachChoice != 9);
    }

    public void optionsForCoach(){
        System.out.println("Coach options:");
        System.out.println("1. Show top 5 elite swimmers"); //juniors + seniors
        System.out.println("2. Show elite swimmers");
        System.out.println("3. Create a training result");
        System.out.println("4. Create a competition result");
        System.out.println("9. Return");
    }

}
