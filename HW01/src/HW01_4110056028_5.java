public class HW01_4110056028_5 extends ArrayData {
    static int max = -99999;
    static int min = 99999;

    public HW01_4110056028_5(int[] A) {
        this.A = A;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
    }

    public static void main(String[] args) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        int[] A = { -100, 5, 2222, 45, 666, 90, 87, -55, 123, -88888 };
        HW01_4110056028_2 test = new HW01_4110056028_2(A);
        System.out.println("max: " + test.max());
        System.out.println("min: " + test.min());
        time_end = System.currentTimeMillis();
        System.out.println("time: " + (time_start - time_end) / 1000 + " s");
    }

    @Override
    public int max() {
        return max;
    }

    @Override
    public int min() {
        return min;
    }
}
