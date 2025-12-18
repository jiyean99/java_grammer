package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C11RecursiveBasicFlow {
    public static void main(String[] args) {
        /// * ************ 재귀함수 ************ *///
        // - 함수가 자기 자신을 호출하는 형태
        // - while(true)와 달리 StackOverflowError 에러가 발생하고, break가 아닌 return을 적절히 해줘야 함
        // - 백트래킹 시 해결 알고리즘이 재귀함수 이용을 함(dfs, 백트래킹 등 재귀함수가 아니면 못품)

        //recur0(0, 3);
        //recur1(0, 3);
        recur2(new ArrayList<>(), 0, 3);
    }
    /// * ************ 재귀함수 기본 호출 원리와 과정 ************ *///
    // - recur0 : 재귀함수 내 변화 과정 확인 (매개변수로 넘기는 시점에 값 변경)
    // - recur1 : 재귀함수 내 변화 과정 확인 (함수 내에서 값 변경 후 해당 값을 매개변수로 넘김)
    // - recur2 : 객체를 매개변수로 활용한 재귀함수 내 변화 과정 확인
    //   - 객체는 힙 메모리를 통해 원본 객체가 변경되므로, 재귀함수간에도 값의 변화를 공유함
    public static void recur0(int count, int target) {
        if (count == target) {
            return;
        }
        // System.out.println("hello world"); // return 설정 X -> StackOverflowError 에러 발생
        System.out.println("재귀 호출 전 count : " + count); // recur0(0, 3) 호출 시 출력 : 0(첫번째) -> 1(두번째)-> 2(세번째)
        recur0(count + 1, target);
        System.out.println("재귀 호출 후 count : " + count); // recur0(0, 3) 호출 시 출력 : 2(네번째) -> 1(다섯번째)-> 0(여섯번째)
        // return; // 해당위치에 있으면 return을 만나지 못하고 여전히 recur0를 무한 호출 중
    }

    public static void recur1(int count, int target) {
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출 전 count : " + count); // recur1(0, 3) 호출 시 출력 : 0(첫번째) -> 1(두번째) -> 2(세번째)
        count += 1;
        recur1(count, target);
        System.out.println("재귀 호출 후 count : " + count); // recur1(0, 3) 호출 시 출력 : 3(네번째) -> 2(다섯번째) -> 1(여섯번째)
    }

    public static void recur2(List<Integer> myList, int count, int target) {
        if (myList.size() == target) {
            return;
        }
        myList.add(count);
        recur2(myList, count + 1, target);
        System.out.println(myList); // recur2(new ArrayList<>(), 0, 3); 호출 시 출력 : [0, 1, 2] -> [0, 1, 2] -> [0, 1, 2]
        //myList.remove(count);
        myList.remove(myList.size() - 1);
    }
}
