package C03Inheritance;

public class C02SuperKeyword extends SuperParents {
    int a = 20;

    public static void main(String[] args) {
        C02SuperKeyword c = new C02SuperKeyword();
        c.display(); // 20 출력 O
    }

    /// * ************ super 키워드 (super.메서드명 / super.변수명) ************ *///
    // - 자식클래스에서 부모클래스의 메서드나 변수를 접근할때 사용
    // - 일반적으로 자식클래스와 부모클래스가 같은 변수명이나 메서드명을 사용할때 활용
    public void display() {
        System.out.println("자식의 변수 a : " + this.a); // 만일 이 때 자식에 a가 없다면 그냥 super(부모)꺼를 쓰게 됨
        System.out.println("부모의 변수 a : " + super.a);
    }

    /// * ************ super() ************ *///
    //📍super() : 자식 클래스에서 부모 클래스의 생성자를 호출하는 메서드
    //📍this. : 나 자신의 생성자를 호출하는 메서드(초기화)
    public C02SuperKeyword(){
        super(10);
        this.a = 20;
    }
}

//📍 부모 클래스를 상속받을 때, 자식 객체의 생성자에서는 부모객체를 자동으로 생성.
// 자식 객체를 만들 때 부모객체를 만들게 되면, 부모 객체의 "기본 생성자"를 호출하게 되는 것
// 이 때, 부모 클래스에 기본생성자가 없으면 자식 클래스에서 에러 발생
class SuperParents {
    int a = 10;

    public SuperParents(int a) {
        this.a = a;
    }
}

