package factory;

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
    private ArrayList<Member> members = readAllMembers.ReadAllMembers();
    private ArrayList<Member> membersToUpdate = new ArrayList<Member>();

    public MemberUpdate () throws IOException {
            }


    public void getNonActiveMembers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isActive() == false) {
                membersToUpdate.add(members.get(i));
            }

        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setActive(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            }

        }
    }
    public  void getActiveMembers() throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isActive() == true) {
                membersToUpdate.add(members.get(i));

            }
        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setActive(false);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            }
        }
    }
    public void getNonEliteMembers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isEliteSwimmer() == false) {
                membersToUpdate.add(members.get(i));
            }
        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setEliteSwimmer(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            }
        }
    }
      public void getEliteMembers () throws IOException {
          for (int i = 0; i < members.size(); i++) {
              if (members.get(i).isEliteSwimmer() == true) {
                  membersToUpdate.add(members.get(i));
              }
          }  for (int i = 0; i < membersToUpdate.size() ; i++) {
              System.out.println(membersToUpdate.get(i).toStringToPrintAll());
          }
          Scanner scanner = new Scanner(System.in);
          System.out.println("Type id to adjust: ");
          int userInput = scanner.nextInt();

          for (int i = 0; i < membersToUpdate.size(); i++) {
              if (userInput == membersToUpdate.get(i).getMemberId()) {
                  membersToUpdate.get(i).setEliteSwimmer(false);
                  members.add(membersToUpdate.get(i));
                  updateFile(i);
              }
          }
      }
    public void getJuniorMebers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isUnder18() == true) {
                membersToUpdate.add(members.get(i));
            }
        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setUnder18(false);
                members.add(membersToUpdate.get(i));
                updateFile(i);
            }
        }
    }
    public void getSeniorMebers () throws IOException {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).isUnder18() == false) {
                membersToUpdate.add(members.get(i));

            }
        }  for (int i = 0; i < membersToUpdate.size() ; i++) {
            System.out.println(membersToUpdate.get(i).toStringToPrintAll());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setUnder18(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setHasPaid(false);
                members.add(membersToUpdate.get(i));
                updateFile(i);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id to adjust: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < membersToUpdate.size(); i++) {
            if (userInput == membersToUpdate.get(i).getMemberId()) {
                membersToUpdate.get(i).setHasPaid(true);
                members.add(membersToUpdate.get(i));
                updateFile(i);
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

    public static void main(String[] args) throws IOException {
      MemberUpdate memberUpdate = new MemberUpdate();
      memberUpdate.getEliteMembers();
    }

}
