import java.util.*;
class num implements Comparable<num>{
    PriorityQueue<Integer> pq;
    int x;
    public num(int x,PriorityQueue<Integer> pq){
        this.x = x;
        this.pq = new PriorityQueue<>(pq);
    }

    @Override
    public int compareTo(num n){
        Integer pq_top = this.pq.peek();
        Integer n_top = n.pq.peek();
        if(pq_top==null) pq_top=0;
        if(n_top==null) n_top=0;
        return (pq_top+this.x) - (n_top+n.x);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        PriorityQueue<Integer> temp_pq = new PriorityQueue<>();
        PriorityQueue<num> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            temp_pq.add(sc.nextInt());
        for (int i = 0; i < m; i++){
            //PriorityQueue<Integer> newpq = new PriorityQueue<>(temp_pq);
            pq.add(new num(sc.nextInt(),temp_pq));
        }
        for(int i=0;i<k-1;i++){
            num now = pq.peek();
            if(now.pq.size()==1) pq.poll();
            else {
                pq.poll();
                now.pq.poll();
                pq.add(now);
            }
        }

        System.out.println(pq.peek().pq.peek()+pq.peek().x);
    }
}