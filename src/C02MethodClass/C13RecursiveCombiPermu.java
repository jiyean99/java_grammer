package C02MethodClass;

/// * ************ 재귀함수 활용 대표적 알고리즘 예시 ************ *///
// - 백트래킹, dfs 알고리즘에서 주로 사용 (또는 분할 정복)
// 백트래킹 : https://www.acmicpc.net/problemset?sort=ac_desc&algo=5
// dfs : https://www.acmicpc.net/problemset?sort=ac_desc&algo=127
// 분할정복 : https://www.acmicpc.net/problemset?sort=ac_desc&algo=24

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// * ************ 백트래킹 대표 예시 ************ *///
// - 조합과 순열에서 경우의 수 찾기
// for문 사용시 순열/조합 구할 시, (조합)이중포문 중 바깥이 0, 안쪽이 i+1 <-> (순열)바깥이 0, 안쪽이 0(이 때 같은건 걸러주기)
public class C13RecursiveCombiPermu {
    public static void main(String[] args) {
        /// * ************ 맛보기 문제 ************ *///
        //📍 for문 풀이
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //System.out.println("hello world");
            }
        }
        // 위 for문의 반복횟수(개수)는 동적으로 결정되지 않고, 정적으로 코딩할 수 밖에 없다는 한계 존재
        // 즉, for문의 깊이를 함수로 제어해야할 필요가 있음

        //📍 재귀함수 활용
        recurForLoop(0, 3);

        /// * ************ 조합 문제 ************ *///
        // 숫자 1,2,3,4 를 가지고 만들 수 있는 2개짜리 숫자 조합
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        //📍 for문 풀이(1)
        // 1,2/1,3/1,4/2,3/2,4/3,4
        for (int i = 0; i < myList.size(); i++) {
            for (int j = i + 1; j < myList.size(); j++) {
//                System.out.println(myList.get(i) + "," + myList.get(j));
            }
        }

        //📍 for문 풀이(2) : 이중리스트에 담아서 출력
        // [[0, 1], [0, 2], [0, 3], [1, 2], [1, 3], [2, 3]]
        List<List<Integer>> doubleList0 = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            for (int j = i + 1; j < myList.size(); j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(myList.get(i));
                temp.add(myList.get(j));
                doubleList0.add(temp);
            }
        }
        System.out.println("test ====== " + doubleList0);

        //📍 for문 풀이(3) : 재귀함수를 만들기 위한 for문 디벨롭
        /// * ************ 문제가 있는 코드 ************ *///
//        List<List<Integer>> doubleList = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < myList.size(); i++) {
//            temp.add(myList.get(i));
//            for (int j = i + 1; j < myList.size(); j++) {
//                temp.add(myList.get(j));
//                doubleList.add(temp);
//            }
//        }
//        System.out.println(doubleList);
        //[[1, 2, 3, 4, 2, 3, 4, 3, 4, 4], [1, 2, 3, 4, 2, 3, 4, 3, 4, 4], [1, 2, 3, 4, 2, 3, 4, 3, 4, 4], [1, 2, 3, 4, 2, 3, 4, 3, 4, 4], [1, 2, 3, 4, 2, 3, 4, 3, 4, 4], [1, 2, 3, 4, 2, 3, 4, 3, 4, 4]]

        /// * ************ 개선 ************ *///
        List<List<Integer>> doubleList1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            temp.add(myList.get(i));
            for (int j = i + 1; j < myList.size(); j++) {
                temp.add(myList.get(j));
                doubleList1.add(new ArrayList<>(temp)); // TODO 1)같은 힙메모리 주소를 계속해서 호출중인 상태를 개선
                temp.remove(temp.size() - 1); // TODO 2) get(j)가 끝나는 자리에서 떼어줌
            }
            temp.remove(temp.size() - 1); // TODO 3) get(i)가 끝나는 자리에서 떼어줌
        }
        System.out.println(doubleList1);

        //📍 재귀함수 활용
        // 숫자 1,2,3,4 를 가지고 만들 수 있는 n개짜리 숫자 조합
        List<List<Integer>> combDoubleList = new ArrayList<>();
        recurForComb(new ArrayList<>(), 0, myList, 2, combDoubleList); // 원본, n개짜리의 조합, 값을 담을 이중리스트
        System.out.println(combDoubleList);

        /// * ************ 순열 문제 ************ *///
        // (1) for문으로 풀기
        List<List<Integer>> permuDoubleList1 = new ArrayList<>();
        List<Integer> permuTemp = new ArrayList<>();
        boolean[] visited = new boolean[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            permuTemp.add(myList.get(i));
            visited[i] = true;
            for (int j = 0; j < myList.size(); j++) {
                if (visited[j]) continue;
                permuTemp.add(myList.get(j));
                visited[j] = true;
                permuDoubleList1.add(new ArrayList<>(permuTemp));
                permuTemp.remove(permuTemp.size() - 1);
                visited[j] = false;
            }
            permuTemp.remove(permuTemp.size() - 1);
            visited[i] = false;
        }
        System.out.println(permuDoubleList1);

        // (2) 재귀 풀이
        List<List<Integer>> permuDoubleList = new ArrayList<>();
        recurForPermu(new boolean[myList.size()], new ArrayList<>(), myList, 2, permuDoubleList);
        System.out.println(permuDoubleList);

    }

    /// * ************ 재귀함수 요령 ************ *///
    // - for문의 바깥쪽과 안쪽의 형식이 수미상관을 이루도록 짜라
    public static void recurForLoop(int nowDepth, int targetDepth) {
        if (nowDepth == targetDepth) {
            //System.out.println("===");
            /// 끝나는 자리에 넣어야 3^n 형식으로 올바르게 출력됨
            /* e.g. targetDepth가 3이라면 아래의 구조로 그려진다는 뜻
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            System.out.println("==="); // 3*3*3
                        }
                    }
                }
             */
            return;
        }

        for (int i = 0; i < 3; i++) {
            // System.out.println("===");
            /// 해당위치에서 출력하게 되면, 바깥 for문 마다 또 출력하게 되는 것임 (39 = 3*3*3 + 3*3 +3)
            /* e.g. targetDepth가 3이라면 아래의 구조로 그려진다는 뜻
                for (int i = 0; i < 3; i++) {
                    System.out.println("==="); // 3
                    for (int j = 0; j < 3; j++) {
                        System.out.println("==="); // 3*3
                        for (int k = 0; k < 3; k++) {
                            System.out.println("==="); // 3*3*3
                        }
                    }
                }
            */
            recurForLoop(nowDepth + 1, targetDepth);
        }
    }

    public static void recurForComb(List<Integer> temp, int start, List<Integer> myList, int n, List<List<Integer>> doubleList) {
        if (temp.size() == n) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            recurForComb(temp, i + 1, myList, n, doubleList);
//            recurForComb(temp, ++start, myList, n, doubleList);
            temp.remove(temp.size() - 1);
        }
    }

    public static void recurForPermu(boolean[] visited, List<Integer> temp, List<Integer> myList, int n, List<List<Integer>> doubleList) {
        if (temp.size() == n) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (visited[i]) continue;
            temp.add(myList.get(i));
            visited[i] = true;
            recurForPermu(visited, temp, myList, n, doubleList);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    // 백준 : 15649(N과 M), 6603(로또)
}
