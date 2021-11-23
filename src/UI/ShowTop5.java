package UI;

import database.ReadResults;

import java.util.Scanner;

public class ShowTop5 {
     private Scanner scanner = new Scanner(System.in);
     private ReadResults readResults = new ReadResults();

    public void getOptions(){
        System.out.println("1.Butterfly\n2.Breaststroke\n3.Crawl\n4.Backcrawl");
        int userInputDiscipline = scanner.nextInt();
        switch (userInputDiscipline) {
            case 1 -> {
                System.out.println("Butterfly:");
                readResults.getTop5("resources/butterfly.csv");
            }
            case 2 -> {
                System.out.println("Breaststroke:");
                readResults.getTop5("resources/Breaststroke.csv");
            }
            case 3 -> {
                System.out.println("Crawl:");
                readResults.getTop5("resources/Crawl.csv");
            }
            case 4 -> {
                System.out.println("Backcrawl:");
                readResults.getTop5("resources/Backcrawl.csv");
            }
        }
    }}
