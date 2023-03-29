public class HW01_4110056028_3 extends ArrayData {
    public HW01_4110056028_3(int[] A) {
        this.A = A;
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
        int i = 0, max = -99999;
        while (i < A.length - 1) {
            if (this.A[i] > this.A[i + 1]) {
                if (this.A[i] > max) {
                    max = this.A[i];
                }
            } else {
                if (this.A[i + 1] > max) {
                    max = this.A[i + 1];
                }
            }
            i += 2;
        }
        return max;
    }

    @Override
    public int min() {
        int i = 0, min = 99999;
        while (i < A.length - 1) {
            if (this.A[i] < this.A[i + 1]) {
                if (this.A[i] < min) {
                    min = this.A[i];
                }
            } else {
                if (this.A[i + 1] < min) {
                    min = this.A[i + 1];
                }
            }
            i += 2;
        }
        return min;
    }
}
