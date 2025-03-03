import java.util.*;

class Data implements Comparable<Data>{
    int x;
    int y;

    public Data(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Data d){
        if(this.x==d.x) return this.y-d.y;
        else return this.x-d.x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Data> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            set.add(new Data(sc.nextInt(),sc.nextInt()));
        }
        for(int i=0;i<m;i++){
            int num = sc.nextInt();
            Data dot = set.ceiling(new Data(num,0));
            if(dot==null) System.out.println("-1 -1");
            else {
                System.out.println(dot.x+" "+dot.y);
                set.remove(dot);
            }
        }
    }
}