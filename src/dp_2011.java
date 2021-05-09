import java.util.*;

public class dp_2011 {
    final static int mod = 1000000;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        int[] dp = new int[5001];
        char[] N = ('0'+ str).toCharArray();
        if (N.length != 1 && N[1] >= '1' && N[1] <= '9')
            dp[0] = dp[1] = 1;
        for(int i = 2; i < N.length; ++i) {
            int tmp = (N[i-1] - '0') * 10 + (N[i] - '0') ;
            if (N[i] >= '1' && N[i] <= '9')
                dp[i] = dp[i - 1];
            if(tmp >= 10 && tmp <= 26)
                dp[i] = (dp[i] + dp[i - 2]) % mod;
        }
        System.out.printf("%d", dp[N.length - 1]);
    }
}
