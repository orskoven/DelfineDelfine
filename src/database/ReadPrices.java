// AUTHOR : SIMON

package database;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ReadPrices {

    public static void getMembershipPricesFromFile(){

//this reads the prices from csv file
    try {
        File file = new File("resources/membershipPrices.csv");
        Scanner productScanner = new Scanner(file);
        while (productScanner.hasNext()){
            String[] membershipDetails = productScanner.next().split(";");
            String membershipType = membershipDetails[0];
            int price = Integer.parseInt(membershipDetails[1]);
            membershipPrices.put(membershipType, price);
        }
        //  Block of code to try
    } catch(Exception e) {
        System.out.println("File couldn't read");
    }

    }

    public static HashMap<String, Integer> membershipPrices = new HashMap<>();

}




