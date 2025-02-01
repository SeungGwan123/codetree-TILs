import java.util.*;

public class Main {

    public static List<Integer> merge_sort(List<Integer> list,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            list = merge_sort(list,low,mid);
            list = merge_sort(list,mid+1,high);
            list = merge(list,low,mid,high);
        }
        return list;
    }
    public static List<Integer> merge(List<Integer> list,int low, int mid,int high){
        int i = low;
        int j = mid+1;
        int k = low;
        List<Integer> merge_list = new ArrayList<>();
        while(i<=mid&&j<=high){
            if(list.get(i)<list.get(j)){
                merge_list.add(list.get(i));
                k++;i++;
            }else{
                merge_list.add(list.get(j));
                k++;j++;
            }
        }
        while(i<=mid){
            merge_list.add(list.get(i));
            k++;i++;
        }
        while(j<=high){
            merge_list.add(list.get(j));
            k++;j++;
        }
        for(int m=0;m<merge_list.size();m++){
            list.set(low+m,merge_list.get(m));
        }
        return list;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        list = merge_sort(list,0,list.size()-1);

        for(int num : list){
            System.out.print(num+ " ");
        }
    }
}