package CodingTest.programers.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Boat {

    public int solution(int[] people, int limit) {

        ArrayList<Integer> arrayList = new ArrayList<>();


        for (int person : people) {
            arrayList.add(person);
        }


        int left = 0;
        int right = people.length - 1;
        int count = 0 ;


        Collections.sort( arrayList);
        while (left <= right) {

            if (limit > (arrayList.get(left) + arrayList.get(right))) {
                left++;
            }

            right--;
           count++;


        }

        return count;


    }
}
