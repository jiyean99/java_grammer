package C01Basic;

import java.util.*;

public class C09Array {
    public static void main(String[] args) {
        ///* ************ 배열 표현식 ************ *///
        // 기본 전제 사항 : java의 배열은 반드시 사전에 길이가 결정되어야 함
        //int[] arr = new int[]; // <- 허용X

        //📍 (1) 배열 선언 후 값 할당 방식
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        // int 배열의 경우 선언 시 기본적으로 0 초기화. boolean은 false, 참조자료형은 null
        arr1[3] = 40;
        arr1[4] = 50;
        //arr1[5] = 60; // error : Index out of bounds

        //📍 (2) 리터럴 방식
        int[] arr2 = {10, 20, 30, 40, 50};

        //📍 (3) 명시적 배열 생성 방식
        int[] arr3 = new int[]{10, 20, 30, 40, 50};

        // 배열표현식(3)의 활용 예시 : 배열 객체를 다른 매서드의 매개변수로 사용할 경우
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[5]);
        //myList.add({10, 20, 30, 40, 50}); // 사용 불가 : 리터럴 방식으로 넣을 시에 배열인지 아닌지 확인 불가
        myList.add(new int[]{10, 20, 30, 40, 50}); // 초기값을 세팅해서 넣을 수 있게 됨

        ///* ************ 주요 매서드 ************ *///
        ///* ************ 배열의 정렬 ************ *///
        //📍 Arrays.sort(stArr) : 배열의 정렬
        // sort 매서드는 정렬에 대한 최적의 알고리즘이 구현되어있다 -> 직접 알고리즘으로 구현하기보다는 매서드를 쓰라는 뜻
        // 내장 매서드의 복잡도 = nlog(n)
        String[] stArr = {"abc", "aaa", "acd", "add"};
        Arrays.sort(stArr);
        System.out.println("배열의 정렬(디폴트) : " + Arrays.toString(stArr)); // 디폴트는 오름차순
        Arrays.sort(stArr, Comparator.reverseOrder());
        System.out.println("배열의 정렬(내림차순) : " + Arrays.toString(stArr)); // 내림차순 정렬

        //📍 오름차순 정렬 알고리즘 만들어보기
        //   (1) 선택정렬 알고리즘 (성능X)
        //       - min 찾는 알고리즘으로 배열 전체 조회 후 가장 작은 값을 찾는다.
        //       - 가장 작은값을 확정 후 위치를 알아야함.
        //       - 자리를 바꿔야 함. -> 첫번째 자리 확정.
        //       - 확정된 값 이후부터 다시 가장 작은 값을 찾는다.
        //       - 확정된 값 이후부터 다시 가장 작은 값을 찾는다. -> 자리 change
        //       - 확정된 값 이후부터 다시 가장 작은 값을 찾는다. -> 자리 change ... 정렬 완료
        //   정리 : 최상단 for문 -> 자리결정(i 0~arr.length), 하위 for문 -> 최소값 결정(j i~arr.length)
        //         for문 내부에서 할 일은 순차적으로 최소값 찾는다 -> 자리 체인지 한다
        //   정리 : (1) 2중 for문을 사용하여 index마다 최소값 찾기 (2)현재 위치와 자리 체인지 하기

        int[] sortArr = {17, 12, 20, 10, 15};
        for (int i = 0; i < sortArr.length; i++) {
            int minIdx = i; // 0을 넣어서 시작하면 혼선 발생 가능성이 있으므로 i로 두고 하는게 가장 바람직함, -1같이 안나올 값을 넣어도 됨
            int minValue = sortArr[i];
            for (int j = i + 1; j < sortArr.length; j++) { // index를 i로 두었기 때문에 i+1의 범위부터 시작
                if (minValue > sortArr[j]) {
                    minValue = sortArr[j];
                    minIdx = j;
                }
            }
            int temp = sortArr[i];
            sortArr[i] = sortArr[minIdx];
            sortArr[minIdx] = temp;
        }
        System.out.println("선택정렬 알고리즘(1) : " + Arrays.toString(sortArr));

