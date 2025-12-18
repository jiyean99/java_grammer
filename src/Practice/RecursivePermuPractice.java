package Practice;

import java.util.ArrayList;
import java.util.List;

public class RecursivePermuPractice {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);

        // for문으로 풀이
        List<List<Integer>> permuListForLoop = new ArrayList<>();
        List<Integer> tempForLoop = new ArrayList<>();
        boolean[] checkedForLoop = new boolean[numList.size()];

        for (int i = 0; i < numList.size(); i++) {
            if (checkedForLoop[i]) continue;
            tempForLoop.add(numList.get(i));
            checkedForLoop[i] = true;
            for (int j = 0; j < numList.size(); j++) {
                if (checkedForLoop[j]) continue;
                tempForLoop.add(numList.get(j));
                checkedForLoop[j] = true;
                permuListForLoop.add(new ArrayList<>(tempForLoop));
                tempForLoop.remove(tempForLoop.size() - 1);
                checkedForLoop[j] = false;
            }
            tempForLoop.remove(tempForLoop.size() - 1);
            checkedForLoop[i] = false;
        }
        System.out.println(permuListForLoop);

        // 재귀함수 풀이
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> permuList = new ArrayList<>();
        boolean[] checked = new boolean[numList.size()];
        // 인자로 받을 요소들 : n(조합의 수), numList, temp, permuList, checke[]
        permu(2, numList, temp, permuList, checked);
        System.out.println(permuList);


    }

    public static void permu(int n, List<Integer> numList, List<Integer> temp, List<List<Integer>> permuList, boolean[] checked) {
        if(temp.size() == n){
            permuList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            if(checked[i]) continue;
            temp.add(numList.get(i));
            checked[i] = true;
            permu(n, numList, temp, permuList, checked);
            temp.remove(temp.size() - 1);
            checked[i] = false;
        }

    }
}
