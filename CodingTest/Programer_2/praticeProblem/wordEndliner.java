package CodingTest.Programer_2.praticeProblem;

import java.util.HashMap;
import java.util.HashSet;

public class wordEndliner {
    public int[] solution(int n, String[] words) {


        HashSet<String> map = new HashSet<>();


        for (int i = 0; i < words.length; i++) {


            boolean duplicated = map.contains(words[i]);


            boolean wrong = i > 0 && words[i - 1].charAt(words[i].length() - 1)
                    != words[i].charAt(0);

            if (wrong || duplicated) {
                int number = i %n + 1;
                int turn = i /n + 1;
                return new int[]{number, turn};
            }


            map.add(words[i]);
        }


        return new int[]{0, 0};




    }
}
