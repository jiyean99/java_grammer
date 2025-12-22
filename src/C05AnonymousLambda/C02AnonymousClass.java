package C05AnonymousLambda;

/// * ************ 익명 내부클래스 ************ *///
// - Comparator 이해하려면 익명 내부클래스를 알아야함

public class C02AnonymousClass {
    public static void main(String[] args) {

        /// * ************ 익명 내부클래스 ************ *///
        // - AbstractAnimal을 상속한 클래스가 별도로 존재하지않고,
        //   익명 클래스가 만들어짐과 동시에 익명객체가 생성된 형태
        AbstractAnimal aa = new AbstractAnimal() {
            @Override
            void makeSound() {
                System.out.println("멍멍");
            }
        };

        aa.makeSound();
        aa.eat();


        // 구현체가 없는 추상클래스 또는 인터페이스는 익명객체로 생성
        // 이 때 a1은 클래스명이 없으므로 익명객체이다.
        Animal1 a1 = new Animal1() {
            @Override
            public void makeSound() {
                System.out.println("인터페이스 소리지롱");
            }

            @Override
            public void eat() {
                System.out.println("인터페이스 냠냠");
            }
        };

        /// * ************ 람다표현식 사용 ************ *///
        // - 인터페이스의 익명 객체에 구현해야할 메서드가 한개밖에 없을 때에는 람다 표현식(화살표함수) 사용 가능
        // - (): 이 곳에다가 메서드의 매개변수를 받아낼 수 있음
        Animal2 a2_1 = () -> {
            System.out.println("hello world1");
            System.out.println("hello world2");
        };
        a2_1.makeSound();

        // - 실행문이 한 줄 밖에 없을 때에는 중괄호 생략 가능
        Animal2 a2_2 = () -> System.out.println("hello world1");
        a2_2.makeSound();

        /// * ************ 매개변수가 잇는 익명객체의 람다함수 생성 ************ *///
        // - 기본구조
        Animal3 a3_1 = (a, b, c) -> {
            return a + "," + b + "," + c;
        };
        System.out.println(a3_1.makeSound("java", "c", "node"));

        // - 한줄실행 시 return을 제거한 형태
        Animal3 a3_2 = (a, b, c) -> a + "," + b + "," + c;

        // 실습:
        // Animal4 인터페이스 생성 및 makeSound 메서드 선언 : 매개변수는 String, String, int, 리턴타입은 String
        // 익명객체 생성 시 메서드 기능: 매개변수의 숫자값이 10 이상이면 a+b 리턴하고, 10 미만이면 a만 리턴
        Animal4 a4 = (n, a, b) -> {
            if (n >= 10) {
                return a + b;
            } else {
                return a;
            }
        };
        System.out.println(a4.makeSound(8, "강아지", "고양이"));
        System.out.println(a4.makeSound(12, "강아지", "고양이"));

    }
}

abstract class AbstractAnimal { // 당연히 객체로 못만듬(구현체가 없으므로) -> 상속해줘야지 가능(또 다른 방법도 있음)
    abstract void makeSound();

    void eat() {
        System.out.println("동물이 먹이를 먹습니다.");
    }
}

interface Animal1 {
    void makeSound();

    void eat();
}

interface Animal2 {
    void makeSound();
}

interface Animal3 {
    String makeSound(String a, String b, String c);
}

interface Animal4 {
    String makeSound(int n, String a, String b);
}