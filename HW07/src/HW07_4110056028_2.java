import java.util.HashMap;
import java.util.Map;

public class HW07_4110056028_2 extends LLK {

    @Override
    public boolean checkLLK(int[][] array) {
        if (array.length < 3) {
            return true; // 如果點的數量小於3，則一定在同一條線上
        }

        // 對於每兩個點，計算它們之間的斜率並存入HashMap中
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int x1 = array[i][0];
                int y1 = array[i][1];
                int x2 = array[j][0];
                int y2 = array[j][1];
                double slope = (double) (y2 - y1) / (double) (x2 - x1);

                // 如果HashMap中已經有了這個斜率，則將計數器加1
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    // 如果HashMap中還沒有這個斜率，則新增一個計數器
                    map.put(slope, 1);
                }
            }
        }

        // 如果有任何一個斜率對應的計數器的值等於點的總數減2，則表示有三個點在同一條線上
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() == array.length - 2) {
                return true;
            }
        }

        // 如果沒有任何一個斜率對應的計數器的值等於點的總數減2，則表示沒有三個點在同一條線上
        return false;
    }
}
