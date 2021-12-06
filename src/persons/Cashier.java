package persons;

import java.util.ArrayList;
import java.util.Scanner;


public class Cashier {
    private String login;
    private String password;
    static ArrayList<Cashier> cashiers = new ArrayList<Cashier>();

    public Cashier(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static void login() {
        String login = "cashier";
        String password = "cashier123";
        Cashier cashier = new Cashier(login, password);
        cashiers.add(cashier);
    }

    public static void validateLogin(){
        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (!validateCheck) {

            System.out.println("Login:");
            String cashierLogin = userInputString.nextLine();

            System.out.println("Password: ");
            String cashierPassword = userInputString.nextLine();

            Cashier test = new Cashier(cashierLogin, cashierPassword);

            for (int i = 0; i < cashiers.size(); i++) {
                Boolean loginCheck = test.getLogin().equals(cashiers.get(i).getLogin());
                Boolean passwordCheck = test.getPassword().equals(cashiers.get(i).getPassword());

                if (loginCheck && passwordCheck) {
                    System.out.println("Correct login - Welcome");
                    validateCheck = true;
                    break;
                } else {
                    System.out.println("Wrong login - try again");

                }
            }
        }
        cashiers = new ArrayList<Cashier>();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}