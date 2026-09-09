package CodingTest.Programer_2.DP;

public class DangDDaEAT {
        int solution(int[][] land) {
            int n = land.length;

            for (int i = 1; i < n; i++) { // 모든것에 누적합을 구해가면서 하는거레  //각 열을선택했을때의 최대결과를 저장해야한데
                land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]); //  행방식으로 처리하는 건 맞았는데
                land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
                land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
                land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
            }

            return Math.max(
                    Math.max(land[n - 1][0], land[n - 1][1]),
                    Math.max(land[n - 1][2], land[n - 1][3])
            );
        }
}
