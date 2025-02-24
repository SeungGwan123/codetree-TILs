import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int result = matrix[0][0];
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int right = j+1;
                int down = i+1;
                if(right<n){
                    dp[i][right] = Math.max(dp[i][right],dp[i][j]+matrix[i][right]);
                    result = Math.max(result, dp[i][right]);
                }
                if(down<n){
                    dp[down][j] = Math.max(dp[down][j], dp[i][j]+matrix[down][j]);
                    result = Math.max(result, dp[down][j]);
                }
            }
        }
        System.out.println(result);
    }
}