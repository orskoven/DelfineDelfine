package database;

import persons.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

//BRUGER VI DENNE KLASSE?

public class LookUpMember {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> readAllMembers = new ReadAllMembers().setFile();
    private ReadAllMembers readAllMembersGetMember = new ReadAllMembers();

    public Member lookUpMember() throws IOException {
        Member memberToLocate = lookForMemberId(readAllMembers);
        readAllMembers = new ArrayList<Member>();
        return memberToLocate;

    }

    public Member lookForMemberId(ArrayList<Member> membersList) {

        Member member = null;

        boolean isIDfound = true;

                do {
                    try {
                        System.out.println("Type a member ID to look up: ");
                        int lookForId = scanner.nextInt();
                        for (int i = 0; i < membersList.size(); i++) {
                            if (membersList.get(i).getMemberId() == lookForId) {
                                System.out.println("The member you are looking for: ");
                                member = membersList.get(i);
                                isIDfound = true;
                            }
                        } System.out.println(member.toStringToPrintAll());
                    } catch (NullPointerException exception){
                        System.out.println("No member has that ID");
                        System.out.println("\nHere are all member ID's:");
                        for (int j = 0; j < membersList.size(); j++) {
                            System.out.println(membersList.get(j).getMemberId());
                        }
                        isIDfound = false;
                    }

                } while (!isIDfound);

        return member;
    }

    //SKAL DENNE SLETTES??
    public void removeMember(ArrayList<Member> membersList, Member member) throws IOException {
        System.out.println("1. Remove\n2. Quit");
        int inputUser = scanner.nextInt();
        if (inputUser == 1) {
            for (int i = 0; i < membersList.size(); i++) {
                if (membersList.get(i) == member) {
                    membersList.remove(member);
                    System.out.println("Saved" + "💾");
                }
            }
        } else if (inputUser == 2 ) {
            System.out.println("No member has been removed.");
        }
        Writer w = new FileWriter("resources/members.csv", false);
        for (int i = 0; i < membersList.size(); i++) {
            MemberToSave.writerToFile("\n" + membersList.get(i).toString());

        }

    }


}
