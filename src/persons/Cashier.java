package persons;

import database.EditFile;
import database.MemberToSave;
import database.ReadAllMembers;
import factory.MemberGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Cashier extends User {

    public Cashier(String login, String password) {
        super(login, password);
    }

    public static void login() {
        String cashierLogin = "cashier";
        String casherPassword = "cashier123";
        Cashier cashier = new Cashier(cashierLogin,casherPassword);
        users.add(cashier);

        Scanner userInputString = new Scanner(System.in);

        boolean validateCheck = false;
        while (validateCheck == false) {

            System.out.println("Login:");
            String login = userInputString.nextLine();

            System.out.println("Password: ");
            String password = userInputString.nextLine();

            Cashier test = new Cashier(login, password);

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