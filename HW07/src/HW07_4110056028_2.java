public class HW07_4110056028_2 extends LLK {
    public static void main(String[] args) throws Exception {
        int[][] star1 = { { 1, 2 }, { 1, 3 }, { 1, 4 } };
        int[][] star2 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
        HW07_4110056028_2 test = new HW07_4110056028_2();
        System.out.println(test.checkLLK(star1));
        System.out.println(test.checkLLK(star2));
    }

    @Override
    public boolean checkLLK(int[][] array) {
        if (array.length < 3) {
            return false;
        }

        // �ϥΦۦ��{���ֳt�Ƨǹ�P�P�y�Ы���x�b���жi��Ƨ�
        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length - 2; i++) {
            int[] star1 = array[i];
            int[] star2 = array[i + 1];
            int[] star3 = array[i + 2];

            // �p��T�I�������ײv
            int deltaX1 = star2[0] - star1[0];
            int deltaY1 = star2[1] - star1[1];

            int deltaX2 = star3[0] - star1[0];
            int deltaY2 = star3[1] - star1[1];

            // �ˬd�ײv�O�_�۵�
            if (deltaX1 * deltaY2 == deltaX2 * deltaY1) {
                return true;
            }
        }

        return false;
    }

    // �ۦ��{���ֳt�Ƨ�
    public static void quickSort(int[][] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // �ֳt�ƧǪ����Ψ��
    public static int partition(int[][] array, int low, int high) {
        int[] pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j][0] < pivot[0]) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    // �洫��Ӥ�������m
    public static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
