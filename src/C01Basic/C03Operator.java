package C01Basic;

import java.io.IOException;

public class C03Operator {
    public static void main(String[] args) throws IOException {
//        // /* ************ 산술연산자 : 사칙연산 ************ */
//        // *: 곱셈, /: 나눗셈(몫), %: 나머지
//        int n1 = 8;
//        int n2 = 3;
//        System.out.println("n1 * n2 = " + (n1 * n2));
//        System.out.println("n1 / n2 = " + (n1 / n2));
//        System.out.println("n1 % n2 = " + (n1 % n2));
//
//        // /* ************ 대입연산자 ************ */
//        // += -= *= /=
//        int n = 7;
//        n += 7;
//        n -= 7;
//        n *= 7;
//        n /= 7;
//        n %= 7;

//        int n1 = 7;
//        int n2 = 7;
//        int n3 = 7;
//        n1 = n1 - 3;
//        n2 -= 3;
//        n3 =- 3;
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);

//        // /* ************ 증감 연산자 ************ */
//        // @++ : 후위 증감연산자, 현재 라인에 명령문이 실행되고 나서 1증가
//        // ++@ : 전위 증감연산자, 현재 라인에 명령문이 실행되기전에 1증가
//        int a = 10;
//        a = a+1;
//        System.out.println(a); //11
//        a += 1;
//        System.out.println(a); //12
//        a++;
//        System.out.println(a); //13
//        ++a;
//        System.out.println(a); //14

//        int b = 5;
//        int c = b++;
//        System.out.println(c); //5
//        int d = ++b;
//        System.out.println(d); //7

//        // /* ************ 비교 연산자 ************ */
//        // ==, !=, >, >= 등
//        int n1 = 10;
//        int n2 = 20;
//        System.out.println(n1 == n2);
//        System.out.println(n1 != n2);
//        if (n1 > n2) {
//            System.out.println("n1은 n2보다 큽니다.");
//        }

//        // /* ************ 논리연산자 : &&, ||, ! ************ */
//        int n1 = 10;
//        int n2 = 20;
//        boolean b1 = !(n1 > 5 && n1 < 7);
//        System.out.println(b1);


        // /* ************ 비트 연산자 : 컴퓨터의 2진체계에서의 연산방식. &, |, ^ , << , >> ************ */
        // n1의 값을 왼쪽으로 1칸 옮긴다는 의미는 숫자값에 2로 1번 곱한다는 의미
        // n1 = 5  System.out.print ( n1<<1); : 10
        // n2의 값을 오른쪽으로 2칸 옮긴하는 의미는 해당 숫자값에 2로 2번 나눈다는의미
        // n2 = 4  System.out.print( n2 >> 2); //1
        int n1 = 5;
        int n2 = 4;
        System.out.println(n1&n2); //4
        System.out.println(n1|n2); //5
        // n1의 값을 왼쪽으로 한 칸 옮긴다는 의미는 해당 숫자값에 2로 한번 곱한다는 의미
        System.out.println(n1<<1); //10
        // n2의 값을 오른쪽으로 두 칸 옮긴다는 의미는 해당 숫자를 2로 두번 나눈다는 의미
        System.out.println(n2>>2); //1


    }
}