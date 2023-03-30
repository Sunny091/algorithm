public class HW05_4110056028_2 extends littlebit {

    public static void main(String[] args) throws Exception {
        int[] A = { 0, 1, 3, 3, 5, 2 };
        int[] B = { 2, 5, 1, 6, 4, 8 };
        int[] C = { 1, 0, 2 };
        int[] D = { 1, 2, 2 };
        HW05_4110056028_1 test = new HW05_4110056028_1();
        System.out.println(test.l_bit(A));
        System.out.println(test.l_bit(B));
        System.out.println(test.l_bit(C));
        System.out.println(test.l_bit(D));
    }

    @Override
    public int l_bit(int[] A) {
        int result = 0, direction = 1, count = 2;
        if (A[1] > A[0]) {
            direction = 1;
        } else if (A[1] < A[0]) {
            direction = -1;
        } else {
            direction = 0;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i + 1] > A[i]) {
                switch (direction) {
                    case 1:
                        count++;
                        break;
                    case -1:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = -1;
                        break;
                    case 0:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = 0;
                        break;
                }
            } else if (A[i + 1] < A[i]) {
                switch (direction) {
                    case 1:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = 1;
                        break;
                    case -1:
                        count++;
                        break;
                    case 0:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = 0;
                        break;
                }
            } else {
                switch (direction) {
                    case 1:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = 1;
                        break;
                    case -1:
                        result += ((1 + count) * count / 2);
                        count = 1;
                        direction = -1;
                        break;
                    case 0:
                        count++;
                        break;
                }
            }
        }
        return result;
    }

}
