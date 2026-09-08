package CodingTest.SWEA;

import java.util.ArrayList;
import java.util.List;

public class decreas_minMumKAKAOBLINDRECRUITMENT {

    // tree[팀장] = 그 팀장의 직속 부하 목록
    // 예: tree[1] = [2, 3] 이면 1번 직원의 직속 부하가 2번, 3번이라는 뜻
    List<Integer>[] tree;

    // 각 직원의 매출액
    // 직원 번호는 1번부터지만, sales 배열은 0번부터 시작함
    // 그래서 n번 직원의 매출은 sales[n - 1]
    int[] sales;

    // dp[직원번호][0] = 이 직원이 참석하지 않을 때, 이 직원 아래 조직의 최소 비용
    // dp[직원번호][1] = 이 직원이 참석할 때, 이 직원 아래 조직의 최소 비용
    int[][] dp;

    public int solution(int[] sales, int[][] links) {
        // 전역 변수에 저장해서 dfs 함수에서도 쓸 수 있게 함
        this.sales = sales;

        // 직원 수
        int n = sales.length;

        // 직원 번호가 1번부터 시작하므로 배열 크기를 n + 1로 잡음
        // 0번 인덱스는 사용하지 않음
        tree = new ArrayList[n + 1];

        // 각 직원마다 [불참, 참석] 두 가지 경우의 최소 비용을 저장
        dp = new int[n + 1][2]; // 각 디피에 최소 비용저장

        // 각 직원의 부하 목록을 저장할 ArrayList 생성
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // links는 [팀장, 부하] 형태
        // 예: [1, 3]이면 1번 직원의 직속 부하가 3번이라는 뜻
        for (int[] link : links) {
            int parent = link[0]; // 팀장
            int child = link[1];  // 직속 부하

            // 팀장의 부하 목록에 child 추가
            tree[parent].add(child);
        }

        // 1번 직원이 전체 조직의 루트라고 문제에서 주어짐
        // 1번부터 아래로 내려가며 dp 값을 채움
        dfs(1);

        // 전체 조직 기준:
        // 1번 직원이 참석하는 경우와 참석하지 않는 경우 중 더 작은 값이 정답
        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int current) {
        // current 직원이 참석하지 않으면, current 본인의 비용은 0
        dp[current][0] = 0;

        // current 직원이 참석하면, current 본인의 매출액만큼 비용 발생
        // 직원 번호 current는 1번부터 시작하지만 sales는 0번부터 시작하므로 current - 1
        dp[current][1] = sales[current - 1]; // 해당값의 매출액

        // 직속 부하가 없으면 이 직원은 말단 직원
        // 더 계산할 자식 조직이 없으므로 그대로 종료
        if (tree[current].isEmpty()) {
            return; // 없으니까 일단 DP에 저장해놓는것임
        }

        // current가 참석하지 않는 경우,
        // current의 팀에서는 직속 부하 중 최소 한 명은 반드시 참석해야 함
        // 그때 추가로 가장 적게 드는 비용을 저장하는 변수
        int extraCost = Integer.MAX_VALUE;

        // 자식들 중 이미 참석하는 쪽이 더 싸서 선택된 사람이 있는지 확인
        // current가 불참할 때는 자식 중 최소 한 명이 참석해야 하므로 이 정보가 필요함
        boolean hasAttendee = false;

        // current의 직속 부하들을 하나씩 확인
        for (int child : tree[current]) {
            // 먼저 child 아래 조직의 dp 값을 계산
            // 아래에서부터 계산해야 부모가 자식의 결과를 사용할 수 있음
            dfs(child); // 자식들 먼저 설정

            // child가 참석하지 않는 경우가 더 싸다면
            if (dp[child][0] < dp[child][1]) {   // 마지막 집합 점장 무조건이지 왜냐하면 비교 값이 ㅇ없으니까>?
                // current가 참석하지 않는 경우:
                // 일단 child도 참석하지 않는 쪽을 선택
                dp[current][0] += dp[child][0];

                // current가 참석하는 경우:
                // current가 이미 참석했으므로 child는 참석 안 해도 됨
                // 그래서 더 싼 쪽인 child 불참을 선택
                dp[current][1] += dp[child][0];

                // 하지만 current가 불참하면,
                // current 팀에는 누군가 한 명은 참석해야 함
                // 지금 child는 불참으로 골랐으니, 나중에 참석으로 바꿀 수도 있음
                // 그때 추가로 드는 비용 = child 참석 비용 - child 불참 비용
                extraCost = Math.min(extraCost, dp[child][1] - dp[child][0]);  // 여기서 가장 작은값들을 색출해내눈 과정임  오로지 그해당값만 색출하기위해서 빼는듯? 일단ㅂ ㅗ자
            } else {
                // child가 참석하는 경우가 더 싸거나 같다면

                // current가 참석하지 않는 경우:
                // child 참석을 고르면 current 팀 조건도 만족됨
                dp[current][0] += dp[child][1];

                // current가 참석하는 경우:
                // 그래도 child 쪽은 참석하는 게 더 싸거나 같으므로 child 참석 선택
                dp[current][1] += dp[child][1];

                // current가 불참하더라도 child가 참석하므로
                // current 팀에서 참석자가 최소 한 명 존재함
                hasAttendee = true;
            }
        }

        // current가 참석하지 않았는데,
        // 직속 부하들 중 아무도 참석하지 않는 선택만 골라진 경우
        if (!hasAttendee) {
            // 팀 조건을 만족시키기 위해 부하 중 한 명을 참석으로 바꿔야 함
            // 그중 추가 비용이 가장 작은 사람을 선택
            dp[current][0] += extraCost;
        }
    }
}