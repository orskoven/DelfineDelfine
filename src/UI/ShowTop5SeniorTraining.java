package UI;

import database.ReadResults;

import java.util.Scanner;

public class ShowTop5SeniorTraining {
     private Scanner scanner = new Scanner(System.in);
     private ReadResults readResults = new ReadResults();

    public void showTop5Disciplines(){
        System.out.println("Show top 5 in:");
        System.out.println("1. Butterfly\n2. Breaststroke\n3. Crawl\n4. Backcrawl");
    }
/*
    public void getOptions(){
        showTop5Disciplines();
        int userInputDiscipline = scanner.nextInt();
        switch (userInputDiscipline) {
            case 1 -> {
                System.out.println("Top 5 Butterfly:");
                readResults.getTop5("resources/eliteResults/seniorResults/training/butterfly.csv");
            }
            case 2 -> {
                System.out.println("Top 5 Breaststroke:");
                readResults.getTop5("resources/eliteResults/seniorResults/training/breastStroke.csv");
            }
            case 3 -> {
                System.out.println("Top 5 Crawl:");
                readResults.getTop5("resources/eliteResults/seniorResults/training/crawl.csv");
            }
            case 4 -> {
                System.out.println("Top 5 Backcrawl:");
                readResults.getTop5("resources/eliteResults/seniorResults/training/backcrawl.csv");
            }
        }
    }*/}
