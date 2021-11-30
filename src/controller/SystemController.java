package controller;


import UI.*;
import database.*;
import factory.DisciplineGenerator;
import factory.DisciplineGeneratorTraining;
import factory.MemberGenerator;
import factory.MemberUpdate;
import persons.Cashier;
import persons.Chairman;
import persons.EliteSwimmer;
import persons.Member;

import java.io.IOException;
import java.util.*;

public class SystemController {
    private Menu menu = new Menu();
    private CashierMenu cashierMenu = new CashierMenu();
    private ChairmanMenu chairmanMenu = new ChairmanMenu();
    private CoachMenu coachMenu = new CoachMenu();

    public SystemController() throws IOException {
    }

    public void chooseOptions() throws IOException {
        int userInput;

        menu.welcome();
        do {
            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput) {
                case 1:
                    chairmanMenu.showChairmanMenu();
                    break;

                case 2:
                    cashierMenu.showCashierMenu();
                    break;

                case 3:
                    coachMenu.showCoachMenu();
                    break;
            }
            System.out.println();
        } while (userInput != 9);
    }

}