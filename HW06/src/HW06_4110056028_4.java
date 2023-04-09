public class HW06_4110056028_4 extends MedianOfArrays{
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_4 test = new HW06_4110056028_4();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }
    @Override
    public double find_median(int[][] arr) {
        int total = 0;
        for (int[] row : arr) {
            total += row.length;
        }
        int[] nums = new int[total];
        int idx = 0;
        for (int[] row : arr) {
            for (int num : row) {
                nums[idx++] = num;
            }
        }
        mergeSort(nums, 0, total - 1);
        int mid = total / 2;
        if (total % 2 == 0) {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        } else {
            return nums[mid];
        }
    }
    
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
    
}
