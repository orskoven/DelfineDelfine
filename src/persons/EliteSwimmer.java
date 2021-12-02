package persons;

import database.ReadAllMembers;

import java.util.ArrayList;

public class EliteSwimmer {

    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();




    public ArrayList<Member> findEliteSwimmer() {

        members.clear();
        eliteMembers.clear();

        members = readAllMembers.setFile();

        //til at få

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isEliteSwimmer() == (true)) {
                eliteMembers.add(members.get(i));

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



}