import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(list.get(j)<list.get(min)){
                    min = j;
                }
            }
            int temp = list.get(min);
            list.set(min,list.get(i));
            list.set(i,temp);
        }

        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}