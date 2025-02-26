import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            set1.add(arr1[i]);
        }
        int m = sc.nextInt();
 
        for (int i = 0; i < m; i++) {
            if(set1.contains(sc.nextInt())) System.out.print(1+" ");           
            else System.out.print(0+" ");
        }
    }
}