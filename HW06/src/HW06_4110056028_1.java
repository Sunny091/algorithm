public class HW06_4110056028_1 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_1 test = new HW06_4110056028_1();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    @Override
    public double find_median(int[][] arr) {
        int[] nums = flatten(arr);
        int n = nums.length;
        int k = n / 2;
        int left = 0, right = n - 1;
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) {
                if (n % 2 == 0) {
                    return (nums[k - 1] + nums[k]) / 2.0;
                } else {
                    return nums[k];
                }
            } else if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1.0; // should never reach here
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

    private static int partition(int[] nums, int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
