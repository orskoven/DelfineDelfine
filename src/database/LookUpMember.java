package database;

import persons.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class LookUpMember {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> readAllMembers = new ReadAllMembers().ReadAllMembers();
    private ReadAllMembers readAllMembersGetMember = new ReadAllMembers();
    private Write write = new Write();

    public Member LookUpMember() throws IOException {
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
                        System.out.println("NO MEMBER HAS THAT ID");
                        System.out.println("\nHere are all member ID's:");
                        for (int j = 0; j < membersList.size(); j++) {
                            System.out.println(membersList.get(j).getMemberId());
                        }
                        isIDfound = false;
                    }

                } while (!isIDfound);

        return member;
    }
    public void removeMember(ArrayList<Member> membersList, Member member) throws IOException {
        System.out.println("1.Remove\n2.Quit");
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
            write.writerToFile("\n" + membersList.get(i).toString());

        }

    }

    public static void main(String[] args) throws IOException {
        new LookUpMember();
    }

}
