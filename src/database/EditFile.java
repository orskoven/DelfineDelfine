package database;

import persons.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class EditFile {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> readAllMembers = new ReadAllMembers().setFile();
    private ReadAllMembers readAllMembersGetMember = new ReadAllMembers();
    private WriteMember write = new WriteMember();

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
                }
                System.out.println(member.toStringToPrintAll());
            } catch (NullPointerException exception) {
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
        } else if (inputUser == 2) {
            System.out.println("No member has been removed.");
        }
        Writer w = new FileWriter("resources/members.csv", false);
        write.writerToFile("name;age;address;id;isActive;isUnder18;isElite;hasPaid");
        for (int i = 0; i < membersList.size(); i++) {
            write.writerToFile("\n" + membersList.get(i).toString());

        }


    }

    public void removeMemberProcess() throws IOException {
        Member memberToLocate = lookForMemberId(readAllMembers);
        removeMember(readAllMembers, memberToLocate);
        readAllMembers = new ArrayList<Member>();
    }


    public void addMember(ArrayList<Member> membersList) throws IOException {
        Writer w = new FileWriter("resources/members.csv", false);
        write.writerToFile("name;age;address;id;isActive;isUnder18;isElite;hasPaid" + "\n");
        for (int i = 0; i < membersList.size(); i++) {
            write.writerToFile( membersList.get(i).toString() + "\n");
        }
    }

}
