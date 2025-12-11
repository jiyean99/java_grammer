package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C10List {
    public static void main(String[] args) {
        /* ************ List 선언 방법 ************ */
        // List는 인터페이스(카테고리)이고, 이의 구현체(클래스)로 ArrayList, LinkedList 등이 있다\
        //📍 List 선언 방법 (1) : ArrayList
        ArrayList<String> myList = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>(); // 우측에선 String은 안써도 됨(생략 가능)

        //📍 List 선언 방법 (2) : 가장 일반적인 방법
        // cf) 객체 : 자기 자신만의 고유 메모리를 갖고 잇음
        // 인터페이스는 실체(구현체)가 없음 그저 카테고리일 뿐
        List<String> myList3 = new ArrayList<>();

        //📍 초기값 세팅 방법(1) : 개별 데이터 add
        myList3.add("java");
        myList3.add("js");
        myList3.add("c++");

        System.out.println("List 초기값 세팅1 : " + myList3);

        //📍 초기값 세팅 방법(2) : 배열을 리스트로 변환
        String[] arr = {"java", "js", "c++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List 초기값 세팅2 : " + myList4);

        // 📍 List의 안의 자료 타입으로는 기본형 타입 사용 불가
        int[] intArr = {10,20,30};
        //List<Integer> myList5 = new ArrayList<>(Arrays.asList(intArr)); // 자동 오토박싱이 안되고 호환이 되지 않음 -> 반복문 사용 or Integer 박싱 후 변환
        List<Integer> myList5 = new ArrayList<>();
        for (int i : intArr){
            myList5.add(i);
        }

        System.out.println("for으로 기본자료형 자료 삽입" + myList5);

    }
}
