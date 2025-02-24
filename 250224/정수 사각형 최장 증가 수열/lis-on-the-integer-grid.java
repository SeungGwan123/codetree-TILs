import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                dp[i][j] = 1;
            }
        }
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>0 && matrix[i-1][j] < matrix[i][j]){
                    dp[i][j] = Math.max(dp[i-1][j]+1, dp[i][j]);
                }
                if(j>0 && matrix[i][j-1] < matrix[i][j]){
                    dp[i][j] = Math.max(dp[i][j-1]+1, dp[i][j]);
                }
                if(i<n-1 && matrix[i+1][j] < matrix[i][j]){
                    dp[i][j] = Math.max(dp[i+1][j]+1, dp[i][j]);
                }
                if(j<n-1 && matrix[i][j+1] < matrix[i][j]){
                    dp[i][j] = Math.max(dp[i][j+1]+1, dp[i][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}