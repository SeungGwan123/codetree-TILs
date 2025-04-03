import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] answer = new int[n];
        int result = 0;
        for(int i=0;i<n;i++){
            if(i>0&&answer[i]==0) continue;
            for(int j=1;j<=arr[i];j++){
                if(i+j>=n) break;
                answer[i+j] = Math.max(answer[i+j],answer[i]+1);
                result = Math.max(result, answer[i+j]);
            }
        }
        System.out.println(result);
    }
}