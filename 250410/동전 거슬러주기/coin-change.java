import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        int[] change = new int[m+1];
        for (int i = 0; i < n; i++){
            coin[i] = sc.nextInt();
            change[coin[i]] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=coin[i]+1;j<=m;j++){
                if(change[j-coin[i]]==0) continue;
                if(change[j]==0) change[j] = change[j-coin[i]]+1;
                else change[j] = Math.min(change[j],change[j-coin[i]]+1);
            }
        }
        // for(int i=0;i<=m;i++){
        //     System.out.print(change[i]+ " ");
        // }
        // System.out.println();

        if(change[m]==0) System.out.println(-1);
        else System.out.println(change[m]);
    }
}