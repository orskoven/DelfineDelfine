import controller.SystemController;
import database.LoadMemberMissingPayment;
import database.MemberToSave;
import database.ReadFiles;
import factory.MemberGenerator;

import java.io.IOException;

public class DelfinenApp {
    private SystemController systemController = new SystemController();

    public DelfinenApp() throws IOException {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        DelfinenApp delfinenApp = new DelfinenApp();

        delfinenApp.systemController.chooseOptions();


    }
}
