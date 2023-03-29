public class HW01_4110056028_1 extends ArrayData {
    static int[] result = new int[2];

    public HW01_4110056028_1(int[] A) {
        this.A = A;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] < A[i + 1]) {
                if (A[i] < result[0]) {
                    result[0] = A[i];
                }
                if (A[i + 1] > result[1]) {
                    result[1] = A[i + 1];
                }
            } else {
                if (A[i + 1] < result[0]) {
                    result[0] = A[i + 1];
                }
                if (A[i] > result[1]) {
                    result[1] = A[i];
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
        return result[1];
    }

    @Override
    public int min() {
        return result[0];
    }
}
