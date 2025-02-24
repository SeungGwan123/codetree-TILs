import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        for(int i=3;i<=n;i++){
            list.add(list.get(i-2)+list.get(i-1));
        }
        System.out.println(list.get(n));
    }
}