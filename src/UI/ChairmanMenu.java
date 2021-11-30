package UI;

import controller.SystemController;
import database.EditFile;
import database.MemberToSave;
import database.ReadAllMembers;
import database.TempRead;
import factory.MemberGenerator;
import persons.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChairmanMenu {
    private Scanner scanner = new Scanner(System.in);
    private MemberGenerator member = new MemberGenerator();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> readAllMembersList = new ReadAllMembers().setFile();
    static MemberToSave memberToSave = new MemberToSave();


    public ChairmanMenu() throws IOException {
        new Menu().optionsForChairman();
        switch ( new Menu().getUserInput()){
            case 1:
                TempRead.getMembershipPricesFromFile();
                memberToSave.saveMemberDetailsToFile(member.MemberGenerator());
                break;
            case 2:
                //show members
                System.out.println("All MEMBERS: ");

                for (int i = 0; i <readAllMembersList.size() ; i++) {
                    System.out.println(readAllMembersList.get(i).toStringToPrintAll());
                }

                break;
             case 3:
            // remove member
             new EditFile().removeMemberProcess();
                break;
             case 4:
            // edit members
            new AdjustmentMenu().adjustmentMenuOverview();
            break;
            case 9:
              break;
        }

    }
}
