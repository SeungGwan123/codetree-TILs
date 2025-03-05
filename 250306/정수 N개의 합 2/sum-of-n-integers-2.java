import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1;i<n;i++){
            sum[i] = arr[i]+sum[i-1];
        }
        int result = 0;
        for(int i=k-1;i<n;i++){
            result = Math.max(sum[i]-sum[i-(k-1)]+arr[i-(k-1)],result);
        }
        System.out.println(result);
    }
}