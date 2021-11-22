import database.MemberToSave;
import database.ReadFiles;
import factory.MemberGenerator;
import persons.Member;

public class DelfinenApp {
    static MemberToSave memberToSave = new MemberToSave();



    public static void main(String[] args) {
        new ReadFiles("src/disciplines/resources/members.csv");
        new ReadFiles("src/disciplines/resources/memberIdCounter.csv");
        MemberGenerator memberGenerator = new MemberGenerator();
        memberToSave.saveMemberDetailsToFile(memberGenerator.MemberGenerator());

    }
}
