public class HW01_4110056028_4 extends ArrayData {
    static int max = -99999;
    static int min = 99999;

    public HW01_4110056028_4(int[] A) {
        this.A = A;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] < A[i + 1]) {
                if (A[i] < min) {
                    min = A[i];
                }
                if (A[i + 1] > max) {
                    max = A[i + 1];
                }
            } else {
                if (A[i + 1] < min) {
                    min = A[i + 1];
                }
                if (A[i] > max) {
                    max = A[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = { -100, 5, 2222, 45, 666, 90, 87, -55, 123, -88888 };
        HW01_4110056028_2 test = new HW01_4110056028_2(A);
        System.out.println("max: " + test.max());
        System.out.println("min: " + test.min());
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
