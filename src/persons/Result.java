package persons;

import UI.Menu;
import analysis.CoachAnalysis;
import analysis.ResultAnalysis;
import database.ReadAllMembers;
import database.ReadResults;

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
    private CoachAnalysis eliteSwimmer = new CoachAnalysis();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private ResultAnalysis resultAnalysis = new ResultAnalysis();

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

    public String chooseDisciplineName() {
        System.out.println("Press the following numbers for a discipline:\n1. Butterfly" +
                "\n2. Breast Stroke\n3. Crawl\n4. Back Crawl");
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

    public void addMemberIdAndNameToResult(){
        eliteMembers = eliteSwimmer.findEliteSwimmer();

        boolean isIdFound = false;
        do {
            try {
                System.out.println("Type in the member ID");
                resultAnalysis.showElitenameAndId();
                int userinput = menu.getUserInput();

                for (int i = 0; i < eliteMembers.size(); i++) {
                    if (eliteMembers.get(i).getMemberId() == userinput) {
                        memberId = userinput;
                        nameOfMember = eliteMembers.get(i).getName();
                        isIdFound = true;

                    }
                }

            } catch (NullPointerException exception){
                System.out.println("Couldn't find the member!");
                isIdFound = false;
            }

        } while (!isIdFound);
    }

    public void chooseRank (){
        System.out.println("Enter rank result:");
        rank = scanner.nextInt();
    }

    public void chooseTimeResult (){
        System.out.println("Enter the time result: (hh:mm:ss)");
        timeResult = scanner.next();

    }


    public void getTournamentName(){
        System.out.println("Enter the name of the tournament:");
        tournamentName = scanner.next();
    }
    public void getTimestamp() {
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

    public String toStringCsv() {
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
