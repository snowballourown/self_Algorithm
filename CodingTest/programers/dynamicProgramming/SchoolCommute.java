package CodingTest.programers.dynamicProgramming;



class SchoolCommute {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;

        int[][] dp = new int[n + 1][m + 1];
        boolean[][] block = new boolean[n + 1][m + 1];


        for (int[] p : puddles) {
            block[p[1]][p[0]] = true;
        }


        dp[1][1] = 1;


        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (x == 1 && y == 1) continue;

                if (block[y][x]) {
                    dp[y][x] = 0;
                } else {
                    dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}