package persons;

public class Member {
    private String name;
    private int age;
    private String address;
    private int memberId;
    private boolean isActive;
    private boolean isUnder18;
    private boolean isEliteSwimmer;
    private boolean hasPaid;

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
