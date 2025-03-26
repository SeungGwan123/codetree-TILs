import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int num = list.size()-1;
        for(int i=1;i<n;i++){
            int now = arr[i];
            if(list.get(num)<now){
                list.add(now);
                num++;
            }else{
                int low = 0;
                int high = num;
                int result = 0;
                while(low<=high){
                    int mid = (low+high)/2;
                    if(list.get(mid)>=now){
                        low = mid+1;
                    }else {
                        high = mid - 1;
                        result = mid;
                    }
                }
                list.set(result,now);
            }
        }
        System.out.println(list.size());
    }
}