import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,Integer> hash = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> seq = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            
            Integer high = set.higher(num);
            Integer low = set.lower(num);
            if(high==null&&low==null){
                seq.add(n-num);
                seq.add(num);
                hash.put(n-num,1);
                hash.put(num,1);
            }else{

                if(high==null) high = n-num;
                else high -= (num+1);

                if(low==null) low = num;
                else low = num-low-1;
                int now = high+low+1;

                if(hash.get(now)==1) hash.remove(now);
                else hash.put(now,hash.get(now)-1);

                if(!hash.containsKey(now)) seq.remove(now);
                seq.add(high);
                seq.add(low);

                if(hash.containsKey(high)) hash.put(high,hash.get(high)+1);
                else hash.put(high,1);

                if(hash.containsKey(low)) hash.put(low,hash.get(low)+1);
                else hash.put(low,1);
            }
            set.add(num);
            System.out.println(seq.last());
        }
        
    }
}