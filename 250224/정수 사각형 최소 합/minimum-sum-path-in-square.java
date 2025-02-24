import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
                dp[i][j] = 1000000000;
            }
        }
        dp[0][n-1] = board[0][n-1];
        
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                int left = j-1;
                int down = i+1;
                if(left>=0){
                    dp[i][left] = Math.min(dp[i][left],dp[i][j]+board[i][left]);
                }
                if(down<n){
                    dp[down][j] = Math.min(dp[down][j],dp[i][j]+board[down][j]);
                }
            }
        }
        System.out.println(dp[n-1][0]);
    }
}