import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer> height = new ArrayList<>();
    public static List<Integer> length = new ArrayList<>();
    public static Stack<Integer>[] stack = new Stack[50001];
    public static List<Integer> makeLIS(List<Integer> list,int san){
        int last_san = list.get(list.size() - 1);
        if(last_san<san){
            list.add(san);
            height.set(height.size() - 1,san);
            length.add(list.size());
            return list;
        }else{
            int left = 0;
            int right = list.size() - 1;
            int result = 0;
            int max_height = san;
            while(left<=right){
                int mid = (left+right)/2;
                if(list.get(mid)>=san){
                    right = mid - 1;
                    result = mid;
                    max_height = Math.max(max_height, list.get(mid));
                }else{
                    left = mid + 1;
                }
            }
            stack[result].push(list.get(result));
            list.set(result, san);
            length.add(result + 1);
            height.set(height.size() - 1,Math.max(max_height,height.get(height.size() - 1)));
            return list;
        }
    }
    public static List<Integer> delLIS(List<Integer> list, int san){
        int left = 0;
        int right = list.size() - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)<san){
                left = mid+1;
            }else if(list.get(mid)>san){
                right = mid -1;
            }else if(list.get(mid) == san){
                list.remove(mid);
                if(!stack[mid].isEmpty()){
                    list = makeLIS(list,stack[mid].pop());
                    length.remove(length.size() - 1);
                    // for(int i=0;i<list.size();i++){
                    //     System.out.print(list.get(i)+" ");
                    // }
                    // System.out.println();
                    // System.out.println("length "+length.get(length.size() - 1));
                }
                break;
            }
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> mountain = new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        
        for(int i=0;i<50001;i++){
            stack[i] = new Stack<>();
        }
        String[] initData = br.readLine().split(" ");
        for(int i=2;i<initData.length;i++){
            int san = Integer.parseInt(initData[i]);
            mountain.add(san);
            
            if(lis.size()==0){
                height.add(san);
                lis.add(san);
                length.add(1);
            }else{
                height.add(height.get(height.size() - 1));
                lis = makeLIS(lis, san);
            }
        }

        for(int i=1;i<n;i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("200")){
                int san = Integer.parseInt(command[1]);
                mountain.add(san);
                height.add(height.get(height.size() - 1));
                lis = makeLIS(lis, san);
                // System.out.println("plus " + san);
                // for(int j=0;j<lis.size();j++){
                //     System.out.print(lis.get(j)+" ");
                // }
                // System.out.println();
                // System.out.println("length ");
                // for(int j=0;j<length.size();j++){
                //     System.out.print(length.get(j)+" ");
                // }
                // System.out.println();
            }else if(command[0].equals("300")){
                int san = mountain.get(mountain.size() - 1);
                
                mountain.remove(mountain.size() - 1);
                height.remove(height.size() - 1);
                length.remove(length.size() - 1);

                lis = delLIS(lis,san);
            }else{
                int cable = Integer.parseInt(command[1]) - 1;
                long result = length.get(cable) - 1;

                result += lis.size();
                //System.out.println(cable+" "+length.get(cable)+" "+lis.size()+" "+height.get(height.size() - 1));
                System.out.println(1000000*result+height.get(height.size() - 1));
            }
        }
    }
}