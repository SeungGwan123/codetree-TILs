import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        long[] arr = new long[a.length()];
        boolean check = false;
        boolean count = false;
        long result = 0;
        long num = 0;
        for(int i=a.length()-1;i>=0;i--){
            char now = a.charAt(i);
            if(now==')'&&check){
                arr[i] = ++num;
            }else if(now==')'){
                check = true;
                count = false;
            }else if(now=='('&&count){
                result += num;
            }else if(now=='('){
                count = true;
                check = false;
            }
        }
        System.out.println(result);
    }
}