package database;

import persons.EliteSwimmer;
import persons.Member;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
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
    private WriteResult WriteResults;
    private EliteSwimmer eliteSwimmer = new EliteSwimmer();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private ReadResults readResults = new ReadResults();

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

    public String getDisciplineName(){
        return this.disciplineName;
    }

   public String getTimeResult(){
        return this.timeResult;
   }

    private String chooseDisciplineName() {
        System.out.println("Press the follwing numbers for a discipline:\n1 ‣ Butterfly" +
                "\n2 ‣ Breast Stroke\n3 ‣ Crawl\n4 ‣ Back Crawl");
        int disciplineChoice = scanner.nextInt();
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

    private void getTimestamp() {
        System.out.println("Please enter the date of the result: (dd-mm-yyyy)");
        timestamp = scanner.next();
    }

    private void chooseTimeResult (){
        System.out.println("Enter the time result: (hh:mm:ss)");
        timeResult = scanner.next();

    }

    public String writeTrainingToCsv() {
        addMemberIdAndNameToResult();
        chooseDisciplineName();
        getTimestamp();
        chooseTimeResult();
        return toStringCsv();
    }

    public String writeCompetitionToCsv() {
        addMemberIdAndNameToResult();
        chooseDisciplineName();
        getTournamentName();
        getRank();
        getTimestamp();
        chooseTimeResult();
        return toStringCsv();
    }


    public void getTournamentName(){
        System.out.println("Enter the name of the tournament:");
        tournamentName = scanner.next();
    }

    public void getRank (){
        System.out.println("Enter rank result:");
        rank = scanner.nextInt();
    }

    public void showElitenameAndId(){
        //se om den fordobles hvis den køres flere gange
        eliteMembers = eliteSwimmer.findEliteSwimmer();
        System.out.println("Elite Members:");

        for (int i = 0; i < eliteMembers.size(); i++) {
            System.out.println("name: " + eliteMembers.get(i).getName() + "," + " member ID: " +
                    eliteMembers.get(i).getMemberId());
        }
    }

    public void addMemberIdAndNameToResult(){
        //se om den fordobles hvis den køres flere gange
        eliteMembers = eliteSwimmer.findEliteSwimmer();

        boolean isIdFound = false;
        do {
            try {
                System.out.println("type in the member ID");
                showElitenameAndId();
                int userinput = scanner.nextInt();

                 for (int i = 0; i < eliteMembers.size(); i++) {
                     if (eliteMembers.get(i).getMemberId() == userinput) {
                memberId = userinput;
                nameOfMember = eliteMembers.get(i).getName();
                System.out.println("nice");
                isIdFound = true;
                //userinput og user name addes til resultobject!!
            }
        }
        }catch (NullPointerException exception){
            System.out.println("try again");
            isIdFound = false;
        }

    }while (!isIdFound);
    }

    public int timeToSeconds(){
        String str = getTimeResult();
        String [] array = new String[3];
        array = str.split(":");
        int timeInSecond = 0;

        try{
            int number = Integer.parseInt(array[0]);
            number = number*60*60;
            //System.out.println(number); // output = 20

            int number1 = Integer.parseInt(array[1]);
            number1 = number1*60;
            //System.out.println(number1); // output = 04

            int number2 = Integer.parseInt(array[2]); // output = 33
            //System.out.println(number2);

            timeInSecond = number+number1+number2;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            System.out.println("nope");
        }
        return timeInSecond;
    }

    public void getJuniorResults(){

    }


    public void getTop5Result(String desciplineName){
        ReadResults readResults = new ReadResults();
        ArrayList<Result> allResults = readResults.setFile();
        ArrayList<Result> results = new ArrayList<Result>();

        for (int i = 0; i < allResults.size() ; i++) {
            if (allResults.get(i).getDisciplineName().toLowerCase(Locale.ROOT).equals(desciplineName)){
                results.add(allResults.get(i));
            }
        }

        Comparator<Result> resultSorting = Comparator.comparing(Result::getTimeResult);
        results.sort(resultSorting);

        if (results.size() == 1){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).toStringTraining());
        } else if (results.size() == 2){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).toStringTraining());
            System.out.println(results.get(1).toStringTraining());
        } else if (results.size() == 3){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).toStringTraining());
            System.out.println(results.get(1).toStringTraining());
            System.out.println(results.get(2).toStringTraining());
        }else if (results.size() == 4){
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).toStringTraining());
            System.out.println(results.get(1).toStringTraining());
            System.out.println(results.get(2).toStringTraining());
            System.out.println(results.get(3).toStringTraining());
        } else{
            System.out.println("Top 5 in " + desciplineName + " results:");
            System.out.println(results.get(0).toStringTraining());
            System.out.println(results.get(1).toStringTraining());
            System.out.println(results.get(2).toStringTraining());
            System.out.println(results.get(3).toStringTraining());
            System.out.println(results.get(4).toStringTraining());
        }
/*
        System.out.println("Top 5 in " + desciplineName + " results:");
        for (int i = 0; i < results.size(); i++) {
            if (results.size() > 5){

                System.out.println(results.get(i).toStringTraining());
            }
            System.out.println(results.get(i).toStringTraining());
        }

 */
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

    public String toStringTraining(){
        return "training reult:" +
                " disciplineName='" + disciplineName + '\'' +
                " nameOfMember='" + nameOfMember + '\'' +
                ", memberId=" + memberId +
                ", date='" + timestamp + '\''+ "training result" +
                timeResult;
    }



    @Override
    public String toString() {
        return "database.Result:" +
                " disciplineName='" + disciplineName + '\'' +
                ", nameOfMember='" + nameOfMember + '\'' +
                ", memberId=" + memberId + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", date='" + timestamp + '\''
                + "time result" + timeResult + '\'' +
                "rank" + rank;
    }

    public static void main(String[] args) {
        Result result = new Result();
        //Result result = new Result();
        WriteResult.writerToFile(result.writeTrainingToCsv());

        //Result.showEliteNameAndId();



    }
}
