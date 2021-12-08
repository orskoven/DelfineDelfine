// AUTHOR : RASMUS & LAURA


package database;

import persons.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadResults {
    private ArrayList<Result> resultArrayList = new ArrayList<Result>();


    public ArrayList<Result> setFile() {
        try {
            File membersFile = new File("resources/results.csv");
            Scanner fileReading = new Scanner(membersFile);
            fileReading.nextLine();

            while (fileReading.hasNextLine()) {

                String line1 = fileReading.nextLine();
                String[] membersArray1 = line1.split(";");


                String discipline = membersArray1[0];
                String memberName = membersArray1[1];
                int memberId = Integer.parseInt(membersArray1[2]);
                String timeStamp = membersArray1[3];
                String tournament = membersArray1[4];
                String timeResult = membersArray1[5];
                int rank = Integer.parseInt(membersArray1[6]);

                Result result = new Result(discipline, memberName, memberId, timeStamp,
                        tournament, timeResult, rank);

                resultArrayList.add(result);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldn't read Results file");
        }

        return resultArrayList;
    }


}


