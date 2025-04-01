import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer> height = new ArrayList<>();
    public static List<Integer> length = new ArrayList<>();

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
            list.set(result, san);
            length.add(result + 1);
            height.set(height.size() - 1,Math.max(max_height,height.get(height.size() - 1)));
            return list;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> mountain = new ArrayList<>();
        List<List<Integer>> lis = new ArrayList<>();
        
        String[] initData = br.readLine().split(" ");
        for(int i=2;i<initData.length;i++){
            int san = Integer.parseInt(initData[i]);
            mountain.add(san);
            
            if(lis.size()==0){
                height.add(san);
                List<Integer> temp_lis = new ArrayList<>();
                temp_lis.add(san);
                length.add(1);
                lis.add(temp_lis);
            }else{
                height.add(height.get(height.size() - 1));
                List<Integer> temp_lis = new ArrayList<>(lis.get(lis.size()-1));
                temp_lis = makeLIS(temp_lis, san);
                lis.add(temp_lis);
            }
        }

        for(int i=1;i<n;i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("200")){
                int san = Integer.parseInt(command[1]);
                mountain.add(san);
                height.add(height.get(height.size() - 1));
                List<Integer> temp_lis = new ArrayList<>(lis.get(lis.size()-1));
                temp_lis = makeLIS(temp_lis, san);
                lis.add(temp_lis);
            }else if(command[0].equals("300")){
                mountain.remove(mountain.size() - 1);
                height.remove(height.size() - 1);
                length.remove(length.size() - 1);
                lis.remove(lis.size() - 1);
            }else{
                int cable = Integer.parseInt(command[1]) - 1;
                long result = length.get(cable) - 1;
                List<Integer> last_lis = lis.get(lis.size() - 1);

                result += last_lis.size();
                System.out.println(1000000*result+height.get(height.size() - 1));
            }
        }
    }
}