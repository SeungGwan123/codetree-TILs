import java.util.*;
class Segment{
    long left = 1;
    long right = 1000000000;
    Segment parent = null;
    Segment left_node = null;
    Segment right_node = null;
    long sum = 0;
    int size = 0;
    public Segment(){
        
    }
}
public class Main {
    public static Map<String,Long> map = new HashMap<>();
    public static Map<Long,String> pam = new HashMap<>();
    public static Set<String> nameSet = new HashSet<>();
    public static Set<Long> valueSet = new HashSet<>();
    public static List<Segment> list = new ArrayList<>();
    public static void init(){
        list = new ArrayList<>();
        list.add(new Segment());
        map = new HashMap<>();
        nameSet = new HashSet<>();
        valueSet = new HashSet<>();
    }
    public static Segment findRoot(){
        if(list.size()==0){
            list.add(new Segment());
        }
        return list.get(0);
    }
    public static void insert_handler(long left,long right,Segment node,String name,long value){
        node.sum+=value;
        node.size++;
        if(left==right) return;
        long mid = (left + right) / 2;
        if(mid<value){
            if(node.right_node==null){
                Segment right_node = new Segment();
                right_node.parent = node;
                node.right_node = right_node;
            }
            insert_handler(mid+1,right,node.right_node,name,value);
        }else{
            if(node.left_node==null){
                Segment left_node = new Segment();
                left_node.parent = node;
                node.left_node = left_node;
            }
            insert_handler(left,mid,node.left_node,name,value);
        }
    }
    public static void insert(String name, long value){
        if(nameSet.contains(name)||valueSet.contains(value)){
            System.out.println("0");
            return;
        }
        nameSet.add(name);
        valueSet.add(value);
        map.put(name,value);
        pam.put(value,name);
        insert_handler(1,1000000000,findRoot(),name,value);
        System.out.println(1);
        return;
    }
    public static void delete_child(Segment node){
        if(node.left_node!=null&&node.left_node.sum==0){
            node.left_node = null;
        }
        if(node.right_node!=null&&node.right_node.sum==0){
            node.right_node = null;
        }
        return;
    }
    public static void delete_handler(long left,long right,Segment node,String name,long value){
        node.sum-=value;
        node.size--;
        if(node.sum==0){
            if(node.parent!=null){
                delete_child(node.parent);
            }
        }
        if(left==right) return;
        long mid = (left + right) / 2;
        if(mid<value){
            delete_handler(mid+1,right,node.right_node,name,value);
        }else{
            delete_handler(left,mid,node.left_node,name,value);
        }
    }
    public static void delete(String name){
        if(!map.containsKey(name)){
            System.out.println(0);
            return;
        }
        long value = map.get(name);
        nameSet.remove(name);
        valueSet.remove(value);
        map.remove(name);
        pam.remove(value);
        delete_handler(1,1000000000,findRoot(),name,value);
        System.out.println(value);
    }
    public static void rank_handler(long left,long right, Segment node, Long size){
        if(left==right){
            String name = pam.get(node.sum);
            System.out.println(name);
            return;
        }
        long mid = (left+right)/2;
        if(node.left_node!=null){
            if(node.left_node.size<size){
                rank_handler(mid+1,right,node.right_node,size-node.left_node.size);
            }else rank_handler(left,mid,node.left_node,size);
        }else{
            rank_handler(mid+1,right,node.right_node,size);
        }
    }
    public static void rank(long k){
        Segment root = findRoot();
        if(root.size < k){
            System.out.println("None");
            return;
        }
        rank_handler(1,1000000000,findRoot(),k);
    }
    public static void sum_handler(long left,long right, Segment node,long sum,long k){
        if(left==right){
            sum+=node.sum;
            System.out.println(sum);
            return;
        }
        long mid = (left + right) / 2;
        if(mid<k){
            if(node.right_node==null){
                if(node.left_node==null){
                    System.out.println(sum);    
                }else{
                    System.out.println(sum+node.left_node.sum);
                }
            }else{
                if(node.left_node==null){
                    sum_handler(mid+1,right,node.right_node,sum,k);
                }else{
                    sum_handler(mid+1,right,node.right_node,sum+node.left_node.sum,k);
                }
            }
        }else{
            if(node.left_node==null){
                System.out.println(sum);
            }else{
                sum_handler(left,mid,node.left_node,sum,k);
            }
        }
        return;
    }
    public static void sum(int k){
        
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i=0;i<n;i++){
            String[] command = sc.nextLine().split(" ");
            if(command[0].equals("init")){
                init();
            }else if(command[0].equals("insert")){
                insert(command[1],Long.parseLong(command[2]));
            }else if(command[0].equals("delete")){
                delete(command[1]);
            }else if(command[0].equals("rank")){
                rank(Long.parseLong(command[1]));
            }else{
                sum_handler(1,1000000000,findRoot(),0,Long.parseLong(command[1]));
            }
        }
    }
}