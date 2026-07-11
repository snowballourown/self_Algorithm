//package CodingTest.programers.completedsearch;
//import java.util.*;
//
//class Solution {
//
//    ArrayList<Integer>[] graph; // 배열마다 list가 있는거임
//    boolean[] visited;
//
//    public int solution(int n, int[][] wires) {
//
//        int answer = Integer.MAX_VALUE;
//
//        // 그래프 생성
//        graph = new ArrayList[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // 양방향 연결
//        for (int[] wire : wires) {
//            int a = wire[0];
//            int b = wire[1];
//
//            graph[a].add(b);
//            graph[b].add(a);
//        }
//
//        // 전선 하나씩 끊기
//        for (int[] wire : wires) {
//
//            visited = new boolean[n + 1];
//
//            int a = wire[0];
//            int b = wire[1];
//
//            // a-b 연결 끊은 상태로 DFS
//            int count = dfs(a, a, b); // 현재값, a,b를 끊은 상태라고 가정하고 넣어버림
//
//            int other = n - count; // 나머지는 연결되어있따고 가정
//
//            answer = Math.min(answer, Math.abs(count - other)); // 차이가작은녀석을 선택
//        }
//
//        return answer;
//    }
//
//    int dfs(int current, int cutA, int cutB) {
//
//        visited[current] = true; // 현재 값
//
//        int count = 1;//
//
//        for (int next : graph[current]) {
//            // 이거 배열안에있는 리스트에서 숫자를 꺼내는 거임
//
//            // 끊은 전선 무시
//            if ((current == cutA && next == cutB) || (current == cutB && next == cutA)) {
//                continue; } //처음 짜르고 시작했던 애들이 나오면 그냥 패스하라는것 처음에 짜르고시작했으니까
//
//            if (!visited[next]) { // 방문하지않은녀석들을 넣어서 카운트
//                count += dfs(next, cutA, cutB); }
//
//        }
//
//        return count;
//    }
//}