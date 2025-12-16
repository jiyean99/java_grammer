package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class C03Class {
    public static void main(String[] args) {
        ///* ************ 클래스 개요 ************ *///
        // 여러 메서드와 변수들을 포괄(단편적인 정의)
        // 객체를 위한 설계도 ⭐(대부분 클래스의 목적)
        // 클래스와 객체의 비교:
        // - 클래스 : 객체를 정의하는 틀 또는 설계도와 같은 역할
        // - 인스턴스(객체) : 클래스로부터 만들어진 구체화된 형태의 자료형

        ///* ************ 클래스의 구성 요소 ************ *///
        // - 필드(field)=변수
        // - 메서드 : 1) 클래스 메서드, 2) 객체 메서드


        ///* ************ 클래스 메서드 기본 호출 방식 ************ *///
        int sum_result = Calculator.sum(10, 20);
        System.out.println("Calculator 10 + 20 ===" + sum_result);

        ///* ************ 클래스 메서드 사용의 문제점 ************ *///
        // 즉, 객체를 써야만 하는 이유(객체가 아닌 클래스로만 작업하면 안되는 이유)

        // A부서 매출:
        // 1월 : 20원 매출 발생
        Calculator.sumAcc(20);
        System.out.println("A부서 1월까지의 매출 누적액 ===" + Calculator.total); //20
        // 2월 : 30원 매출 발생
        Calculator.sumAcc(30);
        System.out.println("A부서 2월까지의 매출 누적액 ===" + Calculator.total); //40
        // 3월 : 40원 매출 발생
        System.out.println("A부서 3월까지의 매출 누적액 ===" + Calculator.sumAcc(40)); // 메서드 자체가 total를 return 해주기 때문에 이와 같은 코드도 가능
        // 누적매출 : 90원

        // B부서 매출:
        // 1월 : 10원 매출 발생
        Calculator.sumAcc(10);
        System.out.println("B부서 1월까지의 매출 누적액 ===" + Calculator.total); // 10 -> A와 누적되어 100이 출력됨
        // 2월 : 30원 매출 발생
        Calculator.sumAcc(30);
        System.out.println("B부서 2월까지의 매출 누적액 ===" + Calculator.total); // 40 -> A와 누적되어 130이 출력됨
        // 3월 : 20원 매출 발생
        System.out.println("B부서 3월까지의 매출 누적액 ===" + Calculator.sumAcc(20));
        // 누적매출 : 60원 -> A와 누적되어 150이 출력됨

        //📍 즉, 고유의 변수, 고유의 메서드 사용이 불가

        ///* ************ 문제점 개선 ************ *///
        // 객체를 활용한 부서별 월매출 누적 계산
        //📍 객체 생성 방법 : 클래스명 객체명 = new 클래스명();
        // A부서 매출:
        // 1월 : 20원 매출 발생
        // 2월 : 30원 매출 발생
        // 3월 : 40원 매출 발생
        CalculatorForInstance calA = new CalculatorForInstance();
        calA.sumAcc(20);
        calA.sumAcc(30);
        calA.sumAcc(40);
        System.out.println("A부서 매출 누적액 ===" +calA.total); // calA라는 고유의 힙메모리 공간에 total값들이 누적됨

        // B부서 매출:
        // 1월 : 10원 매출 발생
        // 2월 : 30원 매출 발생
        // 3월 : 20원 매출 발생
        // 누적매출 : 60원
        CalculatorForInstance calB = new CalculatorForInstance();
        calB.sumAcc(10);
        calB.sumAcc(30);
        calB.sumAcc(20);
        System.out.println("B부서 매출 누적액 ===" +calB.total); // calB라는 고유의 힙메모리 공간에 total값들이 누적됨

        ///* ************ 클래스 메서드 vs 객체 메서드 ************ *///
        // - 클래스 메서드 : static이 붙어 있는 클래스 내의 메서드, 객체 상태와 무관한 도우미 함수(utility method)를 목적으로 주로 사용
        // - 객체 메서드 : static이 붙어있지 않은 클래스 내의 메서드
        // - 지속적으로 사용하는가? 자신만의 고유한 공간이 필요한가? 등을 판단하여 사용
        // - 대부분 객체 메서드를 사용함

        ///* ************ 클래스 메서드 사용 예시 ************ *///
        System.out.println(Math.min(10,20));

        ///* ************ 객체 메서드 사용 예시 ************ *///
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        System.out.println(myList);
    }
}

// 한 파일 내 여러 클래스 선언 가능 (public은 단 하나만 선언 가능)
class Calculator {
    //📍 변수 선언 종류 : 1)클래스변수(static O), 2)객체 변수(static X)
    // 객체변수를 만드는 순간 고유의 공간이 계속해서 생성된다(힙메모리 내). 즉, 객체 생성 시 자신만의 고유한 공간(메모리)를 사용하는 것
    // 이 때 static을 안붙이면 변수의 값을 변경하면 계속 덮어쓰기가 되는 것
    static int total = 0; // 클래스에 종속되어있는 클래스 변수

    // 덧셈
    public static int sum(int a, int b) {
        return a + b;
    }

    // 누적 덧셈
    public static int sumAcc(int a) {
        total += a;
        return total;
    }
}

/// * ************ 객체를 위한 클래스 생성(동일한 기능) ************ *///
class CalculatorForInstance {
    int total = 0;

    //📍 메서드에 static이 있는 경우는 클래스 메서드
    // 클래스 메서드 호출 방법 : 클래스명.메서드명();
    // sum 메서드는 연산해서 뱉어내는거지, 메모리에 저장하는 형태가 아니기 때문에 static을 붙여줘도 됨
    // 즉, 클래스 메서드는 일반적으로 객체에 상태와 상관없는 독립적인 로직 수행시에 사용
    static public int sum(int a, int b) {
        return a + b;
    }

    //📍 메서드에 static이 없는 경우는 객체 메서드
    // 객체 메서드 호출 방법 : 객체명.메서드명();
    public int sumAcc(int total) {
        //📍 this.는 객체 자기 자신을(객체를) 지칭함(e.g. calA, calB 등)
        // 일반적으로, 매개변수와 객체변수 이름을 구분짓기 위해 사용.(관례적으로 사용하므로 그냥 습관적으로 붙이셈)
        this.total += total;
        return this.total;
    }
}