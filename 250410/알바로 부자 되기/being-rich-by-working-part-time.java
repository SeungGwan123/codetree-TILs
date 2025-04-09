import java.util.*;
class tuple implements Comparable<tuple>{
    int x;
    int y;
    int num;
    public tuple(int x,int y,int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(tuple t){
        return this.x - t.x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] p = new int[n];
        List<tuple> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            p[i] = sc.nextInt();
            list.add(new tuple(s[i],e[i],p[i]));
        }
        Collections.sort(list);
        int result = 0;
        for(int i=0;i<n;i++){
            tuple now = list.get(i);
            result = Math.max(result,now.num);
            int num = now.num;
            for(int j=0;j<i;j++){
                tuple before = list.get(j);
                if(before.y<now.x){
                    num = Math.max(num,before.num+now.num);
                }
            }
            now.num = num;
            result = Math.max(result,now.num);
        }
        System.out.println(result);
    }
}