package C06EtcClass;

public class C01Math {
    public static void main(String[] args) {
        /// * ************ Math 클래스의 메서드 ************ *///
        // 객체를 따로 만들필요가 없는 클래스 메서드(static)
        //📍 Math.random() : 임의의 수 반환, 0.0~1.0사이의 double 반환
        System.out.println("random : " + Math.random());

        // [📝실습예제]
        // 로또번호 7개 뽑기. 0-99까지의 임의 숫자
        for (int i = 0; i < 7; i++) {
            System.out.println("Lotto (" + i + ") :" + (int) (Math.random() * 100));
        }

        //📍 Math.abs() : 절대값 반환
        System.out.println("abs : " + Math.abs(-5)); //5

        //📍 Math.ceil() : 올림
        //📍 Math.floor() : 내림
        //📍 Math.round() : 반올림
        System.out.println("ceil : " + Math.ceil(5.7)); //6.0
        System.out.println("floor : " + Math.floor(5.7)); //5.0
        System.out.println("round : " + Math.round(5.7)); //6

        //📍 Math.max(a,b) : 두 수의 최대값
        //📍 Math.min(a,b) : 두 수의 최소값
        System.out.println("max : " + Math.max(10, 20)); //20
        System.out.println("min : " + Math.min(10, 20)); //10

        //📍 Math.pow(a,b) : a의 b승(제곱)
        //📍 Math.sqrt(a,b) : a의 제곱근
        System.out.println("pow : " + Math.pow(2,3)); //8.0
        System.out.println("square root : " + Math.sqrt(25)); //5

    }
}
