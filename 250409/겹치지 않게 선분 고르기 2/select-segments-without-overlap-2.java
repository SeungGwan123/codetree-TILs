import java.util.*;
class pair implements Comparable<pair>{
    int x;
    int y;
    public pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(pair p){
        return this.x - p.x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        List<pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            list.add(new pair(segments[i][0],segments[i][1]));
        }
        
        Collections.sort(list);
        int[] result = new int[n];
        int answer = 0;
        for(int i=0;i<n;i++){
            result[i] = 1;
            for(int j=0;j<i;j++){
                if(list.get(j).y<list.get(i).x){
                    result[i] = Math.max(result[i],result[j]+1);
                }
            }
            answer = Math.max(answer,result[i]);
        }
        System.out.println(answer);
    }
}