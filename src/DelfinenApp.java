import database.MemberToSave;
import factory.MemberGenerator;
import persons.Member;

public class DelfinenApp {
    static MemberToSave memberToSave = new MemberToSave();

    public static void main(String[] args) {
        MemberGenerator memberGenerator = new MemberGenerator();
        memberToSave.saveMemberDetailsToFile(memberGenerator.MemberGenerator());
    }
}
