import java.util.*;

public class dp_2157_dp {
    static int N, M, K;
    static int[][] plain = new int[301][301];
    static int[][] dp = new int[301][301];
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        K = input.nextInt();

        for(int i = 1; i <= K; ++i) {
            int s = input.nextInt();
            int e = input.nextInt();
            int v = input.nextInt();
            plain[s][e] = Math.max(v, plain[s][e]);
        }
        for(int i = 0; i <= N; ++i)
            for(int j = 0; j <= N; ++j)
                dp[i][j] = -987654321;

        System.out.println(func(1,1));
    }
    static int func(int e, int m) {
        if(e == N)
            return 0;

        if(m == M)
            return -987654321;

        if(dp[e][m] != -987654321)
            return dp[e][m];

        for(int i = e+1; i <= N; ++i)
            if(plain[e][i] != 0)
                dp[e][m] = Math.max(dp[e][m], func(i, m+1) + plain[e][i]);

        return dp[e][m];
    }
}
