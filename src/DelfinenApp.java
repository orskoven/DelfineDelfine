// AUTHOR : ELISA & LAURA & SIMON & RASMUS


import controller.SystemController;

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
