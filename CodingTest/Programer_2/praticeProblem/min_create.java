package CodingTest.Programer_2.praticeProblem;

import CodingTest.SWEA.BigPrizeMoney;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

public class min_create {


    public int solution(int []A, int []B)
    {


        Arrays.sort(A);
        Arrays.sort(B);

        int sum  = 0;
        for (int i = 0; i < A.length; i++) {
         sum += A[i] * B[A.length -1 -i];
        }


        return sum;

    }





}
