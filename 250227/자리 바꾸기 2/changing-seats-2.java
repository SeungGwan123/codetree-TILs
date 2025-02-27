import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt()-1;
            b[i] = sc.nextInt()-1;
        }
        int[] seat = new int[n];
        int[] s_num = new int[n];

        HashSet<Integer>[] set = new HashSet[n];

        for(int i=0;i<n;i++){
            set[i] = new HashSet<>();
            set[i].add(i);
            seat[i] = i;
            s_num[i] = 1;
        }
        for(int i=0;i<3*k;i++){
            int first = a[i%k];
            int second = b[i%k];

            int temp = seat[first];
            seat[first] = seat[second];
            seat[second] = temp;

            if(!set[seat[first]].contains(first)){
                set[seat[first]].add(first);
                s_num[seat[first]]++;
            }
            if(!set[seat[second]].contains(second)){
                set[seat[second]].add(second);
                s_num[seat[second]]++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(s_num[i]);
        }
    }
}
