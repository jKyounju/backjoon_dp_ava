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
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = i + 1; j <= N; ++j) {
                if (box[i] < box[j])
                    dp[i][j] = dp[i-1][j] + 1;
                else
                    dp[i][j] = dp[i-1][j];
                ans = Math.max(ans, dp[i][N]);
            }
        }


        for (int i = 1; i <= N; ++i) {
            System.out.printf("%d ", dp[3][i]);
        }
        System.out.println(ans);
    }
}
