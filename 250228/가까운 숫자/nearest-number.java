import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        int result = 1000000000;
        set.add(0);
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            Integer high = set.higher(num);
            Integer low = set.lower(num);
            if(high == null) high = 2000000000;
            if(low == null) low = -1000000000;
            result = Math.min(Math.min(high-num,num-low),result);
            System.out.println(result);
            set.add(num);
        }
    }
}