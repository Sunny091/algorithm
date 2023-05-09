public class HW08_4110056028_2 extends MaxLandArea {

    private int[] directionX = { 1, 0, -1, 0 };
    private int[] directionY = { 0, -1, 0, 1 };

    private int answer = 0;

    @Override
    public int maxLandArea(int[][] array) {
        int[][] record = new int[array.length][array[0].length];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                record[i][j] = 0;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    if (record[i][j] == 0) {
                        record[i][j] = 1;
                        run(array, record, i, j, 1);
                    }
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[0].length; j++) {
                System.out.print(record[i][j] + " ");
            }
            System.out.println("");
        }
        return answer;
    }

    private void run(int[][] array, int[][] record, int nowX, int nowY, int count) {
        // if (count > answer) {
        // answer = count;
        // }
        for (int i = 0; i < 4; i++) {
            int now_x = nowX + directionX[i];
            int now_y = nowY + directionY[i];
            if (now_x > -1 && now_x < array.length && now_y > -1 && now_y < array[0].length) {
                if (record[now_x][now_y] == 0) {
                    if (array[now_x][now_y] == 1) {
                        record[now_x][now_y] = 1;
                        count++;
                        if (count > answer) {
                            answer = count;
                        }
                        run(array, record, now_x, now_y, count);
                    }
                }
            }
        }
    }
}
