package CodingTest.Programer_2.DP;

import javax.print.DocFlavor;

public class reIntegerCalculate {
    // 사칙연산
    public int solution(String arr[]) {

        int n = (arr.length- 1)/2;

        int maxDp[][] = new int[n][n];
        int minDp[][] = new int[n][n];


        for (int i = 0; i < n; i++) {
            maxDp[i][i] = Integer.parseInt(arr[i*2]);
            minDp[i][i] = Integer.parseInt(arr[i*2]);
        }

        for (int len = 2; len <= n; len++) {



            for (int start = 0; start + len - 1 < n; start++) {

                int end = start + len - 1;

                maxDp[start][end] = Integer.MIN_VALUE; // 계산할 값을 미리 초기화
                minDp[start][end] = Integer.MAX_VALUE; //  계산할 값을 미리 초기화


                for (int split = start; split < end; split++) {

                    String operator = arr[split * 2 + 1];

                    if (operator.equals("+")) {

                        maxDp[start][end] = Math.max(maxDp[start][split] + maxDp[split + 1][end], maxDp[start][end]);
                        minDp[start][end] = Math.min(minDp[start][split] + minDp[split + 1][end], minDp[start][end]);
                    } else {
                        maxDp[start][end] = Math.max(maxDp[start][split] - minDp[split + 1][end], maxDp[start][end]);
                        minDp[start][end] = Math.min(minDp[start][split] - maxDp[split + 1][end], maxDp[start][end]);
                    }

                }



            }
        }



        return maxDp[0][n-1];






    }


}
