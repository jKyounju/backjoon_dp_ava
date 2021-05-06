import java.util.*;

public class dp_2225 {
    static long div = 1000000000;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        long[][] dp = new long[201][201];
        for( int i = 0; i <= N; ++i)
            dp[1][i] = 1;

        for(int k = 2; k <= K; ++k) {
            for (int i = 0; i <= N; ++i) {
                for (int j = 0; j <= i; ++j) {
                    dp[k][i] += dp[k-1][j];
                }
                dp[k][i] %= div;
            }
        }

        System.out.print(dp[K][N]);

    }

}
