// AUTHOR : ELISA & LAURA


package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private String username;
    private String password;
    static ArrayList<Chairman> chairmen = new ArrayList<Chairman>();

    public Chairman(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void chairmanLogin() {
        String username = "chairman";
        String password = "chairman123";
        Chairman chairman = new Chairman(username, password);
        chairmen.add(chairman);
    }

    public static Chairman login(){
        Scanner userInputString = new Scanner(System.in);

        System.out.println("Username:");
        String chairmanUsername = userInputString.nextLine();

        System.out.println("Password: ");
        String chairmanPassword = userInputString.nextLine();

        Chairman currentUser = new Chairman(chairmanUsername, chairmanPassword);
        return currentUser;
    }


    public static void validateLogin() {
        boolean validateCheck = false;
        while (!validateCheck) {

            Chairman userInput = login();

            for (int i = 0; i < chairmen.size(); i++) {
                Boolean usernameCheck = userInput.getUsername().equals(chairmen.get(i).getUsername());
                Boolean passwordCheck = userInput.getPassword().equals(chairmen.get(i).getPassword());

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
        chairmen = new ArrayList<Chairman>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
