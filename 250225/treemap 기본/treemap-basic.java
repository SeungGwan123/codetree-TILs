import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        

        sc.nextLine();
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            if(temp.length>2){
                tree.put(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            }else{
                if(temp[0].equals("remove")){
                    tree.remove(Integer.parseInt(temp[1]));
                }else if(temp[0].equals("find")){
                    if(tree.containsKey(Integer.parseInt(temp[1]))){
                        System.out.println(tree.get(Integer.parseInt(temp[1])));
                    }else System.out.println("None");
                }else{
                    Iterator<Map.Entry<Integer,Integer>> iter = tree.entrySet().iterator();
                    if(tree.size()==0) System.out.print("None");
                    while(iter.hasNext()){
                        Map.Entry<Integer,Integer> entry = iter.next();
                        System.out.print(entry.getValue()+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}