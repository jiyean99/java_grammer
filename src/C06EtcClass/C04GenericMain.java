package C06EtcClass;

import java.util.*;
//import java.util.stream.IntStream;

public class C04GenericMain {
    public static void main(String[] args) {
        /// * ************ 제네릭 개요 ************ *///
        // 제네릭 클래스나 메서드의 타입을 파라미터화해서, 객체 생성 시에도 그 타입이 미리 정해져 있지 않아도 되므로, 다양한 타입으로 그때 그때 지정이 가능하므로 코드의 재사용성을 향상


        String[] stArr = {"java", "python", "c++"};
        stChange(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr));

        Integer[] inArr = {10, 20, 30};
        intChange(inArr, 0, 1);
        System.out.println(Arrays.toString(inArr));

        allChange(stArr, 1, 2);
        System.out.println(Arrays.toString(stArr));
        allChange(inArr, 1, 2);
        System.out.println(Arrays.toString(inArr));


        /// * ************ 제네릭을 사용한 객체 생성 ************ *///
        GenericPerson<String> p1 = new GenericPerson<>("hong");
        GenericPerson<Integer> p2 = new GenericPerson<>(20);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());


        /// * ************ 제네릭의 사용 예시 ************ *///
        List<String> myList = new ArrayList<>(); // 구현체인 ArrayList를 들어가면 ArrayList<E> 제네릭 사용을 확인할 수 있음
        Map<String,Integer> myMap = new HashMap<>(); // HashMap<K,V>
        Optional<Student> myStudent; // Optional<T>


    }

    static void stChange(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void intChange(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    // 문법: 제네릭 메서드는 반환타입 왼쪽에 <T>라고 선언 (단, 클래스차원에 <T>가 있다면 내부의 메서드에는 안써줘도 됨)
    // 이 때 T는 참조형 변수인 객체타입만을 허용
    static <T> void allChange(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}

class GenericPerson<T> {
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}