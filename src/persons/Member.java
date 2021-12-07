package persons;

import UI.Menu;

import java.util.Scanner;

public class Member {
    private String name;
    private int age;
    private String address;
    private int memberId;
    private boolean isActive;
    private boolean isUnder18;
    private boolean isEliteSwimmer;
    private boolean hasPaid;
    private Scanner input = new Scanner(System.in);

    private Menu menu = new Menu();

    public Member(){

    }

    public Member(String name, int age, String address, int memberId,
                  boolean isActive, boolean isUnder18, boolean isEliteSwimmer, boolean hasPaid) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.memberId = memberId;
        this.isActive = isActive;
        this.isUnder18 = isUnder18;
        this.isEliteSwimmer = isEliteSwimmer;
        this.hasPaid = hasPaid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isUnder18() {
        return isUnder18;
    }

    public boolean isEliteSwimmer() {
        return isEliteSwimmer;
    }

    public void setEliteSwimmer(boolean eliteSwimmer) {
        isEliteSwimmer = eliteSwimmer;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public int askForAge(){
        System.out.println("Age: ");
        age = menu.getUserInput();
        return age;
    }

    public String askForName(){
        System.out.println("Name: ");
        name = input.next();
        return name;
    }

    public String askForAddress(){
        System.out.println("Address: ");
        address = input.nextLine();
        if (address.isEmpty()) {
            address = input.nextLine();
        }
        return address;
    }

    public boolean askForIsActive(){
        System.out.println("Is the member:\n1. Active\n2. Passive ");
        if (menu.getUserInput() == 1) {
            isActive = true;
        } else {
            isActive = false;
        }
        return isActive;
    }

    public boolean askIsUnder18(){
        if (age < 18) {
            isUnder18 = true;
        } else {
            isUnder18 = false;
        }
        return isUnder18;
    }

    public boolean askForIsElite(){
        System.out.println("Is the member:\n1. Elite swimmer\n2. Non-elite");
        if (menu.getUserInput() == 1) {
            isEliteSwimmer = true;
        } else {
            isEliteSwimmer = false;
        }
        return isEliteSwimmer;
    }

    public boolean askForHasPaid(){
        System.out.println("Has the member paid:\n1. Yes\n2. No");
        if (menu.getUserInput() == 1) {
            hasPaid = true;
        } else {
            hasPaid = false;
        }
        return hasPaid;
    }


    @Override
    public String toString() {
    return name + ";" + age + ";" + address + ";" + memberId + ";" + isActive + ";" +
            isUnder18 + ";" + isEliteSwimmer + ";" + hasPaid;
}
    public String toStringToConsole() {
        return
                " Name: " + name +
                "\n Age: " + age +
                "\n Address: " + address +
                "\n Id: " + memberId +
                "\n Active: " + isActive +
                "\n Under 18: " + isUnder18 +
                "\n Elite Swimmer: " + isEliteSwimmer +
                "\n Paid: " + hasPaid;
    }
    public String toStringToPrintAll() {
        String toPrint = "• Name: "+ name +
                        " | Age: " + age +
                        " | Address: " + address +
                        " | Id: " + memberId;
                        if (this.isActive) {
                           toPrint +=  " | Active";
                        } else {
                            toPrint +=  " | Passive";
                        } if (this.isUnder18) {
                            toPrint +=  " | Junior";
                         } else {
                            toPrint +=  " | Senior";
                        }  if (this.isEliteSwimmer) {
                            toPrint +=  " | Elite Swimmer";
                        } else {
                            toPrint +=  " | Leisure swimmer";
                        } if (this.hasPaid) {
                            toPrint +=  " | Has paid |";
                        } else {
                            toPrint +=  " | Has not paid |";
                        }
                        return toPrint;
    }
}
