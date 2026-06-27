package CodingTest.programers.dynamicProgramming;


import java.util.*;


public class N_expression_pratice {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> dp = new ArrayList<>();


        for (int i = 0; i <= 8; i++) { // 각 리스트 set을 설정해놓는거임 각위치에  그리고 8개가 한계라고했으니 이렇게 설정
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) { // 5,55,55
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            // 리스트들중에서 하나의 set을 뽑아서 추가하는 방식  그방식에서
            // String메소드를 활용해서 i번 반복해서 5, 55, 555 이렇게 만들어지게 함


            // 사칙연산 계산하기


            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {

                        dp.get(i).add(a * b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a + b);
                        if (b != 0) dp.get(i).add(a / b);
                        if (a != 0) dp.get(i).add(b / a);

                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }


        }
        return -1;
    }
}
