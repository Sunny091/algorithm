public class HW04_4110056028_4 extends doge_coin {

    public static void main(String[] args) {
        int[] A = { 7, 4, 5, 3, 9, 1, 8 };
        int[] B = { 7, 6, 4, 3, 1 };
        HW04_4110056028_4 test = new HW04_4110056028_4();
        System.out.println(test.doge(A));
        System.out.println(test.doge(B));
    }

    @Override
    public int doge(int[] price) {
        int result = 0;
        int max = 0, min = 99999;
        int max_index = 0, min_index = 0;
        for (int i = 0; i < price.length; i++) {
            if (price[i] < min) {
                min = price[i];
                min_index = i;
            }
            if (price[i] > max) {
                max = price[i];
                max_index = i;
            }
        }
        if (max_index > min_index) {
            return price[max_index] - price[min_index];
        } else {
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

}
