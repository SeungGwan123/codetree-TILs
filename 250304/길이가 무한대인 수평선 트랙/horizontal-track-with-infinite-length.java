import java.util.*;

class run implements Comparable<run>{
    int loc;
    long speed;

    public run(int loc,int speed){
        this.loc = loc;
        this.speed = speed;
    }

    @Override
    public int compareTo(run r){
        return this.loc - r.loc;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] start = new int[n];
        int[] speed = new int[n];
        TreeSet<run> set = new TreeSet<>();
        int result = n;
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            speed[i] = sc.nextInt();
            run now = new run(start[i],speed[i]);
            set.add(now);
        }
        run before = set.first();
        while(before!=null){
            run now = set.higher(before);
            if(now==null) {
                before=null;
                continue;
            }
            if(before.speed<now.speed){
                before = now;
                continue;    
            }
            while((before.speed-now.speed)*t+before.loc>=now.loc) {
                result--;
                set.remove(before);
                before = set.lower(before);
                if(before==null) break;
            }
            before = now;
        }
        System.out.println(result);
    }
}