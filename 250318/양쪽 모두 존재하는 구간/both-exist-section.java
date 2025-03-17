import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        if(map.size()!=m){
            System.out.println("-1");
            return;
        }
        int start = 0;
        int end = 0;
        int result = 100000;
        TreeMap<Integer,Integer> section = new TreeMap<>();
        while(end<n){
            int now = arr[end];
            if(section.containsKey(now)){
                section.put(now,section.get(now)+1);
            }else section.put(now,1);
            if(map.get(now)==1){
                map.remove(now);
            }else{
                map.put(now,map.get(now)-1);
            }
            while(section.size()==m){
                if(map.size()==m) result = Math.min(result,end - start + 1);
                int erase = arr[start];
                if(section.get(erase)==1){
                    section.remove(erase);
                }else section.put(erase,section.get(erase)-1);
                if(map.containsKey(erase)){
                    map.put(erase,map.get(erase)+1);
                }else map.put(erase,1);
                start++;
            }
            end++;
        }
        if(result == 100000)System.out.println("-1");
        else System.out.println(result);
        // Please write your code here.
    }
}