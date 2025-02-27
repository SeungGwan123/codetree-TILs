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

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(i+"-"+i);
            seat[i] = i;
            s_num[i] = 1;
        }
        for(int i=0;i<3*k;i++){
            int first = a[i%k];
            int second = b[i%k];

            int temp = seat[first];
            seat[first] = seat[second];
            seat[second] = temp;

            if(!set.contains(seat[first]+"-"+first)){
                set.add(seat[first]+"-"+first);
                s_num[seat[first]]++;
            }
            if(!set.contains(seat[second]+"-"+second)){
                set.add(seat[second]+"-"+second);
                s_num[seat[second]]++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(s_num[i]);
        }
    }
}