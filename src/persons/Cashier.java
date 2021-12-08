// AUTHOR : ELISA & LAURA


package persons;

import java.util.ArrayList;
import java.util.Scanner;


public class Cashier {
    private String username;
    private String password;
    static ArrayList<Cashier> cashiers = new ArrayList<Cashier>();

    public Cashier(String login, String password) {
        this.username = login;
        this.password = password;
    }

    public static void cashierLogin() {
        String username = "cashier";
        String password = "cashier123";
        Cashier cashier = new Cashier(username, password);
        cashiers.add(cashier);
    }


    public static Cashier login(){
        Scanner userInputString = new Scanner(System.in);

        System.out.println("Username:");
        String cashierUsername = userInputString.nextLine();

        System.out.println("Password: ");
        String cashierPassword = userInputString.nextLine();

        Cashier currentUser = new Cashier(cashierUsername, cashierPassword);
        return currentUser;
    }


    public static void validateLogin(){

        boolean validateCheck = false;
        while (!validateCheck) {

            Cashier userInput = login();

            for (int i = 0; i < cashiers.size(); i++) {
                Boolean usernameCheck = userInput.getUsername().equals(cashiers.get(i).getUsername());
                Boolean passwordCheck = userInput.getPassword().equals(cashiers.get(i).getPassword());

                if (usernameCheck && passwordCheck) {
                    System.out.println("👋🏽 Welcome 👋🏽");
                    validateCheck = true;
                    break;
                } else {
                    System.out.println("Wrong login - try again");

                }
            }
            System.out.println();
        }
        cashiers = new ArrayList<Cashier>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}