import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long answer = 0;
        long high = 20000000000L;
        long mid = high/2;
        long low = 0;
        while(low<=high){
            long result = mid*(mid+1)/2;
            if(result<=s){
                answer = Math.max(mid,answer);
                low = mid+1;
            }else{
                high = mid-1;
            }
            mid = (high+low)/2;
        }
        System.out.println(answer);
    }
}