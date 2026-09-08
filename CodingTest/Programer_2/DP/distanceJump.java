package CodingTest.Programer_2.DP;

public class distanceJump { //멀리뛰기
    public long solution(int n) {
        long answer = 0;
        // 효진이는 1칸~2칸 뛰기 가능

        // 5칸이면 뭐 1,1,1,1   1,2,1   2,2


        long[] dp = new long[n + 1];

        if (n >= 2) {
            dp[2] = 2;
        }


        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }


        return dp[n];
    }
}
