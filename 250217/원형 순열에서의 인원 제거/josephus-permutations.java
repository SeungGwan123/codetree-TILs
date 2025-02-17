import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.add(i+1);
        }

        while(!queue.isEmpty()){
            for(int i=1;i<k;i++){
                queue.add(queue.poll());
            }
            System.out.print(queue.poll()+" ");
        }
    }
}