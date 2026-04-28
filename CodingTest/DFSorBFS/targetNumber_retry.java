package CodingTest.DFSorBFS;

class targetNumber_retry {

    public  static  int count =0;
    public int solution(int[] numbers,int target) {

        DFS(0, 0, numbers, target);


        return  count;
    }


    void DFS(int i, int sum, int[] numbers, int target) {
        if (i == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }


        DFS(i + 1, sum + numbers[i], numbers, target);
        DFS(i + 1, sum - numbers[i], numbers, target);



    }





}
