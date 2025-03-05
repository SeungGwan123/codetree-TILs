import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
            set.add(points[i]);
        }
        Integer iter = set.first();
        int j = 0;
        while(iter!=null){
            map.put(iter,j);
            iter = set.higher(iter);
            j++;
        }
        int[][] queries = new int[q][2];
        
        for (int i = 0; i < q; i++) {
            // int start = sc.nextInt();
            // int end = sc.nextInt();
            System.out.println(-map.get(sc.nextInt())+map.get(sc.nextInt())+1);
        }
        
    }
}