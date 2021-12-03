package database;

import persons.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadAllMembers {
    private ArrayList<Member> membersArrayList = new ArrayList<Member>();



    public ArrayList<Member> setFile(){


        try {
            File membersFile = new File("resources/members.csv");
            String line = "";
            String[] membersArray;
            Scanner scanner = new Scanner(membersFile);
            scanner.nextLine();
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                membersArray = line.split(";");


                    String name = membersArray[0];
                    int age = Integer.parseInt(membersArray[1]);
                    String adress = membersArray[2];
                    int memberId = Integer.parseInt(membersArray[3]);
                    Boolean isActive = Boolean.parseBoolean(membersArray[4]);
                    Boolean isUnder18 = Boolean.parseBoolean(membersArray[5]);
                    Boolean isEliteSwimmer = Boolean.parseBoolean(membersArray[6]);
                    Boolean hasPaid = Boolean.parseBoolean(membersArray[7]);

                    Member member = new Member(name, age, adress, memberId, isActive, isUnder18, isEliteSwimmer, hasPaid);
                    membersArrayList.add(member);
                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File couldn't read");
        }

        return membersArrayList;
    }


}

