import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int result = 0;
        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++){
            String temp = sc.nextLine();
            if(hash.containsKey(temp)){
                hash.put(temp,hash.get(temp)+1);
                result = Math.max(result, hash.get(temp));
            }else{
                hash.put(temp,1);
                result = Math.max(result,1);
            }
        }
        System.out.println(result);
    }
}