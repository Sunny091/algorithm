public class HW07_4110056028_2 extends LLK {
    // public static void main(String[] args) {
    // int[][] star2 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
    // HW07_4110056028_2 test = new HW07_4110056028_2();
    // System.out.println(test.checkLLK(star2));
    // }

    @Override
    public boolean checkLLK(int[][] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                double slope = getSlope(array[i], array[j]);
                boolean collinear = true;
                for (int k = j + 1; k < array.length; k++) {
                    if (getSlope(array[i], array[k]) != slope) {
                        collinear = false;
                        break;
                    }
                }
                if (collinear) {
                    return true;
                }
            }
        }
        return false;
    }

    private static double getSlope(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
