public class HW06_4110056028_3 extends MedianOfArrays {
    public static void main(String[] args) throws Exception {
        int[][] a = { { 1, 3, 10 }, { -1, 5, 7 }, { -2, 5, 12 } };
        int[][] b = { { 3 }, { -1, 5 }, { -2, 5, 12 } };
        HW06_4110056028_3 test = new HW06_4110056028_3();
        System.out.println(test.find_median(a));
        System.out.println(test.find_median(b));
    }

    @Override
    public double find_median(int[][] arrays) {
                
    }
}