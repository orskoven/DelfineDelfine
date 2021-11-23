package database;

import persons.Member;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoadTeams {
    private Member member;
    private ArrayList<Member> members = new ArrayList<Member>();
    private int counter = 0;
    private  String name;
    private int age;
    private int id;
    private  String address;
    private  boolean isActive;
    private  boolean isUnder18;
    private  boolean isElite;
    private  boolean hasPaid;
    private  Scanner fileReading;
    private String[] stringToArray;
    static LoadTeams readAllMembers = new LoadTeams();
    private ArrayList<Member> teamJunior = new ArrayList<Member>();
    private ArrayList<Member> teamSenior = new ArrayList<Member>();

    public void loadingTeams() {
        try {
            File file = new File("resources/members.csv");
            fileReading = new Scanner(file);
            while (fileReading.hasNextLine()) {
                stringToArray = fileReading.next().split("=");
                if (counter == 0) {
                    String[] nameArray = stringToArray[1].toString().split(" ");
                    name = "";
                    for (char i = 2; i < Arrays.toString(nameArray).length() - 2; i++) {
                        name += Arrays.toString(nameArray).charAt(i);
                    }
                }
                if (counter == 1) {
                    String[] ageArray = stringToArray[1].toString().split(" ");
                    String ageString = "";
                    for (char i = 1; i < Arrays.toString(ageArray).length() - 1; i++) {
                        ageString += Arrays.toString(ageArray).charAt(i);
                    }
                    age = Integer.parseInt(ageString);
                }
                if (counter == 2) {
                    String[] addressArray = stringToArray[1].toString().split(" ");
                    address = "";
                    for (char i = 2; i < Arrays.toString(addressArray).length() - 2; i++) {
                        address += Arrays.toString(addressArray).charAt(i);
                    }
                }
                if (counter == 3) {
                    String[] idArray = stringToArray[1].toString().split(" ");
                    String idString = "";
                    for (char i = 1; i < Arrays.toString(idArray).length() - 1; i++) {
                        idString += Arrays.toString(idArray).charAt(i);
                    }
                    id = Integer.parseInt(idString);
                }
                if (counter == 4) {
                    String[] activeArray = stringToArray[1].toString().split(" ");
                    String activeString = "";
                    for (char i = 1; i < Arrays.toString(activeArray).length() - 1; i++) {
                        activeString += Arrays.toString(activeArray).charAt(i);
                    }
                    isActive = Boolean.parseBoolean(activeString);
                }
                if (counter == 5) {
                    String[] under18Array = stringToArray[1].toString().split(" ");
                    String under18String = "";
                    for (char i = 1; i < Arrays.toString(under18Array).length() - 1; i++) {
                        under18String += Arrays.toString(under18Array).charAt(i);
                    }
                    isUnder18 = Boolean.parseBoolean(under18String);
                }
                if (counter == 6) {
                    String[] isEliteArray = stringToArray[1].toString().split(" ");
                    String isEliteString = "";
                    for (char i = 1; i < Arrays.toString(isEliteArray).length() - 1; i++) {
                        isEliteString += Arrays.toString(isEliteArray).charAt(i);
                    }
                    isElite = Boolean.parseBoolean(isEliteString);
                }
                if (counter == 7) {
                    String[] hasPaidArray = stringToArray[1].toString().split(" ");
                    String hasPaidString = "";
                    for (char i = 1; i < Arrays.toString(hasPaidArray).length() - 2; i++) {
                        hasPaidString += Arrays.toString(hasPaidArray).charAt(i);
                    }
                    hasPaid = Boolean.parseBoolean(hasPaidString);
                    if (isElite && !isUnder18) {
                        teamSenior.add(new Member(name, age, address, id, isActive, isUnder18, isElite, hasPaid));
                    } else if (isElite && isUnder18) {
                        teamJunior.add(new Member(name, age, address, id, isActive, isUnder18, isElite, hasPaid));
                    }
                }
                counter++;
                if (counter == 8) {
                    counter = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("File couldn't read");
        }
    }


    public String getTeamJunior() {
        String juniorMembers = "";
        for (int i = 0; i < teamJunior.size() ; i++) {
            juniorMembers += "\n・ Name: " + teamJunior.get(i).getName() + " ID: " + teamJunior.get(i).getMemberId();
        }
        return juniorMembers;
    }

    public String getTeamSenior() {
        String seniorMembers = "";
        for (int i = 0; i < teamSenior.size(); i++) {
            seniorMembers += "\n・ Name: " + teamSenior.get(i).getName() + " ID: " + teamSenior.get(i).getMemberId();
        }
        return seniorMembers;
    }

    public static void main(String[] args) {
        LoadTeams.readAllMembers.loadingTeams();
        System.out.println(readAllMembers.teamSenior);
    }
}

