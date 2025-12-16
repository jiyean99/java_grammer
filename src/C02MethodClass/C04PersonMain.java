package C02MethodClass;

public class C04PersonMain {
    public static void main(String[] args) {
        // 회원가입 예시
        // 사용자가 입력한 이름, 이메일, pw를 서버에서 갖고 있어야 함(서버=java)
        // 이 때 어떻게 가지고 있을 수 있는가?

        /// * ************ 원시적인 방식(변수) ************ *///
        // 사용자1
        String name1 = "홍길동";
        String email1 = "hong@naver.com";
        int age1 = 30;
        PrintMember(name1, email1, age1); // 이름은 홍길동, 이메일은 hong@naver.com, 나이는 30세 입니 다.
        // 사용자2
        String name2 = "김땡땡";
        String email2 = "kim@naver.com";
        int age2 = 20;
        PrintMember(name2, email2, age2); // 이름은 김땡땡, 이메일은 kim@naver.com, 나이는 20세 입니다.
        //📍 위 코드의 문제점 : 요소(속성)들이 그룹화되어있지 않다보니, 중복과 코드의 가독성이 저하

        /// * ************ 클래스에 속성을 정의하여, 사람 객체로 생성 ************ *///
        C04Person1 p1 = new C04Person1();
        p1.name = "홍길동";
        p1.email = "hong@naver.com";
        p1.age = 30;
        // p1이라는 객체의 힙메모리 안에 위 데이터들이 함께 담기게 되는 것(그룹핑O, 가독성O)

        C04Person1 p2 = new C04Person1();
        p2.name = "김땡땡";
        p2.email = "kim@naver.com";
        p2.age = 20;

        // PrintMember(p1.name, p1.email, p1.age); -> 이 방식은 너무 복잡(귀찮)
        System.out.println("=== 최종 ===");
        PrintMemberForInstance(p1);
        PrintMemberForInstance(p2);
        // cf) 현재 "p1." 이렇게 접근이 가능한 이유는? 현재는 defualt로 설정되어있고, 이는 같은 패키지내에 있기 때문에 접근 가능
        //📍 위 설계 문제점 정리:
        // 1. person 객체의 변수에 외부 클래스에서 접근이 가능한 점(변수의 안정성을 헤치는 구조)
        // 2. person에 대한 출력 코드가 외부 클래스마다 중복되어 들어갈 여지가 있다는 점(각 클래스마다 매 번 동일한 메서드를 선언했다는 뜻)

        //📍 cf) 접근제어자 (사실 4개임, 추후에 다룰 예정)
        // 1. public : 해당 프로젝트 사용하는 곳 "어디에서나" 접근 가능
        // 2. default: "같은 패키지" 내에 속하는 것들끼린 접근 가능
        // 3. private : "같은 클래스" 내에 속하는 것들끼리만 접근 가능

        /// * ************ 클래스에 속성을 private로 접근제어자 설정 + 공통 메서드 생성 ************ *///
        C04Person2 p3 = new C04Person2();
        p3.setName("홍길동");
        p3.setEmail("hong@naver.com");
        p3.setAge(30);
        System.out.println("=== 최종 ===");
        PrintMemberForInstanceForPrivate(p3); // 공통 메서드 X
        System.out.println(p3.returnPersonInfo()); // 공통 메서드 O

    }

    // 사용자 정보 출력 메서드 (PrintMember)
    // 출력 요구사항 : 이름은 XX, 이메일은 YY, 나이는 ZZ입니다.
    public static void PrintMember(String name, String email, int age) {
        System.out.println("이름은 " + name + ", " + "이메일은 " + email + ", " + "나이는 " + age + "세 입니다.");
    }

    public static void PrintMemberForInstance(C04Person1 person) {
        System.out.println("이름은 " + person.name + ", " + "이메일은 " + person.email + ", " + "나이는 " + person.age + "세 입니다.");
    }

    public static void PrintMemberForInstanceForPrivate(C04Person2 person) { // 객체의 주소값이 매개변수로 전달
        System.out.println("이름은 " + person.getName() + ", " + "이메일은 " + person.getEmail() + ", " + "나이는 " + person.getAge() + "세 입니다.");
    }
}
