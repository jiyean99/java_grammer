package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
        ///* ************ List 특징 ************ *///
        // List와 Array의 가장 큰 차이는 값을 추가/삭제가 가능하다는 점
        // List는 인터페이스(카테고리)이고, 이의 구현체(클래스)로 ArrayList, LinkedList 등이 있다.
        // 결국 List는 그저 껍데기일 뿐!
        // 또한 List, Map, Set 등은 컬렉션 프레임워크이며 이들은 비슷한 메서드를 공유함

        ///* ************ List 선언 방법 ************ *///
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
        int[] intArr = {10, 20, 30};
        //List<Integer> myList5 = new ArrayList<>(Arrays.asList(intArr)); // 자동 오토박싱이 안되고 호환이 되지 않음 -> 반복문 사용 or Integer 박싱 후 변환
        List<Integer> myList5 = new ArrayList<>();
        for (int i : intArr) {
            myList5.add(i);
        }
        System.out.println("for으로 기본자료형 자료 삽입" + myList5);

        ///* ************ List의 출력 ************ *///
        //📍Q) 참조자료형은 원래 힙메모리 주소가 출력되어야하는데 왜 출력이 되지?
        //  A) 배열의 경우 메서드를 별도로 호출해주었는데,
        //     list등의 컬렉션 프레임워크(map,set,list 등) 안에는 toString 메서드가 구현 및 자동 호출된다.
        //     참조자료형 : 클래스 기반의 객체 -> 힙메모리에 저장
        //     나만의 클래스, 나만의 객체를 만들 때에는 toString 을 호출해줘야함
        //📍 cf) 클래스 선언 위치로 들어가서 확인해보기
        // public class ArrayList<E> extends AbstractList<E> -> ArrayList는 AbstractList의 기능을 상속받았고, AbstractList는 AbstractCollection를 상속받는데, 이 때 AbstractCollection에 toString 메서드가 구현되어있다. 이 때 포맷도 확인 가능

        ///* ************ List 주요 메서드 ************ *///
        // 📍.add() : 리스트에 값을 하나씩 추가
        List<Integer> test_list = new ArrayList<>();
        test_list.add(10);
        test_list.add(20);
        test_list.add(0, 30); // 자리를 지정하여 중간에 데이터를 삽입/삭제 하는 작업은 비효율적 (index가 다 뒤로 밀림)
        System.out.println("add : " + test_list);

        // 📍.get(index) : 특정 index의 요소 반환
        System.out.println("get : " + test_list.get(2));

        // 📍.size() : 리스트의 개수(길이) 반환
        System.out.println("size : " + test_list.size());

        // 📍.set(int index, E element) : 특정 위치에 있는 요소를 지정된 요소로 대체

        // 📍cf) 리스트의 값 출력 : 일반 for문
        System.out.println("=== 리스트의 값 출력 : 일반 for문 ===");
        for (int i = 0; i < test_list.size(); i++) {
            System.out.println(test_list.get(i));
        }

        // 📍cf) 리스트의 값 출력 : 향상된 for문
        System.out.println("=== 리스트의 값 출력 : 향상된 for문 ===");
        int idx = 0;
        for (int a : test_list) {
            System.out.println(test_list.get(idx));
            idx++;
        }

        // 📍.remove() : 값 삭제
        List<Integer> remove_list = new ArrayList<>();
        remove_list.add(10);
        remove_list.add(20);
        remove_list.add(30);
        remove_list.remove(0); // 마찬가지로 index가 변동되므로 성능저하 발생
        remove_list.remove(remove_list.size() - 1); // 마지막 요소 삭제

        // 📍.indexOf() : 특정 값을 찾아 index return
        List<Integer> index_list = new ArrayList<>();
        index_list.add(10);
        index_list.add(20);
        index_list.add(30);
        index_list.add(30);
        System.out.println("indexOf 30 : " + index_list.indexOf(30)); // 가장 먼저 나오는 값 return(내부적으로 break되었기 때문) -> for문으로 직접 구현해도 똑같음(복잡도 n)

        // 📍.contains() : 값이 있는지 없는지 여부를 불린값으로 리턴
        System.out.println("contains 20 : " + index_list.contains(20)); // 마찬가지로 복잡도 O(n)

        // 📍 정렬 : 1) Collections클래스의 sort 메서드 사용, 2) 객체의 sort 메서드 사용
        // 클래스명.메서드() vs 객체(변수명).메서드()
        List<Integer> sort_list = new ArrayList<>();
        sort_list.add(5);
        sort_list.add(3);
        sort_list.add(2);
        sort_list.add(1);
        sort_list.add(4);

        // 1)
        Collections.sort(sort_list); // 오름차순
        Collections.sort(sort_list, Comparator.reverseOrder());
        System.out.println("클래스메서드 오름차순 -> 내림차순 : " + sort_list);
        // 2)
        sort_list.sort(Comparator.naturalOrder()); // 오름차순
        sort_list.sort(Comparator.reverseOrder()); // 내림차순
        System.out.println("객체메서드 오름차순 -> 내림차순 : " + sort_list);

        ///* ************ 이중 리스트 : 리스트 안에 리스트 ************ *///
        List<List<Integer>> multi_list = new ArrayList<>();
        // 핵심: 빈 껍데기만 있으면 데이터 삽입 불가 → [[], [], ...] 형태로 내부 껍데기부터 만들어야 함

        // [📝실습예제] - 이중리스트 채우기
        // 요구사항 : [[1,2,3],[4,5,6]]
        List<Integer> m1 = new ArrayList<>();
        multi_list.add(m1);
        multi_list.add(new ArrayList<>());
        m1.add(1);
        m1.add(2);
        m1.add(3);
        multi_list.get(1).add(4);
        multi_list.get(1).add(5);
        multi_list.get(1).add(6);
        System.out.println(multi_list);

        // 📍 메모리 구조 설명
        // 1. m1 = new ArrayList<>() → 힙에 m1 객체 생성 (빈 리스트)
        // 2. multi_list.add(m1) → multi_list가 m1의 메모리 주소 참조
        // 3. m1.add(1,2,3)든 multi_list.get(1).add(4,5,6)이든 → 같은 객체를 참조하므로 데이터 추가 순서 상관없음
        // 결국 List는 "메모리 주소"를 저장 → 참조에 의한 동작임
        /*

                multi_list (외부) → [ m1주소, new ArrayList()주소 ]
                     ↓                  ↓
                   m1 객체           내부 리스트 객체
                   [1,2,3]           [4,5,6]

        */

        ///* ************ 이중 리스트 : 리스트 안에 배열 ************ *///
        // [{10,20},{1,2,3},{4,3,2,1}]
        List<int[]> m_list = new ArrayList<>();
        // 방법 (1)
        int[] arr1 = new int[2]; // 배열 역시 객체이기 때문에 arr1에 값을 세팅하는 순서는 중요하지 않다(더 밑에서 삽입해도 된다는 뜻)
        arr1[0] = 1;
        arr1[0] = 2;
        m_list.add(arr1);

        // 방법 (2)
        m_list.add(new int[3]);
        m_list.get(1)[0] = 1;
        m_list.get(1)[1] = 2;
        m_list.get(1)[2] = 3;

        // 방법 (3)
        m_list.add(new int[]{4, 3, 2, 1});

        System.out.println("리스트 안에 배열(주소값만 출력) : " + m_list); // 내부 각각의 배열의 힙메모리 주소만 출력(배열은 toString이 구현되어있지 않기 때문)

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < m_list.size(); i++) {
            sb.append(Arrays.toString(m_list.get(i)));
            if (i != m_list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println("리스트 안에 배열(값까지 출력) : " + sb);
        //📍 리스트 안의 배열들을 정렬하는 기준은 길이, 0번인덱스 크기 등 다양하게 잡아야하기 때문에 추후에 배우는 메서드를 통해 정렬 작업을 진행


        ///* ************  실습문제 모음집 ************ *///
        // [📝실습예제] 프로그래머스 - n의 배수 고르기
        // https://school.programmers.co.kr/learn/courses/30/lessons/120905


        // [📝실습예제]
        // 요구사항 : [[1,2,3],[4,5,6],[7,8,9], ... ,[58,59,60] 형태의 이중 리스트 생성
        List<List<Integer>> my_list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            my_list.add(new ArrayList<>());
            for (int j = 1; j < 4; j++) {
                my_list.get(i).add(3 * i + j);
            }
        }
        /* 강사님 풀이(1) : 위와 같은 방식(다 만들어놓고 채우는 것)인데 연산 방식만 약간 다름
        int num = 1;
        for (int i = 0; i < 20; i++) {
            my_list.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                my_list.get(i).add(num);
                num++;
            }
        }
        */
        /* 강사님 풀이(2) : 위와 같은 방식(다 만들어놓고 채우는 것)인데 연산 방식만 약간 다름
        int num = 1;
        for (int i = 0; i < 20; i++) {
            List<Integer> m1 = new ArrayList<>();
            my_list.add(m1); // m1의 add 시점은 위, 아래 모두 가능
            for (int j = 0; j < 3; j++) {
                m1.add(num);
                num++;
            }
        }
        */
        System.out.println(my_list);

    }
}
