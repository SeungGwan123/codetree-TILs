import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sequence = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
            set.add(sequence[i]);
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            Integer num = set.floor(queries[i]);
            if(num==null) System.out.println("-1");
            else {
                System.out.println(num);
                set.remove(num);
            }
        }
        // Please write your code here.
    }
}