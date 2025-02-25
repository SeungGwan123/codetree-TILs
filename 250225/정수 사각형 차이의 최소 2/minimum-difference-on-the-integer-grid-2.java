import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][][] dp = new int[n][n][2]; // min max
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0][0] = grid[0][0];
                    dp[0][0][1] = grid[0][0];
                }else if(i==0){
                    dp[i][j][0] = Math.min(dp[i][j-1][0],grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i][j-1][1],grid[i][j]);
                }else if(j==0){
                    dp[i][j][0] = Math.min(dp[i-1][j][0],grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1],grid[i][j]);
                }else{
                    // int now = grid[i][j];
                    // int[] left = new int[]{Math.min(dp[i][j-1][0],now),Math.max(dp[i][j-1][1],now)};
                    // int[] up = new int[]{Math.min(dp[i-1][j][0],now),Math.max(dp[i-1][j][1],now)};
                    // if(left[1]-left[0]<up[1]-up[0]){
                    //     dp[i][j] = left;
                    // }else dp[i][j] = up;
                    dp[i][j][0] = Math.min(Math.max(dp[i][j-1][0],dp[i-1][j][0]),grid[i][j]);
                    dp[i][j][1] = Math.max(Math.min(dp[i][j-1][1],dp[i-1][j][1]),grid[i][j]);
                }

                // for(int a=0;a<n;a++){
                //     for(int b=0;b<n;b++){
                //         System.out.print(dp[a][b][0]+" "+dp[a][b][1]+"  ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
            }
        }
        System.out.println(dp[n-1][n-1][1]-dp[n-1][n-1][0]);
    }
}