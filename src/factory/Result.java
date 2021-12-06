package factory;

import UI.Menu;
import database.ReadAllMembers;
import database.ReadResults;
import persons.EliteSwimmer;
import persons.Member;

import java.util.*;


public class Result {
    private Scanner scanner = new Scanner(System.in);
    private String disciplineName;
    private String nameOfMember;
    private int memberId;
    private String tournamentName;
    private String timestamp;
    private String timeResult;
    private int rank;
    private Menu menu = new Menu();
    private EliteSwimmer eliteSwimmer = new EliteSwimmer();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private ReadResults readResults = new ReadResults();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Result> juniorResults = new ArrayList<Result>();
    private ArrayList<Result> allResults = new ArrayList<Result>();
    private ArrayList<Member> allMembers = new ArrayList<Member>();
    ArrayList<Result> seniorResults = new ArrayList<Result>();

    public Result() {
    }

    public Result(String disciplineName, String nameOfMember, int memberId, String timestamp, String tournamentName, String timeResult, int rank) {
        this.disciplineName = disciplineName;
        this.nameOfMember = nameOfMember;
        this.memberId = memberId;
        this.timestamp = timestamp;
        this.tournamentName = tournamentName;
        this.timeResult = timeResult;
        this.rank = rank;
    }
    public void chooseRank (){
        System.out.println("Enter rank result:");
        rank = scanner.nextInt();
    }

    private void chooseTimeResult (){
        System.out.println("Enter the time result: (hh:mm:ss)");
        timeResult = scanner.next();

    }


    private String chooseDisciplineName() {
        System.out.println("Press the following numbers for a discipline:\n1 ‣ Butterfly" +
                "\n2 ‣ Breast Stroke\n3 ‣ Crawl\n4 ‣ Back Crawl");
        int disciplineChoice = menu.getUserInput();
        switch (disciplineChoice) {
            case 1:
                disciplineName = "Butterfly";
                break;
            case 2:
                disciplineName = "Breast Stroke";
                break;
            case 3:
                disciplineName = "Crawl";
                break;
            case 4:
                disciplineName = "Back Crawl";
                break;
            default:
                break;
        }
        return disciplineName;
    }

    public String writeTrainingToCsv() {
        addMemberIdAndNameToResult();
        chooseDisciplineName();
        getTimestamp();
        chooseTimeResult();
        setTournamentNameToNull();
        setRankTo0();
        return toStringCsv();
    }

    public String writeCompetitionToCsv() {
        addMemberIdAndNameToResult();
        chooseDisciplineName();
        getTournamentName();
        chooseRank();
        getTimestamp();
        chooseTimeResult();
        return toStringCsv();
    }

    public void showElitenameAndId(){
        //se om den fordobles hvis den køres flere gange
        eliteMembers = eliteSwimmer.findEliteSwimmer();
        System.out.println("Elite Members:");

        for (int i = 0; i < eliteMembers.size(); i++) {
            System.out.println("Name: " + eliteMembers.get(i).getName() + "," + " Member ID: " +
                    eliteMembers.get(i).getMemberId());
        }
    }

    public void addMemberIdAndNameToResult(){
        //se om den fordobles hvis den køres flere gange
        eliteMembers = eliteSwimmer.findEliteSwimmer();

        boolean isIdFound = false;
        do {
            try {
                System.out.println("Type in the member ID");
                showElitenameAndId();
                int userinput = menu.getUserInput();

                 for (int i = 0; i < eliteMembers.size(); i++) {
                     if (eliteMembers.get(i).getMemberId() == userinput) {
                     memberId = userinput;
                     nameOfMember = eliteMembers.get(i).getName();
                     isIdFound = true;

                     //userinput og user name addes til resultobject!!
                    }
                }

            } catch (NullPointerException exception){
            System.out.println("Couldn't find the member!");
            isIdFound = false;
            }

        } while (!isIdFound);
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

    //Skal der opdeles så det kun er træningsresultater der bliver vist??????**
    public void getTop5Result(String desciplineName, int userInput){
        ReadResults readResults = new ReadResults();
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
            if (eliteResult.get(i).getDisciplineName().toLowerCase(Locale.ROOT).equals(desciplineName) && eliteResult.get(i).getRank() == 0){
                results.add(eliteResult.get(i));
            }
        }

        Comparator<Result> resultSorting = Comparator.comparing(Result::getTimeResult);
        results.sort(resultSorting);

        if (results.size() == 0) {
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println("No results to show");
        } else if (results.size() == 1){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
        } else if (results.size() == 2){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
        } else if (results.size() == 3){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
            System.out.println(results.get(2).top5ToString());
        }else if (results.size() == 4){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).top5ToString());
            System.out.println(results.get(1).top5ToString());
            System.out.println(results.get(2).top5ToString());
            System.out.println(results.get(3).top5ToString());
        } else{
            System.out.println("Top 5 in " + desciplineName + " results:");
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
    public void getTournamentName(){
        System.out.println("Enter the name of the tournament:");
        tournamentName = scanner.next();
    }
    private void getTimestamp() {
        System.out.println("Please enter the date of the result: (dd-mm-yyyy)");
        timestamp = scanner.next();
    }

    public void setTournamentNameToNull(){
        tournamentName = null;
    }

    public void setRankTo0(){
        rank = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getRank() {
        return rank;
    }

    public String getDisciplineName(){
        return this.disciplineName;
    }

    public String getTimeResult(){
        return this.timeResult;
    }

    private String toStringCsv() {
        return disciplineName + ";" +
                nameOfMember + ";" +
                memberId + ";" +
                timestamp + ";" +
                tournamentName + ";" +
                timeResult + ";" +
                rank;
    }

    @Override
    public String toString() {
        return "Result:" +
                " disciplineName='" + disciplineName + '\'' +
                ", nameOfMember='" + nameOfMember + '\'' +
                ", memberId=" + memberId + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", date='" + timestamp + '\''
                + "time result" + timeResult + '\'' +
                "rank" + rank;
    }

    public String top5ToString(){
        return "• Name: " + nameOfMember + ',' +
                " Id: " + memberId + ',' +
                 " Time result:" + timeResult;
    }

    public String competitionToString(){
        return "• Name: " + nameOfMember + ',' +
                " Id: " + memberId + ',' +
                " Tournament: " + tournamentName + ',' +
                " Discipline: " + disciplineName + ',' +
                " Rank: " + rank + ',' +
                " Time result: " + timeResult;

    }
}
