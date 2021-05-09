import java.util.*;


public class dp_2096 {
    static int[][] map  = new int[100001][4];
    static int[][] max  = new int[100001][4];
    static int[][] min  = new int[100001][4];
    static int ans1 = -1;
    static int ans2 = 9*100000 + 1;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for (int i = 1; i <= N; ++i)
            for (int j = 1; j <= 3; ++j) {
                map[i][j] = input.nextInt();
                max[i][j] = -1;
                min[i][j]  = 9 * 100000 + 1;
            }

            for (int y = 1; y <= N; y++) {
                max[y][1] = Math.max(max[y-1][1], max[y-1][2]) + map[y][1];
                max[y][2] = Math.max(Math.max(max[y-1][1], max[y-1][2]), max[y-1][3]) + map[y][2];
                max[y][3] = Math.max(max[y-1][3], max[y-1][2]) + map[y][3];

                min[y][1] = Math.min(min[y-1][1], min[y-1][2]) + map[y][1];
                min[y][2] = Math.min(Math.min(min[y-1][1], min[y-1][2]), min[y-1][3]) + map[y][2];
                min[y][3] = Math.min(min[y-1][3], min[y-1][2]) + map[y][3];
            }

        System.out.printf("%d %d", Math.max(Math.max(max[N][1], max[N][2]), max[N][3]), Math.min(Math.min(min[N][1], min[N][2]), min[N][3]));
    }

}