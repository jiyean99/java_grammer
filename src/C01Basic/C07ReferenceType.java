package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C07ReferenceType {
    public static void main(String[] args) {
        ///* ************ 기본(원시)자료형 : int, char, boolean 등 ************ *///
        // 특징 : 리터럴 형식으로 값 세팅, 기본값으로 초기화
        int a1 = 10;

        ///* ************ 참조 자료형 : 기본 자료형을 제외한 클래스 기반의 객체 ************ *///
        // 특징 : new 키워드를 통해 값 세팅, null로 초기화
        String st1 = new String("Hello world");

        int[] arr1 = new int[4];

        //📍 참조자료형이지만 예외적으로 리터럴 형식으로 값 세팅을 허용하는 경우 : String, 배열, Wrapper 클래스
        String st2 = "Hello world"; // String은 예외적으로 리터럴 형식으로 값 세팅 허용
        int[] arr2 = {1, 3, 5, 7}; // 배열도 객체이므로 new 키워드를 써야하나, 예외적으로 리터럴형식으로 값 세팅 허용

        //📍 참조자료형을 출력하면 힙메모리의 주소값이 출력되어야하나, String 내부에 toString 메서드가 구현 및 자동 호출되도록 설계
        System.out.println(arr1); // 힙메모리 주소값 출력(toString 별도 호출 필요)
        System.out.println(Arrays.toString(arr1)); // 데이터 출력
        System.out.println(st1); // 내부에 toString 구현 및 자동 호출

        //📍 원시 자료형은 스택메모리에 "값"이 저장되므로, == 로 비교시 값 자체를 비교
        int a = 10;
        int b = 10;
        System.out.println(a == b); // true

        //📍 참조 자료형은 스택메모리에 "힙메모리 주소값"이 저장되므로, ==로 비교시 메모리 주소값을 비교
        String st_1 = new String("hello");
        String st_2 = new String("hello");
        System.out.println(st_1 == st_2); // false
        System.out.println(st_1.equals(st_2)); // true (*equals 메서드를 통해 힙메모리의 값 비교)

        ///* ************ WrapperClass : 기본형 타입을 Wrapping한 클래스(참조자료형) ************ *///
        // wrapper 클래스의 주요 메서드 사용 예시
        int i1 = 10; // 원시자료형은 별도의 메서드가 없음
        Integer i2 = 10; // i2. 작성 시 Integer의 메서드들이 출력됨
        // Integer i3 = new Integer(10); // int와 Integer는 호환성이 좋기때문에 박싱과 언박싱이 자유롭게 이루어짐
        String st_3 = Integer.toString(i1); // i1을 String으로 변환
        int i_3 = Integer.parseInt(st_3); // st_3을 Integer로 변환


        //📍 추후 배우게 될 list, map, set 등 참조 자료형에는 원시 자료형을 쓸 수 없음.
        List<Integer> list1 = new ArrayList<>();
        list1.add(10); // 10은 int이기도하고, Integer이기도 함 (auto boxing) (오토박싱 X : list1.add(new Integer(10));)
        list1.add(20);
        list1.add(30);
        // List<int> list2 = new ArrayList<>(); // 원시자료형을 넣을 시 오류발생(클래스 기반의 참조자료형들이 만들어진건데, 새롭게 나온 클래스와의 호환성을 위해서 원시자료형을 세팅하지 않는것)
        //📍 단, 예외적으로 배열(참조자료형)에는 원시자료형 세팅이 가능
        int[] arr_1 = {10, 20, 30}; // 원시 자료형 허용!

        ///* ************ 박싱/언박싱 ************ *///
        int i_b_1 = 10;
        // Integer ig1 = new Integer(10); // 사용중지된 문법(java5부터 오토박싱/언박싱)

        //📍 오토 박싱 : 원시 자료형에서 Wrapper 클래스로 자동 형변환
        Integer ig1 = i1;

        //📍 오토 언박싱 : Wrapper 클래스에서 원시 자료형으로 자동 형변환
        int i_b_2 = ig1;

    }
}
