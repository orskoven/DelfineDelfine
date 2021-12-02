package UI;

import database.ReadAllMembers;
import factory.MemberUpdate;
import persons.Cashier;
import persons.Member;

import java.io.IOException;
import java.util.ArrayList;

public class CashierMenu {
    private Menu menu = new Menu();
    private MemberUpdate memberUpdate = new MemberUpdate();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> hasntPayedMembers = new ArrayList<Member>();

    public CashierMenu() throws IOException {
    }

    public void showCashierMenu () throws IOException {
        int cashierChoice;

        do {
            optionsForCashier();
            cashierChoice = menu.getUserInput();

            if (cashierChoice == 1) {
                //Show contingent prices
                showContingentPrices();
            } else if (cashierChoice == 2) {
                //show expected payments
                showRevenueData();
            } else if (cashierChoice == 3) {
                //show members in arrears
                getMembersWhoHasntPayed();      //evt. LoadingMissingpaymentmembers
            } else if (cashierChoice == 4) {
                //change member payment status
                paymentStatus();


            } else if (cashierChoice == 9) {
                break;
            }
            System.out.println();

        }while (cashierChoice != 9);

    }

    public void optionsForCashier(){
        System.out.println("Cashier options:");
        System.out.println("1. Show contingent prices");
        System.out.println("2. Show revenue data");
        System.out.println("3. Show members in arrears");       //restance = er i gæld til svømmeklubben
        System.out.println("4. Change members payment status");
        System.out.println("9. Return");
    }

    public void paymentStatus() throws IOException {
        System.out.println("1. Change member to 'has paid'\n2. Change member to 'has NOT paid'\n3. Quit");
        int adjustChoice = menu.getUserInput();


        switch (adjustChoice){
            case 1:
                System.out.println("Members who have not paid:");
                memberUpdate.nonPayingMembers();
                break;
            case 2:
                System.out.println("Members who have paid:");
                memberUpdate.payingMembers();
                break;
            case 3:
                break;

        }
    }



    public void showContingentPrices(){
        System.out.println("Contingent list:");
        System.out.println("Under 18 years......... 1000 DKK");
        System.out.println("Over 18 years.......... 1600 DKK");
        System.out.println("Over 60 years.......... 1200 DKK");
        System.out.println("Passive membership...... 500 DKK");
    }

    public void showRevenueData(){
        System.out.println("Expected revenue:");
        System.out.println(getExpectedRevenue()+" DKK");
        System.out.println("Payed revenue:");
        System.out.println(getPayedRevenue()+" DKK");
        System.out.println("Missing revenue:");
        System.out.println(getMissingRevenue()+" DKK");
    }
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
            System.out.println("Members in arrears " + hasntPayedMembers.size());
        }
        for (Member member:hasntPayedMembers) {
            System.out.println(member.toStringToPrintAll());
        }
    }
}
