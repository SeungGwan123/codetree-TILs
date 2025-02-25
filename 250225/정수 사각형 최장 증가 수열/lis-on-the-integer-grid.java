import java.util.*;

public class Main {
    static int result = 0;
    static int[][] matrix;
    static int[][] dp = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static void dfs(int i,int j,int count,int n){
        result = Math.max(result, count);
        int now = matrix[i][j];
        for(int d=0;d<4;d++){
            int x = i+dp[d][0];
            int y = j+dp[d][1];
            if(x<0||x>=n||y<0||y>=n) continue;
            if(matrix[x][y]>now) dfs(x,y,count+1,n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,1,n);
            }
        }

        System.out.println(result);
    }
}