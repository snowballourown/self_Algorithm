//package CodingTest.programers.binarySearch;
//
//import java.util.Arrays;
//public class importTest {
//
//    class Solution_2{
//
//        public long solution(int n, int[] times) {
//
//
//            Arrays.sort(times);
//
//            long answer = 0;
//
//            long left  = 1;
//
//            long right = (long) times[times.length - 1] *n; // 느린심사위원이 다처리하는경우
//            while (left <= right) {
//
//                long mid = (left + right) / 2;
//
//                long count =0;
//
//
//                for (int time : times) {
//                    count += mid / time;
//                }
//
//
//                if (count >= n) {
//                    answer = mid;
//                    right = mid-1;
//                } else {
//                    left = mid + 1;
//                }
//
//                }
//
//            return answer;
//            }
//
//
//
//
//
//        }
//    }
//
//    // 너무 오레걸림
//    class Solution_1 {
//
//        class Node implements Comparable<Node> {
//            int sum;
//            int time;
//
//            @Override
//            public int compareTo(Node o) {
//                if (this.sum == o.sum) {
//                    return this.time - o.time;
//                }
//                return this.sum - o.sum;
//            }
//        }
//
//        public long solution(int n, int[] times) {
//            Node[] nodes = new Node[times.length];
//
//            for (int i = 0; i < times.length; i++) {
//                nodes[i] = new Node();
//                nodes[i].sum = 0;
//                nodes[i].time = times[i];
//            }
//
//            int count = 0;
//
//            while (n > count) {
//                Arrays.sort(nodes);
//                nodes[0].sum += nodes[0].time;
//                count++;
//            }
//
//            long answer = 0;
//            for (Node node : nodes) {
//                answer = Math.max(answer, node.sum);
//            }
//
//            return answer;
//        }
//    }
//
//
