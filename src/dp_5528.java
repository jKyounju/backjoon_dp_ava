import java.util.*;

public class dp_5528 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        char[] A = input.next().toCharArray();
        char[] B = input.next().toCharArray();
        int[][] dp = new int[4001][4001];
        int ans = 0;
        for (int a = 1; a <= A.length; ++a) {
            for(int b = 1; b <= B.length; ++b) {
                if(A[a-1] == B[b-1]) {
                    dp[a][b] = dp[a - 1][b - 1] + 1;
                    ans = Math.max(dp[a][b], ans);
                }
            }
        }
        System.out.println(ans);
    }
}
