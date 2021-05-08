import java.util.*;

public class dp_2225 {
    static int div = 1000000000;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[][][] dp = new int[N+1][N+1][N+1];
        int ans = 1;

        for(int k = 1; k <= K; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = i - 1; j > i; --j ) {
                    dp[i][j][k] = dp[i-1][j][k-1] + i;
                }

            }
        }

        for (int i = 1; i <= N; ++i) {


            for (int j = 1; j <= N; ++j)
                System.out.printf("%d ", dp[i][j][1]);
            System.out.println();
        }

        System.out.println(ans);
    }

}
