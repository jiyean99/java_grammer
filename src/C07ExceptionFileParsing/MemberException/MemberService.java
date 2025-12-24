package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

// 핵심 로직 처리(구현)하는 계층
public class MemberService {
    private MemberRepository memberRepository;

    // MemberRepository 객체를 register 메서드 안에서 생성하게되면 매번 새로운 객체를 생성하게 되므로 저장이 되지 않는다
    // 따라서 생성자에 MemberRepository 객체를 생성
    // 아니면 static을 붙여서 코드관리하면됨
    public MemberService() {
        memberRepository = new MemberRepository();
    }


    public void register(String name, String email, String password) throws IllegalArgumentException {
        // 검증작업 수행 : List(DB)에 이메일이 중복일 경우 예외 발생
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 객체 조립 후 repository를 통해 저장
        Member member = new Member(name, email, password);
        memberRepository.register(member);
    }

    public Member findById(long id) throws NoSuchElementException {
        //return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("일치하는 ID값이 없습니다."));
        return memberRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 사용자입니다."));
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void login(String email, String password) throws NoSuchElementException, IllegalArgumentException {
        // email이 있는지 확인 후 없으면 예외 발생
        Member member = memberRepository
                .findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("일치하는 email이 없습니다."));

        // password가 일치하는지 확인 후 일치하지 않으면 예외 발생
        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}
