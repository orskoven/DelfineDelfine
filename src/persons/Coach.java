package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends User{
    public Coach(String login, String password) {
        super(login, password);
    }

    public static void main(String[] args) {
        ArrayList<Coach> coachUsers = new ArrayList<Coach>();

        String coachLogin = "coach";
        String coachPassword = "coach1";
        Coach coach = new Coach(coachLogin,coachPassword);
        coachUsers.add(coach);

        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (validateCheck == false) {

            System.out.println("Login:");
            String login = userInputString.nextLine();

            System.out.println("Password: ");
            String password = userInputString.nextLine();

            Coach test = new Coach(login, password);

            for (int i = 0; i < coachUsers.size(); i++) {
                Boolean loginCheck = test.getLogin().equals(coachUsers.get(i).getLogin());
                Boolean passwordCheck = test.getPassword().equals(coachUsers.get(i).getPassword());

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
