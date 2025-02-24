import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long MOD = 1000000007;
        List<Long> dp = new ArrayList<>();
        
        // 초기 조건 설정
        dp.add(1L);   // dp[0] = 1
        dp.add(2L);   // dp[1] = 2
        dp.add(7L);   // dp[2] = 7
        dp.add(22L);  // dp[3] = 22

        // n이 4 미만이면 미리 설정된 값을 출력
        if(n < dp.size()){
            System.out.println(dp.get(n));
            return;
        }
        
        // dp[i] = dp[i-1]*2 + dp[i-2]*3 + (dp[0]부터 dp[i-3]까지의 합)*2 (mod MOD)
        for (int i = 4; i <= n; i++) {
            long one = dp.get(i - 1) * 2 % MOD;
            long two = dp.get(i - 2) * 3 % MOD;
            long three = 0;
            // dp[0]부터 dp[i-3]까지의 합을 구함 (각 항에 2를 곱함)
            for (int j = 0; j <= i - 3; j++) {
                three = (three + dp.get(j) * 2) % MOD;
            }
            long now = (one + two + three) % MOD;
            dp.add(now);
        }
        System.out.println(dp.get(n));
    }
}
