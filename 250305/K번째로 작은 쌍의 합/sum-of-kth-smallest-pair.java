import java.util.*;
class num implements Comparable<num>{
    int[] arr;
    int x;
    int index;

    public num(int x,int[] arr,int index){
        this.x = x;
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(num n){
        return (this.arr[this.index]+this.x) - (n.arr[n.index]+n.x);
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
        PriorityQueue<num> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Arrays.sort(arr1);
            //temp_pq.add(sc.nextInt());
        for (int i = 0; i < m; i++){
            //PriorityQueue<Integer> newpq = new PriorityQueue<>(temp_pq);
            pq.add(new num(sc.nextInt(),arr1,0));
        }
        for(int i=0;i<k-1;i++){
            num now = pq.peek();
            if(now.index==n-1) {
                pq.poll();
            }else {
                pq.poll();
                now.index++;
                pq.add(now);
            }
        }
        num result = pq.peek();
        System.out.println(result.arr[result.index]+result.x);
    }
}