package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private String login;
    private String password;
    static ArrayList<Chairman> chairmans = new ArrayList<Chairman>();

    public Chairman(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static void login() {
        String login = "chairman";
        String password = "chairman123";
        Chairman chairman = new Chairman(login, password);
        chairmans.add(chairman);
    }

    public static void validateLogin() {
        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (!validateCheck) {

            System.out.println("Login:");
            String chairmanLogin = userInputString.nextLine();

            System.out.println("Password: ");
            String chairmanPassword = userInputString.nextLine();

            Chairman test = new Chairman(chairmanLogin, chairmanPassword);

            for (int i = 0; i < chairmans.size(); i++) {
                Boolean loginCheck = test.getLogin().equals(chairmans.get(i).getLogin());
                Boolean passwordCheck = test.getPassword().equals(chairmans.get(i).getPassword());

                if (loginCheck && passwordCheck) {
                    System.out.println("Correct login - Welcome");
                    validateCheck = true;
                    break;
                } else {
                    System.out.println("Wrong login - try again");

                }
            }
        }
        chairmans = new ArrayList<Chairman>();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
