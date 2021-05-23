import java.util.*;

class path {
    int s,e,v,m;
    path(int ss, int ee, int vv, int mm) {
        s = ss;
        e = ee;
        v = vv;
        m = mm;
    }
}

public class dp_2157 {
    static int N, M, K;
    static int[][] plain = new int[301][301];
    static int[][] dp = new int[301][301];
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        K = input.nextInt();
        for(int i = 1; i <= K; ++i) {
            int s = input.nextInt();
            int e = input.nextInt();
            int v = input.nextInt();
            plain[s][e] = Math.max(v, plain[s][e]);
        }
        System.out.println(bfs());
    }

    static  int bfs() {
        Queue<path> q = new LinkedList<path>();
        for(int i = 1; i <= N; ++i)
            if(plain[1][i] != 0)
                q.add(new path(1, i, plain[1][i], 1));
        int ans = 0;
        while(!q.isEmpty()) {
            path tmp = q.remove();
            if(tmp.m > M || dp[tmp.s][tmp.e]  >= tmp.v)
                continue;

            if(tmp.e == N) {
                ans = Math.max(ans, tmp.v);
                continue;
            }

            for(int i = tmp.e+1; i <= N; ++i)
                if(plain[tmp.e][i] != 0)
                    q.add(new path(tmp.e, i, tmp.v + plain[tmp.e][i], tmp.m + 1));
        }

        return ans;
    }
}
