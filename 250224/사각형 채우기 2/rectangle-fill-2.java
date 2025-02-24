import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(3);
        for(int i=3;i<=n;i++){
            int one = list.get(i-1);
            int two = list.get(i-2)*2;
            int three = (one+two)%10007;
            list.add(three);
        }
        System.out.println(list.get(n));
    }
}