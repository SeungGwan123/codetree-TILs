import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeMap<Integer,Integer> tree = new TreeMap<>();

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(!tree.containsKey(num)){
                tree.put(num,i+1);
            }
        }

        Iterator<Map.Entry<Integer,Integer>> iter = tree.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer,Integer> next = iter.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }
    }
}