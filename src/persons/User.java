package persons;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String login;
    private String password;
    static ArrayList<User> users = new ArrayList<User>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static void login(String login, String password) {
        String userLogin = "...";
        String userPassword = "...";
        User user = new User(login,password);
        users.add(user);
        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (validateCheck == false) {

            System.out.println("Login:");
            String loginInput = userInputString.nextLine();

            System.out.println("Password: ");
            String passwordInput = userInputString.nextLine();

            User test = new User(login, password);

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User:" +
                "login: " + login + '\'' +
                ", password: " + password + '\'' +
                '}';
    }
}
