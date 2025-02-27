import java.util.*;
public class Main {
    static List<Integer>[] list;
    static HashSet<Integer>[] set;
    static int result = 1;

    public static void dfs(int num){
        for(int i=0;i<list[num].size();i++){
            int group = list[num].get(i);
            set[group].remove(num);

            //System.out.println(num+" : "+group+" size : "+set[group].size());
            if(set[group].size()==1){
                result++;
                dfs(set[group].iterator().next());
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();
        set = new HashSet[n];
        list = new ArrayList[n];
        for(int i=0;i<n;i++){
            set[i] = new HashSet<>();
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<g;i++){
            int s = sc.nextInt();
            for(int j=0;j<s;j++){
                int temp = sc.nextInt() - 1;
                set[i].add(temp);
                list[temp].add(i);
            }
        }
        dfs(0);
        System.out.println(result);
    }
}