import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            dq.addLast(i+1);
        }
        while(dq.size()!=1){
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.pollFirst());
    }
}