import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            PriorityQueue<Integer> left = new PriorityQueue<>();
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for(int i = 0; i < m; i++){
                int num = sc.nextInt();
                if(left.size()==0&&right.size()==0) {
                    left.add(-num);
                    System.out.print(num+" ");
                    continue;
                }
                if(num<-left.peek()) left.add(-num);
                else right.add(num);
                if(i%2==0){
                    while(left.size()!=right.size()+1){
                        if(left.size()<right.size()) left.add(-right.poll());
                        else right.add(-left.poll());
                    }
                    System.out.print(-left.peek()+" ");
                }
            }
            System.out.println();
            // Please write your code here.
        }
    }
}