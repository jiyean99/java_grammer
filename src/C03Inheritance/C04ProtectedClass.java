package C03Inheritance;

/// * ************ class 접근제어자 ************ *///
// - public
// - default
public class C04ProtectedClass {
    /// * ************ 변수, 메서드 접근제어자 ************ *///
    // - public : 프로젝트 전체에서 접근 가능(다른 패키지에서도 접근 가능)
    // - private : 클래스 내에서만 접근 가능
    // - default : 같은 패키지 내에서만 접근 가능
    // - protected : 다른 패키지이더라도, 상속관계인 경우 접근 가능
    // 접근 범위 : public > protected > default > private

    public String st1 = "hello java 1";
    private String st2 = "hello java 2";
    String st3 = "hello java 3";
    protected String st4 = "hello java 4";





}
