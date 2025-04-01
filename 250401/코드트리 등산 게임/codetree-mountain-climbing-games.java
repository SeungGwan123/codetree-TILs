import java.util.*;
import java.io.*;
class pair{
    int san;
    int index;
    public pair(int san,int index){
        this.san = san;
        this.index = index;
    }
}
public class Main {
    public static List<Integer> height = new ArrayList<>();
    public static List<Integer> length = new ArrayList<>();
    public static Stack<pair>[] stack = new Stack[50001];
    public static List<pair> makeLIS(List<pair> list,int san,int index){
        int last_san = list.get(list.size() - 1).san;
        //System.out.println("last_san : "+last_san);
        if(last_san<san){
            list.add(new pair(san,index));
            height.add(san);
            length.add(list.size());
            return list;
        }else{
            int left = 0;
            int right = list.size() - 1;
            int result = 0;
            int max_height = san;
            while(left<=right){
                int mid = (left+right)/2;
                if(list.get(mid).san>=san){
                    right = mid - 1;
                    result = mid;
                    max_height = Math.max(max_height, list.get(mid).san);
                }else{
                    left = mid + 1;
                }
            }
            stack[result].push(list.get(result));
            list.set(result, new pair(san,index));
            length.add(result + 1);
            height.add(Math.max(max_height,height.get(height.size() - 1)));
            return list;
        }
    }
    public static List<pair> delLIS(List<pair> list, int san){
        int left = 0;
        int right = list.size() - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid).san<san){
                left = mid+1;
            }else if(list.get(mid).san>san){
                right = mid -1;
            }else if(list.get(mid).san == san){
                
                if(!stack[mid].isEmpty()){
                    // System.out.print("lis : ");
                    // for(int i=0;i<list.size();i++){
                    //     System.out.print(list.get(i).san+" ");
                    // }
                    // System.out.println();

                    pair temp_san = stack[mid].pop();
                    list.set(mid,temp_san);
                    //list = makeLIS(list,temp_san.san,temp_san.index);
                    //length.set(temp_san.index,length.get(length.size() - 1));
                    //height.set(temp_san.index,height.get(height.size() - 1));
                    //length.remove(length.size() - 1);
                    //height.remove(height.size() - 1);
                    //System.out.println("del "+temp_san.san+" "+temp_san.index);

                    // System.out.print("lis : ");
                    // for(int i=0;i<list.size();i++){
                    //     System.out.print(list.get(i).san+" ");
                    // }
                    // System.out.println();
                    // System.out.println("length "+length.get(length.size() - 1));
                }else list.remove(mid);
                break;
            }
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> mountain = new ArrayList<>();
        List<pair> lis = new ArrayList<>();
        
        for(int i=0;i<50001;i++){
            stack[i] = new Stack<>();
        }
        String[] initData = br.readLine().split(" ");
        for(int i=2;i<initData.length;i++){
            int san = Integer.parseInt(initData[i]);
            mountain.add(san);
            
            if(lis.size()==0){
                height.add(san);
                lis.add(new pair(san,i-2));
                length.add(1);
            }else{
                //height.add(height.get(height.size() - 1));
                lis = makeLIS(lis, san,i-2);
            }
        }

        for(int i=1;i<n;i++){
            String[] command = br.readLine().split(" ");

            // System.out.print("lis : ");
            // for(int j=0;j<lis.size();j++){
            //     System.out.print(lis.get(j).san+" ");
            // }
            // System.out.println();
            
            // System.out.print("length : ");
            // for(int j=0;j<length.size();j++){
            //     System.out.print(length.get(j)+" ");
            // }
            // System.out.println();

            if(command[0].equals("200")){
                int san = Integer.parseInt(command[1]);
                mountain.add(san);
                //height.add(height.get(height.size() - 1));
                lis = makeLIS(lis, san,mountain.size());
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