        //   (2) 선택정렬 알고리즘 : 각 자리마다 계속 비교하고 비교할 때 마다 작은값이 있으면 바꿔줌
        for (int i = 0; i < sortArr.length; i++) {
            for (int j = i; j < sortArr.length; j++) {
                if (sortArr[i] > sortArr[j]) {
                    int temp = sortArr[i];
                    sortArr[i] = sortArr[j];
                    sortArr[j] = temp;
                }
            }
        }
        System.out.println("선택정렬 알고리즘(2) : " + Arrays.toString(sortArr));

        //📍 알고리즘의 복잡도
        // 데이터 수가 n개가 있다면,
        // n개를 모두 순회할 시 n번의 반복횟수 필요 -> O(n)
        // 한번에 찾아갈 때 -> O(1)
        // 이 때 선택정렬의 복잡도는 O(n^2) <-> Java 기본 내장 정렬함수 복잡도는 O(n*log(n)).
        // log(1000) = log(10^3) = 3 (프로그래밍에선 log의 밑을 2로 두고 생각한다) 따라서 log(1000) = 10정도 됨.
        // 즉, 선택정렬 알고리즘 사용 시 데이터가 만개면 일억에 조금 못미치는 정도로 반복함 (100000^2).
        // sort 매서드 사용시 데이터 만개면 10000*log(10000) = 10000*16 = 16만번 정도로 반복함.
        // 따라서 로그를 사용해버리면 복잡도가 현저히 줄어듬.
        // 정리하자면, 정렬의 복잡도는 n*long(n)이고 매우 효율적이다 라는 키워드는 알고 가자!(추후 이분탐색에서도 사용되는 내용)


        //📍 cf) 자바의 고질적 문제
        int[] arr_1 = {17, 12, 20, 10, 15};
        Arrays.sort(arr_1); // 오름차순 정렬
        //Arrays.sort(arr, Comparator.reverseOrder()); // int배열은 Comparator 객체를 사용하지 못한다는 에러 발생 (원시 자료형은 Comparator 사용 불가능) -> arr 배열을 Integer로 박싱하면 됨
        // 추후에 개발된 요소들은 원시자료형에서 사용 못하는 경우가 많음(결국 원시 자료형 호환X)

        //📍 cf) 스테틱매서드, 객체메서드 매서드 종류에 따라 String.,Arrays. 이런식으로 쓸 수도 있고 변수명. 이런식으로 쓸 수 있는 매서드도 있다.
        //   클래스 매서드 vs 객체 매서드 추후에 다뤄볼것

        ///* ************ 배열의 검색 ************ *///
        //📍 Arrays.binarySearch(arr, target):
        // - 찾고자 하는 값이 있으면 해당 index 리턴, 없으면 음수값 리턴
        // - 중복되는 데이터가 있을 때도 정확한 인덱스 위치를 알 수 없음

        // 📍 선형 검색 (Linear Search)
        // - 복잡도: O(n) - 모든 데이터를 순차적으로 확인
        // 📍 이진 탐색 (Binary Search)
        // - 복잡도: O(log n) - 반드시 정렬된 데이터에서만 사용 가능

        // 과정:
        // 1. 데이터를 절반으로 나눔
        // 2. 가운데 값(mid)이 target보다 큰지 작은지 확인
        // 3. target < mid → 왼쪽 절반만 조회 대상
        // 4. target > mid → 오른쪽 절반만 조회 대상
        // 5. 반복 → 조회 대상이 log(n) 단계로 급감
        // 📍 핵심 아이디어
        // "전체 데이터를 대상으로 절반씩 쪼개서 들어가는 방식"
        // → 이분탐색, 이진탐색(Binary Search)이라고 함

        // [📝실습예제]
        // 요구사항 : target이 몇 번째 index에 있는지 출력
        int[] findArr = {1, 3, 6, 8, 8, 9, 11, 15};
        int target = 11;
        // 선형검색 풀이법
        int targetIdx1 = -1;
        for (int i = 0; i < findArr.length; i++) {
            if (findArr[i] == target) {
                targetIdx1 = i;
                break;
            }
        }
        System.out.println("선형탐색 : " + targetIdx1);
        // 이분탐색 풀이법(이진검색: Binary Search)으로 찾기 : 복잡도 O(lon(n))
        int targetIdx2 = Arrays.binarySearch(findArr, target);
        System.out.println("이분탐색 : " + targetIdx2);
        int targetIdx3 = Arrays.binarySearch(findArr, 13); //-8
        System.out.println("없는 값 탐색 : " + targetIdx3);

