public class HW08_4110056028_1 extends MaxLandArea {

    private int[] directionX = { 0, 1, 0, -1 };
    private int[] directionY = { 1, 0, -1, 0 };

    private int answer = 0;

    @Override
    public int maxLandArea(int[][] array) {
        int[][] record = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    if (record[i][j] == 0) {
                        run(array, record, i, j, 1);
                    }
                }
            }
        }
        return answer;
    }

    private void run(int[][] array, int[][] record, int nowX, int nowY, int count) {
        if (count > answer) {
            answer = count;
        }
        for (int i = 0; i < 4; i++) {
            if (nowX + directionX[i] > -1 && nowX + directionX[i] < array[0].length && nowY + directionY[i] > -1
                    && nowY + directionY[i] < array.length) {
                if (array[nowX + directionX[i]][nowY + directionY[i]] == 1) {
                    if (record[nowX + directionX[i]][nowY + directionY[i]] == 0) {
                        record[nowX + directionX[i]][nowY + directionY[i]] = 1;
                        run(array, record, nowX + directionX[i], nowY + directionY[i], ++count);
                    }
                }
            }
        }
    }
}
