package CodingTest.DFSorBFS;

class targetNumber {
    static int count = 0 ;
    static boolean visited[];
    public int solution(int[] numbers, int target) {
        // 순서, 기억해야되는게 있으니 DFS를 쓰겠음

        visited = new boolean[numbers.length];




        DFS(numbers, target, 0, 0);


        return count;
    }


    void DFS(int[] number, int target, int current, int sum) {
        if (current == number.length) {
            if (sum == target) {
                count++;
            }
            return;
        }


        DFS(number, target, current + 1, sum + number[current]);

        DFS(number, target, current + 1, sum - number[current]);





    }
}
