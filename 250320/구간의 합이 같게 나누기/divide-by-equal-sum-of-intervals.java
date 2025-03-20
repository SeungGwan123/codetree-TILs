import java.util.*;

public class Main {
    public static long total;
    public static long[] arr;
    public static long[] left;
    public static long[] right;
    public static int section(int a,int b,boolean dir){
        int result = 0;
        if(dir){
            for(int i=a;i<b;i++){
                if(left[i]==(total/4)) result++;
            }
        }else{
            for(int i=b;i>a;i--){
                if(right[i]==(total/4)) result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new long[n];
        left = new long[n];
        right = new long[n];
        total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total+= arr[i];
        }
        long left_sum = 0;
        long right_sum = 0;
        int left_count = 0;
        int right_count = 0;
        int[] left_num = new int[n];
        int[] right_num = new int[n];
        int[] arr_num = new int[n];
        for(int i=0;i<n;i++){
            left_sum+=arr[i];
            right_sum+=arr[n-1-i];
            left[i] = left_sum;
            right[n-1-i] = right_sum;
            if(left[i]==total/2) arr_num[i]=1;
            
            if(left_sum==total/4) left_count++;
            if(right_sum==total/4) right_count++;
            if(i<2&&left_count==2) left_count--;
            if(i<2&&right_count==2) right_count--;
            left_num[i] = left_count;
            right_num[n-1-i] = right_count;
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(left_num[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.print(right_num[i]+" ");
        // }
        // System.out.println();
        int result = 0;
        for(int i=1;i<n-2;i++){
            if(arr_num[i]==1){
                //System.out.println(i);
                result += left_num[i] * right_num[i+1];
            }
        }
        System.out.println(result);
    }
}