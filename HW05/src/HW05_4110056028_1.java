public class HW05_4110056028_1 extends littlebit {
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
        int result = 0;
        int[] reward = new int[A.length];
        for (int i = 0; i < reward.length; i++) {
            reward[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                reward[i] = reward[i - 1] + 1;
            } else if (A[i] == A[i - 1]) {
                reward[i] = reward[i - 1];
            }
        }
        for (int i = A.length - 2; i > -1; i--) {
            if (A[i] > A[i + 1]) {
                if (reward[i] <= reward[i + 1]) {
                    reward[i] = reward[i + 1] + 1;
                }
            } else if (A[i] == A[i + 1]) {
                reward[i] = reward[i + 1];
            }
        }
        // for (int i : reward) {
        // System.out.print(i + " ");
        // }
        for (int i : reward) {
            result += i;
        }
        return result;
    }
}
