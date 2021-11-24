package persons;

import database.ReadAllMembers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EliteSwimmer {

    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private Cashier cashier = new Cashier();



    public void addEliteSwimmer() {

        members.clear();
        eliteMembers.clear();

        members = readAllMembers.ReadAllMembers();

        //til at få

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isEliteSwimmer() == (true)) {
                eliteMembers.add(members.get(i));
                //System.out.println(eliteMembers.get(i));
            } else {
            }
            for (Member eliteSwimmer : eliteMembers) {
                System.out.println(eliteSwimmer);
            }
        }
    }
/*
    public void showEliteSwimmers(){
        addEliteSwimmer();
        for (Member eliteSwimmer : eliteMembers) {
            System.out.println(eliteSwimmer);
        }
    }
 */


}