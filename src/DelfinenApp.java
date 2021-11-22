import database.MemberToSave;
import persons.Member;

public class DelfinenApp {
    static MemberToSave memberToSave = new MemberToSave();

    public static void main(String[] args) {
        Member member = new Member(null,0,null,0,0,true,true,true,true);
        memberToSave.saveMemberDetailsToFile(member);
    }
}
