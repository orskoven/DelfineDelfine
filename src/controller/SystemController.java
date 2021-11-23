package controller;

import UI.Menu;
import UI.ShowTop5;
import database.*;
import factory.DisciplineGenerator;
import factory.MemberGenerator;
import persons.EliteSwimmer;
import persons.Member;

import java.util.*;

public class SystemController {
    private Scanner scanner = new Scanner(System.in);
    static MemberToSave memberToSave = new MemberToSave();
    private Menu menu = new Menu();
    private MemberGenerator member = new MemberGenerator();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<EliteSwimmer>();
    private LoadTeams loadAllEliteSwimmers = new LoadTeams();
    private ReadResults readResults = new ReadResults();
    private ShowTop5 showTop5 = new ShowTop5();

    public void chooseOptions(){
        int userInput;

        menu.welcome();

        do {

            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput){
                case 1:
                    menu.optionsForChairman();
                    int chairmanChoice = menu.getUserInput();
                    if (chairmanChoice == 1){
                        //create member
                        TempRead.getMembershipPricesFromFile();
                        memberToSave.saveMemberDetailsToFile(member.MemberGenerator());
                    }else if (chairmanChoice == 2){
                        //show members
                        new ReadFiles("resources/members.csv");

                    }else if (chairmanChoice == 9){             //go back option

                    }
                    break;

                case 2:
                    menu.optionsForCashier();
                    int cashierChoice = menu.getUserInput();
                    if (cashierChoice == 1){
                        //show expected payments
                    }else if (cashierChoice == 2){
                        //show members in arrears
                        new LoadMemberMissingPayment();
                    }else if (cashierChoice == 9){

                    }
                    break;

                case 3:
                    menu.optionsForCoach();
                    int coachChoice = menu.getUserInput();
                    if (coachChoice == 1){
                        //Show top 5 elite swimmers
                       showTop5.getOptions();

                    }else if (coachChoice == 2) {
                        //Show elite swimmers
                        loadAllEliteSwimmers.loadingTeams();
                        System.out.println("Juniors " + loadAllEliteSwimmers.getTeamJunior());
                        System.out.println();
                        System.out.println("Seniors " +loadAllEliteSwimmers.getTeamSenior());

                    }else if (coachChoice == 3){
                        //create result
                        System.out.println("1.Backcrawl\n2.Breaststroke\n3.Crawl\n4.Butterfly");
                        int userInputDiscipline = scanner.nextInt();
                        DisciplineGenerator disciplineGenerator = new DisciplineGenerator(userInputDiscipline);
                    }else if (coachChoice == 9){
                        //return
                    }
                    break;
            }
            System.out.println();
        } while (userInput != 9);
    }

    public static void main(String[] args) {
        SystemController hej = new SystemController();
        hej.chooseOptions();
    }

}
