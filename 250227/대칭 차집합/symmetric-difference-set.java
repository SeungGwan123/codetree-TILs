import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = 0;
        int y = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<a;i++){
            set.add(sc.nextInt());
        }
        for(int i=0;i<b;i++){
            if(set.contains(sc.nextInt())) x++;
            else y++;
        }
        System.out.println(set.size()-x+y);
    }
}