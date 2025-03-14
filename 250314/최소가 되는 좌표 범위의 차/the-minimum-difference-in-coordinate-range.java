import java.util.*;
class pair implements Comparable<pair>{
    int x;
    int y;
    public pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(pair p){
        if(this.x==p.x) return this.y - p.y;
        else return this.x - p.x;
    }
}
class pair_y implements Comparable<pair_y>{
    int x;
    int y;
    public pair_y(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(pair_y p){
        if(this.y==p.y) return this.x - p.x;
        else return this.y - p.y;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        TreeSet<pair> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            set.add(new pair(x[i],y[i]));
        }
        TreeSet<pair> set_x = new TreeSet<>();
        TreeSet<pair_y> set_y = new TreeSet<>();
        pair start = set.first();
        pair_y start_y = new pair_y(start.x,start.y);
        pair end = set.first();
        pair_y end_y = start_y;
        int result = 10000000;
        while(end!=null){
            set_x.add(end);
            set_y.add(end_y);
            while(set_y.last().y - set_y.first().y >= d){
                result = Math.min(result, set_x.last().x - set_x.first().x);
                set_x.remove(start);
                set_y.remove(start_y);
                start = set.higher(start);
                start_y = new pair_y(start.x,start.y);
            }
            end = set.higher(end);
            if(end!=null)end_y = new pair_y(end.x,end.y);
        }
        if(result == 10000000) System.out.println("-1");
        else System.out.println(result);
    }
}