import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(!set.contains(arr[i])){
                result++;
                set.add(arr[i]);
            }
        }
        System.out.println(result);
    }
}