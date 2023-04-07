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
        if (temp.length % 2 == 0) {
            return (temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2;
        } else {
            return temp[(temp.length - 1) / 2];
        }
    }
}