import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] removals = new int[m];
        TreeSet<Integer> set = new TreeSet<>();
        int result = 0;
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            set.add(num);
            Integer high = set.higher(num);
            Integer low = set.lower(num);
            if(high==null) high = n-num;
            else high -= num;

            if(low==null) low = num;
            else low = num-low;
            result = Math.max(high,low);
            System.out.println(result);
        }
        
    }
}