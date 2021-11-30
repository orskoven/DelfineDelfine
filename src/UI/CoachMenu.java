package UI;

import database.LoadTeams;
import factory.DisciplineGenerator;
import factory.DisciplineGeneratorTraining;
import factory.MemberUpdate;

import java.io.IOException;

public class CoachMenu {
    private Menu menu = new Menu();
    private LoadTeams loadAllEliteSwimmers = new LoadTeams();



    public void showCoachMenu() throws IOException {
        int coachChoice;

        do {
            optionsForCoach();
            coachChoice = menu.getUserInput();

            if (coachChoice == 1) {
                new ResultsMenu();
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

                //eliteSwimmer.addEliteSwimmer();

                loadAllEliteSwimmers.loadingTeams();
                System.out.println("Juniors " + loadAllEliteSwimmers.getTeamJunior());
                System.out.println();
                System.out.println("Seniors " + loadAllEliteSwimmers.getTeamSenior());

            } else if (coachChoice == 3) {
                //create result
                System.out.println("1.Training\n2.Competition");
                int userInputResultType = menu.getUserInput();
                if (userInputResultType == 1) {
                    System.out.println("1.Butterfly\n2.Breaststroke\n3.Crawl\n4.Backcrawl");
                    int userInputDiscipline = menu.getUserInput();
                    DisciplineGeneratorTraining disciplineGenerator = new DisciplineGeneratorTraining(userInputDiscipline);
                }
                if (userInputResultType == 2) {
                    System.out.println("1.Butterfly\n2.Breaststroke\n3.Crawl\n4.Backcrawl");
                    int userInputDiscipline = menu.getUserInput();
                    DisciplineGenerator disciplineGenerator = new DisciplineGenerator(userInputDiscipline);
                }
            } else if (coachChoice == 9) {
                break;
            }


        } while (coachChoice != 9);
    }

    public void optionsForCoach(){
        System.out.println("Coach options:");
        System.out.println("1. Show top 5 elite swimmers"); //juniors + seniors
        System.out.println("2. Show elite swimmers");
        System.out.println("3. Create a result");
        System.out.println("9. Return");
    }

}
