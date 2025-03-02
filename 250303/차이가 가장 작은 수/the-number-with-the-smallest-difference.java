import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        int result = 2000000001;
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            Integer min_num = set.floor(num-m);
            Integer max_num = set.ceiling(num+m);
            if(min_num!=null) result = Math.min(result,num-min_num);
            if(max_num!=null) result = Math.min(result,max_num-num);
            
            set.add(num);
        }
        if(result==2000000001) result = -1;
        System.out.println(result);
    }
}