package C01Basic;

import java.math.BigDecimal;

public class C02Variable {
    public static void main(String[] args) {
//        /* ************ 변수의 명명규칙 ************ */
//        // 변수명 의미에 분절이 일어나는 경우에는 camelcase 또는 _ 사용
//        String myFirstName = "leejiyean";
//        String my_first_name = "leejiyean";
//
//        /* ************ 정수 : byte(1바이트), int(4바이트), long(8바이트) ************ */
//        // byte는 -128~127 범위의 숫자만 할당
//        byte a = 127;
//        byte b = -128;
//
//        // cf) 자료형이 표현할 수 없는 범위를 넘어선 경우 오버플로우/언더플로우 발생(런타임 과정에서 값이 틀어지는 현상)
//        a++; // 오버플로우 발생
//        System.out.println(a);
//        b--; // 언더플로우 발생
//        System.out.println(b);
//
//        long l1 = 10;
//        long l2 = 20L; // long은 명시적으로 "L"을 붙여 해당값이 long 타입임을 명시적으로 표현
//        System.out.println(l1+l2);

//        /* ************ 실수 : float, double ************ */
//        float f1 = 1.123F;
//        double d1 = 1.123;

//        // 실수 연산은 기본적으로 오차 발생: 소수점을 2진법으로 표현하는 부동소수점을 사용하기 때문
//        double d1 = 0.1;
//        System.out.println(d1); // 출력: 0.1, 미세한 오차는 소수점 절사를 통하여 당장에는 드러나지 않음
//
//        // 부동소수점 오차 테스트
//        double total = 0;
//        for(int i =0; i < 1000; i++){
//            total += 0.1;
//        }
//        System.out.println(total); //99가 되어야하는데 오차가 누적되어 99.9999xxxx등 오차가 발생하고있음
//
//        // 소수점 연산 오차 해결 방법 (1) : 소수를 정수로 변환 후 추후 나눗셈을 통해 값을 변환 (이 방법은 지양)
//        double total2 = 0;
//        for(int i =0; i < 1000; i++){
//            total2 += (0.1*10);
//        }
//        System.out.println(total2/10);

//        // 소수점 연산 오차 해결 방법 (2) : BigDecimal 클래스 사용
//        // 값을 입력받아 저장할 때 부터 문자로 입력 받아 오차 문제를 해결
//        double d1 = 1.03;
//        double d2 = 0.42;
//        System.out.println(d1 - d2); // 출력: 0.6100000000000001 (오차 발생중)
//        BigDecimal b1 = new BigDecimal("1.03");
//        BigDecimal b2 = new BigDecimal("0.42");
//        double result = b1.subtract(b2).doubleValue(); // result에 담는것(메모리) 역시 double이라 또 오차 발생 -> 연산 결과를 그냥 DB에 저장하는데 BigDecimal로 저장 시 DB에서 자동으로 decimal로 저장해줌(b1.subtract(b2)까지 저장)
//        System.out.println(result); // 출력: 0.61
//
//        /* ************ 문자형: char(1글자) vs String(1글자 이상) ************ */
//        char c1 = '가';
//        String st1 = "가";
//
//        // String 또는 char 배열 최초 선언 시 초기값이 null이 할당
//        char c2 = 0; // char의 초기값
//        String st2 = ""; // String의 초기값
//        String[] stArr = new String[10];
//        System.out.println(stArr[0]);

//        // cf) null은 값이 없다는 의미로서 하나의 타입
//        String st1 = ""; // 빈 문자열 할당
//        String st2 = null; // null 할당, st2는 더이상 string이 아님
//        System.out.println(st1.isEmpty()); // 출력: true
//        System.out.println(st2.isEmpty()); // 출력 X(NullPointerException 에러 발생), null을 대상으로는 isEmpty라는 매서드가 실행되지 않음

//        String[] stArr = new String[5];
//        stArr[1] = "hello1";
//        stArr[3] = "hello3";
//        for (int i =0; i<stArr.length; i++){
//            System.out.println(stArr[i].length()); // 출력 X(NullPointerException 에러) : stArr[0]는 null이므로 length 매서드 실행이 되지않음
//        }

//        /* ************ boolean : true or false ************ */
//        boolean b1 = true;
//
//        if (b1) {
//            System.out.println("참입니다.");
//        } else {
//            System.out.println("거짓입니다.");
//        }

//        /* ************ 타입변환(형변환) : (기본방향)작은 타입에서 큰 타입으로의 변환은 문제 없이 변환 ************ */
//        // int -> long
//        int i1 = 10;
//        long l1 = i1;
//        System.out.println(l1);
//
//        // int -> double
//        int i2 = 10;
//        double d2 = i2;
//        System.out.println(d2);
//
//        // double -> int : 기본적으로는 허용 불가. 명시적 형변환은 가능.
//        double d3 = 10.5;
//        int i3 = (int) d3;
//        System.out.println(i3);

//        // 관련 문제 풀이 : 0.25를 출력해라
//        // 정수/정수의 경우 소수점 절사 문제 발생
//        // 문제가 발생하는 이유 : 두 수가 모두 정수이면 결과값도 정수일 것이라고 java가 판단함
//        // 즉 a/b=(int)0.25가 되어 0으로 출력됨. 따라서 두 수 중 하나라도 double로 변환시키면 해결됨
//        int a = 1;
//        int b = 4;
//        System.out.println((double) a / b);

//        // char -> int : 문제없음(문자는 기본적으로 아스키코드로 숫자값을 갖고있기 때문에)
//        char c1 = 'a';
//        int i1 = (int)c1; // 명시적 타입변환(중복 형 변환 경고문 발생)
//        int i2 = c1;
//        System.out.println(i1);
//        System.out.println(i2);
//        // 예시 : 문자 비교를 위한 묵시적 타입 변환
//        System.out.println('a' > 'b');

//        // 관련 문제 풀이 : 알파벳 개수 세기
//        String st1 = "01aZFbcsdf한글123";
//        int count = 0;
//        for (int i = 0; i < st1.length(); i++) {
//            char ch = st1.charAt(i);
//            if ((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')) count++;
//        }
//        System.out.println(count);


        /* ************ 변수와 상수 ************ */
        // 변수: 재할당 가능, 재선언 불가능
        int a1 = 10;
        a1 = 20;
//        int a1 = 30; // 재선언 허용 X

        // 상수: 값의 재할당 불가능, 정해진 값(고정된 값) 사용 시 상수 활용
        final double PI = 3.141592;
//        PI = 3.15; // 재할당 허용 X

    }
}
