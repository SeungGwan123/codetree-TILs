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
            map.put(points[i],i);
            set.add(points[i]);
        }
        int[][] queries = new int[q][2];
        
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            int start = queries[i][0];
            int end = queries[i][1];
            int result = 0;
            Integer now = set.ceiling(start);
            if(now>=start&& now<=end) result++;
            while(now<=end){
                now = set.higher(now);
                if(now==null) break;
                if(now<=end) result++;
            }
            System.out.println(result);
        }
        
    }
}