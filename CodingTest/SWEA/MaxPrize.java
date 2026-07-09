package CodingTest.SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MaxPrize {
    static char[] numbers;
    static int swapCount;
    static int answer;
    static Set<String> visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            numbers = st.nextToken().toCharArray(); // string을 char배열로 받도록 내뱉는거임
            swapCount = Integer.parseInt(st.nextToken());

            answer = 0;
            visited = new HashSet<>();

            dfs(0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int depth) {
        String state = new String(numbers);


        if (visited.contains(depth + " " + state)) {   // depth가 지금까지 교환한 횟수  state 현재 상태숫자열
            return;             //visited를 set으로 설정해서 보유시 확인하지말고 바로 리턴
        }

        visited.add(depth + " " + state);           // 없다는거니까 insert해줌

        if (depth == swapCount) {     // 교환횟수에 도달했다는거니까 최대값으로 리턴
            answer = Math.max(answer, Integer.parseInt(state)); // 교환을 다하고난이후에 answer에 저장
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {   // 여기서 720가지 나오는거임 실제로  엄청 많이나오는데 컷이 되는거임
            for (int j = i + 1; j < numbers.length; j++) {
                swap(i, j);             //number배열에 i,j 교환
                dfs(depth + 1);
                swap(i, j);             //number배열에 j,i 교환하여 원상복구
            }
        }
    }

    static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    // 시간복잡도 계산하기 DFS이지만 방문처리까지 한것
    // 교환 횟수가 최대  0 ~ 10번 까지 -> 11 * 가능한 숫자 배열들(720 가지) * 각상태에서 교환을 하는데 (숫자배열 6자리수가 최대 그리고 2개선택후 교환)
    // 11 *  720 * 15
    // 여기서는 그냥 DFS로 해주고 컷하는 과정이 중요하겠구만



    // 여기선 나는 greedy로 풀다가 막힘  기회가 하나일떈 풀수있었는데 바꿀기회가 2개이상부턴 못풀겠음
    // 자리를 바꿀 수 있는 기회 11번 6개의 자리중에 2개를 선택해서 바꾸는 경우
    // 15가지 이어떤숫자가올지모르니까 경우의수를 720가지로 잡아서 이렇게 계산함


}
