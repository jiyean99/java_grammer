package C01Basic;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class C12Set {
    public static void main(String[] args) {
        ///* ************ Set 특징 ************ *///
        // - 중복X, 순서 보장X
        // - 성능 : O(1) (마찬가지로 Hash 테이블을 이용해서 난수값을 뽑아내고, 데이터의 주소를 바로 찾아냄)
        // 종류에 대한 문제의 경우 set을 쓰는 경우가 많음(중복이 알아서 제거되니까!)
        Set<String> mySet = new HashSet<>();
        mySet.add("야구");
        mySet.add("농구");
        mySet.add("야구");
        mySet.add("축구");
        System.out.println(mySet);
        System.out.println("HashSet : " + mySet.contains("야구")); // 복잡도 : O(1)

        ///* ************ 집합 관련 함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll) ************ *///
        Set<String> s1 = new HashSet<>();
        s1.add("java");
        s1.add("python");
        s1.add("c++");
        Set<String> s2 = new HashSet<>();
        s2.add("java");
        s2.add("html");
        s2.add("css");
        //📍.retainAll
        s1.retainAll(s2); // s1에는 교집합인 java만 남음
        System.out.println("retail s1: " + s1);
        //📍.addAll
        s1.addAll(s2); // s1에는 합집합인 java, python, c++, html, css가 남음
        System.out.println("addAll s1: " + s1);
        //📍.removeAll
        s1.removeAll(s2); // s1에는 차집합인 python, c++이 남음
        System.out.println("removeAll s1: " + s1);

        ///* ************ TreeSet : 데이터를 오름차순 정렬 ************ *///
        Set<String> mySet2 = new TreeSet<>();
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println("TreeSet : " + mySet2);

        ///* ************ LinkedHashSet : 데이터의 삽입 순서 보장(입력 시간순 정렬) ************ *///


        // 수찾기(1920) - 복잡도
        // list 전체 탐색 : n^2(n*n)
        // 이분탐색 : n*log(n)
        // set 탐색 : n
        /*
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

        public class Main {
            public static void main(String[] args) throws IOException {
                // TODO 다시 풀기
            }
        }
        */

        // [📝실습예제] 백준 - 숫자카드(10815)
        // https://www.acmicpc.net/problem/10815
        /*
        import java.io.*;
        import java.util.*;

        public class Main {
            public static void main(String[] args) throws IOException {
                // n : 상근이가 갖고있는 숫자카드 개수
                // cards: 상근이 숫자 카드의 정수 리스트
                // m : 상근이 카드 검증 목적의 카드 개수
                // check_cards : 상근이 카드 검증 목적의 카드의 정수 리스트
                // output : 갖고있으면 1, 없으면 0 출력
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int n = Integer.parseInt(br.readLine());

                // int[] cards = new int[n]; TODO 갖고 있는 카드의 경우는 순서가 보장될 필요가 없으므로 해시셋에 담아 검증을 작업

                Set<Integer> cards = new HashSet<>();
                StringTokenizer card_token = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    cards.add(Integer.parseInt(card_token.nextToken()));
                }

                int m = Integer.parseInt(br.readLine());
                StringTokenizer check_token = new StringTokenizer(br.readLine());

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < m; i++) {
                    if (cards.contains(Integer.parseInt(check_token.nextToken()))) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    if (i != (m-1)) {
                        sb.append(" ");

                    }
                }
                System.out.println(sb);
            }
        }
        */

        // [📝실습예제] 프로그래머스 - 폰켓몬
        // https://school.programmers.co.kr/learn/courses/30/lessons/1845
        /*
        import java.util.HashSet;
        import java.util.Set;

        class Solution {
            public int solution(int[] nums) {
                int p_num = nums.length / 2; // 가져갈 수 있는 폰켓몬수
                int answer = 0;

                Set<Integer> my_p = new HashSet<>();
                for (int a : nums) {
                    my_p.add(a);
                }

                int my_p_size = my_p.size();
                if (my_p_size > p_num) {
                    answer = p_num;
                } else {
                    answer = my_p_size;
                }
                return answer;
            }
        }
        */

    }
}
