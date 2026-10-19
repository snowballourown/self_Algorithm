package CodingTest.Programer_2.praticeProblem;

public class tipStown {


    public int solution(int n, int a, int b)
    {
        int answer = 1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.



        for (int i = 0; i < n / 2; i++) {


            if (Math.abs(a - b) == 1) {
                if (a % 2 == 0 && ((b + 1) / 2 == a / 2)) {
                    return answer;
                } else if (b % 2 == 0 && ((a + 1) / 2 == b / 2)){
                    return answer;
                }
            } // a,b 가 같은 상대인지 검증
             // 아닐경우는 라운드 넘김


            if (a % 2 == 0) {
                a = a / 2;
            } else{
                a = (a + 1) / 2;

            }



            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = (b +1)/ 2;
            }






answer++;

        }

        return answer;
    }
}
