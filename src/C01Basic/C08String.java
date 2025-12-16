package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class C08String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ///* ************ String 선언 방법 2가지 ************ *///
        // (1) 객체 선언 방식
        String st1 = new String("Hello world");
        String st2 = new String("Hello world");
        // st1과 st2의 원본은 String 클래스로 같지만, 똑같은 객체라고는 볼 수 없다(저장된 위치가 다름) 즉, equal 관계 성립 X

        // (2) 리터럴 방식 : String pool을 사용하는 방식(java에서 추천하는 방식)
        String st3 = "Hello world";
        String st4 = "Hello world";
        System.out.println(st1 == st2); // false
        System.out.println(st3 == st4); // true
        System.out.println(st1 == st3); // false

        // 단, 참조자료형의 비교는 == 사용 지양
        System.out.println(st1.equals(st3)); // true


        ///* ************ String 주요 메서드 ************ *///
        //📍 .equals() : 힙 메모리의 문자열을 가져와서 equal 관계 비교
        String st_1 = "hello1";
        String st_2 = "Hello1";
        System.out.println(st_1.equals(st_2)); // false
        System.out.println(st_1.equalsIgnoreCase(st_2)); // true

        //📍 .length() : 문자열의 길이 출력
        String st__1 = "hello1 world1 java1";
        System.out.println(st__1.length()); // 19

        //📍 .charAt(n) : 특정 index의 문자(char)값을 리턴
        char ch1 = st__1.charAt(7);
        System.out.println(ch1); // w

        //📍 .toCharArray() : String 문자열을 char배열로 변환(향상된for문 활용 용이)
        char[] charArr = st__1.toCharArray();
        System.out.println(charArr);

        //📍 .indexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
        String st___1 = "hello java java";
        System.out.println(st___1.indexOf("java")); // 6

        //📍 .lastIndexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 나중에 나오는 문자열의 위치 반환.
        System.out.println(st___1.lastIndexOf("java")); // 11

        //📍 .contains(문자열) : 특정 문자열이 포함되어 있는지 확인
        System.out.println(st___1.contains("java")); // true
        System.out.println(st___1.contains("javascript")); // false

        // 위 메서드들은 복잡도가 o(n)의 검색 속도를 가짐, 성능이 그다지 좋지는 않음

        //📍 += : 문자열 더하기. 성능 측면에서는 추후 배울 StringBuffer, StringBuilder 사용
        String st____1 = "hello";
        st____1 += " world";
        st____1 += '1'; // String에 char를 더하면 String으로 자동 변환
        st____1 += 0; // String에 int를 더하면 String으로 자동 변환
        System.out.println(st____1);

        // 여러 번 println()을 호출하는 것보다 문자열을 합쳐 한 번에 출력하는 방식이 더 효율적이다.
        // 이때 단순히 String을 +=로 이어붙이는 것보다 StringBuilder나 StringBuffer를 사용하는 편이 훨씬 빠르다.
        //
        // 이유:
        // println()은 콘솔이라는 I/O(입출력 장치)와의 통신을 거쳐야 하므로 상대적으로 느리다.
        // 반면, StringBuilder나 StringBuffer는 메모리 상에서 문자열을 임시로 모아둔 뒤
        // 한 번에 출력(=버퍼링)하기 때문에 불필요한 I/O 호출이 줄어든다.
        //
        // 참고:
        // 1. println() 여러 번 호출 → I/O 연산이 반복되어 느림
        // 2. String += 결합 → 객체가 매번 새로 생성되어 비효율적
        // 3. StringBuilder / StringBuffer / BufferedWriter 등 사용 → 메모리 내에서 처리 후 한 번에 출력 → 가장 효율적
        //
        // 참고로 StringBuilder가 일반적으로 가장 빠르지만, 상황과 코드 스타일에 따라 선택하면 된다.


        //📍 .substring(a,b) : a 이상 b 미만의 index의 문자를 잘라 문자열로 반환
        String st_____1 = "hello world";
        System.out.println(st_____1.substring(0, 5)); // hello
        System.out.println(st_____1.substring(6, st_____1.length())); // world

        //📍 .trim(), .strip() : 문자열 양쪽 끝의 공백 제거
        String st______1 = " hello world   ";
        String st__2 = st______1.trim();
        String st__3 = st______1.strip();
        System.out.println(st__2); // hello world(양끝 공백 X)
        System.out.println(st__3); // hello world(양끝 공백 X)

        //📍 .toUpperCase(), .toLowerCase(): 모든 문자열을 대문자/소문자로 변환 (원본값을 변경하는건 아님, 불변객체 <-> 스택, 큐는 원본값을 변동, 가변객체)
        String st_______1 = "Hello";
        System.out.println(st_______1.toUpperCase()); // HELLO
        System.out.println(st_______1.toLowerCase()); // hello

        //📍 .replace(a,b) : a문자열을 b문자열로 대체
        String st________1 = "hello world world";
        String st___2 = st________1.replace("world", "java");
        System.out.println(st___2);

        //📍 .replaceAll(a,b) : replace와 사용법 동일, 정규표현식을 사용할 수 있는 점이 다름
        // 정규표현식에 사용되는 메타문자 (^는 시작, $는 끝을 알림)
        // 1. 한글 : "[가-힣]"
        // 2. 소문자 영어 : "[a-z]"
        // 3. 대문자 영어 : "[A-Z]"
        // 4. 알파벳 : "[A-Za-z]"
        // 5. 공백 : "\\s+"
        String st_________1 = "01abC123  한글123";
        String st____2 = st_________1.replaceAll("[가-힣]", "");
        System.out.println("한글 제거 : "+st____2); // 01abC123  123
        String st____3 = st_________1.replaceAll("[a-z]", "");
        System.out.println("소문자 알파벳 제거 : "+st____3); // 01C123  한글123
        String st____4 = st_________1.replaceAll("[A-Z]", "");
        System.out.println("대문자 알파벳 제거 : "+st____4); // 01ab123  한글123
        String st____5 = st_________1.replaceAll("[A-Za-z]", "");
        System.out.println("알파벳 제거 : "+st____5); // 01123  한글123
        String st____6 = st_________1.replaceAll("\\s+", "");
        System.out.println("공백 제거 : "+st____6); // 01abC123한글123

        //📍 .split() : 특정 문자를 기준으로 잘라서 문자 배열로 만드는 것
        String a = "a:b:c:d";
        String[] arr1 = a.split(":"); // [a, b, c, d]
        System.out.println(Arrays.toString(arr1));

        String b = "a b c  d";
        String[] arr2 = b.split(" ");
        System.out.println(Arrays.toString(arr2)); // [a, b, c, , d]
        System.out.println(arr2.length); // 5(빈 문자열로 자르게 되는 것)
        String[] arr3 = b.split("\\s+");
        System.out.println(Arrays.toString(arr3)); // [a, b, c, d]

        //📍 null과 공백의 차이
        // 사용자 입력값 검증 시 아래의 세가지의 차이점을 알아야함
        String case1 = null; // null은 문자열 아님
        String case2 = ""; // 빈 문자열은 문자열
        String case3 = " "; // 공백
        System.out.println("null과 빈문자열 비교 : " + case1 == case2); // false
        System.out.println("null 체크 : " + case1 == null); // true
