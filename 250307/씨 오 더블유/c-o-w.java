import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] left = new int[n];
        int[] right = new int[n];
        int c = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='C') c++;
            if(str.charAt(i)=='O') left[i] = c;
        }
        int w = 0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='W') w++;
            if(str.charAt(i)=='O') right[i] = w;
        }
        long result = 0;
        for(int i=0;i<n;i++){
            result += left[i]*right[i];
        }
        System.out.println(result);
    }
}