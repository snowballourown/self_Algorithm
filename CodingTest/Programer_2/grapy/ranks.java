package CodingTest.Programer_2.grapy;

public class ranks {

    //플로이드 워셜 알고리즘
    public int solution(int n, int[][] results) {

        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            win[result[0]][result[1]] = true;
        }
        int answer =0;
        // 반대 편도 표시
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {

                    if (win[a][k]  && win[k][b]) { // 경유 지점끼리 연결을 하여 목표하는곳까지 표시 및 기록
                        win[a][b] = true;
                    }

                }
            }
        }

        for (int a = 1; a <= n; a++) {

            int count = 0;

            for (int b = 1; b <= n; b++) {
                if (a == b) {
                    continue;
                }

                if (win[a][b] || win[b][a]) {
                    count++; // 이러는이유는 두개의 숫자사이에 결고가값이 나왔기에 이렇게 하는것
                }
            }

            if (count == n - 1) {
                answer++;
            }

        }

    return answer;
}


}
