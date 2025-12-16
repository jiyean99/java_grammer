package C02MethodClass;

public class ClassExample {
    public static void main(String[] args) {
        ClassExample ts = new ClassExample();
        ts.test();

    }

    // test를 main 메서드에서 사용하려면, 객체를 만들어야함
    // 이 때 당연히 ClassExample 클래스를 기반으로 객체를 생성해야함
    // 아니면 static을 붙여야함.

    public int test(){
        return 0;
    }
}
