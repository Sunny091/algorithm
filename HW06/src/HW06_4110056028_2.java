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
        int[] point = new int[arrays.length];
        if (length % 2 == 0) {
            int[] num = new int[(length / 2) + 1];
            int count = 0;
            for (int i = 0; i < num.length; i++) {
                int index = 0;
                int min = 99999999;
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
            return (num[num.length - 1] + num[num.length - 2]) / 2.0;
        } else {
            int[] num = new int[(length + 1) / 2];
            int count = 0;
            for (int i = 0; i < num.length; i++) {
                int index = 0;
                int min = 99999999;
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
            return num[num.length - 1];
        }
    }
}
