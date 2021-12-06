package UI;

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
    private Scanner scanner = new Scanner(System.in);
    private MemberGenerator member = new MemberGenerator();
    private ArrayList<Member> readAllMembersList = new ArrayList<Member>();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    static MemberToSave memberToSave = new MemberToSave();
    private Menu menu = new Menu();
    private MemberUpdate memberUpdate= new MemberUpdate();


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
                   ReadPrices.getMembershipPricesFromFile();
                   memberToSave.saveMemberDetailsToFile(member.MemberGenerator());
                   break;
               case 2:
                   //SKAL DETTE LAVES TIL EN METODE UNDER EN PACKAGE (ANALYSIS?)
                   readAllMembersList.removeAll(readAllMembersList);
                   readAllMembersList = readAllMembers.setFile();
                   //show members
                   System.out.println("All Members: ");
                   for (int i = 0; i < readAllMembersList.size(); i++) {
                       System.out.println(readAllMembersList.get(i).toStringToPrintAll());
                   }
                   break;
               case 3:
                   // remove member
                   new EditFile().removeMemberProcess();
                   break;
               case 4:
                   //SKAL DETTE LAVES TIL EN METODE UNDER EN PACKAGE (ANALYSIS?)
                   readAllMembersList.removeAll(readAllMembersList);
                   readAllMembersList =readAllMembers.setFile();
                   // adjust members
                   System.out.println("All Members: ");

                   for (int i = 0; i < readAllMembersList.size(); i++) {
                       System.out.println("Name: " + readAllMembersList.get(i).getName() + " ID: " + readAllMembersList.get(i).getMemberId());
                   }
                   System.out.println("Please type the ID of the member you want to adjust: ");
                   int memberId = menu.getUserInput();
                   changeMembershipStatus(memberId);
                   break;
               case 9:
                   break;
           }
           System.out.println();
       }while (chairmanChoice !=9);


    }

    public void activeMenu(int memberId) throws IOException {
        System.out.println("1. Turn member active \n2. Turn member passive\n3. Quit");
        int adjustChoice = menu.getUserInput();

        switch (adjustChoice){
            case 1:
               // System.out.println("Members who are passive:");
                memberUpdate.getNonActiveMembers(memberId);
                break;
            case 2:
               // System.out.println("Members who are active:");
                memberUpdate.getActiveMembers(memberId);
                break;
            case 3:
               //changeMembershipStatus();
                break;

        }
    }

    public void eliteMenu(int memberId) throws IOException {
        System.out.println("1. Change member to be elite \n2. Change member to be non-elite\n3. Quit");
        int adjustChoice = menu.getUserInput();
        switch (adjustChoice){
            case 1:
           //     System.out.println("Members who are non-elite:");
                memberUpdate.getNonEliteMembers(memberId);
                break;
            case 2:
             //   System.out.println("Members who are elite:");
                memberUpdate.getEliteMembers(memberId);
                break;
            case 3:
                break;

        }
    }

    public void changeMembershipStatus(int memberId) throws IOException {
        showMembershipOptions();
        int adjustChoice = menu.getUserInput();

        switch (adjustChoice){
            case 1:
                activeMenu(memberId);
                break;
            case 2:
                eliteMenu(memberId);
                break;

        }
    }

    public void showMembershipOptions(){
        System.out.println("What would you like to adjust?: ");
        System.out.println("1. Active/Passive\n2. Elite/non-Elite");
    }




}
