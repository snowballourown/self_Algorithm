package CodingTest.programers.sort;


public class H_index {


    public int solution(int[] citations) {


        //  논문 n편중 h번 이상 인용된
        //  논문이 h편이 이상이고 나머지가 h번 이하로 인용되었다면
        //  h의 최대값이  과학자 =  H-index

        // 배열중에 0보다 큰녀석을 을세고
        // 비교해가면서 일정이상인녀석의 개숫랑 일정이상의 숫자랑 같아지고
        // 나머지 의갯수가 일정 숫자보다 작으면 h-index가 된다
        int a = 0;

        for (int citation : citations) {
            a = Math.max(citation, a);
        }

        for (int i = 0; i < a; i++) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= i) {
                    count++;
                }
            }
            if (i >= count && citations.length - i <= i) {

                return count;
            }
        }

            return -1;
    }

}


