public class HW06_4110056028_3 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_3 test = new HW06_4110056028_3();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    @Override
    public double find_median(int[][] arr) {
        int[] nums = flatten(arr);
        mergeSort(nums);
        int n = nums.length;
        if (n % 2 == 0) {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        } else {
            return nums[n / 2];
        }
    }

    private static int[] flatten(int[][] arr) {
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i].length;
        }
        int[] result = new int[total];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int[] row = arr[i];
            int m = row.length;
            for (int j = 0; j < m; j++) {
                result[k++] = row[j];
            }
        }
        return result;
    }

    private static void mergeSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int[] left = new int[n / 2];
        int[] right = new int[n - n / 2];
        for (int i = 0; i < n / 2; i++) {
            left[i] = nums[i];
        }
        for (int i = n / 2; i < n; i++) {
            right[i - n / 2] = nums[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right) {
        int n = nums.length;
        int m = left.length;
        int k = 0, i = 0, j = 0;
        while (i < m && j < right.length) {
            if (left[i] < right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }
        while (i < m) {
            nums[k++] = left[i++];
        }
        while (j < right.length) {
            nums[k++] = right[j++];
        }
    }

}