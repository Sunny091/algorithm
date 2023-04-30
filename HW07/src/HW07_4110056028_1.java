public class HW07_4110056028_1 extends LLK {

    @Override
    public boolean checkLLK(int[][] array) {
        if (array.length < 3) {
            return true;
        }
        sortPoints(array, 0, array.length - 1);

        double slope = getSlope(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            double currSlope = getSlope(array[0], array[i]);
            if (currSlope != slope) {
                return false;
            }
        }
        return true;
    }

    public void sortPoints(int[][] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(array, left, right);
        sortPoints(array, left, mid - 1);
        sortPoints(array, mid + 1, right);
    }

    public int partition(int[][] array, int left, int right) {
        int[] pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparePoints(array[j], pivot) <= 0) {
                i++;
                swapPoints(array, i, j);
            }
        }
        swapPoints(array, i + 1, right);
        return i + 1;
    }

    public int comparePoints(int[] p1, int[] p2) {
        if (p1[0] != p2[0]) {
            return p1[0] - p2[0];
        } else {
            return p1[1] - p2[1];
        }
    }

    public void swapPoints(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public double getSlope(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (double) (p2[1] - p1[1]) / (double) (p2[0] - p1[0]);
        }
    }
}
