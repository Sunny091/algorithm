public class HW04_4110056028_1 extends doge_coin {
    public static void main(String[] args) {
        int[] A = { 7, 1, 5, 3, 6 };
        HW04_4110056028_1 test = new HW04_4110056028_1();
        System.out.println(test.doge(A));
    }

    @Override
    public int doge(int[] price) {
        int result = 0;
        for (int i = 0; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                if (price[j] - price[i] > result) {
                    result = price[j] - price[i];
                }
            }
        }
        return result;
    }
}
