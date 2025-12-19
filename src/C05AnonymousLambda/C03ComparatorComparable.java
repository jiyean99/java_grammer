package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
        // Java에서는 비교를 위한 인터페이스로 대표적으로 두개가 주어진다
        // 1) Comparator 인터페이스 : 인터페이스 내 compareTo 메서드만 존재
        // 2) Comparable 인터페이스 : 인터페이스 내 compare 메서드만 존재

        /// * ************ Comparator ************ *///
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        // 자바의 대부분 정렬 함수는 매개변수로 Comparator 객체 요구함
        myList.sort(Comparator.naturalOrder());
        // o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되,
        // o1이 먼저 있으면 오름차순, o2가 먼저 있으면 내림차순 (rule이라서 외워야함)
        // 이 때 매개변수가 두개만 있으면 정렬이 되나? -> 두개의 비교만 하면 정렬이 가능하다(like 선택정렬)
        myList.sort((o1, o2) -> o1 - o2);

        List<String> myList2 = new ArrayList<>();
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");

        // 기본적인 문자열 정렬일 때에는 Comparator 커스텀을 하지 않고,
        // 복잡한 자신만의 정렬 기준을 갖고 정렬해야 할 때에는 Comparator 익명객체 생성

        Collections.sort(myList2, Comparator.reverseOrder());
        System.out.println("기본 내림차순 정렬 : " + myList2);
        // 알파벳순 오름차순
        Collections.sort(myList2, (o1, o2) -> o2.compareTo(o1));
        System.out.println("알파벳순 내림차순 정렬 : " + myList2);

        // 길이를 기준으로 한 오름차순
        Collections.sort(myList2, (o1, o2) -> o1.length() - o2.length());
        System.out.println("문자길이순 오름차순 정렬 : " + myList2);

        // 문자열의 길이로 정렬하되, 문자열의 길이가 같은 경우 알파벳 순으로 정렬
        myList2.add("HTML");
        Collections.sort(myList2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }

            }
        });
        System.out.println("문자길이순 & 알파벳순 정렬 오름차순 : " + myList2);


        // 배열, 리스트 정렬 외에 java의 그 외 정렬 자료 구조 (pq, Treeset, Treemap 등)
        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length()-o2.length());
        // 백준 - 최대값 힙 문제 위 구조 활용하면 매우 쉽게 풀이 가능

        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length() - o2.length());

        // TODO 백준 : 단어정렬
        // 백준 : 선긋기
    }
}
