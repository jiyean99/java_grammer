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

        ///* ************ TreeSet : 데이터를 오름차순 정렬 ************ *///
        Set<String> mySet2 = new TreeSet<>();
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println("TreeSet : " + mySet2);


        // 수찾기(1920) - 복잡도
        // list 전체 탐색 : n^2(n*n)
        // 이분탐색 : n*log(n)
        // set 탐색 : n


        // TODO 숙제
        // [📝실습예제] 백준 - 숫자카드(10815)
        // https://www.acmicpc.net/problem/10815

        // [📝실습예제] 프로그래머스 - 폰켓몬
        // https://school.programmers.co.kr/learn/courses/30/lessons/1845

    }
}
