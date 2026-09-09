package CodingTest.Programer_2.DP;

public class IntegerTriangle {


    public int solution(int[][] triangle) {


        for (int i = triangle.length-1 ; i > 0; i--) {  // 행
            for (int j = 0  ; j < triangle[i-1].length ; j--) { // 열 ?
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }



        return triangle[0][0];
    }






}
