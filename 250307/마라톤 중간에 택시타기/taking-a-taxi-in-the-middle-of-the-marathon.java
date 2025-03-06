import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1;i<n;i++){
            left[i] = Math.abs(x[i]-x[i-1]) + Math.abs(y[i]-y[i-1]) + left[i-1];
            right[n-1-i] = Math.abs(x[n-1-i]-x[n-1-(i-1)]) + Math.abs(y[n-1-i]-y[n-1-(i-1)]) + right[n-1-(i-1)];
        }

        // for(int i=0;i<n;i++){
        //     System.out.print(left[i]+" ");
        // }
        // System.out.println();

        // for(int i=0;i<n;i++){
        //     System.out.print(right[i]+" ");
        // }
        // System.out.println();

        long result = 1000000000;
        for(int i=1;i<n-1;i++){
            int jump = Math.abs(x[i-1]-x[i+1]) + Math.abs(y[i-1]-y[i+1]);
            result = Math.min(left[i-1]+right[i+1]+jump,result);
        }
        System.out.println(result);
    }
}