import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i=0;i<n;i++){
            if(hash.containsKey(arr[i])){
                hash.put(arr[i],hash.get(arr[i])+1);
            }else{
                hash.put(arr[i],1);
            }
        }
        for(int i=0;i<m;i++){
            if(hash.containsKey(queries[i])){
                System.out.print(hash.get(queries[i])+" ");
            }else System.out.print(0+" ");
        }
    }
}