import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<n;i++){
            String temp = sc.next();
            if(temp.equals("largest")){
                if(set.size()==0){
                    System.out.println("None");
                    continue;
                }
                Integer num = set.last();
                if(num==null) System.out.println("None");
                else System.out.println(num);
                continue;
            }
            if(temp.equals("smallest")){
                if(set.size()==0){
                    System.out.println("None");
                    continue;
                }
                Integer num = set.first();
                if(num==null) System.out.println("None");
                else System.out.println(num);
                continue;
            }
            Integer num = sc.nextInt();
            switch(temp){
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "find":
                    if(set.contains(num)) System.out.println("true");
                    else System.out.println("false");
                    break;
                case "lower_bound":
                    Integer low = set.ceiling(num);
                    if(low==null) System.out.println("None");
                    else System.out.println(low);
                    break;
                case "upper_bound":
                    Integer higher = set.higher(num);
                    if(higher==null) System.out.println("None");
                    else System.out.println(higher);
            }
        }
    }
}