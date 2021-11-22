package controller;

import UI.Menu;

public class SystemController {

    private Menu menu = new Menu();

    public void chooseOptions(){
        int userInput;

        System.out.println("1. Chairman");
        System.out.println("2. Cashier");
        System.out.println("3. Coach");
        System.out.println("0. Quit");

        do {
            menu.welcome();
            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput){
                case 1:
                    menu.optionsForChairman();
                    break;
                case 2:
                    menu.optionsForCashier();
                    break;
                case 3:
                    menu.optionsForCoach();
                    break;
            }
        } while (userInput != 0);
    }

    public static void main(String[] args) {
        SystemController hej = new SystemController();
        hej.chooseOptions();
    }

}
