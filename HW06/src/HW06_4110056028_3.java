public class HW06_4110056028_3 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_2 test = new HW06_4110056028_2();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    int m, n;

    @Override
    public double find_median(int[][] arrays) {
        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            k += arrays[i].length;
        }
        m = arrays.length;
        n = arrays[0].length; // For general, the matrix need not be a square
        int left = arrays[0][0], right = arrays[m - 1][n - 1], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(arrays, mid) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else
                left = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }

    int countLessOrEqual(int[][] arrays, int x) {
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && arrays[r][c] > x)
                --c; // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
}