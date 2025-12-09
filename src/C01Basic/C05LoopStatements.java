package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C05LoopStatements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        /* ************ while문 ************ */
//        // while문의 조건식에 변화를 주지 않으면, while문은 기본적으로 무한루프를 지향
//        int a = 0;
//        // 아래 while문은 10번 반복되는 반복문
//        while (a < 10) {
//            System.out.println("hello world" + a);
//            a = a + 1;
//        }
//        // while문을 활용하여 2~10까지 출력
//        int b = 2;
//        while (b < 11) {
//            System.out.println(b);
//            b++;
//        }

//        // break 키워드를 통해 가장 가까이에 있는 반복문을 즉시 종료
//        int c = 2;
//        while (true) {
//            System.out.println(c);
//            c++;
//            if (c > 10) break;
//        }

//        // 반복되는 도어락키 예제
//        // 만약 비밀번호를 맞추면 "문이 열렸습니다"출력 후 즉시 종료,
//        // 5회 입력을 초과할 때 까지 맞추지 못하면 "비밀번호 5회 초과" 출력 후 종료
//        int count = 0;
//        while (true) {
//            String answer = "1234";
//            String answerInput = br.readLine();
//            if (answerInput.equals(answer)) {
//                System.out.println("문이 열렸습니다.");
//                break;
//            } else {
//                System.out.println("비밀번호가 틀렸습니다.");
//            }
//            count++;
//            if (count == 5) {
//                System.out.println("비밀번호 횟수를 초과하였습니다.");
//                break;
//            }
//        }

//        // 구구단 예제 : 입력한 숫자의 구구단 단수 출력
//        // ex) 2 입력 -> 2X1=2 \n 2X2=4 \n 2X3=6... \n 2X9=18, 입력은 무한으로 계속 받도록
//        while (true) {
//            int input = Integer.parseInt(br.readLine());
//            int n = 1;
//            while (n < 10) {
//                System.out.println(input + "X" + n + "=" + input * n);
//                n++;
//            }
//        }

//        /* ************ do/while문 : 무조건 한번은 실행되는 while문 ************ */
//        int a = 100;
//        do {
//            System.out.println("hello world");
//        }
//        while (a < 10); // 참이 아니지만 일단 한번은 실행됨!

        /* ************ for문 : 초기식, 조건식, 증감식이 모두 포함돼 있는 반복문 ************ */
        for (int i = 0; i < 10; i++) {
            System.out.println("hello wolrd");
        }

        // 1~10중 홀수만 출력하기
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        // continue : 반복문의 증감, 조건식으로 이동하는 명령어. 즉, continue 하위의 코드를 더이상 실행하지 않는다
        // 코드의 직관성과 가독성을 위해 사용
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
