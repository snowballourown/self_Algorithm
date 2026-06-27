package CodingTest.programers.completedsearch.rePratice;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        //Dynamic_Programming이란 이전에 계산한걸 저장하여 여러번 반복되는 계산을 막아줌


        //  [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
        //  거쳐간 숫자의 최댓값을 return 	30


        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j <  i; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
            // triangle[3][0] += triangle[4][0], triangle[4][1] 큰거랑 합해서 들어가야겠다
            // triangle[3][1] += triangle[4][1], trangle[4][2]
            // triangle[3][2] += triangle[4][2], triangle[4][3]
            // triangle[3][3] += triangle[4][3], triangle[4][4]

            // triangle[2][0] += triangle[3][0] + triangle[3][1]
            // triangle[2][1] += triangle[3][1] + triangle[3][2]
            // triangle[2][2] += triangle[3][2] + triang;e[3][3]
        }





        return triangle[0][0];
    }

}
