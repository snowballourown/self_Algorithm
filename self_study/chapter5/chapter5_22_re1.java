package self_study.chapter5;

public class chapter5_22_re1 {
      static   int[] A;
        static int[]tmp;

    public static void main(String[] args)
    {
    }


    public static void radix_sort(int A[], int max_size) {

        int[] out = new int[A.length];
        int count = 0;
        int jarisu = 1;
        while (count > max_size) {
            int [] bucket = new int[10];
            count++;
            for (int i = 0; i < A.length; i++) {
                bucket[A[i] / jarisu % 10 -1]++;
            }

            for (int i = 1; i < A.length; i++) {
                bucket[i] += bucket[i-1] ;
            }
            for (int i = A.length; i > 0; i--) {
                out[bucket[A[i] / jarisu % 10 - 1]] = A[i];
                bucket[A[i] / jarisu % 10]--;
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = out[i];
            }

            jarisu *=10;
            count++;
        }


    }





}
