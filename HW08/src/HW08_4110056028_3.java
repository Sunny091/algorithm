public class HW08_4110056028_3 extends MaxLandArea {

    private int[][] map, map_record;
    private int map_x, map_y, count,[]area,limit;

    @Override
    public int maxLandArea(int[][] array) {
        for (int j = 0; j < map_y; j++) {
            for (int k = 0; k < map_x; k++) {
                if (map_record[j][k] == 0) {
                    count++;
                    run(k, j, n);
                    n++;
                }
            }
        }
    }

    public static void run(int now_x, int now_y, int n) {
        map_record[now_y][now_x] = n;
        int r, t;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        for (int i = 0; i < 4; i++) {
            int next_x = now_x + dx[i];
            int next_y = now_y + dy[i];

            if (next_x >= 0 && next_x < map_x && next_y >= 0 && next_y < map_y) {
                t = map[next_y][next_x] - map[now_y][now_x];
                r = Math.abs(t);

                if (r <= limit && map_record[next_y][next_x] == 0) {
                    area[n - 1] += 1;
                    map_record[next_y][next_x] = n;
                    run(next_x, next_y, n);
                }
            }
        }
    }
}