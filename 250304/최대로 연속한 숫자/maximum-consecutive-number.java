import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] removals = new int[n+1];
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> seq = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            
            Integer high = set.higher(num);
            Integer low = set.lower(num);
            if(high==null&&low==null){
                seq.add(n-num);
                seq.add(num);
                removals[n-num]++;
                removals[num]++;
            }else{

                if(high==null) high = n-num;
                else high -= (num+1);

                if(low==null) low = num;
                else low = num-low-1;
                removals[high+low+1]--;
                if(removals[high+low+1]==0) seq.remove(high+low+1);
                seq.add(high);
                seq.add(low);

                removals[high]++;
                removals[low]++;
            }
            set.add(num);
            System.out.println(seq.last());
        }
        
    }
}