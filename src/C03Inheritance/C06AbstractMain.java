package C03Inheritance;

import java.util.ArrayList;
import java.util.List;

public class C06AbstractMain {
    public static void main(String[] args) {
        /// * ************ 추상클래스(abstract)의 객체 생성 ************ *///
        // 추상클래스는 구현체가 없는 메서드가 있으므로, 기본적으로 객체 생성 불가능
        //AbstractAnimal a1 = new AbstractAnimal();
        /* 아래 구조는 객체가 아님 나중에 다룰 내용
        AbstractAnimal a1 = new AbstractAnimal() {
            @Override
            void makeSound2() {

            }
        }
        */
        AbstractDog d1 = new AbstractDog();
        d1.makeSound();
        d1.makeSound2();
        AbstractAnimal d0 = new AbstractDog(); // 이런 구조도 가능

        //📍 인터페이스 :
        // - 모든 메서드가 abstract인 클래스 <-> abstract클래스는 자신의 구현체도 있고, abstract 메서드도 있음
        // - 구현체가 없으므로, 별도의 객체 생성 불가
        List<Integer> myList = new ArrayList<>();
        //List<Integer> myList = new List<>(); // 구현체가 없으므로 객체생성 불가


    }
}

/// * ************ 추상클래스(abstract) ************ *///
// 반드시 상속을 가정하고 만드는 클래스
// 즉 자식에서 ... 껍데기만 있는 것
// 왜 이런식의 클래스를 만들었을까?
abstract class AbstractAnimal {
    void makeSound() {
        System.out.println("동물은 소리를 냅니다.");
    }

    /// * ************ 추상메서드(abstract) ************ *///
    // - 추상메서드(abstract)를 하나라도 갖고잇다면, 클래스는 추상클래스가 되며 마찬가지로 abstract 키워드 구현 필요
    // - abstract메서드는 메서드를 선언만 하고, 구현이 없는 메서드이다.
    // - 해당 클래스를 상속받는 클래스에서 abstract 구현
    abstract void makeSound2();
}

// - 추상클래스 내 추상메서드를 직접 구현하라는 에러가 발생할 것(오버라이드)
class AbstractDog extends AbstractAnimal {
    // 구현되지 않은 makeSound2를 구현.(오버라이딩)
    @Override
    void makeSound2() {
        System.out.println("멍!!멍!!");
    }
}

/// * ************ final 클래스 ************ *///
// final 키워드를 통해 상속 불가한 클래스로 변경
final class FinalParents{

}
// class Test extends FinalParents {} // 상속 불가!
