package UI;

import persons.Member;

import java.util.Scanner;

public class Menu {
    private Scanner input;
    private SoundPlayer introSound = new SoundPlayer();

    public Menu(){
        this.input = new Scanner(System.in);
    }

    public int getUserInput(){
        int userInput = Integer.parseInt(input.nextLine());
        return userInput;
    }

    public void welcome() throws InterruptedException {
        introSound.play("resources/booooobbooob.wav");
        MenuVisualization.main();
    }

    public void chooseUser(){
        System.out.println("Login as: ");
        System.out.println("1. Chairman");
        System.out.println("2. Cashier");
        System.out.println("3. Coach");
        System.out.println("9. Quit");
    }




}
