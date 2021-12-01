package UI;

import factory.MemberUpdate;
import persons.Cashier;

import java.io.IOException;

public class CashierMenu {
    private Menu menu = new Menu();
    private Cashier cashier = new Cashier();
    private MemberUpdate memberUpdate = new MemberUpdate();

    public CashierMenu() throws IOException {
    }

    public void showCashierMenu () throws IOException {
        int cashierChoice;

        do {
            optionsForCashier();
            cashierChoice = menu.getUserInput();

            if (cashierChoice == 1) {
                //Show contingent prices
                showContingentPrices();
            } else if (cashierChoice == 2) {
                //show expected payments
                showRevenueData();
            } else if (cashierChoice == 3) {
                //show members in arrears
                cashier.getMembersWhoHasntPayed();      //evt. LoadingMissingpaymentmembers
            } else if (cashierChoice == 4) {
                //change member payment status
                paymentStatus();


            } else if (cashierChoice == 9) {
                break;
            }
            System.out.println();

        }while (cashierChoice != 9);

    }

    public void optionsForCashier(){
        System.out.println("Cashier options:");
        System.out.println("1. Show contingent prices");
        System.out.println("2. Show revenue data");
        System.out.println("3. Show members in arrears");       //restance = er i gæld til svømmeklubben
        System.out.println("4. Change members payment status");
        System.out.println("9. Return");
    }

    public void paymentStatus() throws IOException {
        System.out.println("1. Change member to 'has paid'\n2. Change member to 'has NOT paid'\n3. Quit");
        int adjustChoice = menu.getUserInput();


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
                break;

        }
    }

    public void changePaymentStatus() throws IOException {
        System.out.println("Payment adjust: ");
        paymentStatus();

    }

    public void showContingentPrices(){
        System.out.println("Contingent list:");
        System.out.println("Under 18 years......... 1000 DKK");
        System.out.println("Over 18 years.......... 1600 DKK");
        System.out.println("Over 60 years.......... 1200 DKK");
        System.out.println("Passive membership...... 500 DKK");
    }

    public void showRevenueData(){
        System.out.println("Expected revenue:");
        System.out.println(cashier.getExpectedRevenue()+" DKK");
        System.out.println("Payed revenue:");
        System.out.println(cashier.getPayedRevenue()+" DKK");
        System.out.println("Missing revenue:");
        System.out.println(cashier.getMissingRevenue()+" DKK");
    }
}
