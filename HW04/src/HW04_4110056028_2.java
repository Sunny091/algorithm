public class HW04_4110056028_2 extends doge_coin {

    public static void main(String[] args) {
        int[] A = { 7, 4, 5, 3, 9, 1, 8 };
        int[] B = { 7, 6, 4, 3, 1 };
        HW04_4110056028_2 test = new HW04_4110056028_2();
        System.out.println(test.doge(A));
        System.out.println(test.doge(B));
    }

    @Override
    public int doge(int[] price) {
        int result = 0, buy_index = 0, sell_index = 0;
        boolean change = false, change1 = false;
        for (int i = 0; i < price.length - 1; i++) {
            if (!change) {
                if (price[i + 1] < price[i]) {
                    continue;
                } else {
                    if (!change1) {
                        buy_index = i;
                        change = true;
                        change1 = true;
                        for (int j = i + 1; j < price.length; j++) {
                            if (price[j] - price[i] > result) {
                                result = price[j] - price[i];
                                sell_index = j;
                            }
                        }
                    } else {
                        for (int j = i + 1; j < price.length; j++) {
                            if (price[j] - price[i] > result) {
                                result = price[j] - price[i];
                                buy_index = i;
                                sell_index = j;
                                change = true;
                            }
                        }
                    }
                }
            } else {
                if (i < sell_index) {
                    if (price[i] < price[buy_index]) {
                        result += (price[buy_index] - price[i]);
                    }
                } else {
                    change = false;
                }
            }
        }
        return result;
    }
}
