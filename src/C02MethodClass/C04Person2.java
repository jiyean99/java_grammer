package C02MethodClass;

public class C04Person2 {
    // 객체 변수는 일반적으로 변수의 안정성을 위해 private(클래스 내에서만 접근 가능한 접근제어자)으로 설정(예외 거의 X)
    private String name;
    private String email;
    private int age;

    // setter와 getter를 통해 외부에서 객체 변수에 접근 가능하도록 설정
    // setter, getter는 외부 접근이 가능하도록 일반적으로 public하게 설정
    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String returnPersonInfo() {
        return "이름은 " + this.name + ", " + "이메일은 " + this.email + ", " + "나이는 " + this.age + "세 입니다.";
    }

    //📍 객체 메서드들간의 호출은 문제없이 호출 가능
    public void testMethod1() {
        String temp = this.returnPersonInfo();
    }

    /*📍 클래스 메서드는 기본적으로 객체 생성을 가정하지 않으므로, 클래스 메서드 내에서 객체 메서드를 호출하는 것은 불가능(논리적 모순)
    public static void testMethod2(){
        String temp = this.returnPersonInfo();
    }
    // 위 코드는 객체를 안만든다는 가정하에 만들어진 메서드이다(클래스 메서드)
    // 따라서 this 개념이 들어가는 순간 논리적 모순 발생
    // 결론적으론 객체 메서드는 객체 메서드끼리 호출할 수 있다.
    */
}
