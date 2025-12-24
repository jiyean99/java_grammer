package C07ExceptionFileParsing.MemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 저장소 역할을 하는 계층(사실 정확히는 이건 아님)
// 즉, DB의 CRUD를 수행하는 계층
public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository() {
        this.memberList = new ArrayList<>();
    }

    public void register(Member member) {
        this.memberList.add(member);
    }

    // stream 사용 X 버전
    /* stream 사용 X 버전
        public Optional<Member> findByEmail(String email) {
            Member member = null;
            for (Member a : memberList) {
                if (a.getEmail().equals(email)) {
                    member = a;
                    break;
                }
            }
            return Optional.ofNullable(member);
        }
    */

    // stream 사용 O 버전
    public Optional<Member> findByEmail(String email) {
        // findFirst 메서드 자체는 Optional로 설계되어있기 때문에 이대로 리턴시키면 됨
        return this.memberList.stream().filter(a -> a.getEmail().equals(email)).findFirst();
    }

    public Optional<Member> findById(long id) {
        Member member = null;
        for (Member a : memberList) {
            if (a.getId() == id) {
                member = a;
                break;
            }
        }
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        return this.memberList;
    }

}
