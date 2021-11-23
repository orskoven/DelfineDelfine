package database;

import disciplines.Discipline;
import persons.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveDiscipline {
    private ArrayList<String> disciplineArray = new ArrayList<String>();
    static int memberId;


    public void saveDiscipline(Discipline discipline, String disciplineFile) {
        String[] discplineDetailsArray = discipline.toString().split(",");
        try {
            Writer w = new FileWriter(disciplineFile, true);
            w.write("\r");
            for (int i = 0; i < discplineDetailsArray.length; i++) {
                w.write(discplineDetailsArray[i]);
            }
            w.close();

            System.out.println("Saved" + "💾");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

