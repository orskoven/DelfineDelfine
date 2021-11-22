package factory;

import persons.Member;

import java.util.Scanner;

public class MemberGenerator {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private int age;
    private String adress;
    private boolean isActive;
    private boolean isUnder18;
    private boolean isEliteSwimmer;
    private boolean hasPaid;
    private Member newMember;


    public Member MemberGenerator() {
        boolean isVerified = false;
        do {

            System.out.println("Name: ");
            name = scanner.nextLine();

            System.out.println("Age: ");
            age = scanner.nextInt();

            System.out.println("Address: ");
            scanner.next();
            adress = scanner.nextLine();

            System.out.println("Is the member active (press 1) or passive (press 2)?: ");
            if (scanner.nextInt() == 1) {
                isActive = true;
            } else {
                isActive = false;
            }

            if (age < 18) {
                isUnder18 = true;
            } else {
                isUnder18 = false;
            }

            System.out.println("Is the member elite swimmer (press 1) or is the member non-elite (press 2): ");
            if (scanner.nextInt() == 1) {
                isEliteSwimmer = true;
            } else {
                isEliteSwimmer = false;
            }

            System.out.println("Has the member paid, yes (press 1) or no (press 2): ");
            if (scanner.nextInt() == 1) {
                hasPaid = true;
            } else {
                hasPaid = false;
            }
            newMember = new Member(name, age, adress, 0, 0, isActive, isUnder18, isEliteSwimmer, hasPaid);
            String[] newMemberArray = newMember.toString().split(",");
            System.out.println("Verify the datails: ");
            for (int i = 0; i < newMemberArray.length; i++) {
                System.out.println(newMemberArray[i]);
            }
            System.out.println("Press 1 to proceed press 2 to adjust:");
            if (scanner.nextInt() == 1) {
                isVerified = true;
            }
        } while (!isVerified);
        return newMember;
    }

}
