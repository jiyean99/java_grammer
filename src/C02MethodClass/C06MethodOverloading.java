package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

/// * ************ 메서드 오버로딩 ************ *///
// Java에서 같은 이름의 메서드 선언은 불가
// 단, 같은 이름의 메서드명을 사용하되, 매개변수의 개수 또는 매개변수의 타입이 달라지는 메스드 오버로딩은 허용.

/// * ************ cf) 메스드 오버로딩 ************ *///
// 메서드 오버라이딩이랑은 전혀 상관없음
public class C06MethodOverloading {
    public static void main(String[] args) {
        //📍 메서드 오버로딩 후 해당 메서드 호출
        // 파라미터를 인식하여 알아서 적절한 메서드를 호출해서 사용한다.
        System.out.println(sum(10, 20));
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10.5, 20.5));

        //📍 또 다른 메서드 오버로딩 사례
        // 1) println 메서드 안에 오버로딩이 되어있는 것(매우매우 많이!)
        System.out.println("hello");
        System.out.println(10);
        System.out.println(10.5);
        // 2) ArrayList의 add 메서드
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(0, 20);

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum(double a, double b) {
        return (int) (a + b);
    }
}
