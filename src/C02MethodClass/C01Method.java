package C02MethodClass;

public class C01Method {
    public static void main(String[] args) {
        ///* ************ 메서드의 개요 ************ *///
        // for문을 활용하여 1~10까지의 total 값을 구하여 출력하라
        int total1 = 0;
        for (int i = 0; i < 10; i++) {
            total1 += i;
        }
        System.out.println(total1);

        // for문을 활용하여 10~20까지의 total 값을 구하여 출력하라
        int total2 = 0;
        for (int i = 10; i < 20; i++) {
            total2 += i;
        }
        System.out.println(total2);

        // 위처럼 코드의 중복이 지속적으로 발생된다면,
        // 반복을 피하기 위해 코드의 기능을 모듈(메서드)화하여 별도로 분리 (프로그래밍의 기본적인 발전 양상)

        ///* ************ 메서드의 호출 ************ *///
        //📍 메서드 기본 호출 방식 : 1) 클래스명.메서드명(), 2) 객체명.메서드명()
        System.out.println(C01Method.getTotal(30,40));
        System.out.println(getTotal(10,20)); // 같은 클래스 내에서 정의된 클래스 메서드의 호출은 클래스명 생략 가능
        // 클래스는 객체를 찍어내는 설계 도안같은 것 (클래스 -> 객체1 객체2...) 각각의 객체의 고유 공간에서 작업을 수행함



    }

    // cf) 클래스에서 실행을 하면 반드시 main부터 실행한다 이 때 main에서는 getTotal을 호출하고, 이를 호출하기만 하면 원하는 기능 수행

    ///* ************ 메서드의 구성요소 ************ *///
    // - 접근제어자(public): 해당 메소드에 접근할 수 있는 범위를 명시, 접근 레벨 결정 (public → 프로젝트 전역)
    // - 클래스메서드(static O) || 객체메서드(static X)
    // - 반환타입(void, int, String, array 등)
    // - 매개변수(input값) : 매개변수 수와 타입 등은 개발자가 필요에 따라 지정
    public static int getTotal(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total+=i;
        }
        return total;
    }

    ///* ************ 메서드의 반환타입 ************ *///
    // - 입력값(O || X), 리턴값(O || X)

    ///* ************ return의 의미 ************ *///
    // - C02C02MethodPractice 시트 내 예시 코드 확인
    // - 리턴타입 void에서 return사용시 메소드 강제종료

}
