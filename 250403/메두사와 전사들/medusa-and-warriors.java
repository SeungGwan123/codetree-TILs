import java.util.*;
import java.io.*;
class tuple{
    int x;
    int y;
    List<Integer[]> list;
    public tuple(int x,int y,List<Integer[]> list){
        this.x = x;
        this.y = y;
        this.list = new ArrayList<>(list);
    }
}
public class Main {
    public static int n;
    public static int[][] soldier;
    public static int[][] soldier_loc;
    public static int[][] soldier_num;
    public static int[] house;
    public static int[] park;
    public static int[] monster;
    public static int[][] board;
    public static int[][] visited;
    public static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static int[][] second_dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public static int[][][] monsterRoute;
    public static boolean monsterCheck = false;
    public static int[][][] monsterSight;
    public static int monsterSightNum;
    public static int monsterMinRoute = 1000000000;
    public static List<Integer[]> stoneSoldier;
    public static int[] result;
    public static void saveRoute(List<Integer[]> list){
        for(int i=1;i<list.size();i++){
            Integer[] before = list.get(i-1);
            Integer[] now = list.get(i);
            int x = now[0] - before[0];
            int y = now[1] - before[1];

            if(x==0){
                if(y==1) monsterRoute[before[0]][before[1]][3] = 1;
                else monsterRoute[before[0]][before[1]][2] = 1;
            }else{
                if(x==1) monsterRoute[before[0]][before[1]][1] = 1;
                else monsterRoute[before[0]][before[1]][0] = 1;
            }
        }
    }

    public static void house2park(int x,int y,List<Integer[]> list){
        Queue<tuple> queue = new LinkedList<>();
        queue.add(new tuple(x,y,list));
        while(!queue.isEmpty()){
            tuple now = queue.poll();
            x = now.x;
            y = now.y;
            list = now.list;
            if(list.size()>=monsterMinRoute) continue;
            if(x==park[0]&&y==park[1]){
                if(list.size()<monsterMinRoute){
                    monsterRoute = new int[n][n][4];
                    monsterMinRoute = list.size();
                }
                saveRoute(list);
                monsterCheck = true;
                continue;
            }
            for(int d=0;d<4;d++){
                int a = x+dir[d][0];
                int b = y+dir[d][1];
                if(a<0||b<0||a>=n||b>=n) continue;
                if(visited[a][b]==1 || board[a][b]==1) continue;
                list.add(new Integer[]{a,b});
                visited[a][b] = 1;
                queue.add(new tuple(a,b,list));
                list.remove(list.size() - 1);
            }
        }
    }
    public static void killSolider(){
        soldier_loc[monster[0]][monster[1]] = 0;
        soldier_num[monster[0]][monster[1]] = 0;
        for(int i=0;i<soldier.length;i++){
            if(soldier[i][0]==monster[0]&&soldier[i][1]==monster[1]){
                soldier[i][0] = -1;
                soldier[i][1] = -1;
            }
        }
    }
    public static void monsterMove(){
        int x = monster[0];
        int y = monster[1];
        for(int i=0;i<4;i++){
            if(monsterRoute[x][y][i]==1){
                monster[0] = x + dir[i][0];
                monster[1] = y + dir[i][1];
                // System.out.println(monster[0]+" "+monster[1]);
                killSolider();
                break;
            }
        }
    }

