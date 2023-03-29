public class HW02_4110056028_1 extends FourSum {

    public static void main(String[] args) throws Exception {
        // int[] A = { -1, 1, 1, 2, -4, 4, 8, -3 };
        // HW02_4110056028_1 test = new HW02_4110056028_1(A);
        // System.out.println("result: " + test.F_sum(A));
    }

    @Override
    public int F_sum(int[] A) {
        int low = 0;
        int high = A.length - 1;
        quicksort(A, low, high); // ?��小�?��?�大
        int sum;
        int count = 0; // 答�??
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length - 1; j++) { // ????��??�數???(sum)
                int front = 1; // 左�?��??index
                int behind = -1; // ?��??��??index
                sum = A[i] + A[j];
                while ((j + front) < (A.length + behind)) { // 左右index?��?��交�??
                    if (A[j + front] + A[A.length + behind] == -sum) { // ?��?��??��?�數字�?�是?��??�零
                        count++;
                        front++; // 左index??�右�?
                        behind--; // ?��index??�左�?
                    } else if (A[j + front] + A[A.length + behind] > -sum) { // ??�數???太大
                        behind--; // �??��??��?��??
                    } else if (A[j + front] + A[A.length + behind] < -sum) { // ??�數???太�??
                        front++; // �??��??��?��??
                    }
                }
            }
        }
        return count;
    }

    static void quicksort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int temp;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
