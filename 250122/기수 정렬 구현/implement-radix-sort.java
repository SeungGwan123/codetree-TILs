import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
            int temp_k = list.get(i);
            int k_length = 1;
            while(temp_k>10){
                temp_k = temp_k/10;
                k_length++;
            }
            k = Math.max(k,k_length);
        }

        for(int i=0;i<=k;i++){    
            List<List<Integer>> temp_list = new ArrayList<>();
            for(int t=0;t<10;t++){
                temp_list.add(new ArrayList<Integer>());
            }
            for(int j=0;j<list.size();j++){
                int now = list.get(j);
                if(now<Math.pow(10,i)){
                    temp_list.get(0).add(now);
                }else{
                    int now_num = (int)((int)(now%(int)Math.pow(10,i+1))/(int)Math.pow(10,i));
                    temp_list.get(now_num).add(now);
                }
            }
            List<Integer> new_list = new ArrayList<>();
            for(int t=0;t<10;t++){
                for(int j=0;j<temp_list.get(t).size();j++){
                    new_list.add(temp_list.get(t).get(j));
                }
            }
            list = new_list;
        }

        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}