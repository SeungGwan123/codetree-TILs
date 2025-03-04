import java.util.*;
class dot implements Comparable<dot>{
    int x;
    int y;
    public dot(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(dot d){
        int now = this.x+this.y;
        int another = d.x+d.y;
        if(now==another){
            if(this.x==d.x) return this.y-d.y;
            else return this.x-d.x;
        }else return now-another;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        PriorityQueue<dot> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            pq.add(new dot(points[i][0],points[i][1]));
        }
        for(int i=0;i<m;i++){
            dot d = pq.poll();
            d.x +=2;
            d.y +=2;
            pq.add(d);
        }
        dot d = pq.poll();
        System.out.println(d.x+" "+d.y);
    }
}