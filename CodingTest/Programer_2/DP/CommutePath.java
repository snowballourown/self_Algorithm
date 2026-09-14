package CodingTest.Programer_2.DP;

public class CommutePath {
    public int solution(int m, int n, int[][] puddles) {

        int MOD = 1000000007;
        // m, 가로, 세로
        int[][] number = new int[n+1][m+1];
        boolean[][] block = new boolean[n+1][m+1];

        number[1][1] = 1;

        for (int[] puddle : puddles) {
            block[puddle[1]][puddle[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1 || block[i][j]) {
                    continue;
                }

                number[i][j]  += (number[i-1][j] + number[i][j-1]) %MOD; ; // 1,4 문제발생인데 04, 1,3
            }
        }

        return number[n][m];
    }
}
