class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // delay
        // 노란색 + 갈색 갯수를 주는데
        // 노란색이 가운데이고 그주변은 갈색이다
        // 근데 가로새로 길이를 배열로 달라?


        //자 yellow의 개스수로 brown의 개숫를 추정하는거임

        //처음단계에서는 yellow를 1열로 새우고
        //필요한 brown 개수를 뽑아냄 = yellow의 행의 크기 *2 + 열의 크기 *2 + 꼭지점 4개
        //만약 더 짝다? yellow의 열을 2열로 만들어서 높이를 줄임
        //다시 반복
        //brown의 갯수가 같아지는순간 배열의 크기를 재면됨

        int Y = yellow;
        int X = 1;


        int i = 1;
        while (true) {

            if (yellow % i == 0) { // 약수로 만해야하는이유가 딱덜어지지않으면 나머지가 없어지니 값이 오류남
                Y = ( yellow / i); // 딱 떨어지겠지?
                X =  i;
                if (brown == (Y * 2 + X * 2 + 4) ){ // brown 크기가 같아질때 의 가로세로 구해서 내뱉으면됨
                    int max = Math.max(X+2, Y+2);
                    int min = Math.min(X+2, Y+2);
                    return new int[]{ max, min};
                }
            }


            i++;

        }
    }
}