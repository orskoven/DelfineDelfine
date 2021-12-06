package factory;

import UI.Menu;
import database.EditFile;
import database.ReadAllMembers;
import persons.Member;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemberUpdate {
    private ReadAllMembers readAllMembers = new ReadAllMembers();
    private ArrayList<Member> members = readAllMembers.setFile();
    private ArrayList<Member> membersToUpdate = new ArrayList<Member>();
    private Menu menu = new Menu();

    public MemberUpdate () throws IOException {
    }

    public void getNonActiveMembers (int memberId) throws IOException {

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isActive() == false) {
                membersToUpdate.add(members.get(i));
            }
        }

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (memberId == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setActive(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            } else if (members.size() == 0) {
                System.out.println("No member to update [X]");
                i = members.size();
            }

        }
    }

    public  void getActiveMembers(int memberID) throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isActive() == true) {
                membersToUpdate.add(members.get(i));

            }
        }

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (memberID == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setActive(false);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            } else if (members.size() == 0) {
                System.out.println("No member to update [X]");
                i = members.size();
            }
        }
    }

    public void getNonEliteMembers (int memberId) throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isEliteSwimmer() == false) {
                membersToUpdate.add(members.get(i));
            }
        }

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (memberId == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setEliteSwimmer(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            }  else if (members.size() == 0) {
                System.out.println("No member to update [X]");
                i = members.size();
            }
        }
    }
      public void getEliteMembers (int memberId) throws IOException {
          for (int i = 0; i < members.size(); i++) {
              if (members.get(i).isEliteSwimmer() == true) {
                  membersToUpdate.add(members.get(i));
              }
          }

          for (int i = 0; i < membersToUpdate.size(); i++) {
              if (memberId == membersToUpdate.get(i).getMemberId()) {
                  membersToUpdate.get(i).setEliteSwimmer(false);
                  members.add(membersToUpdate.get(i));
                  updateFile(i);
              } else if (members.size() == 0) {
                  System.out.println("No member to update [X]");
                  i = members.size();
              }
          }
      }

    public void payingMembers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isHasPaid() == true) {
                membersToUpdate.add(members.get(i));
            }
        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }

        System.out.println("Type ID to adjust: ");
        int userInput = menu.getUserInput();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setHasPaid(false);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            } else if (members.size() == 0) {
                System.out.println("No member to update [X]");
                i = members.size();
            }
        }
    }
    public void nonPayingMembers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isHasPaid() == false) {
                membersToUpdate.add(members.get(i));
            }
        }
        for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }

        System.out.println("Type ID to adjust: ");
        int userInput = menu.getUserInput();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setHasPaid(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            } else if (members.size() == 0) {
                System.out.println("No member to update [X]");
                i = members.size();
            }
        }
    }


    public void updateFile (int i) throws IOException {
        for (int j = 0; j < members.size(); j++) {
            if (members.get(j).getMemberId() == membersToUpdate.get(i).getMemberId()) {
                Collections.swap(members, j, members.size() - 1);
                members.remove(members.size() - 1);
                new EditFile().addMember(members);
            }
        }
        System.out.println("\nThe adjustment has been completed [✓]");
    }
}
