package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class LoadMember {
    static Scanner scanner = new Scanner(System.in);
    static int lineCounter = 0;
    static ArrayList<String> membersNotPayed = new ArrayList<String>();

    public LoadMember() {
        File getMemberNotPayedYet = new File("resources/members.csv");
        try {
            Scanner sc = new Scanner(getMemberNotPayedYet);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] stringLikeArray = line.split("=");
                String memberLine = stringLikeArray[9];
                    if (Objects.equals("false}", memberLine)) {
                     lineCounter++;
                     membersNotPayed.add(Arrays.toString(stringLikeArray));
                    }



            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        System.out.println(lineCounter + " members have not payed subscription yet!\nTo show who press 1:");
        if(scanner.nextInt() == 1){
            for (int i = 0; i < membersNotPayed.size() ; i++) {
                System.out.println(membersNotPayed.get(i).toString());
            }
        }


    }
}
