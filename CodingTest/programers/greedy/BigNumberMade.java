package CodingTest.programers.greedy;


import java.util.ArrayList;
import java.util.Collections;

public class BigNumberMade {
    public String solution(String number, int k) {
        String answer = "";

        String[] s = new String[k];
        Integer[] integers = new Integer[k];

        for (int i = 0; i < (number.length() - k + 1); i++) {
             s[i] = number.substring(i, k + i);
        }


        for (int i = 0; i < s.length; i++) {
            integers[i] = Integer.parseInt(s[i]);
        }


        int max =0;
        for (Integer i : integers) {
            if (max < i) {
                max = i;
            }
        }

        return max + "";


        // number.length - k


    }
}
