package Practice;

import java.util.ArrayList;
import java.util.List;

public class RecursiveCombPractice {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);

        // for문 풀이
        List<List<Integer>> combListForLoop = new ArrayList<>();
        List<Integer> tempForLoop = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            tempForLoop.add(numList.get(i));
            for (int j = i + 1; j < numList.size(); j++) {
                tempForLoop.add(numList.get(j));
                combListForLoop.add(new ArrayList<>(tempForLoop));
                tempForLoop.remove(numList.get(j));
            }
            tempForLoop.remove(numList.get(i));
        }
        System.out.println(combListForLoop);

        // 재귀함수 풀이
        List<List<Integer>> combList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 필요한 인자 : n(조합의 수), startNum(시작번호), 값을 담을 이중 리스트, 원본 리스트
        comb(2, 0, temp, numList, combList);
        System.out.println(combList);

    }

    public static void comb(int n, int startNum, List<Integer> temp, List<Integer> numList, List<List<Integer>> combList) {
        if (temp.size() == n) {
            combList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startNum; i < numList.size(); i++) {
            temp.add(numList.get(i));
            comb(n, i + 1, temp, numList, combList);
            temp.remove(temp.size() - 1);
        }
    }
}
