package factory;

import database.MemberToSave;
import database.TemporaryData;
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
    private MemberToSave memberToSave = new MemberToSave();


    public Member MemberGenerator() {
        boolean isVerified = false;
        do {
            System.out.println("Age: ");
            age = Integer.parseInt(scanner.next());

            System.out.println("Name: ");
            name = scanner.next();

            System.out.println("Address: ");
            adress = scanner.nextLine();
            if (adress.isEmpty()){
                adress = scanner.nextLine();
            }

            System.out.println("Is the member:\n1. Active\n2. Passive ");
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

            System.out.println("Is the member:\n1. Elite swimmer\n2. Non-elite");
            if (scanner.nextInt() == 1) {
                isEliteSwimmer = true;
            } else {
                isEliteSwimmer = false;
            }

            System.out.println("Has the member paid:\n1. Yes\n2. No");
            if (scanner.nextInt() == 1) {
                hasPaid = true;
            } else {
                hasPaid = false;
            }
            newMember = new Member(name, age, adress, new MemberToSave().getMemberId(), isActive,
                    isUnder18, isEliteSwimmer, hasPaid);
            String[] newMemberArray = newMember.toStringToConsole().split(",");

            System.out.println("Verify the details: ");
            // print details
            for (int i = 0; i < newMemberArray.length; i++) {
                System.out.println(newMemberArray[i]);
            }

            if (newMember.isHasPaid()) {
                getMemberSubscriptionPrice();
            }  else  if (!newMember.isHasPaid()) {
                getMemberSubscriptionPrice();
            }
            System.out.println("-----------------------------------");
            System.out.println("1. Save the member\n2. Start over");
            if (scanner.nextInt() == 1) {
                isVerified = true;
            }
        } while (!isVerified);
        return newMember;
    }

    public void getMemberSubscriptionPrice(){
        if (newMember.isUnder18() && newMember.isActive()) {
            getMembershipPricesFromFile("junior");
        } else if (newMember.isUnder18() && !newMember.isActive()){
            getMembershipPricesFromFile("passive");
        } else if (!newMember.isUnder18() && newMember.isActive() && age < 60) {
            getMembershipPricesFromFile("senior");
        } else if (!newMember.isUnder18() && newMember.isActive() && age > 60) {
            getMembershipPricesFromFile("elder");
        }  else if (!newMember.isUnder18() && !newMember.isActive() && age > 60) {
        getMembershipPricesFromFile("passive");
    }
    }

    private void getMembershipPricesFromFile(String memberType){
        int membershipPrice = TemporaryData.productPrices.get(memberType);
        System.out.println("The member has to pay " + membershipPrice +  " DKK annually.");
    }


}
