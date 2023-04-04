public class HW06_4110056028_2 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_2 test = new HW06_4110056028_2();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    @Override
    public double find_median(int[][] arrays) {
        int length = 0;
        for (int i = 0; i < arrays.length; i++) {
            length += arrays[i].length;
        }
        int[] num = new int[length];
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                num[count++] = arrays[i][j];
            }
        }
        if (length % 2 == 0) {
            selectionSort(num, length / 2);
            for (int i : num) {
                System.out.print(i + " ");
            }
            return (num[num.length / 2 - 1] + num[num.length / 2]) / 2;
        } else {
            selectionSort(num, (length - 1) / 2);
            for (int i : num) {
                System.out.print(i + " ");
            }
            return num[(length - 1) / 2];
        }
    }

    private void selectionSort(int[] arr, int end) {
        for (int i = 0; i <= end; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

}
