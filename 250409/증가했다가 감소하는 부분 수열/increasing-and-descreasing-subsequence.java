import java.util.*;
public class Main {
    public static List<Integer> lis(List<Integer> list,int num){
        int last = list.get(list.size() - 1);
        if(last<num){
            list.add(num);
            list.add(list.size());
            return list;
        }else{
            int start = 0;
            int end = list.size() - 1;
            int result = 0;
            while(start <= end){
                int mid = (start + end)/2;
                if(list.get(mid)<num){
                    start = mid+1;
                }else{
                    result = mid;
                    end = mid - 1;
                }
            }
            list.set(result,num);
            list.add(result+1);
            return list;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] plus = new int[n];
        int[] minus = new int[n];
        List<Integer> p_list = new ArrayList<>();
        List<Integer> m_list = new ArrayList<>();
        p_list.add(arr[0]);
        m_list.add(arr[n-1]);
        plus[0] = 1;
        minus[n-1] = 1;
        for(int i=1;i<n;i++){
            p_list = lis(p_list,arr[i]);
            plus[i] = p_list.get(p_list.size() - 1);
            p_list.remove(p_list.size() - 1);
        }
        for(int i=n-2;i>=0;i--){
            m_list = lis(m_list,arr[i]);
            minus[i] = m_list.get(m_list.size() - 1);
            m_list.remove(m_list.size() - 1);
        }
        int answer = 0;
        // for(int i=0;i<n;i++)
        //     System.out.print(plus[i]+" ");
        // System.out.println();

        // for(int i=0;i<n;i++)
        //     System.out.print(minus[i]+" ");
        // System.out.println();

        for(int i=0;i<n;i++){
            answer = Math.max(plus[i],answer);
            for(int j=i+1;j<n;j++){
                answer = Math.max(minus[j],answer);
                if(arr[i]>arr[j]){
                    answer = Math.max(plus[i]+minus[j],answer);
                }
            }
        }
        System.out.println(answer);
    }
}