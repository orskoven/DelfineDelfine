package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Coach{
    private String username;
    private String password;
    static ArrayList<Coach> coaches = new ArrayList<Coach>();

    public Coach(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void coachLogin() {
        String username = "coach";
        String password = "coach123";
        Coach coach = new Coach(username, password);
        coaches.add(coach);
    }

    public static Coach login(){
        Scanner userInputString = new Scanner(System.in);

        System.out.println("Username:");
        String coachUsername = userInputString.nextLine();

        System.out.println("Password: ");
        String coachPassword = userInputString.nextLine();

        Coach currentUser = new Coach(coachUsername, coachPassword);

        return currentUser;
    }

    public static void validateLogin() {

            boolean validateCheck = false;
            while (!validateCheck) {

                Coach userInput = login();

                for (int i = 0; i < coaches.size() ; i++) {
                    Boolean usernameCheck = userInput.getUsername().equals(coaches.get(i).getUsername());
                    Boolean passwordCheck = userInput.getPassword().equals(coaches.get(i).getPassword());

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
          coaches = new ArrayList<Coach>();
        }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}



