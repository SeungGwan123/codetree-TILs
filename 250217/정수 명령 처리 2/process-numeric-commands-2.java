import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            String[] order = sc.nextLine().split(" ");
            if(order.length==2) queue.add(Integer.parseInt(order[1]));
            else{
                switch(order[0]){
                    case "front":
                        System.out.println(queue.peek());
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "empty":
                        if(queue.isEmpty()) System.out.println(1);
                        else System.out.println(0);
                        break;
                    case "pop":
                        System.out.println(queue.peek());
                        queue.poll();
                        break;
                }
            }
        }
    }
}