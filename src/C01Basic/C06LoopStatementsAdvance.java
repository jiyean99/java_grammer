package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C06LoopStatementsAdvance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        // 1~20까지의 수 중에 짝수의 총 합 출력
//        int sum = 0;
//        for (int i = 0; i < 21; i++) {
//            if (i % 2 == 0) {
//                sum += i;
//            }
//        }
//        System.out.println(sum);

//        // 두 수의 최대 공약수 찾기 24, 36 - 12
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//        int min = (a > b) ? b : a; // 또는 Math.min(a,b)
//        int answer = 0;
//        for (int i = 1; i < min + 1; i++) {
//            if (a % i == 0 && b % i == 0) {
//                answer = i;
//            }
//        }
//        for (int i = min; i > 0; i--) {
//            if (a % i == 0 && b % i == 0) {
//                answer = i;
//                break;
//            }
//        }
//        System.out.println(answer);

//        // 소수인지 여부 판별 : 소수란, 1과 자신을 제외한 숫자로 나누어 지지 않는 수.
//        int n = Integer.parseInt(br.readLine());
//        boolean isTrue = true;
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) {
//                isTrue = false;
//                break;
//            }
//        }
//        if (n == 1){
//            isTrue=false;
//        }
//        String result = isTrue ? "소수입니다." : "소수가 아닙니다.";
//        System.out.println(result);

//        int[] arr = {1, 3, 5, 7, 9};
//        // 일반 for문을 통한 배열 접근 방식
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

//        // 향상된 for문(Enhanced for문, for each문)을 통한 배열 접근 방식
//        for(int a : arr){
//            System.out.println(a);
//        }

//        // 일반 for문을 통한 배열의 값 변경
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] += 10;
//        }
//        // 참조형변수(객체타입)은 기본적으로 변수를 통한 출력시에 메모리값이 출력된다.
//        // 그래서 내장된 매서드를 통해 힙메모리안의 객체값을 출력
//        System.out.println(arr); // 메모리 자체의 주소값을 출력함(난수값, 힙메모리 주소값)
//        System.out.println(Arrays.toString(arr));
//
//        // 향상된 for문을 통한 배열의 값 변경 -> 원본의 값 변경 불가(이로인해 현대에서는 원본에 접근하지 않는 향상된 for문 방식을 조금 더 지향함)
//        for(int a : arr){
//            a+=10;
//        }

        /* ************ 자바 변수의 유효 범위 : {} ************ */
//        int num1 = 10;
//        if(true){
//            num1 = 20;
//            int num2 = 30;
//        }
//        // 하위 영역의 불록(줄괄호)에서 정의된 변수는 상위 블록에서는 접근 불가
//        num2 = 40;

//        // for문은 사용했던 변수명을 for문이 끝난 이후에 또 다른 for문에서 재선언이 가능
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        /* ************ 다중for문 ************ */
        // 2~9단까지 모든 구구단 한꺼번에 출력
        // 출력 예제: "@단 입니다" 출력 후 2X1=2 2X2=4 ... 2X9=18
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단 입니다.");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "X" + j + "=" + i * j);
            }
            System.out.println("=========================");
        }

        /* ************ 라벨문: 반복문에 이름을 붙이는 것 ************ */
        loop1:
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                // 원하는 for문을 라벨링을 통해 break 또는 continue 시킬 수 있음.
                if(true) break loop1;
            }
        }


    }
}
