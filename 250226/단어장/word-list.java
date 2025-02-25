import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeMap<String,Integer> tree = new TreeMap<>();

        for(int i=0;i<n;i++){
            String word = sc.next();
            if(tree.containsKey(word)){
                tree.put(word,tree.get(word)+1);
            }else{
                tree.put(word,1);
            }
        }

        Iterator<Map.Entry<String,Integer>> iter = tree.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String,Integer> next = iter.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }
    }
}