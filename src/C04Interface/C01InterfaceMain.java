package C04Interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C01InterfaceMain {
    public static void main(String[] args) {
        // - 구조 : 클래스명 객체명 = new 클래스명();
        C01Cat c1 = new C01Cat();
        c1.makeSound();

        C01Dog d1 = new C01Dog();
        d1.makeSound();

        /// * ************ 인터페이스(interface) ************ *///
        // - 모든 메서드가 구현부가 없는 abstract 메서드(선언부만 존재)
        // - 구조 : 인터페이스명 객체명 = new 클래스명();
        // - 특징
        //   1. 다형성 : 하나의 부모타입으로 여러 자식 객체를 다룰 수 있음.
        //   2. 다중구현(상속) 가능
        // 만약 C01AnimalInterface1가 인터페이스가 아니고 클래스였다면, 하위의 makeSound 메서드는 동일한 기능을 수행했을 것
        C01AnimalInterface1 c2 = new C01Cat();
        c2.makeSound();

        C01AnimalInterface1 d2 = new C01Dog();
        d2.makeSound();


        /// * ************ 인터페이스 특징 ************ *///
        //📍 다형성의 장점(왼쪽에 인터페이스를 사용했을 때의 장점)
        // - 기존의 구현체를 다른 구현체로 변경 시 용이함
        // (ArrayList <-> LinkedList)
        // 왼쪽에 List를 선언시에, List에서 선언된 메서드만을 쓰기 때문에 기존의 구현체를 다른 구현체로 바꿔도 에러가 발생하지 않음
        //List<Integer> myList = new ArrayList<>();
        List<Integer> myList = new LinkedList<>();
        myList.add(10);
        myList.add(20);
        myList.get(0);

        //📍 다중구현(상속)
        C01AnimalInterface1 c3 = new C01Cat();
        c3.makeSound();
        C01AnimalInterface2 c4 = new C01Cat();
        c4.eat("츄르");

        //📍 다중구현 예시 - List와 Queue
        List<Integer> myList1 = new LinkedList<>();
        //myList1.get(0); // get메서드 사용가능
        Queue<Integer> myList2 = new LinkedList<>();
        //myList2.get(0); // get메서드 사용불가
        // List의 자료구조라면 get을 쓰는것이 용이하나, Queue 자료구조는 get 메서드가 너무 비효율적이기 떄문에(복잡도) 위 형식으로 제한을 두는 것
        // 따라서 객체의 사용 목적에 따라 인터페이스

        // cf) LinkedList는 List와 Deque를 구현하고있다.
        // 이 때 Deque는 Queue를 상속받고있다.
        // 따라서 Queue를 인터페이스로 쓴 LinkedList 구조는 당연하게 가능해지는 것


    }
}
