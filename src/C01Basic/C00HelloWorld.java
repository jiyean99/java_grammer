package C01Basic;

// 클래스의 명명 규칙
// 1) 반드시 public class명과 파일명이 일치해야 함
// 2) 일반적으로 대문자 알파벳으로 시작
public class C00HelloWorld {
    // 1) main : java 파일 실행 시 실행의 시작점이자, 가장 먼저 실행되는 매서드
    // 2) public static : 어디에서든 접근 가능하고, 반환(리턴)값이 없는 매서드
    // 3) 매서드명, 변수명은 일반적으로 소문자 알파벳으로 시작
    public static void main(String[] args) {
        // println 단축어 : sout + tab
        System.out.println("hello world"); // 반드시 세미콜론으로 명령문 종료

        // 메서드를 호츨할때는 메서드명()를 통해 호출
        System.out.println(method2());

        // //는 컴파일 대상에서 제외처리하는 주석이다

        /*
        여러줄의 주석처리를 이와 같은 방법으로
        깔끔하게 주석처리하는 것도 가능
         */
    }

    // 직접 생성한 리턴값이 있는 매서드 예시
    public static int method2(){
        return 10;
    }
}
