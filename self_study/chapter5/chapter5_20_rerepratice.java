package self_study.chapter5;

public class chapter5_20_rerepratice {

    static  int [ ] A, tmp;
    public static void main(String[] args) {}


    public void merge_sort(int s, int e) {
        if ( (e - s) < 1)
        {return;
        }

        int m = s + (e - s) / 2;

        merge_sort(s, m);
        merge_sort(m+1, e);
        for (int i = s; i < e; i++) {
            tmp[i] = A[i];
        }
        int index1 = s;
        int index2 = m+1;
        int k  = s;

        while (index1 <= m && index2 <= e) {

            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            A[k] = tmp[index1];
            index1++;
            k++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            index2++;
            k++;
        }
    }
}
