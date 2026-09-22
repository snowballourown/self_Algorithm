package CodingTest.Programer_2.praticeProblem;

import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class JadenCaseString {
    public String solution(String s) {

    StringBuilder SB = new StringBuilder();
    boolean isFrist=true;


        for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == ' ') {
            isFrist = true;
            SB.append(" ");
        } else if (isFrist) {
            SB.append(Character.toUpperCase(c));
            isFrist = false;
        } else {
            SB.append(Character.toLowerCase(c));
        }
    }



        return SB.toString();



}


}
