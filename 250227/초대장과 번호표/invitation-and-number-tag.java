import java.util.*;
public class Main {
    static List<Integer>[] list;
    static HashSet<Integer>[] set;
    static HashSet<Integer> card = new HashSet<>();
    static int result = 1;

    public static void dfs(int num){
        for(int i=0;i<list[num].size();i++){
            int group = list[num].get(i);
            set[group].remove(num);

            //System.out.println(num+" : "+group+" size : "+set[group].size());
            if(set[group].size()==1){
                int invite = set[group].iterator().next();
                if(card.contains(invite)) continue;
                result++;
                card.add(invite);
                dfs(invite);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();
        set = new HashSet[g];
        list = new ArrayList[n];
        for(int i=0;i<g;i++){
            set[i] = new HashSet<>();
        }
        for(int i=0;i<n;i++){
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
        card.add(0);
        dfs(0);
        System.out.println(result);
    }
}