        ///* ************ 배열의 값 비교 ************ *///
        // 📍 Arrays.equals(arr,arr) : 배열의 값 비교
        int[] arr___1 = {10, 20, 30};
        int[] arr___2 = {10, 20, 30};
        System.out.println(arr___1 == arr___2); // false
        System.out.println(Arrays.equals(arr___1, arr___2)); // true(잘 안쓰임)

        ///* ************ 배열의 복사 ************ *///
        // 📍 Arrays.copyOf(배열명, length)
        // 📍 Arrays.Arrays.copyOfRange(배열명, start, end)
        int[] arr____1 = {1, 4, 6, 7, 8, 1, 2, 4, 6};
        int[] arr_copy = Arrays.copyOf(arr____1, 4);
        System.out.println("배열 값 복사 : " + Arrays.toString(arr_copy));
        int[] arr_copy_2 = Arrays.copyOfRange(arr____1, 3, 6);
        System.out.println("배열 값 특정 위치 복사 : " + Arrays.toString(arr_copy_2));

        ///* ************ 배열 채우기 ************ *///
        // 📍 Arrays.fill() : 배열에 모든 값 변경(채우기)
        String[] fill_arr = new String[5];
//        for (int i = 0; i < fill_arr.length; i++) {
//            fill_arr[i] = "";
//        }
        Arrays.fill(fill_arr, "");
        System.out.println(Arrays.toString(fill_arr));

        ///* ************ 2차원 배열의 선언과 값 할당 ************ *///
        // 📍 (1) 선언 후 할당 방식
        int[][] multi_arr_1 = new int[3][2];
        multi_arr_1[0][0] = 1;
        multi_arr_1[0][1] = 2;
        multi_arr_1[1][0] = 1;
        multi_arr_1[1][1] = 2;
        multi_arr_1[2][0] = 1;
        multi_arr_1[2][1] = 2;

        // 📍 (2) 리터럴 방식
        int[][] multi_arr_2 = {{1, 2}, {1, 2}, {1, 2}};

        // [📝실습예제]
        // 요구사항 : [3][4] 사이즈의 2차원 배열을 선언하고, 1~12까지의 숫자값을 각 배열에 순차적으로 할당
        // ex) {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
        int[][] multi_arr = new int[3][4];
        int num = 1;
        for (int i = 0; i < multi_arr.length; i++) {
            for (int j = 0; j < multi_arr[i].length; j++) {
                multi_arr[i][j] = num;
                num++;
            }
        }
        System.out.println("multi_arr : " + Arrays.deepToString(multi_arr));
        // 2차원 배열의 출력
        System.out.println("multi_arr 자체 : " + multi_arr); // 2차원 배열 multi_arr의 힙메모리 주소
        System.out.println("multi_arr toString : " + Arrays.toString(multi_arr)); // multi_arr에 담긴 각 일차원 배열들의 힙메모리 주소
        System.out.println("multi_arr deepToString : " + Arrays.deepToString(multi_arr)); // multi_arr에 담긴 각 일차원 배열들의 값

        // 📍 이차원 배열의 활용(좌표)
        int[][] map_arr = {
                {4, 7, 4, 9},
                {5, 7, 2, 2},
                {3, 5, 2, 2},
                {9, 1, 2, 2},
                {5, 7, 4, 2},
                {7, 9, 2, 6},
                {2, 7, 5, 2}
        };
        // 마치 좌표처럼 활용 가능(좌표는 가변배열 사용 시 활용하기 어려움 주의)
        // 즉, 현실세계의 좌표(위치정보)를 이차원배열을 활용하여 bfs, dsf 를 풀어낼 수 있게 됨

