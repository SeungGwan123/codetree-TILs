import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 0; i < n-1; i++)
            dist[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();
        int min_cost = cost[0];
        long result = 0;
        for(int i=0;i<n-1;i++){
            min_cost = Math.min(min_cost,cost[i]);
            result += min_cost * dist[i];
        }
        System.out.println(result);
    }
}