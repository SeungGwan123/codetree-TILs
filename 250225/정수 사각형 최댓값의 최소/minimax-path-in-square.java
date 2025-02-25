import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j] = grid[i][j];
                else if(i==0){
                    dp[i][j] = Math.max(dp[i][j-1],grid[i][j]);
                }else if(j==0){
                    dp[i][j] = Math.max(dp[i-1][j],grid[i][j]);
                }else{
                    dp[i][j] = Math.max(Math.min(dp[i][j-1],dp[i-1][j]),grid[i][j]);
                }
            }
        }
        System.out.print(dp[n-1][n-1]);
    }
}