package C01Basic;

import java.util.*;

public class C11Map {
    public static void main(String[] args) {
        ///* ************ Map 특징 ************ *///
        // Map 역시 인터페이스이며 HashMap, TreeMap, LinkedHashMap등의 구현체들이 있다.
        // 정의 : key, value로 이루어진 자료구조
        // - 키는 중복이 없고, value는 중복 허용한다(사실 덮어쓰기가 됨)
        // - 키에는 순서가 없다(즉, 인덱스도 없다)
        // - LinkedHashMap은 삽입된 순서 보장, TreeMap은 정렬된채로 삽입(그러나 인덱스로 값 구할수 없는건 동일함)
        // - 키 값을 통한 검색 복잡도는 O(1)으로 속도가 매우 빠르다
        // cf) 어떻게 키로 조회 시 복잡도가 1일 수 있지???
        // -> 해시테이블 덕분에 빠른 속도로 검색할 수 있고, 이를 해시맵 구조라고 칭함
        // key값을 기준으로 Hash Function을 돌린다 -> Hash가 생성(16진수의 숫자값 난수)

        // 예시) key: 운동명, value: 해당 운동을 좋아하는 인원수
        // 농구: 2, 축구:3 , 배구: 2, 야구: 4 ... (운동명은 중복X, 인원수는 중복 가능)
        Map<String, Integer> sports = new HashMap<>();
        sports.put("농구", 2);
        sports.put("축구", 3);
        sports.put("배구", 2);
        sports.put("농구", 3); // 덮어쓰기가 됨

        System.out.println("sports : " + sports); // sports : {농구=3, 배구=2, 축구=3} (순서가 없이 무작위로 출력)

        System.out.println("배구의 value값 : " + sports.get("배구")); // map에서 key값을 통한 검색 복잡도는 O(1);


        ///* ************ Map의 주요 매서드 ************ *///
        //📍 .put() : 값 세팅

        //📍 .get() : 값 얻어오기
        // - 복잡도 : O(1)

        /* ************ Map의 전체 value 데이터 출력 ************ *///
        // cf) map의 key값 접근 시 인덱스 사용 불가(순서가 없으므로) -> for문을 통해 조회가 불가능함(뭐가 0번짼데?)
        //📍 .keySet() : map의 전체 키 목록을 반환하는 매서드
        // - 복잡도 : O(n)
        for (String a : sports.keySet()) { // index로는 조회가 불가하므로 향상된 for문을 사용해야만 함(물론 key를 안뽑고 그냥 values 매서드를 써도 함)
            System.out.println("key : " + a + ", value : " + sports.get(a));
        }
        //key : 농구, value : 3
        //key : 배구, value : 2
        //key : 축구, value : 3

        //📍 .values() : map의 전체 value 목록을 반환하는 매서드 (잘 안쓰임)
        for (int a : sports.values()) {
            System.out.println("전체 value 목록을 반환 : " + a);
        }

        //📍 .remove(key) : key를 통해 map요소 삭제
        sports.remove("축구");
        System.out.println("축구 삭제 : " + sports);

        //📍 .putIfAbsent() : key값이 없는 경우에만 put(값 세팅)
        sports.putIfAbsent("배구", 10);
        System.out.println("배구=10 : " + sports);

        //📍 .containsKey(): 키가 있으면 true, 없으면 false;
        System.out.println("배구 키 : " + sports.containsKey("배구"));
        System.out.println("탁구 키 : " + sports.containsKey("탁구"));

        //📍 .getOrDefault(키값, 초기값) : 키값이 없을 경우 초기값 return
        // <map을 통한 개수 count> 실습 풀이 확인

        //📍

        ///* ************ TreeMap : key값을 기준으로 오름차순 정렬하여 map을 저장 ************ *///
        Map<String, Integer> tree_map = new TreeMap<>();
        Map<String, Integer> tree_map2 = new TreeMap<>(Comparator.reverseOrder()); // 내림차순
        tree_map.put("hello5", 1);
        tree_map.put("hello4", 2);
        tree_map.put("hello3", 3);
        tree_map.put("hello2", 4);
        tree_map.put("hello1", 5);
        System.out.println("TreeMap : " + tree_map);

        // [📝실습예제]
        // 요구사항 : map을 통한 개수 count (하고싶은 운동 인원수 수집)
        // 힌트 : 담으려고 하는 키가 있으면 기존것에서 +1, 키가 없으면 key값에 1로 세팅
        String[] list_arr = {"농구", "축구", "야구", "축구", "농구", "배구"};
        Map<String, Integer> like_map = new HashMap<>();
        /* 내 풀이
        for (int i = 0; i < list_arr.length; i++) {
            if (like_map.containsKey(list_arr[i])) {
                like_map.put(list_arr[i], like_map.get(list_arr[i]) + 1);
            } else {
                like_map.put(list_arr[i], 1);
            }
        }
        */
        /* 강사님 풀이(향상된 for문)
        for (String a : list_arr) {
            if (like_map.containsKey(a)) {
                like_map.put(a, like_map.get(a) + 1);
            } else {
                like_map.put(a, 1);
            }
        }
        */
        // getOrDefault 매서드 사용
        for (String a : list_arr) {
            like_map.put(a, like_map.getOrDefault(a, 0) + 1); // getOrDefault : a를 찾되, a의 키값이 있으면 like_map.get(a)리턴, 없으면 0을 리턴
        }
        System.out.println("종목 별 수 : " + like_map);

        // [📝실습예제]
        // 요구사항 : map의 value값 감소 로직 (하기싫은 운동 인원수 수집)
        // {야구=1, 농구=2, 배구=1, 축구=2} << 여기서 차감되는 로직인거임
        // 나와야 하는 화면 : {배구=1, 축구=1}
        String[] un_list_arr = {"농구", "농구", "농구", "야구", "축구"};

        // 시도하려다 망한 풀이
//        Map<String, Integer> un_like_map = new HashMap<>();
//        for (String a : un_list_arr) {
//            un_like_map.put(a, un_like_map.getOrDefault(a, 0) + 1);
//            if (like_map.containsKey(a)) {
//                like_map.put(a, un_like_map.getOrDefault(a, 0) - 1);
//            }
//        }
        for (String a : un_list_arr) {
            if (like_map.containsKey(a)) {
                if (like_map.get(a) == 1) {
                    like_map.remove(a);
                } else {
                    like_map.put(a, like_map.get(a) - 1);
                }
            }
        }

        System.out.println(like_map);

        // [📝실습예제] 프로그래머스 - 완주하지 못한 선수
        // https://school.programmers.co.kr/learn/courses/30/lessons/42576
        /*
        import java.io.*;
        import java.util.*;

        class Solution {
            public String solution(String[] participant, String[] completion) {
                Map<String, Integer> my_map = new HashMap<>();

                String answer = "";

                for (String a : participant) {
                    if (my_map.containsKey(a)) {
                        my_map.put(a, my_map.get(a) + 1);
                    } else {
                        my_map.put(a, 1);
                    }

                }
                for (String a : completion) {
                    if (my_map.containsKey(a)){
                        if (my_map.get(a) == 1) {
                            my_map.remove(a);
                        } else {
                            my_map.put(a, my_map.get(a) - 1);
                        }
                    }
                }
                for (String a : my_map.keySet()) {
                    answer = a;
                }
                return answer;
            }
        }
        */

        // [📝실습예제] 프로그래머스 - 의상
        // https://school.programmers.co.kr/learn/courses/30/lessons/42578
        /*
        import java.io. *;
        import java.util. *;

        class Solution {
            public int solution(String[][] clothes) {
                Map<String, Integer> my_map = new HashMap<>();

                for (int i = 0; i < clothes.length; i++) {
                    if (!my_map.containsKey(clothes[i][1])) {
                        my_map.put(clothes[i][1], 1);
                    } else {
                        my_map.put(clothes[i][1], my_map.get(clothes[i][1]) + 1);
                    }
                }
                int answer = 1;

                for (String a : my_map.keySet()) {
                    answer *= (my_map.get(a) + 1);
                }

                answer -= 1;

                return answer;
            }
        }
        */


        // [📝실습예제]
        // 요구사항 : 가장 Value가 큰 key값 찾기
        Map<String, Integer> max_map = new HashMap<>();
        max_map.put("축구", 3);
        max_map.put("농구", 2);
        max_map.put("야구", 1);
        // 그냥 for문으로 MIN_VALUE 설정하여 가장 큰 값을 찾아봐야 중복된 값이 있을 수 있어서
        int max = Integer.MIN_VALUE;
        String max_key = "";
        for (String a : max_map.keySet()) {
            int value = max_map.get(a);
            if (max < value) {
                max = value;
                max_key = a;
            }
        }
        System.out.println(max_key);

        // [📝실습예제] 백준 - 베스트셀러
        // https://www.acmicpc.net/problem/1302

        // TODO 숙제
        // [📝실습예제] 백준 - 파일정리(TreeMap)
    }
}
