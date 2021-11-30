package database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Write {


    public void writerToFile(String members){
        String firstLine = "name;age;adress;id;isActive;isUnder18;isElite;hasPaid";
        try {
            Writer w = new FileWriter("resources/members.csv", true);
            w.write(firstLine);
            w.write(members);
            w.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
