import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] removals = new int[m];
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < m; i++) {
            int nm = sc.nextInt();
            set.add(nm);
            int result = 0;    
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()){
                int num = iter.next();
                //System.out.println(num);
                Integer high = set.higher(num);
                Integer low = set.lower(num);
                if(high==null) high = n-num;
                else high -= (num+1);

                if(low==null) low = num;
                else low = num-low-1;

                result = Math.max(Math.max(high,low),result);
            }
            System.out.println(result);
        }
        
    }
}