    public static void monsterSee(){
        stoneSoldier = new ArrayList<>();
        monsterSight = new int[4][n][n];
        int sol = 0;
        List<Integer[]> sol_list = new ArrayList<>();
        int[][] see_dir = new int[][]{{-1,1},{-1}};

        for(int d=0;d<4;d++){
            Set<Integer> set = new HashSet<>();
            List<Integer[]> list = new ArrayList<>();
            List<Integer> diag = new ArrayList<>();
            int num = 0;
            int start;
            int end;
            int line;
            if(d<2){
                start = Math.max(0,monster[1]-1);
                end = Math.min(n-1,monster[1]+1);
                if(d==0){
                    line = monster[0]-1;
                }else line = monster[0]+1;
            }else{
                start = Math.max(0,monster[0]-1);
                end = Math.min(n-1,monster[0]+1);
                if(d==2){
                    line = monster[1]-1;
                }else line = monster[1]+1;
            }
            //System.out.println("monster : "+monster[0]+" "+monster[1]+" "+start+" "+end+" "+line);
            while(line>=0&&line<n){
                if(d<2){
                    for(int i=start;i<=end;i++){
                        if(set.contains(i)) continue;
                        monsterSight[d][line][i] = 1;
                        if(soldier_num[line][i]>0){
                            //System.out.println(line+" "+i);
                            num+=soldier_num[line][i];
                            set.add(i);
                            //System.out.println(i);
                            if(i!=monster[1]){
                                if(i<monster[1]) diag.add(-i);
                                else diag.add(i);
                            }
                            list.add(new Integer[]{line,i});
                        }
                    }
                    start = Math.max(0,start-1);
                    end = Math.min(n-1,end+1);
                    if(d==0){
                        line--;
                    }else line++;
                }else{
                    for(int i=start;i<=end;i++){
                        if(set.contains(i)) continue;
                        monsterSight[d][i][line] = 1;
                        if(soldier_num[i][line]>0){
                            //System.out.println(i+" "+line);
                            num+=soldier_num[i][line];
                            set.add(i);
                            if(i!=monster[0]){
                                //System.out.println(i+" "+start+" "+end);
                                if(i<monster[0]) diag.add(-i);
                                else diag.add(i);
                            }
                            list.add(new Integer[]{i,line});
                        }
                    }
                    start = Math.max(0,start-1);
                    end = Math.min(n-1,end+1);
                    if(d==2){
                        line--;
                    }else line++;
                }
                for(int i=0;i<diag.size();i++){
                    int now = diag.get(i);
                    if(now==0||now==n-1) continue;
                    if(now<0){
                        diag.set(i,now+1);
                        set.add(-(now+1));
                    }else{
                        diag.set(i,now+1);
                        set.add(now+1);
                    }
                }
            }
            //System.out.println(list.size());
            if(num>sol){
                sol = num;
                sol_list = list;
                monsterSightNum = d;
            }
            //System.out.println(list.size());
        }
        result[1] = sol;
        for(int i=0;i<sol_list.size();i++){
            soldier_loc[sol_list.get(i)[0]][sol_list.get(i)[1]] = -1;
            stoneSoldier.add(sol_list.get(i));
        }
    }
    public static void dieSolider(int n){
        int x = soldier[n][0];
        int y = soldier[n][1];
        soldier[n][0] = -1;
        soldier[n][1] = -1;
        soldier_loc[x][y] = 0;
        soldier_num[x][y]--;
    }
    public static void moveSolider(){
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(monsterSight[monsterSightNum][i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(soldier_num[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        Set<Integer[]> set = new HashSet<>();
        for(int i=0;i<soldier.length;i++){
            int x = soldier[i][0];
            int y = soldier[i][1];
            //System.out.println(x+" "+y);
            int distance = Math.abs(monster[0] - x) + Math.abs(monster[1] - y);
            if(x==-1&&y==-1) continue;
            if(soldier_loc[x][y]==-1) continue;
            for(int d=0;d<4;d++){
                int a = x + dir[d][0];
                int b = y + dir[d][1];
                if(a<0||b<0||a>=n||b>=n) continue;
                if(distance<=Math.abs(monster[0]-a)+Math.abs(monster[1]-b)) continue;
                if(monsterSight[monsterSightNum][a][b]==1) continue;
                soldier[i][0] = a;
                soldier[i][1] = b;
                if(soldier_loc[a][b]!=-1) soldier_loc[a][b] = 1;
                //System.out.println(x+" "+y+" "+a+" "+b);
                soldier_loc[x][y] = 0;
                soldier_num[x][y]--;
                soldier_num[a][b]++;
                distance = Math.abs(monster[0]-a)+Math.abs(monster[1]-b);
                x=a;
                y=b;
                result[0]++;
                break;
            }
            if(x==monster[0]&&y==monster[1]){
                result[2]++;
                dieSolider(i);
                continue;
            }
            for(int d=0;d<4;d++){
                int a = x + second_dir[d][0];
                int b = y + second_dir[d][1];
                if(a<0||b<0||a>=n||b>=n) continue;
                if(distance<=Math.abs(monster[0]-a)+Math.abs(monster[1]-b)) continue;
                if(monsterSight[monsterSightNum][a][b]==1) continue;
                soldier[i][0] = a;
                soldier[i][1] = b;
                if(soldier_loc[a][b]!=-1) soldier_loc[a][b] = 1;
                //System.out.println(x+" "+y+" "+a+" "+b);
                soldier_loc[x][y] = 0;
                soldier_num[x][y]--;
                soldier_num[a][b]++;
                distance = Math.abs(monster[0]-a)+Math.abs(monster[1]-b);
                x=a;
                y=b;
                result[0]++;
                break;
            }
            if(x==monster[0]&&y==monster[1]){
                result[2]++;
                dieSolider(i);
                continue;
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(soldier_loc[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        for(int i=0;i<stoneSoldier.size();i++){
            Integer[] stone = stoneSoldier.get(i);
            soldier_loc[stone[0]][stone[1]] = 1;
        }
    }
    public static void start(){
        result = new int[3];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(soldier_num[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        //move
        monsterMove();
        //location check
        if(monster[0]==park[0]&&monster[1]==park[1]){
            System.out.println(0);
            return;
        }
        //see
        monsterSee();
        //move
        moveSolider();

        // 전사가 이동한 거리, 돌이된 전사의 수, 메두사를 공격한 전사의 수
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
        start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //집 공원 위치
        st = new StringTokenizer(br.readLine());
        house = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        monster = new int[]{house[0],house[1]};
        monsterRoute = new int[n][n][4];
        park = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        //전사 위치;
        st = new StringTokenizer(br.readLine());
        soldier = new int[m][2];
        soldier_loc = new int[n][n];
        soldier_num = new int[n][n];
        for(int i=0;i<m;i++){
            soldier[i][0] = Integer.parseInt(st.nextToken());
            soldier[i][1] = Integer.parseInt(st.nextToken());
            soldier_loc[soldier[i][0]][soldier[i][1]] = 1;
            soldier_num[soldier[i][0]][soldier[i][1]]++;
        }

        board = new int[n][n];
        visited = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{house[0],house[1]});
        house2park(house[0],house[1],list);

        if(!monsterCheck){
            System.out.println(-1);
            return;
        }
        
        // for(int d=0;d<4;d++){
        //     for(int i=0;i<n;i++){
        //         for(int j=0;j<n;j++){
        //             System.out.print(monsterRoute[i][j][d]+" ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        start();

    }
}