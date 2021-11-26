package UI;

import factory.MemberUpdate;

import java.io.IOException;
import java.util.Scanner;

public class ResultsMenu {
    Scanner scanner = new Scanner(System.in);
    private ShowTop5JuniorCompetition showTop5JuniorCompetition = new ShowTop5JuniorCompetition();
    private ShowTop5JuniorTraining showTop5JuniorTraining = new ShowTop5JuniorTraining();
    private ShowTop5SeniorCompetition showTop5SeniorCompetition = new ShowTop5SeniorCompetition();
    private ShowTop5SeniorTraining showTop5SeniorTraining = new ShowTop5SeniorTraining();


    public ResultsMenu() throws IOException {
        firstMenu();
        int resultsChoice = scanner.nextInt();
        switch (resultsChoice) {
            case 1:
                getJuniorResultsMenu();
                break;
            case 2:
                getSeniorResultsMenu();
                break;
            case 9:
                break;
        }
    }

    public void firstMenu() {
        System.out.println("Choose:");
        System.out.println("1. Junior\n2. Senior\n9. Quit");
    }

    public void getJuniorResultsMenu() throws IOException {
        System.out.println("Choose: ");
        System.out.println("1. Training \n2. Competition\n9. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice) {
            case 1:
                showTop5JuniorCompetition.getOptions();
                break;
            case 2:
                showTop5JuniorCompetition.getOptions();
                break;
            case 9:
                new ResultsMenu();

        }
    }

    public void getSeniorResultsMenu() throws IOException {
        System.out.println("Choose: ");
        System.out.println("1. Training \n2. Competition\n9. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice) {
            case 1:
                showTop5SeniorTraining.getOptions();
                break;
            case 2:
                showTop5SeniorCompetition.getOptions();
                break;
            case 9:
                new ResultsMenu();

        }
    }
}