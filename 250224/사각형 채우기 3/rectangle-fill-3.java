import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int divide = 1000000007;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(22);
        for(int i=4;i<=n;i++){
            int one = list.get(i-1)*2%divide;
            int two = list.get(i-2)*3%divide;
            int three = 0;
            int block = i;
            while(block>=3){
                three += (list.get(i-block)*2%divide);
                block-=1;
            }
            int now = (one+two+three)%divide;
            list.add(now);
        }
        System.out.println(list.get(n));
    }
}