package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends User {
    public Coach(String login, String password) {
        super(login, password);
    }

    public static void login() {
        String coachLogin = "coach";
        String coachPassword = "coach123";
        Coach coach = new Coach(coachLogin,coachPassword);
        users.add(coach);

        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (validateCheck == false) {

            System.out.println("Login:");
            String login = userInputString.nextLine();

            System.out.println("Password: ");
            String password = userInputString.nextLine();

            Coach test = new Coach(login, password);

            for (int i = 0; i < users.size(); i++) {
                Boolean loginCheck = test.getLogin().equals(users.get(i).getLogin());
                Boolean passwordCheck = test.getPassword().equals(users.get(i).getPassword());

                if (loginCheck && passwordCheck) {
                    System.out.println("Correct login - Welcome");
                    validateCheck = true;
                } else {
                    System.out.println("Wrong login - try again");

                }
            }
        }
    }
}
