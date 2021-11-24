package controller;

import UI.Menu;
import UI.ShowTop5Junior;
import database.*;
import factory.DisciplineGenerator;
import factory.MemberGenerator;
import persons.Cashier;
import persons.EliteSwimmer;
import persons.Member;

import java.io.IOException;
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
    private ShowTop5Junior showTop5Junior = new ShowTop5Junior();
    private ShowTop5Junior showTop5Senior = new ShowTop5Junior();
    private EliteSwimmer eliteSwimmer = new EliteSwimmer();
    private Cashier cashier = new Cashier();

    public SystemController() throws IOException {
    }

    public void chooseOptions() throws IOException {
        int userInput;

        menu.welcome();

        do {

            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput) {
                case 1:
                    menu.optionsForChairman();
                    int chairmanChoice = menu.getUserInput();
                    if (chairmanChoice == 1) {
                        //create member
                        TempRead.getMembershipPricesFromFile();
                        memberToSave.saveMemberDetailsToFile(member.MemberGenerator());
                    } else if (chairmanChoice == 2) {
                        //show members
                        new ReadFiles("resources/members.csv");
                    } else if (chairmanChoice == 3) {
                        // remove member
                        new EditFile();
                    } else if (chairmanChoice == 9) {             //go back option

                    }
                    break;

                case 2:
                    menu.optionsForCashier();
                    int cashierChoice = menu.getUserInput();
                    if (cashierChoice == 1){
                        //Show contingent prices
                        cashier.showContingentPrices();
                    }else if (cashierChoice == 2){
                        //show expected payments
                        cashier.getExpectedContigentRevenue();
                    }else if (cashierChoice == 3){
                        //show members in arrears
                        cashier.getMembersWhoHasntPayed();      //evt. LoadingMissingpaymentmembers
                    } else if (cashierChoice == 4){
                        //change member payment status
                        cashier.getMembersWhoHasntPayed();
                        cashier.setMembersWhoHasntPayed();

                    } else if (cashierChoice ==9){

                    }
                    break;

                case 3:
                    menu.optionsForCoach();
                    int coachChoice = menu.getUserInput();
                    if (coachChoice == 1) {
                        System.out.println("Choose:");
                        System.out.println("1. Junior\n2. Senior");
                        int topTeamInput = scanner.nextInt();
                        if (topTeamInput == 1) {
                        showTop5Junior.getOptions();
                    }
                    else if (topTeamInput == 2) {
                        showTop5Senior.getOptions();
                    }

                    }else if (coachChoice == 2) {
                        //Show elite swimmers

                        //eliteSwimmer.addEliteSwimmer();

                        loadAllEliteSwimmers.loadingTeams();
                        System.out.println("Juniors " + loadAllEliteSwimmers.getTeamJunior());
                        System.out.println();
                        System.out.println("Seniors " +loadAllEliteSwimmers.getTeamSenior());

                    }else if (coachChoice == 3){
                        //create result
                        System.out.println("1.Butterfly\n2.Breaststroke\n3.Crawl\n4.Backcrawl");
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

    public static void main(String[] args) throws IOException {
        SystemController hej = new SystemController();
        hej.chooseOptions();
    }

}
