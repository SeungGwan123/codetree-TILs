import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();
                if(command == 'I') set.add(num);
                else{
                    if(set.size()==0) continue;
                    if(num<0){
                        int erase = set.first();
                        set.remove(erase);
                    }else{
                        int erase = set.last();
                        set.remove(erase);
                    }
                }
            }
            if(set.size()==0) System.out.println("EMPTY");
            else{
                System.out.print(set.last()+" ");
                System.out.println(set.first());
            }
        }
    }
}