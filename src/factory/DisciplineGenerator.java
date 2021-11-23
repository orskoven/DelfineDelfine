package factory;

import database.SaveDiscipline;
import disciplines.*;

import java.util.Scanner;

public class DisciplineGenerator {
    private Scanner scanner = new Scanner(System.in);
    private SaveDiscipline saveDiscipline = new SaveDiscipline();
    private String name;
    private int id;
    private int time;
    private String location;
    private String date;
    private String tournament;
    private int rank;

    public DisciplineGenerator(int userInput) {
        System.out.println("Id: ");
        this.id = Integer.parseInt(String.valueOf(scanner.nextInt()));
        System.out.println("Time in minutes and seconds: ");
        this.time = Integer.parseInt(String.valueOf(scanner.nextInt()));
        System.out.println("Date: ");
        this.date = String.valueOf(scanner.nextLine());

        if (this.date.isEmpty()){
            this.date = scanner.nextLine();
        }

        System.out.println("Rank: ");
        this.rank = Integer.parseInt(String.valueOf(scanner.nextInt()));
        System.out.println("Name: ");
        this.name = String.valueOf(scanner.nextLine());

        if (this.name.isEmpty()){
            this.name = scanner.nextLine();
        }

        System.out.println("Location: ");
        this.location = String.valueOf(scanner.nextLine());
        System.out.println("Tournament: ");
        this.tournament = String.valueOf(scanner.nextLine());
        if (userInput == 1){
            saveDiscipline.saveDiscipline( new BackCrawl(name,  id,  time,  location,  date,  tournament,  rank),
                    "resources/backCrawl.csv");
        }  if (userInput == 2){
            saveDiscipline.saveDiscipline( new BreastStroke(name,  id,  time,  location,  date,  tournament,  rank),
                    "resources/breastStroke.csv");
        } if (userInput == 3){
            saveDiscipline.saveDiscipline( new Crawl(name,  id,  time,  location,  date,  tournament,  rank),
                    "resources/crawl.csv");
        } if (userInput == 4){
            saveDiscipline.saveDiscipline( new Butterfly(name,  id,  time,  location,  date,  tournament,  rank),
                    "resources/butterfly.csv");

        }
    }
}
