import java.util.*;

public class dp_2666 {
    static int[] wall = new int[21];
    static int[][][] dp = new int[21][21][21];
    final static int INF = 1000000000;
    static int N, L;
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        int M1 = input.nextInt();
        int M2 = input.nextInt();
        L = input.nextInt();
        for(int i = 1; i <= L; ++i)
            wall[i] = input.nextInt();

        for(int i = 1; i <= 20; ++i)
            for(int j = 1; j<= 20; ++j)
                for(int k = 1; k <= 20; ++k)
                    dp[i][j][k] = INF;

        System.out.println(func(M1,M2,1));
    }
    static int func(int M1,int M2, int n) {
        if(n == L+1)
            return 0;

        if(dp[n][M1][M2] != INF)
            return dp[n][M1][M2];

        dp[n][M1][M2] = Math.min(Math.abs(M2-wall[n]) + func(M1, wall[n], n+1), Math.abs(M1-wall[n]) + func(wall[n], M2, n+1));
        return dp[n][M1][M2];
    }
}
