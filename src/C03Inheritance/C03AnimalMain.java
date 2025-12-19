package C03Inheritance;

import java.util.LinkedList;
import java.util.Queue;

/*
1.Animal 이름의 클래스 생성
	- void sound() 메서드: "동물이 소리를 냅니다" 출력
2. Dog 클래스
	- Animal 클래스 상속
	- soundDog() 메서드 : "멍멍멍멍"
3. Cat 클래스
    - Animal 클래스 상속
    - soundCat() 매서드 : "야옹야옹"
4. AnimalMain
    - Dog 객체 생성 후 메서드 호출
    - Cat 객체 생성 후 메서드 호출
*/
public class C03AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.dogSound();

        Cat cat = new Cat();
        dog.sound();
        cat.catSound();

        //📍 상속관계 일때는, 부모클래스의 타입을 자식클래스의 객체 타입으로 지정 가능
        // 단, 부모클래스의 타입으로 지정시, 부모 클래스에서 지정된 메서드만 객체에서 사용 가능(dogSound메서드는 사용 불가)
        Animal dog2 = new Dog();
        dog2.sound();
        //dog2.dogSound();

        // cf) Queue(인터페이스)를 통한 이해
        LinkedList<Integer> testQue2 = new LinkedList<>();
        Queue<Integer> testQue1 = new LinkedList<>();
        // Queue에 메서드 50개 있고, LinkedList에 100개가 잇으면 위 구조에서는 50개밖에 못쓰는 것
        // 왜 제한을 뒀을까? (get메서드 사용 예시)
        // testQue1.get(1); // 에러 발생
        // testQue2.get(1);
        // 큐로 쓰기에 비효율적인 경우 제한을 두게 되는 것(철학적인 이유)


    }
}

// 부모클래스
class Animal {
    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

// 자식클래스(1)
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍이가 소리를 냅니다.");
    }

    public void dogSound() {
        System.out.println("멍멍!멍멍!");
    }
}

// 자식클래스(2)
class Cat extends Animal {
    public void catSound() {
        System.out.println("야옹~야옹~");
    }
}
