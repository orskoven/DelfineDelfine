package database;

import persons.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EditFile {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> readAllMembers = new ReadAllMembers().ReadAllMembers();
    private ReadAllMembers readAllMembersGetMember = new ReadAllMembers();
    private Write write = new Write();

    public EditFile() throws IOException {
        Member memberToLocate = lookForMemberId(readAllMembers);
        removeMember(readAllMembers,memberToLocate);
        readAllMembers = new ArrayList<Member>();

    }
    public Member lookForMemberId(ArrayList<Member> membersList) {
        System.out.println("Type a member ID to look for: ");
        int lookForId = scanner.nextInt();
        Member member = null;
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getMemberId() == lookForId) {
                member = membersList.get(i);
            }
        }
        System.out.println(member);
        return member;
    }
    public void removeMember(ArrayList<Member> membersList, Member member) throws IOException {
        System.out.println("1.Remove\n2.Do nothing");
        int inputUser = scanner.nextInt();
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i) == member) {
                membersList.remove(member);
            }
        }
        Writer w = new FileWriter("resources/members.csv", false);
        for (int i = 0; i < membersList.size(); i++) {
            write.writerToFile("\n" + membersList.get(i).toString());

        }
        System.out.println("Saved" + "💾");

    }

    public static void main(String[] args) throws IOException {
        new EditFile();
    }

}
