import java.util.*;

public class Main {
    public static int result = 500;
    public static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static int[][] board;
    public static int[][] visited;
    public static int n;
    public static int m;
    public static void dfs(int x,int y,int high,int low){
        if(x==n-1&&y==m-1){
            //System.out.println(high-low);
            result = Math.min(result,high-low);
            return;
        }
        if(high-low>=result) return;
        for(int d=0;d<4;d++){
            int a = x+dir[d][0];
            int b = y+dir[d][1];
            if(a<0||b<0||a>=n||b>=m) continue;
            if(visited[a][b]==1) continue;
            visited[a][b]=1;
            dfs(a,b,Math.max(board[a][b],high),Math.min(board[a][b],low));
            visited[a][b]=0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();
        dfs(0,0,board[0][0],board[0][0]);
        System.out.println(result);
    }
}