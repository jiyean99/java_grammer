package C03Inheritance.Protected;

import C03Inheritance.C04ProtectedClass;

public class C05ProtectedTest extends C04ProtectedClass{
    public static void main(String[] args) {
        C05ProtectedTest c1 = new C05ProtectedTest();

        System.out.println(c1.st1); // public
        //System.out.println(c1.st2); // private (접근 불가)
        //System.out.println(c1.st3); // default (접근 불가)
        System.out.println(c1.st4); // protected (다른패키지일지라도, extends를 통해 접근 가능)
    }
}