//        System.out.println(case1.isEmpty()); // error : NullPointerException
        System.out.println("빈 문자열의 빈문자열 체크 : " + case2.isEmpty()); // true
        System.out.println("공백의 빈문자열 체크 : " + case3.isEmpty()); // false(공백이 차있는 것)
        System.out.println("빈문자열의 빈문자열 체크 : " + case3.isBlank()); // true


        ///* ************ 문자열 조립 : StringBuffer ************ *///
        //📍 .append(), .insert(), .substring(), String의 주요 메서드 들 사용 가능
        String [] arr = {"java", "python", "javascript"};
        StringBuffer sb = new StringBuffer();
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append("\s"); // \n은 줄바꿈 의미
        }
        sb.insert(0, "C++" + "\s"); // 문자열 중간에 insert하는것은 성능 저하를 발생시키므로 사용 지양
        sb.deleteCharAt(0); // 마지막 index를 삭제하는 것 외에는 성능 저하 발생시키므로 사용 지양
        // cf) 대부분의 자료구조는(큐제외) 마치 값들이 배열처럼 저장되어 값들의 중간에 삽입/삭제를 하게 되면 index가 새롭게 세팅되므로 성능저하를 발생시킴
        sb.deleteCharAt(sb.length()-1); // 마지막 index만 삭제
        result = sb.toString();
        System.out.println(result);

        ///* ************ 문자열 조립 : StringBuilder ************ *///
        //📍 .append(), .insert(), .substring(), String의 주요 메서드 들 사용 가능
        //📍 성능이 뛰어나지만, 동시성 문제가 있음(Thread-Safe 하지 않음)
        // ex) 쓰레드 A가 append("hello")하고, 쓰레드 B가 append("world") 할 때 동시에 같은 변수를 사용해야 하는데
        //     두 작업이 중간에 섞여 "heworldllo" 이런식으로 잘못된 값을 만들 수 있음
        // 성능이 뛰어난 이유는? Thread-Safe하려면 A 입력시 B를 막아야함 -> 성능이 떨어지게 됨(사실 실전에선 그냥 buffer 쓰면 됨)

        ///* ************ 문자열 비교 ************ *///
        // 아스키코드가 큰 문자(뒤에 있는 문자)를 빼면 음수가 나옴. 즉 compareTo 메서드 사용 시 양수/음수/0 비교
        // 문자열 정렬 시 유용하게 사용되는 메서드라 중요함
        // 오름차순 정렬시 st1 vs st2 뭐가 먼저 나올까? 2가 먼저 나옴!(2가 더 작은값)
        String st___________1 = "hello";
        String st___________2 = "dello";
        String st___________3 = "hello";
        String st___________4 = "hfllo";

        System.out.println("compareTo 1->2 : "+st___________1.compareTo(st___________2)); //4
        System.out.println("compareTo 2->1 : "+st___________2.compareTo(st___________1)); //-4
        System.out.println("compareTo 1->3 : "+st___________1.compareTo(st___________3)); //0
        System.out.println("compareTo 4->3 : "+st___________4.compareTo(st___________3)); //1



        // [📝실습예제]
        // 요구사항 : 문자열을 뒤집기
        // 반목문 사용
        StringBuilder sb_1 = new StringBuilder();
        String st__________1 = "hello";
        for (int i = st__________1.length()-1; i >= 0 ; i--) {
            sb_1.append(st__________1.charAt(i));
        }
        System.out.println(sb_1);
        // reverse 메서드 사용
        StringBuilder sb_2 = new StringBuilder(st__________1);
        sb_2.reverse();
        System.out.println(sb_2);


        // [📝실습예제]
        // 요구사항: st__1 문자열에서 a의 개수가 몇개인지 출력해라
        // (1) 기본 풀이
