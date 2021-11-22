package UI;

import persons.Member;

import java.util.Scanner;

public class Menu {
    private Scanner input;

    public Menu(){
        this.input = new Scanner(System.in);
    }

    public int getUserInput(){
        int userInput = Integer.parseInt(input.nextLine());
        return userInput;
    }

    public void welcome(){
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("Welcome to swim club The Dolphin!");
        System.out.println();
        System.out.println("------------------------------");
    }

    public void chooseUser(){
        System.out.println("1. Chairman");
        System.out.println("2. Cashier");
        System.out.println("3. Coach");
        System.out.println("0. Quit");
    }

    public void optionsForChairman() {
        System.out.println("1. Create member");
        System.out.println("2. Show members");
        System.out.println("3. Return");
    }

    public void optionsForCashier(){
        System.out.println("1. Show expected payments");
        System.out.println("2. Show members in arrears"); //restance = er i gæld til svømmeklubben
        System.out.println("3. Return");
    }

    public void optionsForCoach(){
        System.out.println("1. Show top 5 elite swimmers"); //juniors + seniors
        System.out.println("2. Show elite swimmers");
        System.out.println("3. Create a result");
        System.out.println("4. Return");
    }

}
