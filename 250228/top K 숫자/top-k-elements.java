import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        Iterator<Integer> iter = set.descendingIterator();
        for(int i=0;i<k;i++){
            System.out.print(iter.next()+" ");
        }
    }
}