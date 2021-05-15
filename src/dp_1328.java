import java.util.*;

public class dp_1328 {
    static int N,R,L;
    static long div = 1000000007;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        L = input.nextInt();
        R = input.nextInt();

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        for(int i = 2; i <= N; ++i)
            for(int l = 1; l <= L; ++l)
                for(int r = 1; r <= R; ++r)
                    dp[i][l][r] = (dp[i-1][l-1][r] + dp[i-1][l][r-1] + (i-2) * dp[i-1][l][r]) % div;

        System.out.println(dp[N][L][R]);
    }
}
