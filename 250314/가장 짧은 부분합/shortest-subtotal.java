import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = -1;
        int result = 100000;
        long count = 0;
        for(int i=0;i<n;i++){
            count+=arr[++end];
            if(count>=s){
                result = Math.min(result, end - start + 1);
                while(count>=s) count -= arr[start++];
            }
        }
        if(result == 100000) System.out.println("-1");
        else System.out.println(result);
    }
}