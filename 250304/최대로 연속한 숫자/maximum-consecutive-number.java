import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] removals = new int[m];
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> seq = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            
             
            
            Integer high = set.higher(num);
            Integer low = set.lower(num);
            if(high==null&&low==null){
                seq.add(n-num);
                seq.add(num);
            }else{

            if(high==null) high = n-num;
            else high -= (num+1);

            if(low==null) low = num;
            else low = num-low-1;
            seq.remove(high+low+1);
            seq.add(high);
            seq.add(low);
            }
            set.add(num);
            System.out.println(seq.last());
        }
        
    }
}