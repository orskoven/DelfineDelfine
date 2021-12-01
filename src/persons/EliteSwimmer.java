package persons;

import database.ReadAllMembers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EliteSwimmer {

    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();
    private Cashier cashier;



    public ArrayList<Member> findEliteSwimmer() {

        members.clear();
        eliteMembers.clear();

        members = readAllMembers.setFile();

        //til at få

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isEliteSwimmer() == (true)) {
                eliteMembers.add(members.get(i));
                //System.out.println(eliteMembers.get(i).toStringToPrintAll());
            } else {
            }
        }
        return eliteMembers;
    }

    public void showJuniorTeam(){
        findEliteSwimmer();
        System.out.println("Junior Team");
        for (int i = 0; i < eliteMembers.size(); i++) {
            if (eliteMembers.get(i).isUnder18() == true){
                System.out.println("・Name: " + eliteMembers.get(i).getName() + " ID: " + eliteMembers.get(i).getMemberId());
            }
        }
    }

    public void showSeniorTeam(){
        findEliteSwimmer();
        System.out.println("Senior Team");
        for (int i = 0; i < eliteMembers.size(); i++) {
            if (eliteMembers.get(i).isUnder18() == false){
                System.out.println("・Name: " + eliteMembers.get(i).getName() + " ID: " + eliteMembers.get(i).getMemberId());
            }
        }
    }

    public void showEliteSwimmers(){
        findEliteSwimmer();
        for (Member eliteSwimmer : eliteMembers) {
            System.out.println(eliteSwimmer);
        }
    }



}