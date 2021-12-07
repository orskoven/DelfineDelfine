package analysis;

import database.ReadAllMembers;
import database.ReadPrices;
import factory.MemberGenerator;
import persons.Member;

import java.util.ArrayList;

public class MemberAnalysis {
    private ArrayList<Member> readAllMembersList = new ArrayList<Member>();
    private ReadAllMembers readAllMembers = new ReadAllMembers();

    public void showAllMembers() {
        readAllMembersList.removeAll(readAllMembersList);
        readAllMembersList = readAllMembers.setFile();

        System.out.println("All Members: ");
        for (int i = 0; i < readAllMembersList.size(); i++) {
            System.out.println(readAllMembersList.get(i).toStringToPrintAll());
        }
    }

    public void getMemberSubscriptionPrice(Member member){
        if (member.isUnder18() && member.isActive()) {
            getMembershipPricesFromFile("junior");
        } else if (member.isUnder18() && !member.isActive()){
            getMembershipPricesFromFile("passive");
        } else if (!member.isUnder18() && member.isActive() && member.getAge() < 60) {
            getMembershipPricesFromFile("senior");
        } else if (!member.isUnder18() && member.isActive() && member.getAge() > 60) {
            getMembershipPricesFromFile("elder");
        }  else if (!member.isUnder18() && !member.isActive() && member.getAge() > 60) {
            getMembershipPricesFromFile("passive");
        }
    }

    private void getMembershipPricesFromFile(String memberType){
        int membershipPrice = ReadPrices.membershipPrices.get(memberType);
        System.out.println("The member has to pay " + membershipPrice +  " DKK annually.");
    }
}
