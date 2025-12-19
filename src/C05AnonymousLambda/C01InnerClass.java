package C05AnonymousLambda;

///* ************ 내부클래스 ************ *///
// - 클래스 안에 클래스
// - 종류: 1) static 내부 클래스, 2) 익명 내부 클래스
public class C01InnerClass {
    public static void main(String[] args) {
        ///* ************ static 내부클래스를 활용한 객체 생성 ************ *///
        Member.MemberInner m1 = new Member.MemberInner(20);
        System.out.println(m1.getB());
    }
}
class Member{
    private int a;

    public int getA(){
        return this.a;
    }

    //생성자
    public Member(int a) {
        this.a = a;
    }

    ///* ************ static 내부클래스 ************ *///
    // - 마치 Member의 static 변수처럼 활용
    static class MemberInner{
        private int b;
        public int getB(){
            return b;
        }

        //생성자
        public MemberInner(int b) {
            this.b = b;
        }
    }
}