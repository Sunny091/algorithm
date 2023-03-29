public class HW02_4110056028_5 extends FourSum {

    static int threadNum = 8;
    volatile static int _count;
    int[] A;
    int limit;

    public static void main(String[] args) {
        // System.out.println("case4:");
        // HW02_4110056028_5 test4 = new HW02_4110056028_5();
        // int[] A = new Random().readData();
        // Stopwatch stopwatch = new Stopwatch();
        // System.out.println("FourSum is zero: "+test4.F_sum(A));
        // double time = stopwatch.elapsedTime();
        // System.out.println("elapsed time " + time);
    }

    @Override
    public int F_sum(int[] A) {
        this.A = A;
        this.merge_sort(this.A);
        // this.show(A);

        limit = this.binarySearch(A, 0, 0, this.A.length - 1);
        _count = 0;

        MultiThread[] mt = new MultiThread[threadNum];

        for (int tr = 0; tr < threadNum; tr++) {
            mt[tr] = new MultiThread(tr);
            mt[tr].start();
        }
        try {
            for (int tr = 0; tr < threadNum; tr++) {
                mt[tr].join();
            }
        } catch (InterruptedException e) {
        }
        return _count;
    }

    public void show(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
    }

    public int binarySearch(int[] A, int key, int l, int h) {
        if (key < A[l])
            return -1;
        if (key > A[h])
            return -1;
        if (key == A[l])
            return -1;
        if (key == A[h])
            return -1;
        int low = l, high = h;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (key < A[mid])
                high = mid;
            else if (key > A[mid])
                low = mid;
            else
                return mid;
        }
        return high;
    }

    public int binarySearch_left(int[] A, int key, int l, int h) {
        int low = l, high = h;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (key < A[mid])
                high = mid;
            else if (key > A[mid])
                low = mid;
            else
                return mid;
        }
        return high;
    }

    private void merge_sort(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length << 1; i = i << 1) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }

    class MultiThread extends Thread {

        int tr;

        public MultiThread(int tr) {
            this.tr = tr;
        }

        public void run() {
            int count = 0;
            int i_end = tr != 7 ? limit / threadNum * (tr + 1) : limit;
            for (int i = limit / (threadNum) * tr; i < i_end; i++) {
                for (int j = 0; j < A.length - 2; j++) {
                    int right = A.length - 1;
                    int left = binarySearch_left(A, -(A[i] + A[j] + A[right]), j, A.length - 1);

                    while (left < right) {
                        int sum = A[i] + A[j] + A[left] + A[right];
                        if (sum > 0) {
                            right--;
                        } else if (sum < 0) {
                            left++;
                        } else {
                            count++;
                            right--;
                            left++;
                        }
                    }
                }

            }

            _count += count;
        }
    }

}