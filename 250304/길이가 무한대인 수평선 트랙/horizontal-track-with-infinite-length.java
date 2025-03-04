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
            run before = set.lower(now);
            run next = set.higher(now);
            if(before!=null){
                if(before.speed*t+before.loc>=now.speed*t+now.loc) result--;
            }
            if(next!=null){
                if(next.speed*t+next.loc<=now.speed*t+now.loc) result--;
            }
        }
        System.out.println(result);
    }
}