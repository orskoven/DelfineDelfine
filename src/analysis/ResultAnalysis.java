// AUTHOR : RASMUS & LAURA


package analysis;

import database.ReadAllMembers;
import database.ReadResults;
import persons.Result;
import persons.Member;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class ResultAnalysis {

    private CoachAnalysis eliteSwimmer = new CoachAnalysis();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private ReadResults readResults = new ReadResults();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Result> juniorResults = new ArrayList<Result>();
    private ArrayList<Result> allResults = new ArrayList<Result>();
    private ArrayList<Member> allMembers = new ArrayList<Member>();
    ArrayList<Result> seniorResults = new ArrayList<Result>();

    public void showElitenameAndId(){

        eliteMembers = eliteSwimmer.findEliteSwimmer();
        System.out.println("Elite Members:");

        for (int i = 0; i < eliteMembers.size(); i++) {
            System.out.println("Name: " + eliteMembers.get(i).getName() + "," + " Member ID: " +
                    eliteMembers.get(i).getMemberId());
        }
    }

    public ArrayList<Result> getJuniorResults(){
        juniorResults.removeAll(juniorResults);
        allResults.removeAll(allResults);
        allMembers.removeAll(allMembers);
        allResults = readResults.setFile();
        allMembers = readAllMembers.setFile();

        for (int i = 0; i < allResults.size(); i++) {
            for (int j = 0; j < allMembers.size(); j++) {
                if (allResults.get(i).getMemberId() == allMembers.get(j).getMemberId()&& allMembers.get(j).isUnder18() == true){
                    juniorResults.add(allResults.get(i));
                }
            }
        }
        return juniorResults;
    }

    public ArrayList<Result> getSeniorResults(){
        seniorResults.removeAll(seniorResults);
        allResults.removeAll(allResults);
        allMembers.removeAll(allMembers);
        allResults = readResults.setFile();
        allMembers = readAllMembers.setFile();

        for (int i = 0; i < allResults.size(); i++) {
            for (int j = 0; j < allMembers.size(); j++) {
                if (allResults.get(i).getMemberId() == allMembers.get(j).getMemberId() && allMembers.get(j).isUnder18() == false){
                    seniorResults.add(allResults.get(i));
                }
            }
        }
        return seniorResults;
    }

    public void getTop5Result(String disciplineName, int userInput){
        ArrayList<Result> results = new ArrayList<Result>();
        ArrayList<Result> eliteResult = new ArrayList<Result>();

        do {
            if (userInput == 1) {
                eliteResult = getJuniorResults();
            } else if (userInput == 2) {
                eliteResult = getSeniorResults();
            } else {
                System.out.println("Try again, type 1 or 2!");
            }
        }while (userInput != 1 && userInput != 2);


        for (int i = 0; i < eliteResult.size() ; i++) {
            if (eliteResult.get(i).getDisciplineName().toLowerCase(Locale.ROOT).equals(disciplineName) && eliteResult.get(i).getRank() == 0){
                results.add(eliteResult.get(i));
            }
        }

        Comparator<Result> resultSorting = Comparator.comparing(Result::getTimeResult);
        results.sort(resultSorting);

        if (results.size() == 0) {
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println("No results to show");
        } else if (results.size() == 1){
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
        } else if (results.size() == 2){
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
        } else if (results.size() == 3){
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
            System.out.println(results.get(2).top5ToString());
        }else if (results.size() == 4){
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
            System.out.println(results.get(2).top5ToString());
            System.out.println(results.get(3).top5ToString());
        } else{
            System.out.println("Top 5 in " + disciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
            System.out.println(results.get(2).top5ToString());
            System.out.println(results.get(3).top5ToString());
            System.out.println(results.get(4).top5ToString());
        }
        results.clear();
        eliteResult.clear();
    }

    public void getCompetitionResults(int userInput){
        ArrayList<Result> eliteResult = new ArrayList<Result>();
        ArrayList<Result> competitionResults = new ArrayList<Result>();

        do {
            if (userInput == 1) {
                eliteResult = getJuniorResults();
            } else if (userInput == 2) {
                eliteResult = getSeniorResults();
            } else {
                System.out.println("Try again, type 1 or 2!");
            }
        }while (userInput != 1 && userInput != 2);

        for (int i = 0; i < eliteResult.size(); i++) {
            if (eliteResult.get(i).getRank() != 0){
                competitionResults.add(eliteResult.get(i));
            }
        }

        for (int i = 0; i < competitionResults.size(); i++) {
            System.out.println(competitionResults.get(i).competitionToString());
        }

        if (competitionResults.size() == 0){
            System.out.println("There are no competition results!");
        }

        competitionResults.removeAll(competitionResults);
        eliteResult.removeAll(eliteResult);
    }

}
