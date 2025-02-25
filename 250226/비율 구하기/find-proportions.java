import java.util.*;
import java.text.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //이부분해설보기
        int n = sc.nextInt();
        sc.nextLine();

        TreeMap<String,Integer> tree = new TreeMap<>();
        for(int i=0;i<n;i++){
            String color = sc.nextLine();
            if(tree.containsKey(color)){
                tree.put(color,tree.get(color)+1);
            }else{
                tree.put(color,1);
            }
        }
        Iterator<Map.Entry<String,Integer>> iter = tree.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,Integer> next = iter.next();
            double result = (double) next.getValue()/n*100;
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(next.getKey()+" "+df.format(result));
        }
    }
}