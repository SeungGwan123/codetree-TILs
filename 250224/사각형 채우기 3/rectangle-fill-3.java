import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(7);
        list.add(22);
        for(int i=4;i<=n;i++){
            list.add((list.get(i-1)*2+list.get(i-2)*3+list.get(i-3)*2)%1000000007);
        }
        System.out.println(list.get(n));
    }
}