/*        int countA = 0;
        for (int i = 0; i < st__1.length(); i++) {
            boolean isA = st__1.charAt(i) == 'a';
            if (isA) {
                countA++;
            }
        }
        System.out.println("st__1에서 a의 개수: " + countA);*/
        // (2) 향상된 for문 풀이 -> st__1에 있는 문자열 하나하나를 뽑아 char 배열 형태로 만들거임
/*        int countA = 0;
        for (char ch : st__1.toCharArray()) {
            boolean isA = ch == 'a';
            if (isA) {
                countA++;
            }
        }
        System.out.println("st__1에서 a의 개수: " + countA);*/

        // [📝실습예제] : 프로그래머스 - 나머지 구하기(플랫폼 사용법을 위한 풀이)
        // [📝실습예제] : 프로그래머스 - 특정 문자 제거하기
        class Solution120826 {
            public String solution(String my_string, String letter) {
                String answer = "";
                // 기본 풀이법
                for (int i = 0; i < my_string.length(); i++) {
                    if (my_string.charAt(i) != letter.charAt(0)) {
                        answer += my_string.charAt(i);
                    }
                }

                // 향상된 for 문 풀이법
                // for(char ch : my_string.toCharArray()){
                //     if(ch != letter.charAt(0)){
                //         answer += ch;
                //     }
                // }

                return answer;
            }
        }

        // [📝실습예제] : 프로그래머스 - 가운데 글자 가져오기
        class Solution12903 {
            public String solution(String s) {
                String answer = "";
                if (s.length() % 2 == 0) {
                    answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
                } else {
                    answer += s.substring(s.length() / 2, s.length() / 2 + 1);
                }
                return answer;
            }
        }

        // [📝실습예제]
        // 요구사항 : 전화번호 검증
        System.out.println("전화번호를 입력하시오. 형식 : 010-XXXX-XXXX");
        String number = br.readLine();
        boolean numCheck = number.matches("^\\d{3}-\\d{4}-\\d{4}$");
        if(numCheck){
            System.out.println("올바르게 입력되었습니다.");
        }else {
            System.out.println("전화번호 형식이 올바르지 않습니다.");
        }

        // [📝실습예제]
        // 요구사항 : 이메일 검증
        System.out.println("이메일주소를 입력하시오. 형식 : 영문숫자@영문숫자.com");
        String email = br.readLine();
        boolean emailCheck = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
        if(emailCheck){
            System.out.println("올바르게 입력되었습니다.");
        }else {
            System.out.println("이메일 형식이 올바르지 않습니다.");
        }

        // [📝실습예제]
        // 요구사항: 공백의 개수 세기
        String blankString = "hello     world    java";
        int blankTotal = 0;
        for (int i = 0; i < blankString.length(); i++) {
            if(blankString.substring(i, i+1).isBlank() ){
                blankTotal++;
            }
        }
        System.out.println(blankTotal); // 9

        // [📝실습예제] : 프로그래머스 - 문자열밀기
        class Solution120921 {
            public int solution(String A, String B) {
                StringBuilder sb = new StringBuilder(A);
                if (A.equals(B)) {
                    return 0;
                }
                for (int i = 0; i < sb.length(); i++) {
                    sb.insert(0, sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);

                    if (sb.toString().equals(B)) {
                        return i+1;
                    }
                }
                return -1;
            }
        }
    }

}
