package database;

import java.io.File;
import java.util.Scanner;

public class ReadFiles {

    public ReadFiles(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileReading = new Scanner(file);
            while (fileReading.hasNext()) {
                String membersDetails = fileReading.nextLine();
                System.out.println(membersDetails + "\n" + "______________________________________________________" +
                        "__________________________________________________________");
            }
        } catch (Exception e) {
            System.out.println("File couldn't read");
        }
    }
}