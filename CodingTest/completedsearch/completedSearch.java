package CodingTest.completedsearch;

import java.util.Map;

public class completedSearch {

    // 최대값을 기록함
    // 가로길이 와 세로 길이를 비교해서 최대값을 넣어버림
    // 그리고 그중 최대값을 뽑아서 x
    public int solution(int[][] sizes) {

        int maxWidth = 0;
        int maxHeight = 0;


        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]); // 가로 세로중에 큰녀석을
            int h = Math.min(size[0], size[1]); // 작은녀석을


            maxWidth = Math.max(maxWidth, w); // 기존의 녀석보다 큰녀석
            maxHeight = Math.max(maxWidth, h); // 작은녀석들중에 큰값
        }


        return maxWidth * maxHeight;
    }


}
