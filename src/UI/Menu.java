package UI;

import persons.Member;

import java.util.Scanner;

public class Menu {
    private Scanner input;
    private SoundPlayer introSound = new SoundPlayer();
    private String lastLine = "";

    public Menu() {
        this.input = new Scanner(System.in);
    }

    public int getUserInput() {
        int userInput = Integer.parseInt(input.nextLine());
        return userInput;
    }

    public void welcome() throws InterruptedException {
        introSound.play("resources/booooobbooob.wav");
        runner();
    }

    public void chooseUser() {
        System.out.println("Login as: ");
        System.out.println("1. Chairman");
        System.out.println("2. Cashier");
        System.out.println("3. Coach");
        System.out.println("9. Quit");
    }


    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (char i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;
    private byte anima = 3;

    public void animate(String line) {
        switch (anim) {
            case 1:
                System.out.println("-------------------------------------");
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println(" Welcome to The Dolphin Swim Club!  ");
                break;
            case 4:
                System.out.println();
                break;
            default:
                anim = 0;
                print("");
        }
        anim++;
    }


    public static void runner() throws InterruptedException {
        Menu menuVisualization = new Menu();
        for (int i = 0; i < 8; i++) {
            menuVisualization.animate(   i + "");
            Thread.sleep(400);
            //simulate a piece of task
        }
    }





}
