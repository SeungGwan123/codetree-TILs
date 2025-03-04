import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = arr[n-1];
        pq.add(result);
        double average = 0;
        for(int i=n-2;i>=0;i--){
            int now = arr[i];
            pq.add(now);
            result+=now;

            int cal = result - pq.peek();
            average = Math.max(cal/(pq.size()-1),average);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(average));
    }
}