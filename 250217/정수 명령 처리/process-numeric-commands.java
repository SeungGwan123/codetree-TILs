import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int num = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<num;i++){
            String[] temp = sc.nextLine().split(" ");
            if(temp.length>1)stack.push(Integer.parseInt(temp[1]));
            else{
                switch(temp[0]){
                    case "pop":
                        System.out.println(stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        if(stack.isEmpty()) System.out.println("1");
                        else System.out.println("0");
                        break;
                    case "top":
                        System.out.println(stack.peek());
                        break;
                }
            }
        }       
    }
}