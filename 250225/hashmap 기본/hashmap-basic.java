import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            if(temp.length>2){
                hm.put(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            }else{
                if(temp[0].equals("find")){
                    if(hm.containsKey(Integer.parseInt(temp[1]))) System.out.println(hm.get(Integer.parseInt(temp[1])));
                    else System.out.println("None");
                }else{
                    hm.remove(Integer.parseInt(temp[1]));
                }
            }
        }
    }
}