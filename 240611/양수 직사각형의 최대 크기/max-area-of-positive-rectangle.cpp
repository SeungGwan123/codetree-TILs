#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int n;int m;
int board[20][20];
priority_queue<int> pq;
set<tuple<int,int,int,int>> total_s;
void big_square(vector<pair<int,int>> v,set<pair<int,int>> s,int x,int y){
    vector<pair<int,int>> temp_v = v;
    set<pair<int,int>> temp_s = s;
    bool check = true;
    int temp_x = x;
    int temp_y = y;
    for(int i=0;i<v.size();i++){
        int a = v[i].first+1;
        int b = v[i].second;
        temp_x = max(temp_x,a);
        temp_y = max(temp_y,b);
        if(a>=n) {
            check = false;
            break;
        }
        if(board[a][b]<=0){
            check = false;
            break;
        }
        if(temp_s.count({a,b})==1)continue;
        temp_v.push_back({a,b});
        temp_s.insert({a,b});
    }
    if(check&&total_s.count({x,y,temp_x,temp_y})==0){
        total_s.insert({x,y,temp_x,temp_y});
        pq.push(temp_v.size());
        big_square(temp_v,temp_s,x,y);
    }
    vector<pair<int,int>> t_v = v;
    set<pair<int,int>> t_s = s;
    check = true;
    temp_x = x;
    temp_y = y;
    for(int i=0;i<v.size();i++){
        int a = v[i].first;
        int b = v[i].second+1;
        temp_x = max(temp_x,a);
        temp_y = max(temp_y,b);
        if(b>=m) {
            check = false;
            break;
        }
        if(board[a][b]<=0){
            check = false;
            break;
        }
        if(t_s.count({a,b})==1)continue;
        t_v.push_back({a,b});
        t_s.insert({a,b});
    }
    if(check&&total_s.count({x,y,temp_x,temp_y})==0){
        total_s.insert({x,y,temp_x,temp_y});
        pq.push(t_v.size());
        big_square(t_v,t_s,x,y);
    }
}
int main() {
    cin>>n>>m;    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int temp;
            cin>>temp;
            board[i][j] = temp;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]<=0)continue;
            pq.push(1);
            total_s.insert({i,j,i,j});
            vector<pair<int,int>> v = {{i,j}};
            set<pair<int,int>> s = {{i,j}};
            big_square(v,s,i,j);
        }
    }
    if(pq.empty()) cout<<"-1";
    else{
        if(pq.top()<0) cout<<"-1";
        else cout<<pq.top();
    }
    return 0;
}