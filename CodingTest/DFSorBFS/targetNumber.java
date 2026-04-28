package CodingTest.DFSorBFS;

class targetNumber {
    public static int sum = 0;
    public int solution(int[] numbers,int target) {


        DFS(0,0,numbers, target);

        return count;
    }

    static int count = 0;

    void DFS(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {// 끝까지 도달했는지 확인
            if (sum == target) { // 값이랑 같은 지확인
                count++;
            }
            return;
        }

        // + 선택
        DFS(idx + 1, sum + numbers[idx], numbers, target);

        // - 선택
        DFS(idx + 1, sum - numbers[idx], numbers, target);
    }
}
