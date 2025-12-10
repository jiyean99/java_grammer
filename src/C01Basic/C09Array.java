package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C09Array {
    public static void main(String[] args) {
        /* ************ 배열 표현식 ************ */
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
        int[] arr_1 = {10, 20, 30, 12, 8, 17};
        // 최대값을 구할 때에는 가장 작은값을 설정 -> 그 값을 배열과 비교 -> max 값이 변경되면 그 다음 배열값들과 비교해서 최대값 도출
        // 최소값을 구할 때에는 가장 큰 값 설정 -> 동일
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr_1) {
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
        for (int i = arr_3.length -1; i >= 0 ; i--) {
            new_arr[idx] = arr_3[i];
            idx++;
        }
        // 풀이(2)
//        for (int i = arr_3.length-1; i>=0; i--){
//            new_arr[(arr_3.length-1)-i] = arr_3[i];
//        }

        System.out.println(Arrays.toString(new_arr));

    }
}
