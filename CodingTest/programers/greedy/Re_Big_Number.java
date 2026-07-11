package CodingTest.programers.greedy;

public class Re_Big_Number {
    public String solution(String number, int k) {


        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < number.length(); i++) {


            char a = number.charAt(i);


            while (k > 0
                    && sb.length() > 0 // 길이를제야히
                    && sb.charAt(sb.length() - 1) < a
            ) {
                sb.deleteCharAt(sb.length() - 1); // 마지막 녀석을 제거함
                k--;
            }
            sb.append(a);
        }


        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();


    }
}