        ///* ************ 가변배열 ************ *///
        // 2차원 배열에서 각 1차원의 배열의 길이가 서로 다를 수 있는 배열의 구조
        // 배열 전체의 길이는 반드시 사전할당 되어야하지만, 1차원 배열의 길이는 추후 할당 가능
        int[][] multi_arr_3 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] multi_arr_4 = new int[3][];
        multi_arr_4[0] = new int[2];
        multi_arr_4[1] = new int[3];
        multi_arr_4[2] = new int[4];
        System.out.println("가변배열 : " + Arrays.deepToString(multi_arr_4));

        // [📝실습예제]
        // 요구사항 : 85, 65, 90으로 int 배열을 선언하고, 총합과 평균을 구하시오.
        int[] test_arr_1 = new int[]{85, 65, 90};
        int sum = 0;
        for (int i : test_arr_1) {
            sum += i;
        }
        double avg = (double) sum / test_arr_1.length;
        System.out.println("test_arr_1 총 합 : " + sum);
        System.out.println("test_arr_1 평균 : " + avg);


        // [📝실습예제]
        // 요구사항 : 배열 최대값, 최소값
        int[] arr__1 = {10, 20, 30, 12, 8, 17};
        // 최대값을 구할 때에는 가장 작은값을 설정 -> 그 값을 배열과 비교 -> max 값이 변경되면 그 다음 배열값들과 비교해서 최대값 도출
        // 최소값을 구할 때에는 가장 큰 값 설정 -> 동일
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr__1) {
            System.out.println(i);
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

        // [📝실습예제]
        // 요구사항 : 배열의 자리 바꾸기
        int[] arr_2 = {20, 10, 30};
        int temp = arr_2[0];
        arr_2[0] = arr_2[1];
        arr_2[1] = temp;

        // [📝실습예제]
        // 요구사항 : 배열 뒤집기
        int[] arr_3 = {10, 20, 30, 40, 50};
        int[] new_arr = new int[arr_3.length];

        // 풀이(1)
        int idx = 0;
        for (int i = arr_3.length - 1; i >= 0; i--) {
            new_arr[idx] = arr_3[i];
            idx++;
        }
        // 풀이(2)
//        for (int i = arr_3.length-1; i>=0; i--){
//            new_arr[(arr_3.length-1)-i] = arr_3[i];
//        }

        System.out.println(Arrays.toString(new_arr));

        // [📝실습예제]
        // 요구사항 : (조합문제) 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두 숫자의 조합을 출력하시오
        // ex) (10,20), (10,30), (10,40), ... (40,50)
        int[] comb_arr = {10, 20, 30, 40, 50};
        for (int i = 0; i < comb_arr.length; i++) {
            for (int j = i + 1; j < comb_arr.length; j++) {
                System.out.println("(" + comb_arr[i] + ", " + comb_arr[j] + ")");
            }
        }

        // [📝실습예제] : 프로그래머스 - 두 개 뽑아서 더하기
        // 위 문제를 풀기 위한 선행지식 - Set 자료구조 활용
        // Set 자료구조 기본 특성 : 중복X, 순서X(index가 없음)
        // 아래의 배열의 중복을 제거하라 ex) 10,20,30,40만 남도록! (kp.중복제거 = Set 자료구조 연상)
        int[] arr = {10, 30, 20, 30, 10, 40};
        Set<Integer> mySet = new HashSet<>();
        for (int a : arr) {
            mySet.add(a);
        }
        int[] mySortArr = new int[mySet.size()];
        int index = 0;
        for (int a : mySet) { // Set이 index가 없어서 반드시 향상된 for문을 사용해야함. 이 때 index를 별도로 두는 구조는 함께 봐야함
            mySortArr[index] = a;
            index++;
        }
        Arrays.sort(mySortArr);
        System.out.println(Arrays.toString(mySortArr));

        // cf) set 안쓰면: 정렬 -> 옆에꺼랑 자기랑 같은지 비교 -> 제거 .. 너무 복잡함!!!!

        // [📝실습예제] : 백준 - 수 찾기(1920)
        // [📝실습예제] : 프로그래머스 - 행렬의 덧셈
        // [📝실습예제] : 프로그래머스 - K번째수
    }
}
