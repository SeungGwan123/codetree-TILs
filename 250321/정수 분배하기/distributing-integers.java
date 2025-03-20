import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int low = 0;
        int high = 100000;
        int mid = (high+low)/2;
        int result = 0;
        while(low<=high){
            int count = 0;
            for(int i=0;i<n;i++){
                if(mid==0){
                    count=m;
                    break;
                }
                count+=(arr[i]/mid);
                if(count>=m) break;
            }
            if(count>=m){
                result = mid;
                low = mid+1;
            }else high = mid-1;
            if(result==0&&high==0) break;
            mid = (high+low)/2;
        }
        System.out.println(result);
    }
}