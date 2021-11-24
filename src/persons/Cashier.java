package persons;

import database.MemberToSave;
import database.ReadAllMembers;
import factory.MemberGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Cashier {
    private ArrayList<Member> members = new ArrayList<Member>();
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> hasntPayedMembers = new ArrayList<Member>();

    public void showContingentPrices(){
        System.out.println("Contingent list:");
        System.out.println("Under 18 years......... 1000 dkk");
        System.out.println("Over 18 years.......... 1600 dkk");
        System.out.println("Over 60 years.......... 1200 dkk");
        System.out.println("Passive membership...... 500 dkk");
    }

    public void getExpectedContigentRevenue(){
        int expectedContigent = 0;
        members.removeAll(members);
        members = readAllMembers.ReadAllMembers();


        for (int i = 0; i <members.size() ; i++) {

            if (members.get(i).isActive() == false){
                expectedContigent += 500;
            } else if (members.get(i).getAge() < 18){
                expectedContigent += 1000;
            } else if (members.get(i).getAge() >=18 && members.get(i).getAge() < 60){
                expectedContigent += 1600;
            } else if (members.get(i).getAge() >= 60){
                expectedContigent += (1600*0.75);
            } else {
            }
            //System.out.println(expectedContigent);
        }
        System.out.println("Yearly expected revenue: " + expectedContigent + " dkk.");
    }

    public void getMembersWhoHasntPayed(){

        members.removeAll(members);
        hasntPayedMembers.removeAll(hasntPayedMembers);

        members = readAllMembers.ReadAllMembers();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isHasPaid() == false) {
                hasntPayedMembers.add(members.get(i));
            }
        }
        System.out.println(hasntPayedMembers.size());

        for (Member member:hasntPayedMembers) {
            System.out.println(member);

        }
    }


/*
    public ArrayList<Member> setFile(){
        File membersFile = new File("resources/members.csv");
        String line = "";
        String[] membersArray = new String[8];
        ArrayList<Member> membersArrayList = new ArrayList<Member>();
        try {
            Scanner scanner =new Scanner(membersFile);
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                membersArray = line.split(",");
                String name = membersArray[0];
                int age = Integer.parseInt(membersArray[1]);
                String adress = membersArray[2];
                int memberId = Integer.parseInt(membersArray[3]);
                Boolean isActive = Boolean.parseBoolean(membersArray[4]);
                Boolean isUnder18 = Boolean.parseBoolean(membersArray[5]);
                Boolean isEliteSwimmer = Boolean.parseBoolean(membersArray[6]);
                Boolean hasPaid = Boolean.parseBoolean(membersArray[7]);
                Member member = new Member(name, age, adress, memberId, isActive, isUnder18, isEliteSwimmer,hasPaid);
                membersArrayList.add(member);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return membersArrayList;
    }
*/

    public void setMembersWhoHasntPayed(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < hasntPayedMembers.size(); i++) {
            System.out.println("Type the memberId to change payment status");
            //System.out.println(hasntPayedMembers);
            int userInput = scanner.nextInt();
            if (hasntPayedMembers.get(i).getMemberId() == userInput){
                hasntPayedMembers.get(i).setHasPaid(true);
                hasntPayedMembers.remove(hasntPayedMembers.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MemberToSave member = new MemberToSave();
        MemberGenerator memberGenerator = new MemberGenerator();
        member.saveMemberDetailsToFile(memberGenerator.MemberGenerator());



    }
}