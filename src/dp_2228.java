import java.util.*;

public class dp_2228 {
    final static int MIN = -987654321;
    static int[][] dp = new int[101][101];
    static boolean[][] visit = new boolean[101][101];
    static int[] n = new int[101];
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        for(int i = 1; i <= N; ++i) {
            n[i] = n[i - 1] + input.nextInt();
            for(int j = 1; j <= N; ++j)
                dp[i][j] = MIN;
        }
        System.out.println(func(N,M));
    }
    static int func(int N, int M) {
        if (M == 0) return 0;
        if (N <= 0) return MIN;
        if(visit[N][M]) return dp[N][M];
        visit[N][M] = true;
        dp[N][M] = func(N-1,M);
        for(int i = N; i >= 1; --i)
            dp[N][M] = Math.max(dp[N][M], n[N] - n[i-1] + func(i-2, M-1));
        return dp[N][M];
    }
}
