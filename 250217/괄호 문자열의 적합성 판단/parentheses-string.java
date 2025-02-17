import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<line.length();i++){
            char now = line.charAt(i);

            if(now=='(') stack.push(now);
            else{
                if(stack.isEmpty()){
                    System.out.println("No");
                    return;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }
}