package controller;
import UI.*;
import persons.*;
import java.io.IOException;

public class SystemController {
    private Menu menu = new Menu();
    private CashierMenu cashierMenu = new CashierMenu();
    private ChairmanMenu chairmanMenu = new ChairmanMenu();
    private CoachMenu coachMenu = new CoachMenu();

    public SystemController() throws IOException {
    }

    public void chooseOptions() throws IOException, InterruptedException {
        int userInput;

        menu.welcome();


        do {
            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput) {
                case 1:
                    Chairman.login();
                    Chairman.validateLogin();
                    chairmanMenu.showChairmanMenu();
                    break;

                case 2:
                    Cashier.login();
                    Cashier.validateLogin();
                    cashierMenu.showCashierMenu();
                    break;

                case 3:
                    Coach.login();
                    Coach.validateLogin();
                    coachMenu.showCoachMenu();
                    break;
            }
            System.out.println();
        } while (userInput != 9);
    }

}