package persons;

import database.EditFile;
import database.MemberToSave;
import database.ReadAllMembers;
import factory.MemberGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Cashier {
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> hasntPayedMembers = new ArrayList<Member>();

    public void showContingentPrices(){
        System.out.println("Contingent list:");
        System.out.println("Under 18 years......... 1000 DKK");
        System.out.println("Over 18 years.......... 1600 DKK");
        System.out.println("Over 60 years.......... 1200 DKK");
        System.out.println("Passive membership...... 500 DKK");
    }

    public int paymentDetails(int memberArrayIndex){
        members.removeAll(members);
        members = readAllMembers.ReadAllMembers();

        int contigent = 0;

        if (members.get(memberArrayIndex).isActive() == false){
            contigent += 500;
        } else if (members.get(memberArrayIndex).getAge() < 18){
            contigent += 1000;
        } else if (members.get(memberArrayIndex).getAge() >=18 && members.get(memberArrayIndex).getAge() < 60){
            contigent += 1600;
        } else if (members.get(memberArrayIndex).getAge() >= 60){
            contigent += (1600*0.75);
        } else {
        }
        return contigent;
    }

    public int getExpectedRevenue(){

        members = readAllMembers.ReadAllMembers();
        int expectedContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            expectedContigent += paymentDetails(i);
        }
        return expectedContigent;
    }

    public int getPayedRevenue(){

        members = readAllMembers.ReadAllMembers();
        int payedContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            if (members.get(i).isHasPaid() == true){
                payedContigent += paymentDetails(i);
            }
        }
        return payedContigent;
    }

    public int getMissingRevenue(){

        members = readAllMembers.ReadAllMembers();
        int missingContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            if (members.get(i).isHasPaid() == false){
                missingContigent += paymentDetails(i);
            }
        }
        return missingContigent;
    }

    public void showRevenueData(){
        System.out.println("Expected revenue:");
        System.out.println(getExpectedRevenue()+" DKK");
        System.out.println("Payed revenue:");
        System.out.println(getPayedRevenue()+" DKK");
        System.out.println("Missing revenue:");
        System.out.println(getMissingRevenue()+" DKK");
    }



    public void getMembersWhoHasntPayed(){
        members.removeAll(members);
        members = readAllMembers.ReadAllMembers();

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