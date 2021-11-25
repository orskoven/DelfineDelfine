package UI;

import factory.MemberUpdate;

import java.io.IOException;
import java.util.Scanner;

public class AdjustMentMenu {
    Scanner scanner = new Scanner(System.in);
    private MemberUpdate memberUpdate = new MemberUpdate();


    public AdjustMentMenu() throws IOException {
       firsetMenu();
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                paymentMenu();
                break;
            case 2:
                activeMenu();
                break;
            case 3:
                eliteMenu();
                break;
            case 4:
                juniorSeniorMenu();
                break;
            case 5:


        }
    }
    public void firsetMenu(){
        System.out.println("Welcome to the adjustment menu: ");
        System.out.println("1. Payment\n2. Active/Passive\n3. Elite/non-Elite\n4. Junior/Senior");
    }
    public void activeMenu() throws IOException {
        System.out.println("Please choose your action: ");
        System.out.println("1. Turn member active \n2. Turn member passive\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                memberUpdate.getNonActiveMembers();
                break;
            case 2:
                memberUpdate.getActiveMembers();
                break;
            case 3:
                new AdjustMentMenu();

        }
    }

    public void paymentMenu() throws IOException {
        System.out.println("Please choose your action: ");
        System.out.println("1. Member has paid\n2. Member has not paid\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                memberUpdate.nonPayingMembers();
                break;
            case 2:
                memberUpdate.payingMembers();
                break;
            case 3:
                new AdjustMentMenu();

        }
    }

    public void eliteMenu() throws IOException {
        System.out.println("Please choose your action: ");
        System.out.println("1. Wants to be elite \n2. Want to be non-elite\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                memberUpdate.getNonEliteMembers();
                break;
            case 2:
                memberUpdate.getEliteMembers();
                break;
            case 3:
                new AdjustMentMenu();

        }
    }
    public void juniorSeniorMenu() throws IOException {
        System.out.println("Please choose your action: ");
        System.out.println("1. Member has turned over 18 \n2. Turn member passive\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                memberUpdate.getJuniorMebers();
                break;
            case 2:
                memberUpdate.getSeniorMebers();
                break;
            case 3:
                new AdjustMentMenu();

        }
    }
}
