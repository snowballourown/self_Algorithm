package CodingTest.Programer_2.DP;

public class integerCalculate {

    public int solution(String[] arr) {
        int n = (arr.length + 1) /2;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];


        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(arr[i * 2]);

            maxDp[i][i] = value;
            minDp[i][i] = value;
        }


        for (int len = 2; len <= n; len++) { // 길이를 2부터 n까지

            for (int start = 0; start + len -1 < n; start++) { // 길이의 마지막 부분이 마지막 숫자에 도달하면 종료
                int end = start + len -1;


                maxDp[start][end] = Integer.MIN_VALUE; // 계산할 값을 미리 초기화
                minDp[start][end] = Integer.MAX_VALUE; //  계산할 값을 미리 초기화

                for (int split = start; split <end ; split++) { // 구간 쪼개기

                    String operator = arr[split * 2 + 1]; // 쪼갠위치에 연산자 찾기

                    if (operator.equals("+")) {
                        // 최소 최대를 구하는이유 최대는 더할떄 덧셈에서 최대로 더하기위해서고
                        // 최소는 뺼떄 조금만 뺄려고함 그래서 최대를 만들려고

                        int max = maxDp[start][split]
                                + maxDp[split + 1][end];

                        int min = minDp[start][split]
                                + minDp[split + 1][end];

                        maxDp[start][end] =
                                Math.max(maxDp[start][end], max);

                        minDp[start][end] =
                                Math.min(minDp[start][end], min);
                    } else {

                        int max =
                                maxDp[start][split]
                                        - minDp[split + 1][end];

                        int min =
                                minDp[start][split]
                                        - maxDp[split + 1][end];

                        maxDp[start][end] =
                                Math.max(maxDp[start][end], max);

                        minDp[start][end] =
                                Math.min(minDp[start][end], min);
                    }



                }

            }




        }
        return maxDp[0][n - 1];
    }

}
