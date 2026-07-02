package CodingTest.programers.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Boat {

    public int solution(int[] people, int limit) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer integer : arrayList) {
            arrayList.add(integer);
        }


        Collections.sort(arrayList);


        int left = 0;
        int right = arrayList.size() - 1;
        int count = 0;


        while (left <= right) {

            if (arrayList.get(left) + arrayList.get(right) <= limit) {
                left++;
            }

            right--;
            count++;
        }

        return count;
    }
}
