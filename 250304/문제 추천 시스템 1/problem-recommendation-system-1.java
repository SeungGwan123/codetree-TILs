import java.util.*;

class Data implements Comparable<Data>{
    int a;
    int b;
    public Data(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Data d){
        if(this.b==d.b) return this.a-d.a;
        else return this.b-d.b;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Data> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            set.add(new Data(p,l));
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();
                if(x>0){
                    Data high = set.last();
                    System.out.println(high.a);
                }else{
                    Data low = set.first();
                    System.out.println(low.a);
                }
            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();
                if(command.equals("ad")){
                    set.add(new Data(p,l));
                }else set.remove(new Data(p,l));
            }
        }
        // Please write your code here.
    }
}