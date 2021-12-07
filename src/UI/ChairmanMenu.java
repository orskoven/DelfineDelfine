package UI;

import analysis.MemberAnalysis;
import database.EditFile;
import database.MemberToSave;
import database.ReadAllMembers;
import database.ReadPrices;
import factory.MemberGenerator;
import factory.MemberUpdate;
import persons.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChairmanMenu {
    private MemberGenerator member = new MemberGenerator();
    private ArrayList<Member> readAllMembersList = new ArrayList<Member>();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    static MemberToSave memberToSave = new MemberToSave();
    private Menu menu = new Menu();
    private MemberUpdate memberUpdate= new MemberUpdate();
    private MemberAnalysis memberAnalysis = new MemberAnalysis();


    public ChairmanMenu() throws IOException {
    }
    public void optionsForChairman() {
        System.out.println("Chairman options:");
        System.out.println("1. Create member");
        System.out.println("2. Show members");
        System.out.println("3. Remove member");
        System.out.println("4. Adjust member");
        System.out.println("9. Return");
    }

    public void showChairmanMenu() throws IOException {
       int chairmanChoice;

       do {
           optionsForChairman();
           chairmanChoice = menu.getUserInput();

           switch (chairmanChoice) {
               case 1:
                   //create member
                   ReadPrices.getMembershipPricesFromFile();
                   memberToSave.saveMemberDetailsToFile(member.memberGenerator());
                   break;
               case 2:
                   //show members
                   memberAnalysis.showAllMembers();
                   break;
               case 3:
                   // remove member

                   new EditFile().removeMemberProcess();
                   break;
               case 4:
                   // adjust members
                   changeMembershipStatus();


                   break;
               case 9:
                   break;
           }
           System.out.println();
       }while (chairmanChoice !=9);


    }

    public void activeMenu() throws IOException {
        System.out.println("1. Turn member active \n2. Turn member passive\n3. Quit");
        int adjustChoice = menu.getUserInput();

        switch (adjustChoice){
            case 1:
               //Turn member active
                memberUpdate.getNonActiveMembers();
                break;
            case 2:
               //Turn member passive
                memberUpdate.getActiveMembers();
                break;
            case 3:
               //quit
                break;

        }
    }

    public void eliteMenu() throws IOException {
        System.out.println("1. Change member to be elite \n2. Change member to be non-elite\n3. Quit");
        int adjustChoice = menu.getUserInput();
        switch (adjustChoice){
            case 1:
           //     System.out.println("Members who are non-elite:");
                memberUpdate.getNonEliteMembers();
                break;
            case 2:
             //   System.out.println("Members who are elite:");
                memberUpdate.getEliteMembers();
                break;
            case 3:
                break;

        }
    }

    public void changeMembershipStatus() throws IOException {
        showMembershipOptions();
        int adjustChoice = menu.getUserInput();

        switch (adjustChoice){
            case 1:
                activeMenu();
                break;
            case 2:
                eliteMenu();
                break;

        }
    }

    public void showMembershipOptions(){
        System.out.println("What would you like to adjust?: ");
        System.out.println("1. Active/Passive\n2. Elite/non-Elite");
    }
}
