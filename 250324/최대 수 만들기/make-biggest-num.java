import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a,String b){
                return Long.compare(Long.parseLong(b + a), Long.parseLong(a + b));
            }
        });
        String result = "";
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
        }
        System.out.println(result);
    }
}