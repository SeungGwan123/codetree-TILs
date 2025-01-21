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
            boolean check = true;
            for(int j=0;j<n-i-1;j++){
                if(list.get(j)>list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                    check = false;
                }
            }
            if(check) break;
        }
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}