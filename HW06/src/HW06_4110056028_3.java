public class HW06_4110056028_3 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_2 test = new HW06_4110056028_2();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    @Override
    public double find_median(int[][] arrays) {
        int[] temp = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length % 2 == 0) {
                temp[i] = arrays[i][arrays[i].length / 2 - 1] + arrays[i][arrays[i].length / 2] / 2;
            } else {
                temp[i] = arrays[i][(arrays[i].length - 1) / 2];
            }
        }
        quickSort(temp, 0, temp.length - 1);
        if (temp.length % 2 == 0) {
            return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2.0;
        } else {
            return temp[(temp.length - 1) / 2];
        }
    }

    private void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
}