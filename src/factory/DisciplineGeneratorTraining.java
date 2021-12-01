package factory;

import database.LookUpMember;
import database.SaveDiscipline;
import disciplines.BackCrawl;
import disciplines.BreastStroke;
import disciplines.Butterfly;
import disciplines.Crawl;
import persons.Member;

import java.io.IOException;
import java.util.Scanner;

public class DisciplineGeneratorTraining {
    private Scanner scanner = new Scanner(System.in);
    private SaveDiscipline saveDiscipline = new SaveDiscipline();
    private String name;
    private int id;
    private int time;
    private String location;
    private String date;
    private String tournament;
    private int rank;
    private LookUpMember currentMember = new LookUpMember();

    public DisciplineGeneratorTraining(int userInput) throws IOException {
        Member memberToLoad = currentMember.LookUpMember();
        this.id = memberToLoad.getMemberId();
        System.out.println("Time in minutes: ");
        int timeMinutes = Integer.parseInt(String.valueOf(scanner.nextInt()))*60;
        System.out.println("Time in seconds: ");
        this.time = Integer.parseInt(String.valueOf(scanner.nextInt())+timeMinutes);
        System.out.println("Date: ");
        this.date = String.valueOf(scanner.nextLine());
        if (this.date.isEmpty()){
            this.date = scanner.nextLine();
        }
        this.name = memberToLoad.getName();
        if (memberToLoad.isUnder18()){
        if (userInput == 1){
            saveDiscipline.saveDiscipline( new Butterfly(name,  id,  time,  location,  date,  tournament, rank),
                    "resources/eliteResults/juniorResults/training/butterfly.csv");
        }  if (userInput == 2){
            saveDiscipline.saveDiscipline( new BreastStroke(name,  id,  time,  location,  date,  tournament, rank),
                    "resources/eliteResults/juniorResults/training/breastStroke.csv");
        } if (userInput == 3){
            saveDiscipline.saveDiscipline( new Crawl(name,  id,  time, location,  date,  tournament, rank),
                    "resources/eliteResults/juniorResults/training/crawl.csv");
        } if (userInput == 4){
                saveDiscipline.saveDiscipline( new BackCrawl(name,  id,  time,  location,  date,  tournament, rank),
                        "resources/eliteResults/juniorResults/training/backCrawl.csv");
        }
    } else if (!memberToLoad.isUnder18()) {
            saveDiscipline.saveDiscipline( new Butterfly(name,  id,  time,  location,  date,  tournament, rank),
                    "resources/eliteResults/seniorResults/training/butterfly.csv");
        }  if (userInput == 2){
            saveDiscipline.saveDiscipline( new BreastStroke(name,  id,  time,  location,  date,  tournament, rank),
                    "resources/eliteResults/seniorResults/training/breastStroke.csv");
        } if (userInput == 3){
            saveDiscipline.saveDiscipline( new Crawl(name,  id,  time, location,  date,  tournament, rank),
                    "resources/eliteResults/seniorResults/training/crawl.csv");
        } if (userInput == 4){
            saveDiscipline.saveDiscipline( new BackCrawl(name,  id,  time,  location,  date,  tournament, rank),
                    "resources/eliteResults/seniorResults/training/backCrawl.csv");
        }
    }
}