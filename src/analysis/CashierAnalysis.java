// AUTHOR : RASMUS & LAURA

package analysis;

import database.ReadAllMembers;
import persons.Member;

import java.util.ArrayList;

public class CashierAnalysis {
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> hasntPayedMembers = new ArrayList<Member>();

    public int paymentDetails(int memberArrayIndex){
        members.removeAll(members);
        members = readAllMembers.setFile();

        int contingent = 0;

        if (members.get(memberArrayIndex).isActive() == false){
            contingent += 500;
        } else if (members.get(memberArrayIndex).getAge() < 18){
            contingent += 1000;
        } else if (members.get(memberArrayIndex).getAge() >=18 && members.get(memberArrayIndex).getAge() < 60){
            contingent += 1600;
        } else if (members.get(memberArrayIndex).getAge() >= 60){
            contingent += (1600*0.75);
        } else {
        }
        return contingent;
    }

    public int getExpectedRevenue(){

        members = readAllMembers.setFile();
        int expectedContingent = 0;

        for (int i = 0; i <members.size() ; i++) {
            expectedContingent += paymentDetails(i);
        }
        return expectedContingent;
    }

    public int getPayedRevenue(){

        members = readAllMembers.setFile();
        int payedContingent = 0;

        for (int i = 0; i <members.size() ; i++) {
            if (members.get(i).isHasPaid() == true){
                payedContingent += paymentDetails(i);
            }
        }
        return payedContingent;
    }

    public int getMissingRevenue(){

        members = readAllMembers.setFile();
        int missingContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            if (members.get(i).isHasPaid() == false){
                missingContigent += paymentDetails(i);
            }
        }
        return missingContigent;
    }

    public void getMembersWhoHasntPayed(){
        members.removeAll(members);
        members = readAllMembers.setFile();

        hasntPayedMembers.removeAll(hasntPayedMembers);

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isHasPaid() == false) {
                hasntPayedMembers.add(members.get(i));
            }
        } if (hasntPayedMembers.size() == 0) {
            System.out.println("There are no members in arrears.");
        } else {
            System.out.println("Members in arrears: " + hasntPayedMembers.size());
        }
        for (Member member:hasntPayedMembers) {
            System.out.println(member.toStringToPrintAll());
        }
    }
}
