import java.util.*;
class ticket implements Comparable<ticket>{
    int i;
    int start;
    int end;
    public ticket(int i,int start,int end){
        this.i = i;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ticket t){
        if(this.start==t.start) return this.i - t.i;
        return this.start - t.start;
    }
}
class waiting implements Comparable<waiting>{
    int ticket_id;
    int arr_id;
    public waiting(int a,int b){
        this.ticket_id = a;
        this.arr_id = b;
    }

    @Override
    public int compareTo(waiting w){
        return this.ticket_id - w.ticket_id;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        ticket[] tickets = new ticket[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            t[i] = sc.nextInt();
            tickets[i] = new ticket(i,a[i],t[i]);
        }
        Arrays.sort(tickets);
        PriorityQueue<waiting> pq = new PriorityQueue<>();
        pq.add(new waiting(tickets[0].i,0));
        int ticket_num = 1;
        int time = tickets[0].start;
        int result = 0;
        while(!pq.isEmpty()){
            waiting now = pq.poll();
            ticket now_ticket = tickets[now.arr_id];
            //System.out.println(now_ticket.i+" "+now_ticket.start+" "+now_ticket.end);
            int wait_time = time - now_ticket.start;
            if(wait_time<0) wait_time = now_ticket.start;
            result = Math.max(result, wait_time);
            int ending = time+now_ticket.end;
            time = ending;
            while(ticket_num<n){
                if(tickets[ticket_num].start<=ending){
                    pq.add(new waiting(tickets[ticket_num].i,ticket_num));
                    ticket_num++;
                }else break;
            }
            if(pq.isEmpty()&&ticket_num<n){
                pq.add(new waiting(tickets[ticket_num].i,ticket_num));
                ticket_num++;
            }
        }
        System.out.println(result);
    }
}