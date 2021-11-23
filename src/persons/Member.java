package persons;

import java.util.Scanner;

public class Member {
    private String name;
    private int age;
    private String adress;
    private int memberId;
    private int memberCounter;
    private boolean isActive;
    private boolean isUnder18;
    private boolean isEliteSwimmer;
    private boolean hasPaid;

    public Member(String name, int age, String adress, int memberId,
                  boolean isActive, boolean isUnder18, boolean isEliteSwimmer, boolean hasPaid) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.memberId = memberId;
        this.isActive = isActive;
        this.isUnder18 = isUnder18;
        this.isEliteSwimmer = isEliteSwimmer;
        this.hasPaid = hasPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberCounter() {
        return memberCounter;
    }

    public void setMemberCounter(int memberCounter) {
        this.memberCounter = memberCounter;
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

    public void setUnder18(boolean under18) {
        isUnder18 = under18;
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
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", memberId=" + memberId +
                ", memberCounter=" + memberCounter +
                ", isActive=" + isActive +
                ", isUnder18=" + isUnder18 +
                ", isEliteSwimmer=" + isEliteSwimmer +
                ", hasPaid=" + hasPaid +
                '}';
    }
}
