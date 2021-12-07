package factory;

import analysis.MemberAnalysis;
import database.MemberToSave;
import database.ReadPrices;
import database.WriteMember;
import persons.Member;

import java.util.Scanner;

public class MemberGenerator {
    Scanner scanner = new Scanner(System.in);
    private Member newMember;
    private Member member = new Member();
    private MemberAnalysis memberAnalysis = new MemberAnalysis();


    public Member memberGenerator() {
        System.out.println("Insert details:");
        boolean isVerified = false;
        do {

            String name = member.askForName();
            int age = member.askForAge();
            String address = member.askForAddress();
            Boolean isActive = member.askForIsActive();
            Boolean isUnder18 = member.askIsUnder18();
            Boolean isEliteSwimmer = member.askForIsElite();
            Boolean hasPaid = member.askForHasPaid();


            newMember = new Member(name, age, address, new MemberToSave().getMemberId(), isActive,
                    isUnder18, isEliteSwimmer, hasPaid);
            String[] newMemberArray = newMember.toStringToConsole().split(",");

            System.out.println("Verify the details: ");
            // print details
            for (int i = 0; i < newMemberArray.length; i++) {
                System.out.println(newMemberArray[i]);
            }

            if (newMember.isHasPaid()) {
                memberAnalysis.getMemberSubscriptionPrice(newMember);
            }  else  if (!newMember.isHasPaid()) {
                memberAnalysis.getMemberSubscriptionPrice(newMember);
            }
            System.out.println("-----------------------------------");
            System.out.println("1. Save the member\n2. Start over");
            if (scanner.nextInt() == 1) {
                isVerified = true;
            }
        } while (!isVerified);
        return newMember;
    }
}
