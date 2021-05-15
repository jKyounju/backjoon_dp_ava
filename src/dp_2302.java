import java.util.*;

public class dp_2302 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int[] chair = new int[41];
        int[] dp = new int[41];

        for(int i = 0; i < M; ++i)
            chair[input.nextInt()] = 1;

        dp[0] = dp[1] =1;
        for(int i = 2; i <= N; ++i)  {
            dp[i] = dp[i-1];
            if(chair[i-1] == 0 && chair[i] == 0)
                dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.printf("%d", dp[N]);
    }
}
