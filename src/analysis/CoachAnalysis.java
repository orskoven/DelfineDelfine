
// AUTHOR : RASMUS & LAURA & SIMON

package analysis;

import database.ReadAllMembers;
import persons.Member;

import java.util.ArrayList;

public class CoachAnalysis {
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> eliteMembers = new ArrayList<Member>();

    public void clearList (){
        members.clear();
        eliteMembers.clear();
    }

    public ArrayList<Member> findEliteSwimmer() {

        clearList();
        members = readAllMembers.setFile();

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
                System.out.println("• Name: " + eliteMembers.get(i).getName() + ", ID: " + eliteMembers.get(i).getMemberId());
            }
        }
    }

    public void showSeniorTeam(){
        findEliteSwimmer();
        System.out.println("Senior Team");
        for (int i = 0; i < eliteMembers.size(); i++) {
            if (eliteMembers.get(i).isUnder18() == false){
                System.out.println("• Name: " + eliteMembers.get(i).getName() + ", ID: " + eliteMembers.get(i).getMemberId());
            }
        }
    }
}