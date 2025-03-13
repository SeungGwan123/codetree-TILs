import java.util.*;
class pair {
    int x;
    int y;
    public pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static TreeMap<Integer,Integer> dx = new TreeMap<>();
    public static TreeMap<Integer,Integer> dy = new TreeMap<>();

    public static void addX(int x){
        if(!dx.containsKey(x)){
            dx.put(x,1);
        }else{
            int num = dx.get(x);
            dx.put(x,num+1);
        }
    }
    public static void addY(int y){
        if(!dy.containsKey(y)){
            dy.put(y,1);
        }else{
            int num = dy.get(y);
            dy.put(y,num+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pair[] dots = new pair[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dots[i] = new pair(x,y);
            addX(x);
            addY(y);
        }
        
        Iterator<Map.Entry<Integer,Integer>> iter_x = dx.entrySet().iterator();
        Iterator<Map.Entry<Integer,Integer>> iter_y = dy.entrySet().iterator();
        int count_x = 0;
        int count_y = 0;
        double min_x = 1000;
        double min_y = 1000;
        int X = 0;
        int Y = 0;
        while(iter_x.hasNext()){
            Map.Entry<Integer,Integer> next = iter_x.next();
            count_x += next.getValue();
            double half_x = Math.abs((double)n/2-count_x);
            if(min_x>half_x){
                min_x = half_x;
                X = next.getKey() + 1;  
            } 
            else break;
        }
        while(iter_y.hasNext()){
            Map.Entry<Integer,Integer> next = iter_y.next();
            count_y += next.getValue();
            double half_y = Math.abs((double)n/2-count_y);
            // System.out.println(min_y+" "+half_y+" "+(double)(n/2));
            if(min_y>half_y) {
                min_y = half_y;
                Y = next.getKey() + 1;
            }else break;
        }
        int[] min_dot = new int[4];
        for(int i=0;i<n;i++){
            pair now = dots[i];
            if(now.x < X && now.y < Y) min_dot[0]++;
            else if(now.x < X && now.y > Y) min_dot[1]++;
            else if(now.x > X && now.y < Y) min_dot[2]++;
            else min_dot[3]++;
        }
        Arrays.sort(min_dot);
        //System.out.println(X+" "+Y);
        System.out.println(min_dot[3]);
    }
}