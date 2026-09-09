package CodingTest.Programer_2.DP;

public class reDDangEat {


    int solution(int[][] land) {

        // dp라는게 어떤선택을 하던  최적의 비용을 가져ㅇ가야한다고알음 그래서


        for (int i = 1; i < land.length; i++) {
            land[i][0] = Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] = Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] = Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] = Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }



        return Math.max( land[land.length-1][3],Math.max( land[land.length-1][2] , Math.max(land[land.length-1][0],land[land.length-1][1])));










    }


}
