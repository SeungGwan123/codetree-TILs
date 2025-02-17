import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            if(temp.length > 1) {
                if(temp[0].equals("push_front")) q.addFirst(Integer.parseInt(temp[1]));
                else q.addLast(Integer.parseInt(temp[1]));
            }else{
                switch(temp[0]){
                    case "pop_front":
                        System.out.println(q.pollFirst());
                        break;
                    case "pop_back":
                        System.out.println(q.pollLast());
                        break;
                    case "size":
                        System.out.println(q.size());
                        break;
                    case "empty":
                        if(q.isEmpty()) System.out.println(1);
                        else System.out.println(0);
                        break;
                    case "front":
                        System.out.println(q.peekFirst());
                        break;
                    case "back":
                        System.out.println(q.peekLast());
                        break;
                }
            }
        }
    }
}