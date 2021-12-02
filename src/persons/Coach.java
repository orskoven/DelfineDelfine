package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach{
    private String login;
    private String password;
    static ArrayList<Coach> coaches = new ArrayList<Coach>();

    public Coach(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static void login() {
        String login = "coach";
        String password = "coach123";
        Coach coach = new Coach(login, password);
        coaches.add(coach);
    }

    public static void validateLogin() {
            Scanner userInputString = new Scanner(System.in);

            boolean validateCheck = false;
            while (!validateCheck) {

                System.out.println("Login:");
                String coachLogin = userInputString.nextLine();

                System.out.println("Password: ");
                String coachPassword = userInputString.nextLine();

                Coach test = new Coach(coachLogin, coachPassword);

                for (int i = 0; i <coaches.size() ; i++) {
                    Boolean loginCheck = test.getLogin().equals(coaches.get(i).getLogin());
                    Boolean passwordCheck = test.getPassword().equals(coaches.get(i).getPassword());

                    if (loginCheck && passwordCheck) {
                        System.out.println("Correct login - Welcome");
                        validateCheck = true;
                    } else {
                        System.out.println("Wrong login - try again");

                    }
                }
                coaches = new ArrayList<Coach>();
            }
        }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}



