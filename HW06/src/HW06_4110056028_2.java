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
        int length = 0, n = arrays.length;
        for (int i = 0; i < n; i++) {
            length += arrays[i].length;
        }
        int[] point = new int[n];
        if (length % 2 == 0) {
            int[] num = new int[(length / 2) + 1];
            int count = 0;
            for (int i = 0; i < (length / 2) + 1; i++) {
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < arrays.length; j++) {
                    if (point[j] == arrays[j].length) {
                        continue;
                    }
                    if (arrays[j][point[j]] < min) {
                        min = arrays[j][point[j]];
                        index = j;
                    }
                }
                num[count++] = arrays[index][point[index]];
                point[index]++;
            }
            return (num[(length / 2)] + num[(length / 2) - 1]) / 2.0;
        } else {
            int[] num = new int[(length + 1) / 2];
            int count = 0;
            for (int i = 0; i < (length + 1) / 2; i++) {
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (point[j] == arrays[j].length) {
                        continue;
                    }
                    if (arrays[j][point[j]] < min) {
                        min = arrays[j][point[j]];
                        index = j;
                    }
                }
                num[count++] = arrays[index][point[index]];
                point[index]++;
            }
            return num[(length + 1) / 2 - 1];
        }
    }
}
