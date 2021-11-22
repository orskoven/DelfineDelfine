package database;

import persons.Member;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class readAllMembers {
    private Member member;
    private int counter = 0;
    private  String name;
    private int age;
    private int id;
    private  String address;
    private  boolean isActive;
    private  boolean isUnder18;
    private  boolean isElite;
    private  boolean hasPaid;

    public readAllMembers(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileReading = new Scanner(file);
            while (fileReading.hasNext()) {
                String[] stringToArray = fileReading.next().split("=");
                if (counter == 0) {
                    String[] nameArray = stringToArray[1].toString().split(" ");
                     name = "";
                    for (char i = 2; i < Arrays.toString(nameArray).length() - 2; i++) {
                        name += Arrays.toString(nameArray).charAt(i);
                    }
                } if (counter == 1) {
                    String[] ageArray = stringToArray[1].toString().split(" ");
                    String ageString = "";
                    for (char i = 1; i < Arrays.toString(ageArray).length() - 1; i++) {
                        ageString += Arrays.toString(ageArray).charAt(i);
                    }
                     age = Integer.parseInt(ageString);
                }  if (counter == 2) {
                    String[] addressArray = stringToArray[1].toString().split(" ");
                     address = "";
                    for (char i = 2; i < Arrays.toString(addressArray).length() - 2; i++) {
                        address += Arrays.toString(addressArray).charAt(i);
                    }
                } if (counter == 3) {
                    String[] idArray = stringToArray[1].toString().split(" ");
                    String idString = "";
                    for (char i = 1; i < Arrays.toString(idArray).length() - 1; i++) {
                        idString += Arrays.toString(idArray).charAt(i);
                    }
                    id = Integer.parseInt(idString);
                } if (counter == 4) {
                     isActive = Boolean.parseBoolean(Arrays.toString(stringToArray[1].split(" ")));
                }  if (counter == 5) {
                      isUnder18 = Boolean.parseBoolean(Arrays.toString(stringToArray[1].split(" ")));
                } if (counter == 6) {
                     isElite = Boolean.parseBoolean(Arrays.toString(stringToArray[1].split(" ")));
                } if (counter == 7) {
                     hasPaid = Boolean.parseBoolean(Arrays.toString(stringToArray[1].split(" ")));
                    System.out.println(new Member(name,age,address,id,0,isActive,isUnder18,isElite,hasPaid));
                }
                counter++;
            } if (counter == 8) {
                counter = 0;

            }
        } catch (Exception e) {
            System.out.println("File couldn't read");
        }
    }

    public static void main(String[] args) {
        new readAllMembers("resources/members.csv");
    }
}

