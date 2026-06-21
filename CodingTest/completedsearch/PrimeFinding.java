package CodingTest.completedsearch;

import com.sun.jdi.Value;

import java.util.HashSet;
import java.util.Set;

public class PrimeFinding {

    static  int count =0;
    static boolean visited[];
    static Set<Integer> set;
    public int solution(String numbers) {
         set = new HashSet<>();
        // 1. 한자리 숫자가 적힌 종이 조각이 흩어져있슴
        // 2. 흩어진 종이 조각을 붙여 소수를 몇개 만들수있는지 알아내려함
        // 3. DFS

        String[] s = numbers.split("");

        visited = new boolean[s.length];
        //DFS로 풀자

        DFS("", s);

        return set.size();
    }


    void DFS(String current, String s[]) {

        if (!current.equals("")) {

            if (isPrime(Integer.parseInt(current))) {
                set.add(Integer.parseInt(current));
            }
        }




        for (int i = 0; i < s.length; i++) {

            if (visited[i] == false) {// 방문하지 않았던곳이면 true를 해서
                visited[i] = true;


                DFS( current + s[i], s);

                visited[i] = false;
            }


        }
    }










    boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }

        }

        return true;
    }

}
