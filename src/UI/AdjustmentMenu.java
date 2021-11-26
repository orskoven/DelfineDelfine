package UI;

import factory.MemberUpdate;

import java.io.IOException;
import java.util.Scanner;

public class AdjustmentMenu {
    Scanner scanner = new Scanner(System.in);
    private MemberUpdate memberUpdate = new MemberUpdate();


    public AdjustmentMenu() throws IOException {
    }

    public void firsetMenu(){
        System.out.println("What would you like to adjust?: ");
        System.out.println("1. Payment\n2. Active/Passive\n3. Elite/non-Elite");
    }
    public void activeMenu() throws IOException {
        System.out.println("1. Turn member active \n2. Turn member passive\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                System.out.println("Members who are passive:");
                memberUpdate.getNonActiveMembers();
                break;
            case 2:
                System.out.println("Members who are active:");
                memberUpdate.getActiveMembers();
                break;
            case 3:
                new AdjustmentMenu();

        }
    }

    public void paymentMenu() throws IOException {
        System.out.println("1. Change member to 'has paid'\n2. Change member to 'has NOT paid'\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                System.out.println("Members who have not paid:");
                memberUpdate.nonPayingMembers();
                break;
            case 2:
                System.out.println("Members who have paid:");
                memberUpdate.payingMembers();
                break;
            case 3:
                new AdjustmentMenu();

        }
    }

    public void eliteMenu() throws IOException {
        System.out.println("1. Change member to be elite \n2. Change member to be non-elite\n3. Quit");
        int adjustChoice = scanner.nextInt();
        switch (adjustChoice){
            case 1:
                System.out.println("Members who are non-elite:");
                memberUpdate.getNonEliteMembers();
                break;
            case 2:
                System.out.println("Members who are elite:");
                memberUpdate.getEliteMembers();
                break;
            case 3:
                new AdjustmentMenu();

        }
    }
    public void adjustmentMenuOverview() throws IOException {
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


        }
    }

}
