package controller;

import UI.Menu;
import factory.MemberGenerator;

public class SystemController {

    private Menu menu = new Menu();
    private MemberGenerator member = new MemberGenerator();

    public void chooseOptions(){
        int userInput;

        menu.welcome();

        do {

            menu.chooseUser();
            userInput = menu.getUserInput();

            switch (userInput){
                case 1:
                    menu.optionsForChairman();
                    int choice = menu.getUserInput();
                    if (choice == 1){                    //create member
                        member.MemberGenerator();

                    }else if (choice == 2){
                        //show members

                    }else if (choice == 9){
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
        } while (userInput != 9);
    }

    public static void main(String[] args) {
        SystemController hej = new SystemController();
        hej.chooseOptions();
    }

}
