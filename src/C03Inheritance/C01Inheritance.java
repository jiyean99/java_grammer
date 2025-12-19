package C03Inheritance;

/// * ************ 상속 ************ *///
// - 부모의 변수와 메서드를 자식 클래스에서 물려받는 것.
// - extends 키워드 사용

/// * ************ 자식 클래스(child class) ************ *///
// extends 부모클래스 : 해당 키워드로 부모클래스의 기능을 그대로 물려받을수 있게 됨
// - 부모클래스를 상속하여 새롭게 작성되는 클래스
// - 부모 클래스에 새로운 필드, 메소드 를 하나 추가하면, 자식 클래스에도 자동으로 해당 필드가 추가된 것처럼 동작
public class C01Inheritance extends Parents {
    int b = 20;
    public static void main(String[] args) {
        C01Inheritance c1 = new C01Inheritance();
        //📍 부모클래스 변수 상속
        System.out.println(c1.a); // C01Inheritance 객체를 만들었는데 Parents를 상속받았기 때문에 a가 있게 되는 것
        System.out.println(c1.b);

        //📍 부모클래스 메서드 상속
        c1.m1(); // 사용가능하나 현재 오버라이딩 된 상태
        c1.m2();

        //📍 접근제어자 private : 사용 불가
        //c1.c;
    }
    //📍 자식 클래스에서의 오버라이딩(부모 매서드의 재정의)
    // - 부모 클래스의 메서드명과 자식 클래스의 메서드명이 동일한 경우 덮어쓰기 됨
    //📍 메서드 오버로딩 vs 메서드 오버라이딩
    // - 메서드 오버로딩: 메서드명이 같지만, 매개변수를 다르게 한 메서드 생성
    // - 메서드 오버라이딩: 부모 메서드를 자식이 재정의 (메소드의 파라미터(타입, 개수)도 동일)
    //📍 @Override 키워드
    // - 오버라이드된 메서드임을 명시적으로 표현하는 키워드(어노테이션), 성능 최적화를 위해 해당 키워드를 붙여주는것이 더 좋음
    // - 어노테이션 종류 : 수십개가 있는데 spring에서 중요하게 다룰 것(자바에선 ㄱㅊ)
    @Override
    public void m1(){
        System.out.println("자식 클래스의 m1입니다. 오버라이딩하였습니다.");
    }
    public void m2(){
        System.out.println("자식 클래스의 m2입니다.");
    }
}

/// * ************ 부모클래스(parent class) ************ *///
//  - 기존에 정의되어 있던 클래스
class Parents {
    //📍 접근제어자 default : 같은 패키지 내에서 사용 가능
    int a = 10;
    //📍 접근제어자 private : 클래스 내부에서만 사용 가능하므로, 자식 클래스에서도 접근 불가
    private int c = 30;
    public void m1(){
        System.out.println("부모 클래스 입니다.");
    }
}
