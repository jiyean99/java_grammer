package C02MethodClass;

import java.util.Arrays;

public class C12RecursiveExample {
    public static void main(String[] args) {
        /// * ************ 재귀함수 대표적인 기본 예시 : 누적합계, 팩토리얼, 피보나치 수열 등 ************ *///
        // 사실 모두 재귀로 푸는것을 권고하지 않음(스택오버플로우 발생 위험도 있고, 성능 측면에서도 더 우수한 풀이법들이 있기 때문에), 동작 참고만 하셈

        /// * ************ 누적합계 ************ *///
        // 1~10까지 누적합계
        //📍 (1) for문 풀이
        int sumAcc = 0;
        for (int i = 1; i <= 10; i++) {
            sumAcc += i;
        }
        System.out.println(sumAcc);

        //📍 (1) 재귀함수 풀이
        int recSumAcc = sumAcc(0, 10);
        System.out.println(recSumAcc);

        /// * ************ 팩토리얼 ************ *///
        // 1~5까지 누적곱(팩토리얼)
        //📍 (1) for문 풀이
        int factorialByFor = 1;
        for (int i = 1; i <= 5; i++) {
            factorialByFor *= i;
        }
        System.out.println(factorialByFor);

        //📍 (2) 재귀함수 풀이
        System.out.println(factorial(5));

        /// * ************ 피보나치 수열 ************ *///
        // 1 1 2 3 5 8 13 21 34 ...
        // f(n) = f(n-1) + f(n-2)
        // 피보나치 수열의 10번째 값 구하기
        //📍 (1) 재귀 사용 X, for문 이용
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        for (int i = 2; i < 11; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        System.out.println(n3);

        //📍 (2) 재귀 사용 X, dp 이용
        // dp 알고리즘 : 기억하기-메모이제이션 알고리즘
        // 점화식 : f(n) = f(n-1) + f(n-2)
        // DP는 앞에서부터 하나씩 귀납적으로 채워나가는것이고, 재귀는 연역적으로 뒤에서부터 채워나간다고 생각하면 됨
        // 백준 1149 문제 참조
        int[] dp = new int[10]; // 0부터 9까지 이므로 10으로 배열의 크기를 잡음
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));

        //📍 (3) 재귀함수를 이용한 풀이법 -> 중복된 연산이 너무 많음, 단 코드는 매우 직관적이긴 함
        System.out.println(fibonacci(10));

    }

    public static int sumAcc(int start, int end) {
        if (start > end) {
            return 0;
        }
        return start + sumAcc(start + 1, end);

        /*
        워크플로우 예시 (start=1, end=10일 때):

        1. f(1,10) 호출 → 1 + f(2,10) 반환
        2. f(2,10) 호출 → 2 + f(3,10) 반환
        3. f(3,10) 호출 → 3 + f(4,10) 반환
        4. ... 계속 진행
        5. f(10,10) 호출 → 10 + f(11,10) 반환
        6. f(11,10) 호출 → start(11) > end(10)이므로 0 반환

        스택 언와인딩 (unwinding) 과정:
        f(10,10) = 10 + 0 = 10
        f(9,10) = 9 + 10 = 19
        f(8,10) = 8 + 19 = 27
        ...
        f(1,10) = 1 + 54 = 55 (1+2+...+10=55)

        즉, 재귀 호출 스택이 최하단(base case)까지 도달한 후
        순차적으로 값이 계산되며 올라오면서 누적합이 완성됨
        */
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
