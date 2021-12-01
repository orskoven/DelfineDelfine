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
        int expectedContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            expectedContigent += paymentDetails(i);
        }
        return expectedContigent;
    }

    public int getPayedRevenue(){

        members = readAllMembers.setFile();
        int payedContigent = 0;

        for (int i = 0; i <members.size() ; i++) {
            if (members.get(i).isHasPaid() == true){
                payedContigent += paymentDetails(i);
            }
        }
        return payedContigent;
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