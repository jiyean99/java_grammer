package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

// 사용자와 인터페이싱하는 계층(입출력)
public class MemberController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        while (true) {
            System.out.println("1번: 회원가입\n2번: 회원 상세조회\n3번: 회원 목록조회\n4번: 로그인");
            String input = sc.nextLine();

            if (input.equals("1")) {
                // TODO 회원가입 시 발생하는 예외를 적절히 try/catch -> controller에서 실행
                // 회원가입 시 발생할 수 있는 검증 : 1. email 중복검증, 2. email 형식 검증, 3.password 길이 검증, 4. 이름의 길이 검증
                // 이 때 1번은 실제 DB에 갔다와봐야(Repository까지 들어가야함) 검증이 가능하고 이 때 서비스에서 에러를 발생시고, 컨트롤러에서 응답을 해줘야함
                // 그 외는 그냥 컨트롤러에서 검증하면 됨(서비스에 들어갔다 나오는것은 코드의 낭비임)
                System.out.println("회원가입 서비스입니다.");
                System.out.println("이름을 입력해주세요.");
                String name = sc.nextLine();
                System.out.println("email을 입력해주세요.");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요.");
                // 사용자의 입력값 단순 검증
                String password = sc.nextLine();
                if (password.length() < 10) {
                    System.out.println("비밀번호 입력값이 너무 짧습니다.");
                    // 이 때 여기서 throws 를 해버리면 JVW한테 예외를 처리하라고 던지는거임(예외를 줄 필요가 없고 사용자에게 메시지만 전달하면 됨)
                    return;
                }
                try {
                    memberService.register(name, email, password);
                } catch ( IllegalArgumentException e) { // Exception으로 퉁치면 에러 원인(400, 404 등)을 구분하기 어려워서 구체적인 예외로 분기하는 게 좋다.
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            } else if (input.equals("2")) {
                // TODO 회원 상세조회 시 발생하는 예외를 적절히 try/catch
                System.out.println("회원 상세조회 서비스입니다.");
                System.out.println("회원 ID값을 입력해주세요.");
                long id = Long.parseLong(sc.nextLine()); // 여기서는 Number포맷 에러를 바로 try/catch 하는 형식으로 해도 됨
                try {
                    Member member = memberService.findById(id);
                    System.out.println(member);
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            } else if (input.equals("3")) {
                System.out.println("회원 목록조회 서비스입니다.");
                List<Member> memberList = memberService.findAll();
                if (memberList.size() == 0) {
                    System.out.println("회원목록이 없습니다.");
                } else {
                    memberList.forEach(a -> System.out.println("회원목록 : " + a));
                }
            } else {
                System.out.println("로그인 서비스입니다.");
                System.out.println("email을 입력해주세요.");
                String email = sc.nextLine();
                System.out.println("비밀번호를 입력해주세요.");
                String password = sc.nextLine();
                //TODO 예외처리 : 예외 발생 시, 예외의 원인 출력
                try {
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (IllegalArgumentException e) { // 추후에 상태코드를 분기하기 위해서는 그냥 catch도 분기처리하는게 권고됨(접어서 쓰는건 Runtime으로 던지는거랑 동일함) - IllegalArgumentException:400, NoSuchElementException:404
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
            System.out.println("==================");
        }
    }
}
