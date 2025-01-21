import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        for(int i=1;i<n;i++){
            int j = i-1;
            int key = list.get(i);
            while(j>=0&&list.get(j)>key){
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,key);
        }

        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}