package C02MethodClass;

/// * ************ 변수의 유효 범위 ************ *///
// 클래스 변수와 객체 변수는 클래스 전역에서 사용 가능, 지역변수는 해당 메서드 내에서만 사용 가능

public class C05Scope {
    /// * ************ 클래스 변수 vs 스테틱 변수 ************ *///
    //📍 클래스 변수
    static int v1 = 10; // 유효범위에 있기때문에 main에서 사용 가능
    //📍 객체 변수 : 객체 메서드에서만 접근 가능
    int v2 = 20; // 범위의 문제가 아니고, 객체변수라서 main에서 사용 불가

    public static void main(String[] args) {
        /// * ************ call by value ************ *///
        //📍 지역 변수 : 지역 변수는 해당 메서드 내에서만 사용 가능
        int v3 = 10;
        scope1(v3);
        System.out.println(v3); // 10으로 출력 (main메서드의 v3와 scope1메서드의 v3는 각각 서로 다른 유효범위에 있음, 원시자료형 값 만을 던진것 뿐)

        /// * ************ call by reference ************ *///
        C04Person2 p1 = new C04Person2();
        p1.setName("kim");
        p1.setEmail("kim@naver.com");
        p1.setAge(15);
        scope2(p1);
        System.out.println(p1.returnPersonInfo()); // lee(원본을 주고받았기 때문에)
    }

    //📍 call by value : 값을 통한 호출, 값만을 전달
    public static void scope1(int v3) {
        v3 = 30; // 파라미터로 넘겨받은 값은 10인데 30으로 변경함
        System.out.println(v3); // 30으로 출력
    }

    //📍 call by reference : 참조에 의한 호출. 즉, 힙 메모리 주소값 전달
    public static void scope2(C04Person2 person) {
        person.setName("lee"); // 원본 메모리 주소로 접근해서 원본의 값을 변경하였음
        System.out.println(person.returnPersonInfo()); // lee
    }
}
