package CodingTest.programers.dynamicProgramming;

public class reSchoolCommute {
    public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int MOD =1000000007;

        int[][] dp = new int[n + 1][m + 1];// 이렇게 해주는이유는 현실에서는 x,y로 쓰지만  행렬에서는 y,x로 쓰기에 킹정해줘야함
        boolean[][] block = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) { // 웅덩이들 삽입
            block[puddle[1]][puddle[0]] = true;
        }

        dp[1][1] = 1;


        for (int y = 1; y <= n; y++)
        {
            for (int x = 1; x <= m; x++)
            {
                if (x== 1 && y== 1) continue; // 처음은 pass 이미 값이 삽입되어있어서 + 다른값으로 바뀌면안되서

                if (block[y][x]) { //연못이 있을경우 그냥 0으로 철;
                    dp[y][x] = 0;
                } else {
                    dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
        }
}
