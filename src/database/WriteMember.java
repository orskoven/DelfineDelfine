package database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteMember {


    public void writerToFile(String members){
        try {
            Writer w = new FileWriter("resources/members.csv", true);
            w.write(members);
            w.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
