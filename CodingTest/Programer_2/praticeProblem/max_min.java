package CodingTest.Programer_2.praticeProblem;

import java.util.StringTokenizer;

public class max_min {
    public String solution(String s) {

        StringTokenizer stn = new StringTokenizer(s, " ");

int max1 = Integer.MAX_VALUE;
int min1 = Integer.MIN_VALUE;
        while (stn.hasMoreTokens()) {


            int number = Integer.parseInt(stn.nextToken());
            max1 = Math.max(max1, number);
            min1 = Math.min(min1, number);

        }


        return min1 + " " + max1;
    }
}
