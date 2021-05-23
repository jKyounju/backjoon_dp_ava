import java.util.Scanner;

public class dp_1965 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] box = new int[1001];
        int[][] dp = new int[1001][1001];
        int ans = 1;
        for (int i = 1; i<= N; ++i) {
            box[i] = in.nextInt();
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; ++i) {
            dp[i][i] = 1;
            for (int j = i; j <= N; ++j) {
                if (box[i] < box[j])
                    dp[i][j] = Math.max(dp[i][i] + 1, dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
                ans = Math.max(ans, dp[i][j]);
            }
        }

        for(int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j)
                System.out.printf("%d ", dp[i][j]);
            System.out.println();
        }
        System.out.print(ans);
    }
}
