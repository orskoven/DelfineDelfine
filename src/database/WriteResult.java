// AUTHOR : SIMON


package database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteResult {


    public static void writerToFile(String resultData){
        try {
            Writer w = new FileWriter("resources/results.csv", true);
            w.write("\n");
            w.write(resultData);
            w.close();
            System.out.println("Result saved 💾");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
