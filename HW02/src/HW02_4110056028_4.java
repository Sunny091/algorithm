public class HW02_4110056028_4 extends FourSum{
    
    static int threadnum = 8;
    static int[] count = new int[threadnum];
    private int[] A;

    class threads extends Thread{

        public threads(int[] A,int length,int index) {
            int sum, limit;
            if (index == 7) {
                limit = length;
            }else{
                limit = (length/threadnum)*(index+1);
            }
            for (int i = (length/threadnum)*index; i < limit; i++) {
                for (int j = i + 1; j < length - 2; j++) {
                    int front = 1;
                    int behind = -1;
                    sum = A[i] + A[j];
                    while ((j+front)<(A.length+behind)) {
                        if (A[j + front] + A[A.length+behind] == -sum) {
                            count[index]++;
                            front++;
                            behind--;
                        } else if (A[j + front] + A[A.length+behind] > -sum) {
                            behind--;
                        } else if(A[j + front] + A[A.length+behind] < -sum){
                            front++;
                        }
                    }
                }
            }
        }

    }

    @Override
    public int F_sum(int[] A) {
        for (int i = 0; i < threadnum; i++) {
            count[i] = 0;
        }
        this.A = A;
        mergeSort(A, A.length);
        threads[] process = new threads[threadnum];
        for (int i = 0; i < threadnum; i++) {
            process[i] = new threads(this.A, A.length, i);
        }
        for (int i = 0; i < threadnum; i++) {
            try {
                process[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i < threadnum; i++) {
            count[0] += count[i];
        }
        return count[0];
    }

    public void run(){

    }
    
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
 
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
               a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) throws Exception {
        int[] A = { -1, 1, 0, 2, -4, 4, 8, -3 };
        HW02_4110056028_4 test = new HW02_4110056028_4();
        System.out.println("result: " + test.F_sum(A));
    }

}
