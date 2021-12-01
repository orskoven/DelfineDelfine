package UI;
// https://www.logicbig.com/how-to/code-snippets/jcode-java-command-line-animation <- inspiration to whole class

public class MenuVisualization {
    private String lastLine = "";



    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (char i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;
    private byte anima = 3;

    public void animate(String line) {
        switch (anim) {
            case 1:
                System.out.println("-------------------------------------");
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println(" Welcome to The Dolphin Swim Club!  ");
                break;
            case 4:
                System.out.println();
                break;
            default:
                anim = 0;
                print("");
        }
        anim++;
    }

    public static void main() throws InterruptedException {
        MenuVisualization menuVisualization = new MenuVisualization();
        for (int i = 0; i < 8; i++) {
            menuVisualization.animate(   i + "");
            Thread.sleep(400);
            //simulate a piece of task
        }
    }
}

