import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(2);
        for(int i=3;i<=n;i++){
            int num = 0;
            for(int j=0;j<i;j++){
                num+= list.get(j)*list.get(i-j-1);
            }
            list.add(num);
        }
        System.out.println(list.get(n));
    }
}