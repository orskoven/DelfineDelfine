package controller;

import UI.Menu;

public class SystemController {

    private Menu menu = new Menu();

    public void chooseOptions(){
        int userInput;

        menu.welcome();

        do {

            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput){
                case 1:
                    menu.optionsForChairman();
                    if (userInput == 1){
                        //create member
                    }else if (userInput == 2){
                        //show members
                    }else if (userInput == 0){
                        //go back option
                    }
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
