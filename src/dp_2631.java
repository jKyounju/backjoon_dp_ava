import java.util.*;

public class dp_2631 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] kids = new int[201];
        int[] dp = new int[201];
        int ans = 0;
        for(int i = 0; i < N; ++i)
            kids[i] = input.nextInt();

        for(int i = 0; i < N; ++i) {
            dp[i] = 1;
            for(int j = 0; j < i; ++j)
                if (kids[i] > kids[j])
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.printf("%d", N - ans);
    }
}
