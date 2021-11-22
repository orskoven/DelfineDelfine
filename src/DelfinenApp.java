import database.LoadMemberMissingPayment;
import database.MemberToSave;
import database.ReadFiles;
import factory.MemberGenerator;

public class DelfinenApp {
    static MemberToSave memberToSave = new MemberToSave();



    public static void main(String[] args) {
        new LoadMemberMissingPayment();
        System.out.println();
        new ReadFiles("resources/members.csv");
        new ReadFiles("resources/memberIdCounter.csv");
        MemberGenerator memberGenerator = new MemberGenerator();
        memberToSave.saveMemberDetailsToFile(memberGenerator.MemberGenerator());

    }
}
