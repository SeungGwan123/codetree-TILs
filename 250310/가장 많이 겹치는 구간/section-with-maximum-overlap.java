import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[200001];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arr[x1]++;
            arr[x2]--;
        }
        int result = 0;
        int count = 0;
        for(int i=0;i<200001;i++){
            count+=arr[i];
            result = Math.max(result,count);
            
        }
        System.out.println(result);
    }
}