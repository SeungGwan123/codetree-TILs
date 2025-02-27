import java.util.*;

class Data implements Comparable<Data>{
    int x;
    int y;
    
    public Data(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Data data){
        if(this.x == data.x){
            return this.y - data.y;
        }else{
            return this.x - data.x;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        TreeSet<Data> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            set.add(new Data(x[i],y[i]));
        }
        int[] qx = new int[m];
        int[] qy = new int[m];
        for (int i = 0; i < m; i++) {
            qx[i] = sc.nextInt();
            qy[i] = sc.nextInt();
            Data ceil = set.ceiling(new Data(qx[i],qy[i]));
            if(ceil == null) System.out.println("-1 -1");
            else System.out.println(ceil.x+" "+ceil.y);
        }
        
    }
}